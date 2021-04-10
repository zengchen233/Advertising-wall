package zengchen233.test;

import zengchen233.cn.HandleLogin;
import zengchen233.cn.Login;

import java.util.Scanner;

/**
 * @class: AppTestFour
 * @author: Zc
 * @Date: 2021/03/22 22:21
 * @Description:
 */
public class AppTestFour {
    public static void main(String[] args) {
        Login login = new Login();
        String id;
        String password;
        System.out.printf("输入用户名:");
        Scanner sc = new Scanner(System.in);
        id = sc.next();
        System.out.printf("输入密码:");
        Scanner sc1 = new Scanner(System.in);
        password = sc1.next();
        login.setId(id);
        login.setPassword(password);
        HandleLogin handleLogin = new HandleLogin();
        login = handleLogin.handleLogin(login);
        if (login.getLoginSuccess() == false) {
            System.out.println("登陆失败，无用户或密码错误。");
            return;
        }
        else {
            System.out.println("登陆成功");
        }

        String pss = login.getId();
        System.out.println(pss);


    }
}
