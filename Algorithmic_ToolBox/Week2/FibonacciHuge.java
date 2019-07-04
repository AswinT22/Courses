package Courses.Algorithmic_ToolBox.Week2;


import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
//    private static long getFibonacciHugeNaive(long n, long m) {
//        if (n <= 1)
//            return n;
//
//        long previous = 0;
//        long current  = 1;
//
//        for (long i = 0; i < n - 1; ++i) {
//            long tmp_previous = previous;
//            previous = current;
//            current = tmp_previous + current;
//        }
//
//        return current % m;
//    }

    private static final BigInteger one=BigInteger.ONE;
    private static final BigInteger zero=BigInteger.ZERO;
    private static Map table;

    public static void multiply(BigInteger f[][],BigInteger m[][])
    {

        BigInteger x=(f[0][0].multiply(m[0][0])).add(f[0][1].multiply(m[1][0]));
        BigInteger y=(f[0][0].multiply(m[0][1])).add(f[0][1].multiply(m[1][1]));
        BigInteger z=(f[1][0].multiply(m[0][0])).add(f[1][1].multiply(m[1][0]));
        BigInteger w=(f[1][0].multiply(m[0][1])).add(f[1][1].multiply(m[1][1]));
        f[0][0]=x;
        f[0][1]=y;
        f[1][0]=z;
        f[1][1]=w;

    }


    public static void power(BigInteger f[][],long n)
    {


    if(n==0||n==1)
        return;

    BigInteger[][] m={{one,one},{one,zero}};
     power(f,n/2);
     multiply(f,f);

     if(n%2!=0)
         multiply(f,m);





    }

    public static BigInteger getFibonacci(long n){

        if(n<=1)
            return BigInteger.valueOf(n);

        if(table.get(n)!=null)
            return (BigInteger) table.get(n);

        BigInteger f[][]={{one,one},{one,zero}};

        power(f,n);

        table.put(n,f[0][1]);

        return f[0][1];

    }


    private static long pisanoperiod(long n,long m,List values){


        long value= n/2;



        long count=2;
        boolean flagZero=false;
        boolean flagOne=false;
        values.add(0);
        values.add(1);

        while(count<value){


        BigInteger res=getFibonacci(count).mod(BigInteger.valueOf(m));

        values.add(res);

        if(BigInteger.ZERO.compareTo(res)==0)
        {
            flagZero=true;
            flagOne=false;

        }
        else if(flagZero && (BigInteger.ONE.compareTo(res)==0)){

            flagOne=true;
            break;
        }

        else
        {

            flagZero=false;
            flagOne=false;

        }
        ++count;

        }

        if(flagOne && flagZero){
        long size= values.size()-2;
        values.remove(size);
        values.remove(size+1);
        return size;

        }

        return -1;

    }

    private static long getFibonacciHuge(long n, long m) {

        List values=new ArrayList();

        long res=pisanoperiod(n,m,values);
        if(res==-1)
            return getFibonacci(n).mod(BigInteger.valueOf(m)).longValue();

        int modValue=(int)(n %res);

        return ((Number)values.get(modValue)).longValue();

//        BigInteger res=getFibonacci(n);
//        //System.out.println(res);
//        return res.mod(BigInteger.valueOf(m)).longValue();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
       table=new HashMap<Long,BigInteger>();
        System.out.println(getFibonacciHuge(n, m));
    }
}

