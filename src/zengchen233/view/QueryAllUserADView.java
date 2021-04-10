package zengchen233.view;

import zengchen233.cn.Login;

import javax.swing.*;
import java.awt.*;

/**
 * @class: QueryAllUserADView
 * @author: Zc
 * @Date: 2021/03/21 14:02
 * @Description: 查询全部广告的视图
 */
public class QueryAllUserADView extends JPanel {
    public Login login;
    JButton submit;
    public AdvertisingBoardView pCenter;                    //广告牌
    HandleQueryAllUserAD handleQueryAllUserAD;              //负责查询所有的广告

    QueryAllUserADView() {
        initView();
        registerListener();
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    private void initView() {
        setLayout(new BorderLayout());
        JPanel pNorth = new JPanel();
        pCenter = new AdvertisingBoardView();
        submit = new JButton("浏览全部广告");
        pNorth.add(submit);
        add(pNorth,BorderLayout.NORTH);
        add(pCenter,BorderLayout.CENTER);
    }

    private void registerListener() {
        handleQueryAllUserAD = new HandleQueryAllUserAD();
        handleQueryAllUserAD.setView(this);
        submit.addActionListener(handleQueryAllUserAD);
    }
}
