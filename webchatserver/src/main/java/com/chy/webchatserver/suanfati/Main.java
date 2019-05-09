package com.chy.webchatserver.suanfati;

import java.util.*;
import java.util.concurrent.Callable;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] ch = sc.next().toCharArray();
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for(char c:ch){
            if(c == '[') count++;
            else {
                if(count == 0) sb.insert(0,'[');
                else count--;
            }
            sb.append(c);
        }
        while (count>0){
            sb.append(']');
            count--;
        }
        System.out.println(sb.toString());
    }
}