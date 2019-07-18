//package com.Course.Algorithmic_Toolbox;

import java.util.*;

public class PrimitiveCalculator {
//    private static List<Integer> optimal_sequence(int n) {
//        List<Integer> sequence = new ArrayList<>();
//        while (n >= 1) {
//            sequence.add(n);
//            if (n % 3 == 0) {
//                n /= 3;
//            } else if (n % 2 == 0) {
//                n /= 2;
//            } else {
//                n -= 1;
//            }
//        }
//        Collections.reverse(sequence);
//        return sequence;
//    }

    static List<Integer> sequence = new ArrayList<>();
    private static List<Integer> optimal_sequence(int n) {


        int[][] table=new int[2][n];

        table[0][0]=1;


            int lastNum=1,numCount=0;
            for (int j = 2; j < n+1; j++) {

                if(lastNum*2==j){
                    table[0][j-1]=++numCount;

                    lastNum=j;

                }
                else
                    table[0][j-1]=numCount+(j-lastNum);

            }

            lastNum=1;
            numCount=0;
            table[1][0]=1;

            for (int j = 1; j < n+1; j++) {

                if(lastNum*3==j){

                    table[1][j-1]=++numCount;
                    lastNum=j;

                }

                else if(j%3==0){

                    int min1,min2=Integer.MAX_VALUE;
                    min1=Math.min(table[0][j-1],table[1][(j/3)-1]+1);
                    if(j%2==0)
                        min2=Math.min(table[1][j-2]+1,table[1][(j/2)-1]+1);
                    else
                        min2=table[1][j-2]+1;
                    table[1][j-1]=Math.min(min1,min2);
                }

                else if(j%2==0){
                    int min=Math.min(table[0][j-1],table[1][(j/2)-1]+1);
                    min=Math.min(min,table[1][j-2]+1);
                    table[1][j-1]=min;

                }
                else if(j>3)
                    table[1][j-1]=Math.min(table[0][j-1],table[1][j-2]+1);
                else
                    table[1][j-1]=1;



            }

          //  System.out.println(table[1][n-1]);


            while (n>=1){


                sequence.add(n);
                if (n%3==0){
                    if (n%2==0){
                        int temp=n;
                        n=findMinN(table[1][(n-1)-1],n-1,table[1][(n/3)-1],n/3);
                        n=findMinN(table[1][(temp/2)-1],n/2,table[1][n-1],n);
                    }
                    else
                        n=findMinN(table[1][(n-1)-1],n-1,table[1][(n/3)-1],n/3);
                }
                else if(n%2==0){

                    n=findMinN(table[1][(n-1)-1],n-1,table[1][(n/2)-1],(n/2));

                }
                else
                    n=n-1;

            }

            Collections.reverse(sequence);
            return sequence;
    }


    private static int findMinN(int value1,int pos1,int value2,int pos2){

        return value1<value2?pos1:pos2;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> optimalSequence = optimal_sequence(n);
        System.out.println(optimalSequence.size() - 1);
        for (Integer x : optimalSequence) {
            System.out.print(x + " ");
        }
    }
}

