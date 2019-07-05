package Courses.Algorithmic_ToolBox.Week3;

import java.util.*;
import java.io.*;

public class CarFueling {


    static int computeMinRefills(int dist, int tank, int[] stops) {


        int n=stops.length+1;

        int[] newStops=new int[n];
        newStops[n-1]=dist;

        for (int j = 0; j <n-1 ; j++)
            newStops[j]=stops[j];

        int i=0;
        int current=0;
        int stop=0;
        while (i<n){


            while(i< n && newStops[i]-current<=tank)
                ++i;
            if(i>n-1)
                return stop;
            if(current==newStops[i-1])
                return -1;
            current=newStops[i-1];
            ++stop;

        }


        return stop;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
