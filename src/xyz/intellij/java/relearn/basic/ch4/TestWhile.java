package xyz.intellij.java.relearn.basic.ch4;

public class TestWhile {
    static boolean condition(){
        boolean result = Math.random()<0.99;
        System.out.println("result:"+result);
        return result;
    }

    public static void main(String[] args) {
        while(condition())
            System.out.println("in while");
        System.out.println("out while");
    }
}
