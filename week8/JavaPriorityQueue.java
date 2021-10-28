package week8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Student {

  private final int id;
  private final String name;
  private final double cgpa;

  public Student(int id, String name, double cgpa) {
    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getCgpa() {
    return cgpa;
  }

}

class StudentComparator implements Comparator<Student> {

  @Override
  public int compare(Student x, Student y) {
    if (x.getCgpa() < y.getCgpa()) {
      return 1;
    } else if (x.getCgpa() == y.getCgpa()) {
      if (x.getName().compareTo(y.getName()) > 0) {
        return 1;
      } else if (x.getName().compareTo(y.getName()) == 0) {
          if (x.getId() > y.getId()) return 1;
          else if (x.getId() == y.getId()) return 0;
      }
    }
    return -1;
  }
}

class Priorities {

  private final Queue<Student> studentQueue;

  public Priorities() {
    this.studentQueue = new PriorityQueue<>(new StudentComparator());
  }

  public List<Student> getStudents(List<String> events) {
    for (String event : events){
      String[] query = event.split(" ");
      if (query[0].equals("ENTER")){
        this.studentQueue.add(new Student(Integer.parseInt(query[3]), query[1], Double.parseDouble(query[2])));
      }
      else {
        this.studentQueue.poll();
      }
    }
    List<Student> result =  new ArrayList<>();
    while (!studentQueue.isEmpty()){
      result.add(studentQueue.poll());
    }
    return result;
  }
}

public class JavaPriorityQueue {

  private final static Scanner scan = new Scanner(System.in);
  private final static Priorities priorities = new Priorities();

  public static void main(String[] args) {
    int totalEvents = Integer.parseInt(scan.nextLine());
    List<String> events = new ArrayList<>();

    while (totalEvents-- != 0) {
      String event = scan.nextLine();
      events.add(event);
    }

    List<Student> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st : students) {
        System.out.println(st.getName());
      }
    }
  }
}
