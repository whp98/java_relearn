package xyz.intellij.java.relearn.basic.ch5;

/**
 * 书
 *  用于演示终结状态
 * @author whp98
 * @date 2020/03/24
 */
public class Book {
    boolean checkedOut = false;

    /**
     * 书
     *
     * @param checkOut 登记
     */
    Book(boolean checkOut){
        checkedOut=checkOut;
    }

    /**
     * 结算
     */
    void checkIn(){
        checkedOut=false;
    }

    /**
     * 终结状态，用于调试错误
     */
    protected void finalize(){
        if(checkedOut)
            System.out.println("Error:check out");
    }
}
