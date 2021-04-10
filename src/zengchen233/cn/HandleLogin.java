package zengchen233.cn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @class: HandleLogin
 * @author: Zc
 * @Date: 2021/03/19 8:59
 * Description:
 */
public class HandleLogin extends ConnectDatabase {
    public Login handleLogin(Login login) {
        connectDatabase();
        PreparedStatement preSql;
        ResultSet rs;
        if (connection == null){
            login.setLoginSuccess(false);
            return login;
        }
        String id = login.getId();
        String pw = login.getPassword();
        String sqlStr = "select id,password from register_table where "+"id = ? and password = ?";
        try {
            preSql = connection.prepareStatement(sqlStr);
            preSql.setString(1,id);             //用来填充问号
            pw = Encrypt.encrypt(pw,"minima");      //用户密码加密
            preSql.setString(2,pw);
            rs = preSql.executeQuery();
            if (rs.next() == true) {  //检查是否为注册的用户
                login.setLoginSuccess(true);
            }
            else {
                login.setLoginSuccess(false);
            }
            connection.close();
        } catch (SQLException e) {
            login.setLoginSuccess(false);
        }
        return  login;
    }
}
