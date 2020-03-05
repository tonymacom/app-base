package com.tony.exception.test;

import java.util.concurrent.*;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/3/5
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class SubThread2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("run sub SubThread...");
        if(true) {
            throw new RuntimeException("SubThread Exception occured");
        }
        return null;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Future<String> future = executorService.submit(new SubThread2());

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("get subThread2 Exception");
            e.printStackTrace();
        }
    }
}
