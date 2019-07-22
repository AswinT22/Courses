//package Courses.Algorithmic_ToolBox.Week6;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
//        int result = 0;
//        for (int i = 0; i < w.length; i++) {
//          if (result + w[i] <= W) {
//            result += w[i];
//          }
//        }
//        return result;


    int[][]table =new int[w.length+1][W+1];
        for (int i = 1; i <=w.length ; i++) {

            for (int j = 1; j <=W ; j++) {

                if (j>=w[i-1])
                {

                    table[i][j]=Math.max(table[i-1][j],table[i-1][j-w[i-1]]+w[i-1]);


                }
                else
                    table[i][j]=table[i-1][j];


            }
        }

        return table[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

