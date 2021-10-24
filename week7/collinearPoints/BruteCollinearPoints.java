package week7.collinearPoints;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private final LineSegment[] result;
    private int numberSegment;

    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException();
        for (Point point : points) {
            if (point == null)
                throw new IllegalArgumentException();
        }

        int n = points.length;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (points[i].compareTo(points[j]) == 0) throw new IllegalArgumentException();
        numberSegment = 0;
        ArrayList<LineSegment> segmentArrayList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    for (int t = k + 1; t < n; t++)
                        if (check(points[i], points[j], points[k], points[t])) {
                            Point[] tmp = new Point[4];
                            tmp[0] = points[i];
                            tmp[1] = points[j];
                            tmp[2] = points[k];
                            tmp[3] = points[t];
                            Arrays.sort(tmp);
                            segmentArrayList.add(new LineSegment(tmp[0], tmp[3]));
                            numberSegment++;
                        }
        result = segmentArrayList.toArray(new LineSegment[0]);
    }

    public int numberOfSegments() {
        return numberSegment;
    }

    public LineSegment[] segments() {
        return result.clone();
    }

    private boolean check(Point point, Point point1, Point point2, Point point3) {
        double slop1 = point.slopeTo(point1);
        double slop2 = point.slopeTo(point2);
        double slop3 = point.slopeTo(point3);
        return slop1 == slop2 && slop1 == slop3;
    }

    public static void main(String[] args) {

        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        BruteCollinearPoints collinear = new BruteCollinearPoints(points);

        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }

        StdDraw.show();
    }

}
