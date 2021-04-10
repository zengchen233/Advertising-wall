package zengchen233.view;

import zengchen233.cn.HandleLogin;
import zengchen233.cn.Login;
import zengchen233.cn.ModifyPassword;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @class: ModifyPasswordView
 * @author: Zc
 * @Date: 2021/03/23 10:50
 * @Description:
 */
public class ModifyPasswordView extends JPanel implements ActionListener {
    JTextField ID;
    JPasswordField inputPassword;
    JPasswordField againPassword;
    JButton jButton;
    Login login = new Login();
    public void setLogin(Login login) {
        this.login = login;
    }

    ModifyPasswordView() {
        ID = new JTextField(12);
        inputPassword = new JPasswordField(12);
        againPassword = new JPasswordField(12);
        jButton = new JButton("确认");
        add(new JLabel("ID:"));
        add(ID);
        add(new JLabel("修改密码:"));
        add(inputPassword);
        add(new JLabel("请再次输入密码:"));
        add(againPassword);
        add(jButton);
        jButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        login.setId(ID.getText());
        char[] pw = inputPassword.getPassword();
        char[] pw_again = againPassword.getPassword();
        if (new String(pw).equals(new String(pw_again))) {
            login.setPassword(new String(pw));
            HandleLogin handleLogin = new HandleLogin();
            login = handleLogin.handleLogin(login);
            ModifyPassword modifyPassword = new ModifyPassword();
            boolean boo = modifyPassword.ModifyPassword(login);
            if (boo) {
                JOptionPane.showMessageDialog(null, "修改成功", "消息对话框", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "两次输入密码不同", "消息对话框", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}

