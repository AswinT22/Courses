package Courses.Algorithmic_ToolBox.Week3;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here

        Map<Double,Integer> m=new HashMap<Double,Integer>();

        for (int i = 0; i <values.length ; i++)

            m.put(values[i]/(double)weights[i],weights[i]);

          m=m.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        for (Map.Entry<Double,Integer> k:m.entrySet())
        {
            int val=k.getValue();
            double key=k.getKey();
            if(capacity==0)
                break;
            if(capacity- val >=0)
            {
                value+=key*val;
                capacity-=val;
                k.setValue(0);

            }
            else {
                value+=capacity*key;
                capacity=0;
                k.setValue(val-capacity);

            }

        }
        DecimalFormat df = new DecimalFormat("#.0000");
        value=Double.parseDouble(df.format(value));


        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
