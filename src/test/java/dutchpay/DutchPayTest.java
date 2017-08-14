package dutchpay;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;

public class DutchPayTest {


    private DutchPay dutchpay;
    private int totalMoney;

    @Before
    public void create_dutchPay_class(){
        dutchpay = new DutchPay();
    }

    @Test
    public void calc_0won_and_0people(){
        dutchpay.calcMoney(0, 0);
    }

    @Test
    public void calc_0won_and_1people(){
        dutchpay.calcMoney(0, 1);
    }

    @Test
    public void calc_0won_and_2people(){
        dutchpay.calcMoney(0, 2);
    }

    @Test
    public void calc_1won_and_1people(){
        dutchpay.calcMoney(1, 1);
    }

    @Test
    public void calc_1002won_and_3people(){
        totalMoney = 1002;
        ArrayList arrayList = dutchpay.calcMoney(totalMoney, 3);
        Assert.assertThat(totalMoney,is(getSum(arrayList)));
    }

    @Test
    public void calc_1005won_and_3people(){
        totalMoney = 1005;
        ArrayList arrayList = dutchpay.calcMoney(totalMoney, 3);

        Assert.assertThat(totalMoney,is(getSum(arrayList)));
    }

    @Test
    public void calc_10000won_and_4people(){
        totalMoney = 10000;
        ArrayList arrayList = dutchpay.calcMoney(totalMoney, 4);

        Assert.assertThat(totalMoney,is(getSum(arrayList)));
    }

    @Test
    public void calc_1196300won_and_3people(){
        totalMoney = 1196300;
        ArrayList arrayList = dutchpay.calcMoney(totalMoney, 3);

        Assert.assertThat(totalMoney,is(getSum(arrayList)));
    }

    @Test
    public void calc_900won_and_6people(){
        totalMoney = 900;

        ArrayList arrayList = dutchpay.calcMoney(totalMoney, 6);
        Assert.assertThat(totalMoney,is(getSum(arrayList)));

    }



    private int getSum(ArrayList list) {
        int sum = 0;
        for (int i = 0 ; i < list.size(); i++){
            sum += (Integer) list.get(i);
        }
        return sum;
    }


}
