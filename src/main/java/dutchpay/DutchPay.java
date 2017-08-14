package dutchpay;

import java.util.ArrayList;

// TODO 100원 이하 돈을 몰아 줄 때 제일 큰 금액을 내는 사람이 아닌 다른 사람에게 몰아 줄 수도 있다.
// TODO 추가기능 : 총 금액이 아닌 금액과 내용들을 입력받아 sum하기.

// TODO 나중에 서비스 할 때 UI에서는 영수증처럼 출력
//      거래일자, 거래내역, 함계 등

public class DutchPay {

    ArrayList moneyList = new ArrayList<Integer>();
    int firstMoney = 0;
    int secondMoney = 0;
    int restMoney = 0;


    public ArrayList calcMoney(int won,int personnel){
        if(personnel  < 2)
            moneyList.add(won);
        else if(won  < 1 )
            moneyList.add(0);
        else
            divide(won, personnel);
        System.out.println(moneyList);
        return moneyList;
    }

    public void divide(int won, int personnel) throws IllegalArgumentException{
        double doubleWon = won / (double)personnel;
        restMoney = (int) ((Math.round(doubleWon / 100)) * 100);
        firstMoney = won - (restMoney * (personnel-1));

//        if (firstMoney > 0) {
            moneyList.add(firstMoney);
            for (int i = 0; i < personnel-1; i++)
                moneyList.add(restMoney);
//        } else {    // first money 가 0이면 딱 딱맞아떨어진다는 뜻
//
//            System.out.println("rest money " + restMoney);
//
//            int tmpRestMoney = 0;
//            while ((tmpRestMoney + restMoney) < won) {
//                tmpRestMoney += restMoney;
//            }
//
//            int tmp = won - tmpRestMoney;
//            for (int i = 0; i < personnel-2; i++)
//                moneyList.add(restMoney);

//            firstMoney = restMoney / 2 ;
//            secondMoney = restMoney / 2 ;
//            moneyList.add(firstMoney);
//            moneyList.add(secondMoney);
//            for (int i = 0; i < personnel-2; i++) {
//                moneyList.add(restMoney);
//            }

//            System.out.println(firstMoney);
//            System.out.println(secondMoney);
//            System.out.println(restMoney);


//        }

    }

}
