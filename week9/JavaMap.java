package week9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
  public static void main(String []argh)
  {
    Scanner in = new Scanner(System.in);
    int n=in.nextInt();
    in.nextLine();
    Map<String, Integer> maps = new HashMap<>();
    for(int i=0;i<n;i++)
    {
      String name=in.nextLine();
      int phone=in.nextInt();
      in.nextLine();
      maps.put(name, phone);
    }
    while(in.hasNext())
    {
      String s=in.nextLine();
      if (maps.get(s) == null) System.out.println("Not found");
      else System.out.println(s + "=" + maps.get(s));
    }
  }
}
