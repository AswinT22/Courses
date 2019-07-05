package Courses.Algorithmic_ToolBox.Week3;


import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here

        int change=m/10;
        m=m%10;

        change+=m/5;
        m=m%5;

        change+=m;
        return change;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));


    }
}

