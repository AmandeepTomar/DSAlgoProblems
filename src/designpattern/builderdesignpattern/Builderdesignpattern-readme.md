## Builder Design Pattern

- Its a creation design pattern , its helping in creation of an object.
- Any object where a lot of optional fields.
- Here only roll no is mandatory rst all is optional. Assume that we have a lot of optional parameters so constructor
  became so huge. or we have so many overloaded constructor.
- Its have one more problem that Some constructor will have the same parameters type so that throw the compile time
  error.
- Its a Step by step creation of object.
- Just like we want to create the object of House so we like

```House.Builder()
  .buildRoof()
  .buildRoom()
  .buildWindow()
  .buildGate()
  .build()
```

```java


class Student {
    private int rollNo;
    private int age;
    private String name;

    Student(int rollNo, int age, String name) {
        this.rollNo = rollNo;
        this.age = age;
        this.name = name;
    }

}

```