package zengchen233.cn;

import java.awt.*;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @class: QueryOneUserAD
 * @author: Zc
 * @Date: 2021/03/19 10:12
 * @Description:
 */
public class QueryOneUserAD extends ConnectDatabase {  //负责查询用户发布的广告
    Login login;

    public void setLogin(Login login) {
        this.login = login;
    }

    public Advertisement[] queryOneUser(String id) {
        connectDatabase();
        if (connection == null || login == null) return null;
        if (login.getLoginSuccess() == false) return null;
        Advertisement [] ad = null;
        Statement sql;
        ResultSet rs;
        try {
            sql = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("select * from guanggao_table where id = '"+id+"'");
            rs.last();
            int recordAmount = rs.getRow(); //结果集中的全部记录
            ad = new Advertisement[recordAmount];
            for (int i = 0; i < ad.length; i++){
                ad[i] = new Advertisement();
            }
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                ad[i].setID(id);
                ad[i].setContent(rs.getString("content"));
                InputStream in = rs.getBinaryStream("imageFile");
                int length = in.available();
                byte [] b = new byte[length];
                in.read(b);
                in.close();
                Image img = Toolkit.getDefaultToolkit().createImage(b);
                ad[i].setImage(img);
                String number = rs.getString("serialNumber");
                int index = id.length();
                number = number.substring(index);
                ad[i].setSerialNumber(number);
                i++;
            }
            connection.close();
        } catch (Exception e) { }
        return ad;
    }
}
