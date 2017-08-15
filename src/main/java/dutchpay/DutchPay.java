package dutchpay;

import java.math.BigDecimal;
import java.util.ArrayList;

// TODO 나중에 서비스 할 때 UI에서는 영수증처럼 출력
//      거래일자, 거래내역, 함계 등

public class DutchPay {


    public ArrayList calculate(int amounts, int personnel) {
        BigDecimal decimalAmounts = BigDecimal.valueOf(amounts);
        BigDecimal decimalPersonnel = BigDecimal.valueOf(personnel);

        tryValidation(decimalAmounts, decimalPersonnel);
        return divide(decimalAmounts,decimalPersonnel);
    }


    public void tryValidation(BigDecimal amounts, BigDecimal personnel){
        if (amounts.compareTo(personnel) < 1)
            throw new RuntimeException("Exception 발생. 금액보다 인원수가 클 수 없습니다.");
        else if(amounts == personnel)
            throw new RuntimeException("Exception 발생. 금액과 인원수가 같을 수 없습니다.");
    }


    private ArrayList divide(BigDecimal amounts, BigDecimal personnel) {
        ArrayList amountsList = new ArrayList<Integer>();

        BigDecimal remainder = amounts.remainder(personnel);
        BigDecimal divideAmounts = amounts.divide(personnel,0,BigDecimal.ROUND_DOWN);

        if (amounts.compareTo(BigDecimal.ONE) > 1 || personnel.compareTo(BigDecimal.ONE) > 1 )
            amountsList.add(0);
        else if (personnel == BigDecimal.ONE)
            amountsList.add(amounts.intValue());
        else {
            int cnt = remainder.compareTo(BigDecimal.ZERO) == 0 ? personnel.intValue() : personnel.intValue() - 1;

            for (int i=0; cnt > i; i++)
                amountsList.add(divideAmounts.intValue());

            if (remainder.compareTo(BigDecimal.ZERO) != 0)    // 나중에 사용자에게 선택권을 준다.
                amountsList.add((divideAmounts.add(remainder)).intValue());

        }
        return amountsList;
    }


}
