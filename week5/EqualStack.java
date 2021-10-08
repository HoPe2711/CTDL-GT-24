package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class EqualStack {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int[] sum1 = new int[100001];
        int n1 = h1.size();
        for (int i = n1 - 1; i >= 0; i--) sum1[n1 - i] = sum1[n1 - i - 1] + h1.get(i);

        int n2 = h2.size();
        int[] sum2 = new int[100001];
        for (int i = n2 - 1; i >= 0; i--) sum2[n2 - i] = sum2[n2 - i - 1] + h2.get(i);

        int n3 = h3.size();
        int[] sum3 = new int[100001];
        for (int i = n3 - 1; i >= 0; i--) sum3[n3 - i] = sum3[n3 - i - 1] + h3.get(i);

        for (int i=n1; i>0 ;i--){
            while (n2>0 && sum2[n2]>sum1[i]) n2--;
            while (n3>0 && sum3[n3]>sum1[i]) n3--;
            if (sum1[i]==sum2[n2] && sum1[i]==sum3[n3]) return sum1[i];
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        System.out.println(equalStacks(h1, h2, h3));

        bufferedReader.close();
    }
}
