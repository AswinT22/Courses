//package Courses.Algorithmic_ToolBox.Week5;

import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here

        int n1=a.length;
        int n2=b.length;

        int[][] table=new int[n1+1][n2+1];

        for (int i = 0; i <=n1 ; i++)

            table[i][0]=0;

        for (int i = 0; i <=n2 ; i++)
            table[0][i]=0;



        for (int i = 1; i <=n1 ; i++) {

            for (int j = 1; j <= n2; j++) {

                if (a[i-1]==b[j-1])
                    table[i][j]=table[i-1][j-1]+1;
                else {

                    int max=Math.max(table[i][j-1],table[i-1][j]);
                    table[i][j]=Math.max(max,table[i-1][j-1]);

                }

            }

        }

        return table[n1][n2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

