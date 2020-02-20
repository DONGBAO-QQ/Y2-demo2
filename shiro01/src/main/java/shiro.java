import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class shiro {
    public static void main(String[] args) {

        //1.读取配置文件，初始化工厂对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:jdbc_realm.ini");
        //2.获取SecurityManager实例
        SecurityManager manager = factory.getInstance();
        //3.将SecurityManager绑定到工具类
        SecurityUtils.setSecurityManager(manager);
        //4.通过SecurityUtils得到当前登录的用户
        Subject currentUser = SecurityUtils.getSubject();
        //5.窗口登录令牌
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
        //6.登录并传入令牌
        try {
            currentUser.login(token);
            System.out.println("身份信息验证成功！");
        } catch (Exception e) {
            e.printStackTrace();
            //6.登录并传入令牌
            currentUser.login(token);
            System.out.println("身份信息验证失败！");
        }
        currentUser.logout();
    }
}
