package zengchen233.view;

import zengchen233.cn.DelAdvertisement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @class: HandleDelAdvertisement
 * @author: Zc
 * @Date: 2021/03/20 21:25
 * @Description:
 */
public class HandleDelAdvertisement implements ActionListener {
    DelAdvertisementView view;                          //删除广告的视图
    DelAdvertisement delAdvertisement;                  //负责删除广告的对象
    public HandleDelAdvertisement() {
        delAdvertisement = new DelAdvertisement();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        delAdvertisement.setLogin(view.login);
        if (!view.login.getLoginSuccess()) {
            JOptionPane.showMessageDialog(null,"请先登录","消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        String number = view.inputSerialNumber.getText().trim();
        boolean boo = delAdvertisement.delAdvertisement(number); //删除操作
        if (boo)
            view.hintMess.setText("删除成功");
        else
            view.hintMess.setText("删除失败");
    }

    public void setView(DelAdvertisementView view) {
        this.view = view;
    }
}
