package AI;

import AI.Model.LSTMModel;
import AI.representation.PriceCategory;
import AI.representation.StockDataSetIterator;
import AI.util.PlotUtil;

import Data.Api;
import javafx.util.Pair;
import org.bytedeco.javacpp.presets.opencv_core;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import clearScreen.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import Storage.*;
import org.tensorflow.op.strings.StringFormat;

public class StockPrediction {
    private static final Logger log = LoggerFactory.getLogger(StockPrediction.class);

    private static int exampleLength = 20; // time series length, assume 22 working days per month

    private static double finalyPredicPrice=0.0;
    public static void runAI() throws IOException {
        //String file = new ClassPathResource("prices-split-adjusted.csv").getFile().getAbsolutePath();
//        symbol = "GOOG"; // stock name
        int batchSize = 64; // mini-batch size
        double splitRatio = 0.8; // 90% for training, 10% for testing
        int epochs = 100; // training epochs

        System.out.println("Create dataSet iterator...");
        PriceCategory category = PriceCategory.CLOSE; // CLOSE: predict close price
        StockDataSetIterator iterator = new StockDataSetIterator(batchSize, exampleLength, splitRatio, category);

        System.out.println("Load test dataset...");
        List<Pair<INDArray, INDArray>> test = iterator.getTestDataSet();

        System.out.println("Build lstm networks...");
        MultiLayerNetwork net = LSTMModel.buildLstmNetworks(iterator.inputColumns(), iterator.totalOutcomes());

        System.out.println("Training...");
        for (int i = 0; i < epochs; i++) {
            while (iterator.hasNext()) net.fit(iterator.next()); // fit model using mini-batch data
            iterator.reset(); // reset iterator
            net.rnnClearPreviousState(); // clear previous state
        }

//        System.out.println("Saving model...");
//        File locationToSave = new File("src/main/resources/StockPriceLSTM_".concat(String.valueOf(category)).concat(".zip"));
//        // saveUpdater: i.e., the state for Momentum, RMSProp, Adagrad etc. Save this to train your network more in the future
//        ModelSerializer.writeModel(net, locationToSave, true);
//
//        System.out.println("Load model...");
//        net = ModelSerializer.restoreMultiLayerNetwork(locationToSave);

        System.out.println("Testing...");
        if (category.equals(PriceCategory.ALL)) {
            INDArray max = Nd4j.create(iterator.getMaxArray());
            INDArray min = Nd4j.create(iterator.getMinArray());
            predictAllCategories(net, test, max, min);
        } else {
            double max = iterator.getMaxNum(category);
            double min = iterator.getMinNum(category);
            predictPriceOneAhead(net, test, max, min, category);
            showPredict();
        }
        //System.out.println("Done...");


    }

    private static void showPredict(){
        int nowPrice= Api.getNowPrice();
        double yeild;
        if (finalyPredicPrice<nowPrice){
            yeild= ((nowPrice-finalyPredicPrice)/nowPrice)*-10000;
        }
       else {
            yeild= ((finalyPredicPrice-nowPrice)/nowPrice)*10000;
        }
        yeild= Double.parseDouble(String.format("%.2f",yeild));
        clearScreen.clear();
        System.out.println("한 달뒤 수익률:"+yeild+" %");
        int pay= Integer.parseInt(Storage.getIteam("PAY"));
        double result;

        result =(pay*nowPrice)* yeild/100;
        System.out.println("한 달 수익은 :"+result+"원 입니다.");
    }
    /** Predict one feature of a stock one-day ahead */
    private static void predictPriceOneAhead (MultiLayerNetwork net, List<Pair<INDArray, INDArray>> testData, double max, double min, PriceCategory category) {
        double[] predicts = new double[testData.size()];
        double[] actuals = new double[testData.size()];
        for (int i = 0; i < testData.size(); i++) {
            predicts[i] = net.rnnTimeStep(testData.get(i).getKey()).getDouble(exampleLength - 1) * (max - min) + min;
            actuals[i] = testData.get(i).getValue().getDouble(0);
        }
        log.info("Print out Predictions and Actual Values...");
        log.info("Predict,Actual");
        for (int i = 0; i < predicts.length; i++) log.info(predicts[i] + "," + actuals[i]);

        //log.info("Plot...");

         finalyPredicPrice= predicts[0];// 최종 예측가격

        //그래프
        //PlotUtil.plot(predicts, actuals, String.valueOf(category));
    }

    private static void predictPriceMultiple (MultiLayerNetwork net, List<Pair<INDArray, INDArray>> testData, double max, double min) {

    }

    /** Predict all the features (open, close, low, high prices and volume) of a stock one-day ahead */
    private static void predictAllCategories (MultiLayerNetwork net, List<Pair<INDArray, INDArray>> testData, INDArray max, INDArray min) {
        INDArray[] predicts = new INDArray[testData.size()];
        INDArray[] actuals = new INDArray[testData.size()];
        for (int i = 0; i < testData.size(); i++) {
            predicts[i] = net.rnnTimeStep(testData.get(i).getKey()).getRow(exampleLength - 1).mul(max.sub(min)).add(min);
            actuals[i] = testData.get(i).getValue();
        }
        log.info("Print out Predictions and Actual Values...");
        log.info("Predict\tActual");
        for (int i = 0; i < predicts.length; i++) log.info(predicts[i] + "\t" + actuals[i]);
        log.info("Plot...");
        for (int n = 0; n < 5; n++) {
            double[] pred = new double[predicts.length];
            double[] actu = new double[actuals.length];
            for (int i = 0; i < predicts.length; i++) {
                pred[i] = predicts[i].getDouble(n);
                actu[i] = actuals[i].getDouble(n);
            }
            String name;
            switch (n) {
                case 0: name = "Stock OPEN Price"; break;
                case 1: name = "Stock CLOSE Price"; break;
                case 2: name = "Stock LOW Price"; break;
                case 3: name = "Stock HIGH Price"; break;
                case 4: name = "Stock VOLUME Amount"; break;
                default: throw new NoSuchElementException();
            }
            PlotUtil.plot(pred, actu, name);
        }
    }


}
