package com.tony.sort.test;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/4/14
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class QuickSort2 {


    public static void main(String[] args) {
//        int[] array = {3, 1, 2, 4, 5};
//        sort(array, 0, array.length-1);
//        System.out.println(array);

            int[] weight = {2,3,5,7};
            int[] value = {1,5,2,4};

            int v = 10;
            int n = 4;
            System.out.println(plan(n,v,weight,value));

    }




    public static void sort(int [] arrays,int start, int end) {
        if (start < end) {
            int middle =  getMiddle(arrays, start, end);
            sort(arrays, start, middle-1);
            sort(arrays, middle + 1, end);
        }
    }

    private static int getMiddle(int[] arrays, int start, int end) {
        int k = arrays[start];

        while (start < end) {

            while (start < end && k <= arrays[end]) {
                end--;
            }
            arrays[start] = arrays[end]; // end = 2

            while (start < end && k > arrays[start]) {
                start++; // start = 2
            }
            arrays[end] = arrays[start];

        }
        arrays[end] = k;

        return start;
    }


    public static int plan(int N, int V , int[] weight, int[] value) {

        int[][] dep = new int[N + 1][V + 1]; // [n][weight]
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (weight[i-1] > j) {
                    dep[i][j] = dep[i - 1][j];
                } else {
                    dep[i][j] = Math.max(dep[i - 1][j - weight[i-1]] + value[i-1], dep[i - 1][j]);
                }
            }
        }
        return dep[N][V];

    }


}
