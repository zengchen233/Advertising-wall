package zengchen233.view;

import zengchen233.cn.HandleLogin;
import zengchen233.cn.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @class: LoginView
 * @author: Zc
 * @Date: 2021/03/19 21:52
 * @Description:
 */
public class LoginView extends JPanel implements ActionListener {
    Login login;
    JTextField inputID;
    JPasswordField inputPassword;
    JButton buttonLogin;                 //登陆
    JButton buttonExit;                  //退出登录
    public void setLogin(Login login) {
        this.login = login;
    }

    LoginView() {
        inputID = new JTextField(12);
        inputPassword = new JPasswordField(12);
        buttonLogin = new JButton("登陆");
        buttonExit = new JButton("退出登录");
        add(new JLabel("ID:"));
        add(inputID);
        add(new JLabel("密码:"));
        add(inputPassword);
        add(buttonLogin);
        add(buttonExit);

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
        HandleLogin handleLogin = new HandleLogin();
        login = handleLogin.handleLogin(login);
        if (login.getLoginSuccess() == true) {
            JOptionPane.showMessageDialog(null,"登陆成功","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,"登陆失败","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
    }
}
