package Data;

import AI.StockPrediction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import clearScreen.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Api {
    public static void main(String[] args) {
        getStockData(10,"005930");
    }
    private static final Logger log = LoggerFactory.getLogger(StockPrediction.class);
    static int nowPrice = 0;

    public static List<String[]> getStockData(int parameter,String code){

        List<String[]> result = new ArrayList<>();
        try {
            System.out.println("bring Data...");
            //   날짜,   시가, 최고가, 최저가, 종가,  거래량
            //20211125|75100|75100|73600|73700|12462402
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("https://fchart.stock.naver.com/sise.nhn?timeframe=day&count="+parameter+"&requestType=0&symbol="+code);
            XPath xpath = XPathFactory.newInstance().newXPath();
            String expression = "//*/item";

            NodeList cols = (NodeList)xpath.compile(expression).evaluate(document, XPathConstants.NODESET);
            int length = cols.getLength();
            String[][] stocks = new String[length][];

            int index;
            for(index = 0; index < parameter; ++index) {
                String ssn = cols.item(index).getAttributes().item(0).getTextContent();
                String[] arr = ssn.split("\\|");
                stocks[index] = new String[arr.length];

                String[] var11 = arr;

                for(int var13 = 0; var13 < arr.length; ++var13) {
                    stocks[index][var13] = var11[var13];

                }
            }

            for(index = 0; index < parameter; ++index) {
                result.add(stocks[index]);
            }
            nowPrice = Integer.parseInt(result.get(parameter-1)[4]);
            System.out.println("Done...");
        } catch (SAXException var15) {
            var15.printStackTrace();
        } catch (IOException var16) {
            var16.printStackTrace();
        } catch (ParserConfigurationException var17) {
            var17.printStackTrace();
        } catch (XPathExpressionException var18) {
            var18.printStackTrace();
        }
        return result;
    }

    public static int getNowPrice(){
        return nowPrice;
    }
}
