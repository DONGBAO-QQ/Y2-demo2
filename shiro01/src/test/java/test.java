import org.apache.shiro.crypto.hash.Md5Hash;

public class test {
    public static void main(String[] args) {
        String pwd="123";
        //方式一：不设置盐值及散列次数
        //不足：可以被解密
        Md5Hash md5Hash=new Md5Hash(pwd);
        System.out.println("加密后的密码："+md5Hash);
    }
}
