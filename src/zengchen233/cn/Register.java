package zengchen233.cn;

/**
 * @class: Register
 * @author: Zc
 * @Date: 2021/03/18 18:31
 * Description: 记录用户注册的信息。
 */
public class Register {
    String id;
    String password;
    public void setId(String id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public  String getPassword() {
        return password;
    }
}
