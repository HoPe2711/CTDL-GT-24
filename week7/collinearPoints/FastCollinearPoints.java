package week7.collinearPoints;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private final LineSegment[] result;
    private int numberSegment;

    public FastCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException();
        for (Point point : points) {
            if (point == null)
                throw new IllegalArgumentException();
        }

        int n = points.length;
        numberSegment = 0;
        ArrayList<LineSegment> segmentArrayList = new ArrayList<>();
        Point[] tmpPoints = points.clone();
        Arrays.sort(tmpPoints);
        for (int i = 1; i < n; i++)
                if (tmpPoints[i].compareTo(tmpPoints[i-1]) == 0) throw new IllegalArgumentException();
        Point[] sortedPoints = tmpPoints.clone();
        Point[] tmpSegment = new Point[5000];
        for (Point key : sortedPoints) {
            Arrays.sort(tmpPoints, key.slopeOrder());
            int tmpSegmentSize = 1;
            tmpSegment[0] = tmpPoints[0];
            for (int j = 1; j < n; j++) {
                if (tmpSegment[0].slopeTo(key) != tmpPoints[j].slopeTo(key)) {
                    if (tmpSegmentSize > 2) {
                        Arrays.sort(tmpSegment, 0, tmpSegmentSize);
                        if (tmpSegment[0].compareTo(key) > 0) {
                            numberSegment++;
                            segmentArrayList.add(new LineSegment(key, tmpSegment[tmpSegmentSize - 1]));
                        }
                    }
                    tmpSegmentSize = 0;
                }
                tmpSegment[tmpSegmentSize] = tmpPoints[j];
                tmpSegmentSize++;
            }
            if (tmpSegmentSize > 2) {
                Arrays.sort(tmpSegment, 0, tmpSegmentSize);
                if (tmpSegment[0].compareTo(key) > 0) {
                    numberSegment++;
                    segmentArrayList.add(new LineSegment(key, tmpSegment[tmpSegmentSize - 1]));
                }
            }
            if (tmpSegmentSize == n-1) break;
        }

        result = segmentArrayList.toArray(new LineSegment[0]);
    }

    public int numberOfSegments() {
        return numberSegment;
    }

    public LineSegment[] segments() {
        return result.clone();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
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

        FastCollinearPoints collinear = new FastCollinearPoints(points);
        System.out.println(collinear.numberSegment);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
