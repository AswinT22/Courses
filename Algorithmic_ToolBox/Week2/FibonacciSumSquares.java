package Courses.Algorithmic_ToolBox.Week2;

import java.math.BigInteger;
import java.util.*;

public class FibonacciSumSquares {
//    private static long getFibonacciSumSquaresNaive(long n) {
//        if (n <= 1)
//            return n;
//
//        long previous = 0;
//        long current  = 1;
//        long sum      = 1;
//
//        for (long i = 0; i < n - 1; ++i) {
//            long tmp_previous = previous;
//            previous = current;
//            current = tmp_previous + current;
//            sum += current * current;
//        }
//
//        return sum % 10;
//    }
static  final BigInteger one=BigInteger.ONE;
    static  final BigInteger zero=BigInteger.ZERO;

    private static void multiply(BigInteger[][]f,BigInteger[][]m){

        BigInteger x= (f[0][0].multiply(m[0][0]).mod(BigInteger.valueOf(10))).add(f[0][1].multiply(m[1][0]).mod(BigInteger.valueOf(10)));
        BigInteger y= (f[0][0].multiply(m[0][1]).mod(BigInteger.valueOf(10))).add(f[0][1].multiply(m[1][1]).mod(BigInteger.valueOf(10)));
        BigInteger z= (f[1][0].multiply(m[0][0]).mod(BigInteger.valueOf(10))).add(f[1][1].multiply(m[1][0]).mod(BigInteger.valueOf(10)));
        BigInteger w= (f[1][0].multiply(m[0][1]).mod(BigInteger.valueOf(10))).add(f[1][1].multiply(m[1][1]).mod(BigInteger.valueOf(10)));

        f[0][0]=x.mod(BigInteger.valueOf(10));
        f[0][1]=y.mod(BigInteger.valueOf(10));
        f[1][0]=z.mod(BigInteger.valueOf(10));
        f[1][1]=w.mod(BigInteger.valueOf(10));
    }

    private static void power(BigInteger[][] f, long n)
    {
        if (n==1 || n==0)
            return;

        BigInteger[][] m={{one,one},{one,zero}};

        power(f,n/2);
        multiply(f,f);

        if(n%2!=0)
            multiply(f,m);



    }

    private static BigInteger getFibonaci(long n){

        if(n<=1)
            return BigInteger.valueOf(n);



        BigInteger f[][]={{one,one},{one,zero}};

        power(f,n);



        return f[0][1].mod(BigInteger.TEN);



    }
    private static long getFibonacciSumSquaresNaive(long n)
    {

        if(n<=1)
            return n;




        BigInteger temp=getFibonaci(n+1).mod(BigInteger.TEN).multiply(getFibonaci(n).mod(BigInteger.TEN));




        // }

        return temp.mod(BigInteger.valueOf(10)).longValue();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

