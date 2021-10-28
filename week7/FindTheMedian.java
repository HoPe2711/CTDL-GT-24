package week7;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class FindTheMedian {

    public static int partition(int[] arr, int lo, int hi) {
        int i=lo;
        int j=hi+1;
        while (true){
            while (arr[++i] < arr[lo])
                if (i==hi) break;
            while (arr[lo] < arr[--j])
                if (j==lo) break;
            if (i>=j) break;
            int tg =arr[i];
            arr[i]=arr[j];
            arr[j]=tg;
        }

        int tg =arr[lo];
        arr[lo]=arr[j];
        arr[j]=tg;
        return j;
    }

    public static int kthSmallest(int[] arr, int lo, int hi, int k){
        int partition = partition(arr, lo, hi);
        if (partition == k-1) return arr[partition];
        else if (partition <k-1) return kthSmallest(arr, partition+1, hi,k);
        else return kthSmallest(arr, lo, partition-1, k);
    }

    public static int findMedian(List<Integer> arr) {
        int[] a = arr.stream().mapToInt(i->i).toArray();
        int n = arr.size();
        return kthSmallest(a, 0, n-1, n/2+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = findMedian(arr);
        System.out.println(result);

        bufferedReader.close();
    }
}
