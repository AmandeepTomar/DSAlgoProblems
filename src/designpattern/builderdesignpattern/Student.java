package designpattern.builderdesignpattern;

import java.util.Arrays;
import java.util.List;

public class Student {
    int rollNo;
    int age;
    String name;
    String fatherName;
    List<String> subjects;
    Student(StudentBuilder builder){
        this.rollNo = builder.rollNo;
        this.age = builder.age;
        this.name = builder.name;
        this.fatherName = builder.fatherName;
        this.subjects = builder.subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
