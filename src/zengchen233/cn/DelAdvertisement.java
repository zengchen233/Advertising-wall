package zengchen233.cn;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @class: DelAdvertisement
 * @author: Zc
 * @Date: 2021/03/19 9:39
 * Description: 使用delAdvertisement方法可以删除数据库当中的guanggao_db表中的表单记录
 */
public class DelAdvertisement extends ConnectDatabase {  //负责删除广告
    Login login;

    public void setLogin(Login login) {
        this.login = login;
    }

    public boolean delAdvertisement(String serialNumber) {
        boolean success = false;
        connectDatabase();
        PreparedStatement preSql;
        if (connection == null || login == null) return false;
        if (login.getLoginSuccess() == false) return false;
        connectDatabase();
        String SQL = "delete from guanggao_table where serialNumber = ?";
        try {
            preSql = connection.prepareStatement(SQL);
            preSql.setString(1,login.getId()+serialNumber);
            int isOk = preSql.executeUpdate();
            if (isOk != 0)  success = true;
            else success = false;
            connection.close();
        } catch (SQLException e) {
            success = false;
        }
        return success;
    }
}
