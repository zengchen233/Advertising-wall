package zengchen233.cn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @class: ConnectDatabase
 * @author: Zc
 * @Date: 2021/03/18 22:36
 * Description:
 */
public class ConnectDatabase {
    Connection connection;
    public final void connectDatabase() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   //加载jdbc驱动
//            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
//            System.out.println("数据库驱动加载失败");
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/guanggao_db?useSSL=false&serverTimezone=Hongkong",
                    "zengchen","zengchen233");   //连接代码
//            System.out.println("数据库连接成功");
        } catch (SQLException e) {
//            System.out.println("数据库连接失败");
        }
    }
}
