package Courses.Algorithmic_ToolBox.Week2;
import java.math.BigInteger;
import java.util.*;

public class FibonacciPartialSum {
//    private static long getFibonacciPartialSumNaive(long from, long to) {
//        long sum = 0;
//
//        long current = 0;
//        long next  = 1;
//
//        for (long i = 0; i <= to; ++i) {
//            if (i >= from) {
//                sum += current;
//            }
//
//            long new_current = next;
//            next = next + current;
//            current = new_current;
//        }
//
//        return sum % 10;
//    }

    static  final BigInteger one=BigInteger.ONE;
    static  final BigInteger zero=BigInteger.ZERO;

    private static void multiply(BigInteger[][]f,BigInteger[][]m){

        BigInteger x= (f[0][0].multiply(m[0][0]).mod(BigInteger.TEN)).add(f[0][1].multiply(m[1][0]).mod(BigInteger.TEN));
        BigInteger y= (f[0][0].multiply(m[0][1]).mod(BigInteger.TEN)).add(f[0][1].multiply(m[1][1]).mod(BigInteger.TEN));
        BigInteger z= (f[1][0].multiply(m[0][0]).mod(BigInteger.TEN)).add(f[1][1].multiply(m[1][0]).mod(BigInteger.TEN));
        BigInteger w= (f[1][0].multiply(m[0][1]).mod(BigInteger.TEN)).add(f[1][1].multiply(m[1][1]).mod(BigInteger.TEN));

        f[0][0]=x.mod(BigInteger.TEN);
        f[0][1]=y.mod(BigInteger.TEN);
        f[1][0]=z.mod(BigInteger.TEN);
        f[1][1]=w.mod(BigInteger.TEN);
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
    
    private  static long getFibonacciPartialSum(long from, long to) {



        BigInteger toPlus2=getFibonaci(to+2).mod(BigInteger.TEN);
        BigInteger fromPlus1=getFibonaci(from+1).mod(BigInteger.TEN);

        return toPlus2.subtract(fromPlus1).mod(BigInteger.TEN).longValue();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

