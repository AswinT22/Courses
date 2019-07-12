package Courses.Algorithmic_ToolBox.Week4;




import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        int n1=starts.length,i=0;
        int n2=ends.length,j=0;
        int n3=points.length,k=0;
        int[] temp= Arrays.copyOf(points,n3);
       quickSort(starts,0,n1);
        quickSort(ends,0,n2);
        quickSort(points,0,n3);

        int currentCount=0;
        Map<Integer,Integer> map=new HashMap<>();

        while ( j<n2 &&k<n3){


            if(i<n1  &&starts[i]<= ends[j]) {
                if (starts[i] <= points[k]){

                    ++currentCount;
                    ++i;
                }

                else {

                    map.put(points[k],currentCount);
                    ++k;
                }


            }
            else {

                if (ends[j]<points[k]){
                    --currentCount;
                    ++j;
                }
                else {

                    map.put(points[k],currentCount);
                    ++k;
                }
            }

        }

        while (k<n3 ){  map.put(points[k],0);++k;}

        for (int l = 0; l < n3; l++) {

            cnt[l]= map.get(temp[l]);

        }

        return cnt;
    }
    public static void quickSort(int[] a,int left, int right)
    {

        while(left<right)
        {
//            int k=new Random().nextInt(right-left)+left;
//            swap(a,k,left);
            int[] m=partition(a,left,right);

            if(m[0]-left < right-m[1])
            {
                quickSort(a,left,m[0]);
                left=m[1];

            }
            else {


                quickSort(a,m[1],right);
                right=m[0];

            }



        }




    }

    private static int[] partition(int a[],int left,int right){


        int X=a[left],posPiv=left,j=left;

        for (int i = left+1; i < right; i++) {

            if(X> a[i])
            {
                ++j;
                swap(a,i,j);
            }
            else if (X==a[i]){
                ++j;
                ++posPiv;

                if (posPiv!=i){


                    swap(a,posPiv,i);
                    if(posPiv!=j)
                        swap(a,i,j);
                }
            }
        }

        if(posPiv!=left)
            for (int k = 0; k < j-posPiv ; k++) {

                swap(a,left+k,posPiv+1+k);
            }
        else
            swap(a,left,j);

        return new int[]{j-(posPiv-left),j+1};

    }


    private static  void swap(int[]a, int pos1,int pos2){


        if(pos1!=pos2){

            int temp=a[pos1];
            a[pos1]=a[pos2];
            a[pos2]=temp;


        }

    }
//    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
//        int[] cnt = new int[points.length];
//        for (int i = 0; i < points.length; i++) {
//            for (int j = 0; j < starts.length; j++) {
//                if (starts[j] <= points[i] && points[i] <= ends[j]) {
//                    cnt[i]++;
//                }
//            }
//        }
//        return cnt;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

