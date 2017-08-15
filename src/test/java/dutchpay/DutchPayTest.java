package dutchpay;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;

public class DutchPayTest {

    private DutchPay dutchpay;

    @Before
    public void create_dutchPay_class(){
        dutchpay = new DutchPay();
    }


    @Ignore
    @Test
    public void calc_0won_and_0personnel_return_ArrayList_1size_0won(){
        ArrayList calculate = dutchpay.calculate(0, 0);
        Assert.assertThat(0,is(calculate.get(0)));
    }

    @Ignore
    @Test
    public void calc_0won_and_1personnel_return_ArrayList_1size_0won(){
        ArrayList calculate = dutchpay.calculate(0, 1);
        Assert.assertThat(0,is(calculate.get(0)));
    }

    @Ignore
    @Test
    public void calc_1won_and_1personnel_return_ArrayList_1size_1won(){
        ArrayList calculate = dutchpay.calculate(1, 1);
        Assert.assertThat(1,is(calculate.get(0)));
    }


    @Test
    public void calc_2won_and_1personnel_return_ArrayList_1size_2won(){
        ArrayList calculate = dutchpay.calculate(2, 1);
        Assert.assertThat(2,is(calculate.get(0)));
    }

    @Ignore
    @Test
    public void calc_1won_and_2personnel_return_ArrayList_0size_exception(){
        ArrayList calculate = dutchpay.calculate(1, 2);
        Assert.assertThat(0,is(calculate.get(0)));
    }

    @Ignore
    @Test
    public void test_exception(){
        dutchpay.calculate(1,2);
    }

    @Test
    public void calc_100won_and_2personnel_return_ArrayList_2size_50won(){
        ArrayList calculate = dutchpay.calculate(100, 2);
        getSum(calculate);
        Assert.assertThat(50,is(calculate.get(0)));
    }

    @Test
    public void calc_100won_and_3personnel_return_ArrayList_3size(){
        ArrayList calculate = dutchpay.calculate(1101, 7);
        getSum(calculate);
//        Assert.assertThat(100,is(getSum(calculate)));
    }





    private int getSum(ArrayList list) {
        int sum = 0;
        for (int i = 0 ; i < list.size(); i++){
            sum += (Integer) list.get(i);
        }
        System.out.println("amount list: " + list);
        System.out.println("sum amount : " + sum);
        return sum;
    }







}
