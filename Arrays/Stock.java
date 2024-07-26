class Solution {
    public int maxProfit(int[] prices) {
        //greedy apporach
        int profit=0;
        int curr=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>curr)
                profit=Math.max(profit,prices[i]-curr);
            else
                curr=prices[i];
        }
        return profit;
    }
}