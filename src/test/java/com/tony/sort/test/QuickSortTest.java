package com.tony.sort.test;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/3/12
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class QuickSortTest {

    //排序主方法
    public void quickSort(Integer[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            quickSort(list, low, middle - 1);        //对低字表进行递归排序
            quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

    public int getMiddle(Integer[] list, int low, int high) {
        int tmp = list[low];    //数组的第一值作为中轴
        System.out.println();
        System.out.println("基准值tmp=" + tmp);
        while (low < high) {
            while (low<high && tmp<=list[high]) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            System.out.print (StringUtils.join(list,","));
            System.out.println(" //基准值tmp=" + tmp);
            while (low < high && tmp>list[low]) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
            System.out.print(StringUtils.join(list,","));
            System.out.println(" //基准值tmp=" + tmp);
        }
        list[high] = tmp;              //中轴记录到尾
        System.out.print(StringUtils.join(list,","));
        System.out.println(" //基准值tmp=" + tmp);
        return low;                   //返回中轴的位置下标
    }


    @Test
    public void test() {
        Integer[] arrays = {49,38,65,97,76,13,27,49};
        System.out.println("基础顺序: \n"+StringUtils.join(arrays,","));
        quickSort(arrays,0,7);

    }

}
