package zengchen233.cn;

/**
 * @class: Encrypt
 * @author: Zc
 * @Date: 2021/03/18 18:45
 * Description: 对用户注册的密码进行加密算法,并存储到数据库。
 */
public class Encrypt {
    public static String encrypt(String sourceString, String password){
        char [] p = password.toCharArray();
        int n = p.length;
        char [] s = sourceString.toCharArray();
        int m = s.length;
        for(int i = 0; i < m; i++){    //加密算法的精髓
            int mima = s[i] + p[i%n];
            s[i] = (char) mima;
        }
        return new String(s);
    }
}
