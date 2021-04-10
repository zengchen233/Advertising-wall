package zengchen233.test;

import zengchen233.cn.*;

import java.util.Scanner;

/**
 * @class: AppTestOne
 * @author: Zc
 * @Date: 2021/03/19 10:59
 * @Description: 测试注册
 */
public class AppTestOne {
    public static void main(String[] args) {
        Register user = new Register();
        String id;
        String password;
        System.out.printf("输入id:");
        Scanner sc = new Scanner(System.in);
        id = sc.next();
        System.out.printf("输入密码:");
        Scanner sc1 = new Scanner(System.in);
        password = sc1.next();
        user.setId(id);
        user.setPassword(password);
        HandleRegister handleRegister = new HandleRegister();
        boolean isOk = handleRegister.handelRegister(user);
        if (isOk) {
            System.out.println("注册成功!");
        }
        else {
            System.out.println("注册失败，此ID已被注册！");
        }
    }
}
