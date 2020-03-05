package com.tony.exception.test;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/3/5
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class SubThread implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setName("SubThread Name of SubThread");
        System.out.println("run sub SubThread...");
        if(true) {
            throw new RuntimeException("SubThread Exception occured");
        }

    }

    /**
     * 自定义一个子线程的异常捕获处理器
     */
    public static class SubThreadExceptionHandler implements Thread.UncaughtExceptionHandler{

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("say some words for subThread Exception");
            System.out.println(t.getName());
            // do somethings for exception
        }
    }

    public static void main(String[] args) {
        try {

            //全局设置所有的线程异常
//            Thread.setDefaultUncaughtExceptionHandler(new SubThreadExceptionHandler());

            Thread thread = new Thread(new SubThread());
            // 给子线程设置未捕获异常的处理器.即当子线程发生异常时的处理逻辑
            thread.setUncaughtExceptionHandler(new SubThreadExceptionHandler());
            thread.start();

            if(true){
                throw new Exception("Main Exception");
            }

        } catch (Exception e) {
            //主线程是catch不到子线程的exception的, 所以这句话永远不会打印.
            System.out.println("Get Main Exception");
            e.printStackTrace();
        }
    }


}

