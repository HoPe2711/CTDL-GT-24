package week7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaSort
{
    public static class Student implements Comparable<Student>{
        private int id;
        private String fname;
        private double cgpa;
        public Student(int id, String fname, double cgpa) {
            super();
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }
        public int getId() {
            return id;
        }
        public String getFname() {
            return fname;
        }
        public double getCgpa() {
            return cgpa;
        }

        @Override
        public int compareTo(Student other){
            if (this.cgpa < other.cgpa){
                return 1;
            }
            else if (this.cgpa == other.cgpa){
                if (this.fname.compareTo(other.fname) > 0) {
                    return 1;
                }
                else if (this.fname.compareTo(other.fname) == 0 && this.id > other.id) return 1;
            }
            return -1;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort(Student::compareTo);

        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}