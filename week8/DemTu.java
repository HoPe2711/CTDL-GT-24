package week8;

import edu.princeton.cs.algs4.In;
import java.util.Map;
import java.util.TreeMap;

public class DemTu {

  // Có thể dùng CTDL trie để đếm số lượng từ

  public static void countWord(String[] a){
    Map<String, Integer> words = new TreeMap<>();
    for (String word: a){
      word = word.replaceAll("[^\\w's-]", "");
      words.merge(word, 1, Integer::sum);
    }
    System.out.println(words);
  }

  public static void main(String[] args) {
    In in = new In("C:\\Users\\ADMIN\\Downloads\\algs4-data\\tiny.txt");
    String[] a = in.readAllStrings();
    countWord(a);
  }
}
