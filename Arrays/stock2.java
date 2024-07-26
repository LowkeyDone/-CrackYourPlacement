class Solution {
    //space optimised
    public int maxProfit(int[] prices) {
        int ahead[]=new int[2];
        int curr[]=new int[2];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==0)
                    curr[j]=Math.max(-prices[i]+ahead[1],ahead[0]);
                else
                    curr[j]=Math.max(prices[i]+ahead[0],ahead[1]);

                ahead[0]=curr[0];
                ahead[1]=curr[1];
            }
        }
        return curr[0];
    }
}


class Solution {
    //recursive
    int profit=0;
    public int maxProfit(int[] prices) {
        int flag=0; //means we an buy
        return solve(0,prices,flag);
    }

    public int solve(int i, int arr[], int flag){
        if(i==arr.length)
            return 0;

        if(flag==0)
            return Math.max(-arr[i]+solve(i+1,arr,1-flag),solve(i+1,arr,flag));

        else
            return Math.max(arr[i]+solve(i+1,arr,1-flag),solve(i+1,arr,flag));
    }
}


class Solution {
    //memoized
    int t[][];
    public int maxProfit(int[] prices) {
        int flag=0; //means we an buy
        t=new int[prices.length][2];
        for(int row[]: t)
            Arrays.fill(row,-1);
        return solve(0,prices,flag);
    }

    public int solve(int i, int arr[], int flag){
        if(i==arr.length)
            return 0;

        if(t[i][flag]!=-1)
            return t[i][flag];

        if(flag==0)
            return t[i][flag]=Math.max(-arr[i]+solve(i+1,arr,1-flag),solve(i+1,arr,flag));

        else
            return t[i][flag]=Math.max(arr[i]+solve(i+1,arr,1-flag),solve(i+1,arr,flag));
    }
}


class Solution {
    //tabulation
    public int maxProfit(int[] prices) {
        int t[][]=new int[prices.length+1][2];
        t[prices.length][0]=0;
        t[prices.length][1]=0;
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==0)
                    t[i][j]=Math.max(-prices[i]+t[i+1][1],t[i+1][0]);
                else
                    t[i][j]=Math.max(prices[i]+t[i+1][0],t[i+1][1]);
            }
        }
        return t[0][0];
    }
}