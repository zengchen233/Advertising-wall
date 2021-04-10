package zengchen233.cn;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @class: ModifyPassword
 * @author: Zc
 * @Date: 2021/04/05 16:04
 * @Description:
 */
public class ModifyPassword extends ConnectDatabase {
    public boolean ModifyPassword(Login  login) {
        connectDatabase();                              //连接数据库（继承的方法）
        boolean isSuccess = false;
        if (connection == null) {
            return false;
        }
        PreparedStatement preSql;
        String sqlStr = "update register_table set password = ? where id = ?";
        int ok = 0;
        try {
            preSql = connection.prepareStatement(sqlStr);
            String id = login.getId();
            String pw = login.getPassword();
            pw = Encrypt.encrypt(pw, "minima");//把用户密码加密
            preSql.setString(1, pw);
            preSql.setString(2, id);
            ok = preSql.executeUpdate();
            connection.close();
        }
        catch(SQLException e) {}
        if (ok != 0) {
            isSuccess = true;
        }
        return isSuccess;
    }
}

