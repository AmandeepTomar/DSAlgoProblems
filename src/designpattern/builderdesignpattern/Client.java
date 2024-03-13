package designpattern.builderdesignpattern;

public class Client {
    public static void main(String[] args) {
        Director director1 = new Director(new EngineeringStudent());
        Director director2 = new Director(new MBAStudent());

        Student engineeringStudent = director1.createStudent();
        Student mdbStudent = director2.createStudent();

        System.out.println(engineeringStudent.toString());
        System.out.println(mdbStudent.toString());
    }
}
