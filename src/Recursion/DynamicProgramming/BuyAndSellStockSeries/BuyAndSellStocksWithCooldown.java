package Recursion.DynamicProgramming.BuyAndSellStockSeries;

//File Created by -- > anuragbhatt
//Created On -- > 21/09/23,Thursday

public class BuyAndSellStocksWithCooldown {

    public static void main(String[] args) {

        int[] prices = {1,2,3,0,2};

        System.out.println(withCooldown(prices , 5));

    }

    public static long withCooldown(int[] prices , int N)
    {
        int loan = -prices[0] , money = 0 , cooldown = 0;

        for(int i = 1 ; i < N ; ++i)
        {
            int newLoan = Math.max(cooldown - prices[i] , loan);
            int newMoney = Math.max(prices[i] + loan , money);
            int newCooldown = Math.max(money , cooldown);

            loan = newLoan ;
            money = newMoney;
            cooldown = newCooldown;
        }

        return money;
    }
}
