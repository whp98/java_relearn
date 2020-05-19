package xyz.intellij.java.relearn.basic.ch4;

import java.util.Random;

/**
 * 随机测试
 *
 * @author whp98
 * @date 2020/04/01
 */
public class RandomTest{
    public static void main(String[] args) {
        //里面是种子
        Random random = new Random(26);
        for(int i=0;i<30;i++){
            //next里面是大小限制
            System.out.println((char)(random.nextInt(26)+'a'));
        }
    }
}