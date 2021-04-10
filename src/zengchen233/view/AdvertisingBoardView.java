package zengchen233.view;

import zengchen233.cn.AdvertisingBoard;

import javax.swing.*;
import java.awt.*;

/**
 * @class: AdvertisingBoardView
 * @author: Zc
 * @Date: 2021/03/21 10:09
 * @Description:
 */
public class AdvertisingBoardView extends JPanel {
    AdvertisingBoard advertisingBoard;                      //本视图需要显示的广告牌
    public JTextArea showContent;                           //显示广告内容
    public ImageJPanel showImage;                           //显示广告的图像
    public JButton next,previous;                           //上一广告，下一广告按钮
    public JLabel showID;                                   //显示发布者的id
    public JLabel showNumber;                               //显示广告的序列号
    HandleAdvertisingBoard handleAdvertisingBoard;          //负责处理广告牌中的广告
    public AdvertisingBoardView() {
        initView();
        registerListener();
    }

    public void initView() {
        setLayout(new BorderLayout());
        showImage = new ImageJPanel();
        showContent = new JTextArea(12,12);
        showContent.setToolTipText("在图片上点击可调整观看");
        showContent.setForeground(Color.blue);
        showContent.setWrapStyleWord(true);
        showContent.setLineWrap(true);                      //自动回行
        showContent.setFont(new Font("宋体",Font.BOLD,18));
        next = new JButton("下一广告");
        previous = new JButton("上一广告");
        JPanel pNorth = new JPanel();
        pNorth.setBackground(Color.cyan);
        showID = new JLabel();
        showNumber = new JLabel();
        pNorth.add(new JLabel("发布者的ID:"));
        pNorth.add(showID);
        pNorth.add(new JLabel("发布者的序列号:"));
        pNorth.add(showNumber);
        add(pNorth,BorderLayout.NORTH);
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new GridLayout(1,2));
        pCenter.add(new JScrollPane(showContent));
        pCenter.add(showImage);
        add(pCenter,BorderLayout.CENTER);
        JPanel pSouth = new JPanel();
        pSouth.add(previous);
        pSouth.add(next);
        add(pSouth,BorderLayout.SOUTH);
        validate();
    }

    public void registerListener() {
        handleAdvertisingBoard = new HandleAdvertisingBoard();
        next.addActionListener(handleAdvertisingBoard);
        previous.addActionListener(handleAdvertisingBoard);
        handleAdvertisingBoard.setView(this);
    }
    public void setAdvertisingBoard(AdvertisingBoard advertisingBoard) {
        this.advertisingBoard = advertisingBoard;
    }
}
