package javainterviewquestions;

/**
 * Immutable class ias a class , which value can not be changed after initialization.
 * All variavle must be private and final .
 * Only getter will be available.
 * No setter method.
 * Can set values only through constructor
 */
public class ImmutableClass {

    private final String name;
    private final int age;

    public ImmutableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

}
