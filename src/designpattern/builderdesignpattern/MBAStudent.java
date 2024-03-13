package designpattern.builderdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class MBAStudent extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Economics");
        subjects.add("Marketing");
        subjects.add("Industrial");
        subjects.add("HR");
        this.subjects = subjects;
        return this;
    }
}
