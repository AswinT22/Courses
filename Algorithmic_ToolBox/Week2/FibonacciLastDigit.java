package Courses.Algorithmic_ToolBox.Week2;
import java.math.BigInteger;
import java.util.*;

public class FibonacciLastDigit {
//    private static int getFibonacciLastDigitNaive(int n) {
//        if (n <= 1)
//            return n;
//
//        int previous = 0;
//        int current  = 1;
//
//        for (int i = 0; i < n - 1; ++i) {
//            int tmp_previous = previous;
//            previous = current;
//            current = tmp_previous + current;
//        }
//
//        return current % 10;
//    }



    static final BigInteger one=BigInteger.ONE;
    static final BigInteger zero=BigInteger.ZERO;

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


    private static void power(BigInteger[][] f,int n){
        if(n==0||n==1)
            return;

        BigInteger [][] m={{one,one},{one,zero}};

        power(f,n/2);
        multiply(f,f);
        if(n%2!=0)
            multiply(f,m);




    }

    private static int getFibonacciLastDigit(int n){

        if(n<=1)
            return n;

        BigInteger [][] f={{one,one},{one,zero}};

        power(f,n);

        return f[0][1].mod(BigInteger.valueOf(10l)).intValue();





    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
       // Long a=new Long(9223372036854775807l);
        System.out.println(c);
    }
}

