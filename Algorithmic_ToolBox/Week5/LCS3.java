//package Courses.Algorithmic_ToolBox.Week5;

import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here

        int n1=a.length;
        int n2=b.length;
        int n3=c.length;

        int[][][] table=new int[n1+1][n2+1][n3+1];

        for (int i = 0; i <=n1 ; i++)

            table[i][0][0]=0;

        for (int i = 0; i <=n2 ; i++)
            table[0][i][0]=0;

        for (int i = 0; i <=n3 ; i++)
            table[0][0][i]=0;



        for (int i = 1; i <=n1 ; i++) {

            for (int j = 1; j <= n2; j++) {
                for (int k = 1; k <=n3 ; k++) {

                    if (equalityOfThree(a[i-1],b[j-1],c[k-1]))
                        table[i][j][k]=table[i-1][j-1][k-1]+1;
                    else {

                        int max=Math.max(table[i][j-1][k],table[i-1][j][k]);
                        int max2=Math.max(table[i][j][k-1],table[i-1][j-1][k-1]);
                        table[i][j][k]=Math.max(max,max2);

                }



                }

            }

        }




        return table[n1][n2][n3];

    }

    private static boolean equalityOfThree(int a, int b, int c){

        if (a==b)
            if(b==c)
                return true;

        return false;

    }

//    private static int lc2(int[]a,int[]b){
//
//
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

