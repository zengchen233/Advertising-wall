package zengchen233.view;

import zengchen233.cn.Advertisement;
import zengchen233.cn.AdvertisingBoard;
import zengchen233.cn.QueryAllUserAD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @class: HandleQueryAllUserAD
 * @author: Zc
 * @Date: 2021/03/21 14:04
 * @Description:
 */
public class HandleQueryAllUserAD implements ActionListener {
    QueryAllUserAD queryAll;
    QueryAllUserADView view;
    public HandleQueryAllUserAD() {
        queryAll = new QueryAllUserAD();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        queryAll.setLogin(view.login);
        if (view.login.getLoginSuccess() == false) {
            JOptionPane.showMessageDialog(null,"请先登录","消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Advertisement [] ad = queryAll.queryAllUser();
        if (ad == null) return;
        AdvertisingBoard board = new AdvertisingBoard();            //创建广告牌
        board.setAdvertisement(ad);
        view.pCenter.setAdvertisingBoard(board);
        view.pCenter.next.doClick();
    }

    public void setView(QueryAllUserADView view) {
        this.view = view;
    }
}
