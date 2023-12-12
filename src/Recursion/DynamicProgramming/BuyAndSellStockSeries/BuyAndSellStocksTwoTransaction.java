package Recursion.DynamicProgramming.BuyAndSellStockSeries;

//File Created by -- > anuragbhatt
//Created On -- > 26/09/23,Tuesday

public class BuyAndSellStocksTwoTransaction {

    public static void main(String[] args) {
        int[] arr = {10, 22 ,5 ,75, 65,80};

        System.out.println(twoTrans(arr));
    }

    public static int twoTrans(int[] prices)
    {
        int [] hack = new int[prices.length];

        int min = prices[0] , max = 0;

        for(int i = 1 ;i < prices.length ; ++i)
        {
            int today = prices[i];

            if(min > today)
            {
                min = today;
            }
            int diff = today - min ;
            max = Math.max(max , diff);
            hack[i] = max;
        }

        int maxDay = prices[prices.length-1] , maxBuy = 0 , ans = 0;

        for(int j = prices.length-2 ; j >= 0 ; --j)
        {
            int today = prices[j];

            if(today > maxDay)maxDay = today;

            int diff = maxDay - today;
            maxBuy = Math.max(diff , maxBuy);
            hack[j] += maxBuy;

            ans = Math.max(ans , hack[j]);
        }


        return ans;
    }
}
