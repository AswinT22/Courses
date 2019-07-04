package Courses.Algorithmic_ToolBox.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

public class StressTestMaxPair {


    static BigInteger getMaxPairwiseProductFast(int[] numbers) {

        int n = numbers.length;
        long max=numbers[0];
        long max_2=Integer.MIN_VALUE;

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

    static BigInteger getMaxPairwiseProductNaive(int[] numbers) {
        BigInteger max_product =new BigInteger(String.valueOf(Integer.MIN_VALUE));
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = max_product.max(BigInteger.valueOf(numbers[first]).multiply(BigInteger.valueOf(numbers[second])));
            }
        }
        return max_product;
    }

    public static void main(String[] args) {

        FastScanner sc=new FastScanner(System.in);
        System.out.print("Enter number of test cases:");
        long numberOfTestcases=sc.nextInt();
        long count=1;
        long passed=0;
        while (count<=numberOfTestcases) {
            System.out.println("--------------------- Test Case " + count + "  ---------------------");
            ++count;

            Random rand = new Random();
            // This will generate number from 2 to 10
            int n = rand.nextInt(9999) + 2;

            int[] numbers = new int[n];

            for (int i = 0; i < n; i++) {

                //Generates numbers from 1 to 100000
                numbers[i] = rand.nextInt(100000) + 1;

            }

            System.out.println("Number of Elements :" + n);
            System.out.print("List of elements: ");
            for (int i = 0; i < n; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();

            BigInteger res1 = getMaxPairwiseProductFast(numbers);
            BigInteger res2 = getMaxPairwiseProductNaive(numbers);

            if (res1.compareTo(res2)!=0)
                System.out.println("Wrong    Naive:" + res2 + "  Fast:" + res1);
            else {
                ++passed;
                System.out.println("Test Passed!!!  Answer:" + res1);
            }
        }
        System.out.printf("\n \n");
        System.out.println("Total test case:"+numberOfTestcases+"   Test cases passed:"+passed+"  Test cases failed:"+(numberOfTestcases-passed));
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
