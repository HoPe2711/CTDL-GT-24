package week7;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CountingSort {

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> arr1 = new ArrayList<>();
        int n = arr.size();
        for (int i=0; i<100;i++) arr1.add(0);
        for (int i = 0; i <= n - 1; i++) {
            int pos = arr.get(i);
            arr1.set(pos,arr1.get(pos)+1);
        }
        return arr1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = countingSort(arr);
        System.out.println(result);
        bufferedReader.close();
    }
}
