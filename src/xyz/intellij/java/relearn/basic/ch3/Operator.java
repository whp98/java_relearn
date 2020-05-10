package xyz.intellij.java.relearn.basic.ch3;

/**
 * 操作符
 *
 *
 *
 * @author whp98
 * @date 2020/03/18
 */
public class Operator {

    static void Print(String string){
        System.out.println(string);
    }

    public static void main(String[] args) {
        Print("你好");
        Print(Double.MIN_VALUE+"");
        Print(Float.MIN_VALUE+"");
    }
}
