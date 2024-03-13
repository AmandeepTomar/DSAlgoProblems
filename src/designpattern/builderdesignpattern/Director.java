package designpattern.builderdesignpattern;

import com.sun.jdi.connect.IllegalConnectorArgumentsException;

import java.util.IllegalFormatWidthException;

public class Director {
   private StudentBuilder studentBuilder;

    Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if (studentBuilder instanceof EngineeringStudent) {
            return createEngineeringStudent();
        } else if (studentBuilder instanceof MBAStudent) {
            return createMbaStudent();
        } else {
            throw new IllegalArgumentException("NOt supported");
        }
    }

    private Student createEngineeringStudent() {
        return studentBuilder.setRollNo(1).setAge(21).setStudentName("Name").setFatherName("FatherName").setSubjects().build();
    }

    private Student createMbaStudent() {
        return studentBuilder.setRollNo(1).setAge(21).setStudentName("Name").setFatherName("FatherName").setSubjects().build();
    }
}
