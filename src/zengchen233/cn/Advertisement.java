package zengchen233.cn;

import java.awt.*;
import java.io.File;

/**
 * @class: Advertisement
 * @author: Zc
 * @Date: 2021/03/18 21:57
 * Description: 用来和数据库(guanggao_db)交互。
 */
public class Advertisement {
    String ID;                  //广告的id
    String content;             //广告的文本
    File pictureFile;           //广告的图片文件
    Image image;                //广告图片
    String serialNumber;        //广告编号

    public void setID(String id) {
        ID = id;
    }

    public String getID() {
        return ID;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setContent(String s) {
        this.content = s;
    }

    public String getContent() {
        return content;
    }

    public void setPictureFile(File pictureFile) {
        this.pictureFile = pictureFile;
    }

    public File getPictureFile() {
        return pictureFile;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
