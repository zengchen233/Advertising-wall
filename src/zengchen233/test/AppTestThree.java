package zengchen233.test;

import zengchen233.cn.*;

/**
 * @class: AppTestThree
 * @author: Zc
 * @Date: 2021/03/19 16:59
 * @Description:
 */
public class AppTestThree {
    public static void main(String[] args) {
        Login login = new Login();
        login.setId("zengchen");
        login.setPassword("zengchen233");
        HandleLogin handleLogin = new HandleLogin();
        login = handleLogin.handleLogin(login);
        if ((login.getLoginSuccess() == false)){
            System.out.println("登陆失败，无用户或密码错误。");
        }
        else {
            System.out.println("登陆成功");
        }
        QueryOneUserAD query = new QueryOneUserAD();
        query.setLogin(login);
        Advertisement [] ad = query.queryOneUser("zengchen");
        for (int i = 0; i < ad.length; i++){
            System.out.println("广告内容:"+ad[i].getContent());
            System.out.println("广告图片:"+ad[i].getImage().toString());
        }
    }
}
