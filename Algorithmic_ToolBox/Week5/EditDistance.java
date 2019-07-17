//package Courses.Algorithmic_ToolBox.Week5;

import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here


    int n1=s.length();
    int n2=t.length();

    int[][] table=new int[n1+1][n2+1];

    for (int i = 0; i <n1+1 ; i++)
      table[i][0]=i;

    for (int j = 0; j < n2+1; j++)
      table[0][j]=j;


    for (int k =1 ; k <=n1 ; k++) {
      for (int l = 1; l <=n2 ; l++) {

        if(s.charAt(k-1)==t.charAt(l-1))
          table[k][l]=table[k-1][l-1];
        else
        {
          int min=Math.min(table[k-1][l]+1,table[k][l-1]+1);
          table[k][l]=Math.min(min,table[k-1][l-1]+1);

        }
      }
    }



    return table[n1][n2];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
