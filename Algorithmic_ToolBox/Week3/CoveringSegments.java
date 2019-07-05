package Courses.Algorithmic_ToolBox.Week3;

import java.util.*;
import java.util.stream.Collectors;

public class CoveringSegments {




    private static int[] optimalPoints(Segment[] segments) {
        //write your code here



        segments=Arrays.stream(segments).sorted(new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                return o1.end-o2.end;
            }
        }).toArray(Segment[]::new);

        int current__Co=segments[0].end;
        List<Integer> points=new ArrayList<Integer>();

        points.add(current__Co);
        for (int i = 1; i < segments.length; i++) {

            if(segments[i].start<=current__Co && segments[i].end>=current__Co)
                continue;
            else {

                current__Co=segments[i].end;

                points.add(current__Co);
            }


        }
        int[] res=new int[points.size()];

        for (int i = 0; i < res.length; i++) {
            res[i]=points.get(i);
        }


        return res;

    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
