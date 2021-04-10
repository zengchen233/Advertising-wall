package zengchen233.view;

import zengchen233.cn.Login;

import javax.swing.*;

/**
 * @class: DelAdvertisementView
 * @author: Zc
 * @Date: 2021/03/20 22:10
 * @Description: 删除广告的视图
 */
public class DelAdvertisementView extends JPanel {
    Login login;
    JTextField inputSerialNumber;                   //输入广告的序列号码
    JButton submit;                                 //提交按钮
    JTextField hintMess;
    HandleDelAdvertisement handleDelAdvertisement;  //负责删除广告

    DelAdvertisementView() {
        initView();
        registerListener();
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    private void initView() {
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        inputSerialNumber = new JTextField(20);
        submit = new JButton("删除广告");
        add(new JLabel("输入广告的序列号码"));
        add(inputSerialNumber);
        add(submit);
        add(hintMess);
    }

    private void registerListener() {
        handleDelAdvertisement = new HandleDelAdvertisement();
        handleDelAdvertisement.setView(this);
        submit.addActionListener(handleDelAdvertisement);
    }
}
