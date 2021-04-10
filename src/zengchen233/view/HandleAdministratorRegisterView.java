package zengchen233.view;

import zengchen233.cn.HandleAdministratorRegister;
import zengchen233.cn.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @class: HandleAdministratorRegisterView
 * @author: Zc
 * @Date: 2021/04/09 22:53
 * @Description:
 */
public class HandleAdministratorRegisterView extends JPanel implements ActionListener {
    Register register;
    JTextField inputID;                     //输入ID
    JPasswordField inputPassword;           //输入密码
    JPasswordField againPassword;           //再次输入密码
    JButton buttonRegister;                 //确认按钮

    HandleAdministratorRegisterView() {
        register = new Register();
        inputID = new JTextField(12);
        inputPassword = new JPasswordField(12);
        againPassword = new JPasswordField(12);
        buttonRegister = new JButton("管理员注册");
        add(new JLabel("输入ID:"));
        add(inputID);
        add(new JLabel("设置密码:"));
        add(inputPassword);
        add(new JLabel("请再次输入密码:"));
        add(againPassword);
        add(buttonRegister);
        buttonRegister.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = inputID.getText().trim();
        char [] pw = inputPassword.getPassword();
        char [] pw_again = againPassword.getPassword();

        String pwStr = new String(pw).trim();
        if (id.length() == 0 || pwStr.length() == 0) {
            JOptionPane.showMessageDialog(null,"管理员注册失败","消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }

        String pw_againStr = new String(pw_again).trim();
        if (pwStr.equals(pw_againStr)){
            register.setId(id);
            register.setPassword(new String(pw));
            HandleAdministratorRegister handleAdministratorRegister = new HandleAdministratorRegister();
            boolean boo = handleAdministratorRegister.handelRegister(register);
            if (boo)
                JOptionPane.showMessageDialog(null,"管理员注册成功","消息对话框",JOptionPane.WARNING_MESSAGE);
            else
                JOptionPane.showMessageDialog(null,"管理员注册失败,请换一个ID!","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,"两次密码不一致!","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
    }
}
