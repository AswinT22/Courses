package Courses.Algorithmic_ToolBox.Week2;


import java.math.BigInteger;
import java.util.*;


public class LCM {
//  private static long lcm_naive(int a, int b) {
//    for (long l = 1; l <= (long) a * b; ++l)
//      if (l % a == 0 && l % b == 0)
//        return l;
//
//    return (long) a * b;
//  }


  private static BigInteger lcm(int a, int b) {
    BigInteger gcd=BigInteger.valueOf(gcd(a,b));
    return new BigInteger(String.valueOf(a)).multiply(BigInteger.valueOf(b)).divide(gcd);
  }

  public static int gcd(int a, int b) {


    if(a==0)
      return b;
    else if(b==0)
      return a;

    else{

      if(a<b)
        return gcd(a,b%a);

      return gcd(a%b,b);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
