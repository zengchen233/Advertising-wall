package zengchen233.view;

import zengchen233.cn.Advertisement;
import zengchen233.cn.AdvertisingBoard;
import zengchen233.cn.QueryOneUserAD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @class: HandleQueryOneUserAD
 * @author: Zc
 * @Date: 2021/03/21 13:43
 * @Description:
 */
public class HandleQueryOneUserAD implements ActionListener {
    QueryOneUserADView view;
    QueryOneUserAD query;
    public HandleQueryOneUserAD(){
        query = new QueryOneUserAD();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        query.setLogin(view.login);
        if (view.login.getLoginSuccess() == false) {
            JOptionPane.showMessageDialog(null,"请先登录","消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = view.inputID.getText().trim();
        if (id.length() == 0) return;
        Advertisement [] ad = query.queryOneUser(id);
        if (ad == null) return;
        AdvertisingBoard board = new AdvertisingBoard();
        board.setAdvertisement(ad);
        view.pCenter.setAdvertisingBoard(board);
        view.pCenter.next.doClick();
    }

    public void setView(QueryOneUserADView view) {
        this.view = view;
    }
}
