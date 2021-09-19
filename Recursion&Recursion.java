package com.xiaoyou.Test02;

public class Test01 {

    //递归方法
    public static int Recursion(int n){
        if(n==1)return 1;
        if(n==2)return 2;

        return Recursion(n-1)+Recursion(n-2);
    }

    //递推方法
    public static int Recurrence(int n){
        if(n==1)return 1;
        if(n==2)return 2;

        int Part1 = 1;
        int Part2 = 2;
        int temp;
        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = Part1+Part2;
            temp = Part2;
            Part2 = sum;
            Part1 = temp;
        }

        return sum;
    }


    public static void main(String[] args) {
        System.out.println(Recurrence(10));

        System.out.println(Recursion(10));

    }

}
