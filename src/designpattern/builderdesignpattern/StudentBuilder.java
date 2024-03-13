package designpattern.builderdesignpattern;

import java.util.List;

public abstract class StudentBuilder {
    int rollNo;
    int age;
    String name;
    String fatherName;

    List<String> subjects;

    public StudentBuilder setRollNo(int rollNo){
        this.rollNo = rollNo;
        return  this;
    }

    public StudentBuilder setAge(int age){
        this.age = age;
        return  this;
    }

    public StudentBuilder setStudentName(String name){
        this.name = name;
        return  this;
    }

    public StudentBuilder setFatherName(String name){
        this.fatherName = name;
        return  this;
    }

    abstract public StudentBuilder setSubjects();

    public Student build(){
        return new Student(this);
    }

}
