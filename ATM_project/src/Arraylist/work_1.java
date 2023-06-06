package Arraylist;

import java.util.ArrayList;

public class work_1 {
    public static void main(String[] args) {
        ArrayList<Student> al=new ArrayList<>();
        al.add(new Student("张三","class1","java",85));
        al.add(new Student("周乐儿","class1","C#",79));
        al.add(new Student("王涛","class2","C#",52));
        al.add(new Student("李明","class2","java",48));
        int sum=0;
        int n=0;
        for (Student a:al) {
//            System.out.println(a);
            if(a.getClassName().equals("class1")){
                sum+=a.getGrade();
                n++;
            }

        }
        System.out.println("总分: "+sum);
        System.out.println("平均分 "+sum/n);
    }
}
class Student{
    private String name;
    private String className;
    private String course;
    private int grade;

    public Student(String name, String className, String course, int grade) {
        this.name = name;
        this.className = className;
        this.course = course;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
