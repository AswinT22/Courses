package Courses.Algorithmic_ToolBox.Week1;//package Courses.Algo;
import java.math.BigInteger;
import java.util.*;
import java.io.*;




public class MaxPairwiseProduct {



    static BigInteger getMaxPairwiseProduct(int[] numbers) {

        int n = numbers.length;


        int max=numbers[0];
        int max_2=Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            int number=numbers[i];
            if (number>max)
            {
                max_2=max;
                max=number;
            }
            else if(number> max_2)
                max_2=number;


        }

        return BigInteger.valueOf(max).multiply(BigInteger.valueOf(max_2));
    }



    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
       System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}