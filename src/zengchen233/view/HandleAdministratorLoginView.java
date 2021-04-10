package zengchen233.view;

import zengchen233.cn.HandleAdministratorLogin;
import zengchen233.cn.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @class: HandleAdministratorLoginView
 * @author: Zc
 * @Date: 2021/04/09 22:25
 * @Description:
 */
public class HandleAdministratorLoginView extends JPanel implements ActionListener{
    Login login;
    JTextField inputID;
    JPasswordField inputPassword;
    ButtonGroup group;
    JRadioButton admin, user;
    JButton buttonLogin;                 //登陆
    JButton buttonExit;                  //退出登录
    public void setLogin(Login login) {
        this.login = login;
    }

    HandleAdministratorLoginView() {
        inputID = new JTextField(12);
        inputPassword = new JPasswordField(12);
        buttonLogin = new JButton("管理员登陆");
        buttonExit = new JButton("退出登录");
        add(new JLabel("ID:"));
        add(inputID);
        add(new JLabel("密码:"));
        add(inputPassword);
        add(buttonLogin);
        add(buttonExit);
        //这是一段测试代码
        group = new ButtonGroup();
        user = new JRadioButton("用户");
        admin = new JRadioButton("管理员");

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.setLoginSuccess(false);
            }
        });
        buttonLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        login.setId(inputID.getText());
        char [] pw = inputPassword.getPassword();
        login.setPassword(new String(pw));
        HandleAdministratorLogin handleAdministratorLogin = new HandleAdministratorLogin();
        login = handleAdministratorLogin.handleLogin(login);
        if (login.getLoginSuccess() == true) {
            JOptionPane.showMessageDialog(null,"管理员登陆成功","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,"登陆失败","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
    }
}
