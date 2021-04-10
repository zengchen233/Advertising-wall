package zengchen233.cn;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @class: HandleAdministratorRegister
 * @author: Zc
 * @Date: 2021/04/09 22:51
 * @Description:
 */
public class HandleAdministratorRegister extends ConnectDatabase{
    public boolean handelRegister(Register register) {
        connectDatabase();      //从父类ConnectDatabase继承的方法
        boolean isSuccess = false;
        if (connection == null)  return false;
        PreparedStatement preSql;
        String sqlStr = "insert into manage_table values(?,?)";
        int ok = 0;
        try {
            preSql = connection.prepareStatement(sqlStr);
            preSql.setString(1, register.getId());
            String pw = register.getPassword();
            pw = Encrypt.encrypt(pw,"minima");    //对密码进行加密
            preSql.setString(2,pw);
            ok = preSql.executeUpdate();
            connection.close();
        } catch (SQLException e) { }
        if (ok != 0){
            isSuccess = true;
        }
        return isSuccess;
    }
}
