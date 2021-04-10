package zengchen233.view;

import zengchen233.cn.Login;

import javax.swing.*;
import java.awt.*;

/**
 * @class: AddAdvertisementView
 * @author: Zc
 * @Date: 2021/03/20 14:05
 * @Description: 添加广告的视图
 */
public class AddAdvertisementView extends JPanel {      //添加广告的视图
    public Login login;
    public JTextField inputSerialNumber;                //输入广告的序列号码
    public JTextArea inputWord;                         //输入广告词
    public JButton inputPictureFile;                    //选择广告图片文件
    public JButton submit;                              //提交按钮
    public JTextField hintMess;
    HandleAddAdvertisement handleAddAdvertisement;      //负责处理添加广告
    AddAdvertisementView() {
        initView();
        registerListener();
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    private void registerListener() {
        handleAddAdvertisement = new HandleAddAdvertisement();
        handleAddAdvertisement.setView(this);
        submit.addActionListener(handleAddAdvertisement);
        inputPictureFile.addActionListener((handleAddAdvertisement));
    }

    private void initView() {
        setLayout(new BorderLayout());
        JPanel pNorth = new JPanel();
        JPanel pSouth = new JPanel();
        hintMess = new JTextField(20);
        hintMess.setEditable(false);                    //设置显示的文字不可更改且可以被覆盖
        inputSerialNumber = new JTextField(20);
        inputWord = new JTextArea();
        inputWord.setLineWrap(true);
        inputWord.setWrapStyleWord(true);
        inputWord.setFont(new Font("宋体",Font.BOLD,20));
        inputPictureFile = new JButton("选择广告图像文件");
        submit = new JButton("添加广告");
        pNorth.add(new JLabel("输入广告序列号"));
        pNorth.add(inputSerialNumber);
        pNorth.add(new JLabel("在文本区输入广告词"));
        pSouth.add(inputPictureFile);
        pSouth.add(submit);
        pSouth.add(hintMess);
        add(pNorth,BorderLayout.NORTH);
        add(pSouth,BorderLayout.SOUTH);
        add(new JScrollPane(inputWord),BorderLayout.CENTER);
    }
}
