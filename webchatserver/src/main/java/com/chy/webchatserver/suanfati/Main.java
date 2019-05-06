package com.chy.webchatserver.suanfati;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] ch = sc.next().toCharArray();
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i=0;i<ch.length-2;i++){
                while(i<ch.length && ch[i] == '2' ) i++;
                int a = i;
                while(i<ch.length-1 && ch[i+1] == '2') i++;
                int b = i+1;
                while(i<ch.length-2 && ch[i+2] == '2') i++;
                if(i<ch.length-2 && ch[a] == ch[b] && ch[a] == ch[i+2]){
                    ch[a] = '2';
                    ch[b] = '2';
                    ch[i+2] = '2';
                    i = i+3;
                    flag = true;
                }
            }
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i] != '2'){
                System.out.print(ch[i]);
            }
        }
    }
}

