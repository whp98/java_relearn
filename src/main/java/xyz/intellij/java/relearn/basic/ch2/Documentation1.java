package xyz.intellij.java.relearn.basic.ch2;
import java.util.Date;

/**
 * Documentation1
 *
 * @author whp98
 * @date 2020/03/18
 */
public class Documentation1 {
    /**
     * 主要
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        //打印时间
        System.out.println("打印时间");
        System.out.println(new Date());
        //打印系统参数
        System.out.println("打印系统参数");
        System.getProperties().list(System.out);
        //打印用户名
        System.out.println("user.name::::"+System.getProperty("user.name"));
        //打印java.library.path
        System.out.println("java.library.path::::"+System.getProperty("java.library.path"));
    }
}

