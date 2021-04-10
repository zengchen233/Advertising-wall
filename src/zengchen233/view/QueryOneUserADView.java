package zengchen233.view;

import zengchen233.cn.Login;

import javax.swing.*;
import java.awt.*;

/**
 * @class: QueryOneUserADView
 * @author: Zc
 * @Date: 2021/03/21 13:34
 * @Description: 查询一个用户广告的视图
 */
public class QueryOneUserADView extends JPanel {
    public Login login;
    public JTextField inputID;                      //输入用户的ID
    JButton submit;
    public AdvertisingBoardView pCenter;            //广告牌
    HandleQueryOneUserAD handleQueryOneUserAD;      //负责查询某个用户的广告
    QueryOneUserADView() {
        initView();
        registerListener();
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    private void initView(){
        setLayout(new BorderLayout());
        JPanel pNorth = new JPanel();
        pCenter = new AdvertisingBoardView();
        inputID = new JTextField(12);
        submit = new JButton("提交");
        pNorth.add(new JLabel("输入某用户的ID,查询该ID发布的广告"));
        pNorth.add(inputID);
        pNorth.add(submit);
        add(pNorth,BorderLayout.NORTH);
        add(pCenter,BorderLayout.CENTER);
    }

    private void registerListener() {
        handleQueryOneUserAD = new HandleQueryOneUserAD();
        handleQueryOneUserAD.setView(this);
        submit.addActionListener(handleQueryOneUserAD);
    }
}
