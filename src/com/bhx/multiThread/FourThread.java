package com.bhx.multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 给定一个数组[1,2,3,4,5,6,7,8,9....,15]，要求遍历数组，遇到可以同时被3和5整除的数字，打印C；遇到仅能被5整除的数字，打印B；遇到仅能被3整除的数字，打印A；其他打印数字本身；
 *
 * 要求四个线程，每一个线程执行一个打印方法。
 */
public class FourThread implements Runnable {

    private static final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile int currentCount = 0;

    private PrintFunction printFunction;

    private int flag;

    public FourThread(int flag, PrintFunction printFunction) {
        this.flag = flag;
        this.printFunction = printFunction;
    }

    private int checkFlag(int n) {
        if (n % 15 == 0) {
            return 0;
        } else if (n % 5 == 0) {
            return 1;
        } else if (n % 3 == 0) {
            return 2;
        } else {
            return 3;
        }
    }

    @FunctionalInterface
    interface PrintFunction {
        void print(int n);
    }


    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (currentCount < array.length && checkFlag(array[currentCount]) % 4 != flag) {
                    condition.await();
                }
                if (currentCount < array.length) {
                    printFunction.print(array[currentCount]);
                    currentCount++;
                    condition.signalAll();
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new FourThread(0, (n) -> System.out.print("C"))).start();
        new Thread(new FourThread(1, (n) -> System.out.print("B"))).start();
        new Thread(new FourThread(2, (n) -> System.out.print("A"))).start();
        new Thread(new FourThread(3, (n) -> System.out.print(n))).start();
    }

}