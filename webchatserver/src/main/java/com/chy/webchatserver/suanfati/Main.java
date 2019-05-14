package com.chy.webchatserver.suanfati;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.next().split(",");
        int[] a = new int[str.length];
        char[] ch = {'A','B','C'};
        int k = 0;
        for(int i=0;i<str.length;i++){
            a[i] = Integer.parseInt(str[i]);
            k ^= a[i];
        }
        if(k == 0){
            System.out.println(1);
        }else{
            for(int i=0;i<str.length;i++){
                int num = k^a[i];
                int temxor = num^num;
                if(a[i]-num>=0 && temxor==0){
                    System.out.println(ch[i] + "," + (a[i]-num));
                    break;
                }
            }
        }
    }
}