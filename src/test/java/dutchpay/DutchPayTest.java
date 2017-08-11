package dutchpay;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;

public class DutchPayTest {


    private DutchPay dutchpay;

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
    public void calc_1000won_and_3people(){
        ArrayList arrayList = dutchpay.calcMoney(1002, 3);
        Assert.assertThat(402,is(arrayList.get(0)));
        Assert.assertThat(300,is(arrayList.get(1)));
        Assert.assertThat(300,is(arrayList.get(2)));
    }

    @Test
    public void calc_1005won_and_3people(){
        ArrayList arrayList = dutchpay.calcMoney(1005, 3);
        Assert.assertThat(405,is(arrayList.get(0)));
        Assert.assertThat(300,is(arrayList.get(1)));
        Assert.assertThat(300,is(arrayList.get(2)));
    }

    @Test
    public void calc_10000won_and_4people(){
        ArrayList arrayList = dutchpay.calcMoney(10000, 4);
        Assert.assertThat(2500,is(arrayList.get(0)));
        Assert.assertThat(2500,is(arrayList.get(1)));
        Assert.assertThat(2500,is(arrayList.get(2)));
        Assert.assertThat(2500,is(arrayList.get(3)));
    }

    @Test
    public void calc_1196300won_and_3people(){
        ArrayList arrayList = dutchpay.calcMoney(1196300, 3);
        Assert.assertThat(398700,is(arrayList.get(0)));
        Assert.assertThat(398800,is(arrayList.get(1)));
        Assert.assertThat(398800,is(arrayList.get(2)));
    }

        @Test
    public void calc_850won_and_4people(){
        ArrayList arrayList = dutchpay.calcMoney(600, 4);
//        Assert.assertThat(398700,is(arrayList.get(0)));
//        Assert.assertThat(398800,is(arrayList.get(1)));
//        Assert.assertThat(398800,is(arrayList.get(2)));
    }





}
