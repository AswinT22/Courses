//package Courses.DataStructures.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class max_sliding_window {


    public static void main(String[] args) {

        FastScanner sc=new FastScanner();
        try {
            int n = sc.nextInt();

            int[] array=new int[n];

            for (int i = 0; i <n ; i++) { array[i]=sc.nextInt(); }

            int slideSpace=sc.nextInt();

            maxSlidingWindow(array,n,slideSpace);

        }

        catch(Exception ex){

            ex.printStackTrace();

        }

    }
    private static void maxSlidingWindow(int[] arr,int n,int k){



        //Double ended queue
        Deque<Integer> deque=new LinkedList<>();

        //Pre-Processing the initial window
        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty())
                //Removing all elements lesser the current element because it can never be the max in any window with this element being part of the window
                if(arr[deque.peekLast()]<=arr[i])
                    deque.pollLast();
                else
                    break;

            //Adding the index of the element
            deque.addLast(i);
        }
        //After this the Current max in the window will the front end of the queue


        //To Construct the output
        StringBuffer st=new StringBuffer("");

        //Since we have pre-processed the initial window
        int currentStart=1;

        for (int i=k; i<n;i++){
            //This appends the previous window's max
            st.append(arr[deque.peekFirst()]+" ");

            //Removing the max which are not part of the current window
            while (!deque.isEmpty())
                if(deque.peekFirst()<currentStart)
                    deque.pollFirst();
                else
                    break;

            //Removing all elements lesser the current element because it can never be the max in any window with this element being part of the window
            while (!deque.isEmpty())

                if(arr[deque.peekLast()]<=arr[i])
                    deque.pollLast();
                else
                    break;

            //Adding the index of the element
            deque.addLast(i);

            //Moving to next window
            ++currentStart;
        }
        st.append(arr[deque.peekFirst()]);
        System.out.println(st);

    }
   private static class FastScanner{

        StringTokenizer st =new StringTokenizer("");

        BufferedReader br;

        FastScanner(){br=new BufferedReader(new InputStreamReader(System.in)); }

        String next() throws IOException{

                while (!st.hasMoreTokens())
                    st=new StringTokenizer(br.readLine());

            return st.nextToken();

        }

        Integer nextInt() throws  IOException  {return Integer.parseInt(next());}


    }
}
