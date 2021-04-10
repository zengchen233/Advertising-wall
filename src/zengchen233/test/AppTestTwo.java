package zengchen233.test;

import zengchen233.cn.HandleLogin;
import zengchen233.cn.Login;

/**
 * @class: AppTestTwo
 * @author: Zc
 * @Date: 2021/03/19 12:38
 * @Description:
 */
public class AppTestTwo {
    public static void main(String[] args) {
        Login login = new Login();
        login.setId("zengchen");
        login.setPassword("zengchen233");
        HandleLogin handleLogin = new HandleLogin();
        login = handleLogin.handleLogin(login);
        if (login.getLoginSuccess() == false) {
            System.out.println("登陆失败，无用户或密码错误。");
            return;
        }
        else {
            System.out.println("登陆成功");
        }

    }
}
