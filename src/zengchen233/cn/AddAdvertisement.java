package zengchen233.cn;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;

/**
 * @class: AddAdvertisement
 * @author: Zc
 * @Date: 2021/03/19 9:25
 * Description:
 */
public class AddAdvertisement extends ConnectDatabase {
    Login login;

    public void setLogin(Login login) {
        this.login = login;
    }

    public  boolean addAdvertisement(Advertisement ad) {
        connectDatabase();
        if (connection == null || login == null) return false;
        if (login.getLoginSuccess() == false) return false;
        boolean success = false;
        PreparedStatement preSql;
        String sqlStr = "insert into guanggao_table values(?,?,?,?)";
        try {
            preSql = connection.prepareStatement(sqlStr);
            preSql.setString(1,login.getId());  //设置第一个问号的值
            String content = ad.getContent();
            preSql.setString(2,content);        //设置第二个问号的值
            File f = ad.getPictureFile();
            InputStream in = new FileInputStream(f);
            int length = in.available();
            preSql.setBinaryStream(3,in,length);    //设置第三个问号的值
            preSql.setString(4,login.getId()+ad.getSerialNumber()); //设置第四个问号的值
            int isOk = preSql.executeUpdate();
            if (isOk != 0)
                success = true;
            else
                success = false;
            connection.close();;
        } catch (Exception e) {
            success = false;
        }
        return success;
    }
}
