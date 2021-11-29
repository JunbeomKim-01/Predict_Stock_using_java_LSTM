package Login.Account;

import Login.Account.Account;
import Login.UserLogin;

public class UserAccount implements Account {
    @Override
    public void login() throws Exception {
        UserLogin userLogin = new UserLogin();
        userLogin.loginCheck();
    }
}
