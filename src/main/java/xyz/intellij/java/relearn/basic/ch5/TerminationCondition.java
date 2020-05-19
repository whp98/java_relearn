package xyz.intellij.java.relearn.basic.ch5;

/**
 * 终结条件测试
 *
 * @author whp98
 * @date 2020/03/24
 */
public class TerminationCondition {
    /**
     * 主要
     *
     * @param args arg
     */
    public static void main(String[] args) {
        Book novel = new Book(true);
        //正常回收
        novel.checkIn();
        //没有引用的用于强制垃圾回收
        new Book(true);
        //强制垃圾回收
        System.gc();
    }
}
