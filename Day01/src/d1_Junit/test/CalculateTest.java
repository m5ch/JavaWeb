package d1_Junit.test;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ Classname CalculateTest
 * @ Description TODO
 * @ Date 2022/5/7 13:35
 * @ Created by 落尘
 */
public class CalculateTest {
    @Test
    public void Calculate(){
        Calculate c = new Calculate();
        int result = c.plus(1,2);

        //断言
        Assert.assertEquals(3,result);
    }
}
