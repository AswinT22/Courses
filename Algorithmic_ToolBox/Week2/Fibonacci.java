package Courses.Algorithmic_ToolBox.Week2;


import java.math.BigInteger;
import java.util.Scanner;



public class Fibonacci {


 static BigInteger[] table;
  private static BigInteger calc_fib(int n) {

    if (n <= 1)
      return new BigInteger(String.valueOf(n));

    if (table[n]!=null)
      return table[n];



    table[n]=calc_fib(n - 1).add( calc_fib(n - 2));

    return table[n];

  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    table=new BigInteger[n+1];
    System.out.println(calc_fib(n));
  }
}
