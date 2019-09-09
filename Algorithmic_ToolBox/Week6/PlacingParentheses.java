package Courses.Algorithmic_ToolBox.Week6;

import java.util.*;

public class PlacingParentheses {



    private static long[] getMaximValue(String exp,Map<String,long[]> map){

        if(map.containsKey(exp))
            return map.get(exp);


            long[] res=new long[2];
            boolean flag=true;
            long max=Long.MIN_VALUE;
            long min=Long.MAX_VALUE;
            for (int i = 0; i < exp.length(); i++) {

                if (isOperator(exp.charAt(i))) {
                    flag=false;
                    //Checking for max and min of left side of the operator
                    long[] preList=getMaximValue(exp.substring(0,i), map);
                    //Checking for max and min of right side of the operator
                    long[] postList=getMaximValue(exp.substring(i+1,exp.length()), map);


                    //Generating current max and min from max and min of left and right side
                    for (int j = 0; j < preList.length; j++) {

                        for (int k = 0; k < postList.length; k++) {


                            long val=eval(preList[j],postList[k],exp.charAt(i));

                            if(val>max)
                                max=val;

                            if(val<min)
                                min=val;
                        }
                    }
                }


            }



        //Only max and min val have the possibility of producing the max value

        if(flag){
            //if no operator are found it means only one number is part of the current exp which will be min and max
            long val=Long.parseLong(exp);
            res[0]=val;
            res[1]=val;
        }
        else {

            res[0]=min;
            res[1]=max;
        }

        //Storing the exp as the key and value as {min,max}
        map.put(exp,res);
        return res;
    }


    private static boolean isOperator(char c){


        return c=='+'||c=='-'||c=='*';

    }


    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,long[]> map=new HashMap<>();
        String exp = scanner.next();

        //MAX is at index 1
        System.out.println(getMaximValue(exp,map)[1]);
    }
}

