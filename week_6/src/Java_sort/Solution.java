package Java_sort;

import java.util.*;

class Student{
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
}
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y)
    {
        if (x.getCgpa() > y.getCgpa()) return 1;
        else if (x.getCgpa() < y.getCgpa()) return -1;
        else return y.getFname().compareTo(x.getFname());
    }
}
//Complete the code
public class Solution
{
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
        Collections.sort(studentList, new StudentComparator());
        for (int i = studentList.size() - 1; i >= 0; i--) {
            System.out.println(studentList.get(i).getFname());
        }
    }
}



