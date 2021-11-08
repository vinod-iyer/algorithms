package com.practice;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(new Recursion().sum(10));

    }

    public int sum(int n){
        int returnVal=0;
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return sum(n-2)+ (n-1)+n;
    }
}
