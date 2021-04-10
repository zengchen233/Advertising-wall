package zengchen233.cn;

import java.awt.*;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @class: QueryAllUserAD
 * @author: Zc
 * @Date: 2021/03/19 10:30
 * @Description:
 */
public class QueryAllUserAD extends ConnectDatabase { //可以查询全部用户发布的广告
    Login login;

    public void setLogin(Login login) {
        this.login = login;
    }

    public Advertisement[] queryAllUser() {
        connectDatabase();
        if (connection == null || login == null) return null;
        if (login.getLoginSuccess() == false) return null;
        Advertisement [] ad = null;
        Statement sql;
        ResultSet rs;
        try {
            sql = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("select * from guanggao_table");
            rs.last();
            int recordAmount = rs.getRow();
            ad = new Advertisement[recordAmount];
            for (int i = 0; i < ad.length; i++){
                ad[i] = new Advertisement();
            }
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                String id = rs.getString(1);
                ad[i].setID(id);
                ad[i].setContent(rs.getString(2));
                InputStream in = rs.getBinaryStream(3);
                int length = in.available();
                byte [] b = new byte[length];
                in.read(b);
                in.close();
                Image img = Toolkit.getDefaultToolkit().createImage(b);
                ad[i].setImage(img);
                String number = rs.getString(4);
                int index = id.length();
                number = number.substring(index);
                ad[i].setSerialNumber(number);
                i++;
            }
            connection.close();
        } catch(Exception e){ }
        return ad;
    }
}
