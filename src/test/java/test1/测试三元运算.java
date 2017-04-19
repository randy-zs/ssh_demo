package test1;

import org.junit.Test;

/**
 * Created by randy on 17-4-17.
 */
public class 测试三元运算 {

    @Test
    public void a(){
        String a = "0";
        System.out.println(a.equals("1") ? "男" : a.equals("2") ? "女" : "未知");
    }

}
