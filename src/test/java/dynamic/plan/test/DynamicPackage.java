package dynamic.plan.test;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/3/13
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class DynamicPackage {

    /**
     * 0-1背包问题
     * @param V 背包容量
     * @param N 物品种类
     * @param weight 物品重量
     * @param value 物品价值
     * @return
     */
    public static int ZeroOnePack(int V,int N,int[] weight,int[] value){

        //初始化动态规划数组int
        int[][] dp = new int[N+1][V+1];
        //将dp[i][0]和dp[0][j]均置为0
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                System.out.println("第"+i+"个物品重量为"+weight[i-1]+",在容量为"+j+",本身价值为"+value[i-1]+"时:");
                //由于weight和value数组下标都是从0开始,注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if(weight[i-1] > j) {//如果第i件物品的重量大于背包容量j,则不装入背包
                    dp[i][j] = dp[i - 1][j];
                    System.out.println("不装入背包,它的最大价值与" + "dp["+(i-1)+"]["+j+"]相等,=" + dp[i - 1][j]);
                }else {//判断
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                    int not_pack = dp[i - 1][j];
                    int pack =  dp[i - 1][j - weight[i - 1]] + value[i - 1];

                    System.out.println("装入背包" + "dp["+i+"]["+j+"]=" + dp[i][j] + " 此时, 第"+i+"个物品的价值为"+value[i-1]+", 重量为"+weight[i-1]+"," +
                            "若装入该物品后,背包还能装的最大价值为dp["+(i - 1)+"]["+(j - weight[i - 1])+"]="+ (dp[i - 1][j - weight[i - 1]]) + ",总价值为"+pack+"," +
                            "如果不装,最大价值与dp["+(i - 1)+"]["+j+"]价值相同,为"+ not_pack);
                }
            }
        }
        return dp[N][V];
    }

    public static void main(String[] args) {
        int[] weight = {2,3,5,7};
        int[] value = {1,5,2,4};

        int v = 10;
        int n = 4;
        ZeroOnePack(v,n,weight,value);
    }


}
