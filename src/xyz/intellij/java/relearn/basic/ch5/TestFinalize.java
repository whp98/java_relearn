package xyz.intellij.java.relearn.basic.ch5;

/**
 * @Classname TestFinalize
 * @Description 测试垃圾回收
 * @Date 2020/5/10 18:38
 * @Created by whp98
 */
public class TestFinalize {
    TestFinalize(long l){
        this.a = l;
    }

    //占用内存
    private long a;
    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.a+"   执行finalized");
        super.finalize();
    }

    public static void main(String[] args) {
        TestFinalize testFinalize = new TestFinalize(0L);
        testFinalize =null;
        long i=1;
        while(true){
            //不断创建String对象来占用内存
            String s = "" + i;
        }
    }
}
