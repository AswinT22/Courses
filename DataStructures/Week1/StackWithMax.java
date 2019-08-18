//package Courses.DataStructures.Week1;

import java.util.*;
import java.io.*;

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        SpecialStack stack = new SpecialStack();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
            } else if ("pop".equals(operation)) {
                stack.pop();
            } else if ("max".equals(operation)) {
                System.out.println(stack.getMax());
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}



class SpecialStack extends Stack<Integer>{

    private Stack<Integer> maxStack=new Stack<>();



    public void push(int x){

        if(isEmpty()){
            super.push(x);
            maxStack.push(x);


        }else{

            super.push(x);
            int temp=maxStack.peek();

            if(x>= temp)
                maxStack.push(x);


        }



    }

    public Integer  pop()
    {

        int temp=super.pop();

        if(temp==maxStack.peek())
            maxStack.pop();

        return temp;



    }

    public Integer getMax(){


        return maxStack.peek();

    }
}
