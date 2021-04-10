package zengchen233.cn;

/**
 * @class: Login
 * @author: Zc
 * @Date: 2021/03/18 18:37
 * Description: 登陆
 */
public class Login {
    boolean loginSuccess = false;    //先开始把登陆成功的信息设置为否
    String id;
    String password;

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setLoginSuccess(boolean bo) {
        loginSuccess = bo;
    }

    public boolean getLoginSuccess() {
        return loginSuccess;
    }
}
