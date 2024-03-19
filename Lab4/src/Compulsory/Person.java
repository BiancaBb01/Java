package Compulsory;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private boolean isDriver;

    public Person(String name, int age, boolean isDriver) {
        this.name = name;
        this.age = age;
        this.isDriver = isDriver;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean isDriver() {
        return isDriver;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // Auto-generated hashCode() and equals() for simplicity
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }
}
