package vip.tanghong.datastructure.complexity;

import vip.tanghong.datastructure.common.TimeUtils;

/**
 * 斐波那契数列
 * 0 1 1 2 3 5 8 13 21
 * 0 1 2 3 4 5 6 7  8
 */
public class Fibonacci {

    /**
     * 采用递归实现-效率低-复杂度高(O(2^n))
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if(n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n) {
        if(n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for(int i = 2; i <= n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    /**
     * 非递归实现-效率高-复杂度低(O(n))
     * @param args
     */
    public static void main(String[] args) {
        int n = 50;

        System.out.println(fib1(n));
        System.out.println(fib2(n));

        TimeUtils.test("斐波那契数列-递归", new TimeUtils.Task() {
            @Override
            public void execute() {
                fib1(n);
            }
        });

        TimeUtils.test("斐波那契数列-非递归", new TimeUtils.Task() {
            @Override
            public void execute() {
                fib2(n);
            }
        });
    }

}
