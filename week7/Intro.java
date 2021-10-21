package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Intro {

    public static int introTutorial(int V, List<Integer> arr) {
        int l = 0;
        int r = arr.size();
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) == V) return mid;
            else if (arr.get(mid) > V) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(bufferedReader.readLine().trim());

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = introTutorial(V, arr);
        System.out.println(result);
        bufferedReader.close();
    }
}
