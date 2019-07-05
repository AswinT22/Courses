package Courses.Algorithmic_ToolBox.Week3;
import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
//        //write your code here
          String result = "";


      List<String> digits=new ArrayList<String>(Arrays.asList(a));
      while (!digits.isEmpty()){
          String max_Digit="0";

          for (int i=0;i<digits.size();i++)

              if(isGreaterOrEqual(digits.get(i),max_Digit)){
                  max_Digit=digits.get(i);


              }



            result+=max_Digit;
            digits.remove(max_Digit);





      }

        return result;
    }

    private static boolean isGreaterOrEqual(String digit,String max_digit){


        if(Long.parseLong(digit+max_digit)>= Long.parseLong(max_digit+digit))

            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

