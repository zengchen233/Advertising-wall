package zengchen233.view;

import zengchen233.cn.Login;

import javax.swing.*;
import java.awt.*;

/**
 * @class: IntegrationView
 * @author: Zc
 * @Date: 2021/03/21 14:21
 * @Description:
 */
public class IntegrationView extends JFrame {
    JTabbedPane tabbedPane;                     //用选项卡集成所有视图
    RegisterView registerView;
    LoginView loginView;
    AddAdvertisementView addAdvertisementView;
    DelAdvertisementView delAdvertisementView;
    QueryOneUserADView queryOneUserADView;
    QueryAllUserADView queryAllUserADView;
    ModifyPasswordView modifyPasswordView;
    HandleAdministratorLoginView handleAdministratorLoginView;
    HandleAdministratorRegisterView handleAdministratorRegisterView;
    Login login;
//    ImageIcon icon = new ImageIcon("src/img/小怪兽.png");
    ImageIcon icon = new ImageIcon("src/img/小怪兽2.png");
    public IntegrationView() {
        setTitle("曾晨的课程设计");
        setIconImage(icon.getImage());
        registerView = new RegisterView();
        login = new Login();
        loginView = new LoginView();
        addAdvertisementView = new AddAdvertisementView();
        delAdvertisementView = new DelAdvertisementView();
        queryOneUserADView = new QueryOneUserADView();
        queryAllUserADView = new QueryAllUserADView();
        modifyPasswordView = new ModifyPasswordView();
        handleAdministratorLoginView = new HandleAdministratorLoginView();
        handleAdministratorRegisterView = new HandleAdministratorRegisterView();

        loginView.setLogin(login);
        addAdvertisementView.setLogin(login);
        delAdvertisementView.setLogin(login);
        queryAllUserADView.setLogin(login);
        queryOneUserADView.setLogin(login);
        modifyPasswordView.setLogin(login);
        handleAdministratorLoginView.setLogin(login);

        //下面开始分布选项顺序
        tabbedPane = new JTabbedPane((JTabbedPane.LEFT)); //选项卡在左侧,默认是TOP
        tabbedPane.add("登陆",loginView);
        tabbedPane.add("管理员登陆",handleAdministratorLoginView);
        tabbedPane.add("注册",registerView);
        tabbedPane.add("管理员注册",handleAdministratorRegisterView);
        tabbedPane.add("修改密码",modifyPasswordView);
        tabbedPane.add("添加广告",addAdvertisementView);
        tabbedPane.add("删除广告",delAdvertisementView);
        tabbedPane.add("浏览全部用户的广告",queryAllUserADView);
        tabbedPane.add("浏览某个用户的广告",queryOneUserADView);

        tabbedPane.validate();
        add(tabbedPane, BorderLayout.CENTER);
        setBounds(100,100,1200,560);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
