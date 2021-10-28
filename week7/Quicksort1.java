package week7;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Quicksort1 {
    public static List<Integer> quickSort(List<Integer> arr) {
        int key = arr.get(0);
        int n = arr.size();
        List<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i <= n - 1; i++)
            if (arr.get(i) < key) arr1.add(arr.get(i));
        arr1.add(key);
        for (int i = 0; i <= n - 1; i++)
            if (arr.get(i) > key) arr1.add(arr.get(i));
        return arr1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = quickSort(arr);
        System.out.println(result);
        bufferedReader.close();
    }
}
