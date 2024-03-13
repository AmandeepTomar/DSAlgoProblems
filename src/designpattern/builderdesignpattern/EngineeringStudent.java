package designpattern.builderdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class EngineeringStudent  extends StudentBuilder{

    @Override
    public StudentBuilder setSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("DSA");
        subjects.add("System Design");
        subjects.add("Android");
        subjects.add("Java");
        this.subjects= subjects;
        return this;
    }


}
