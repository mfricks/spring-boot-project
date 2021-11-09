package br.com.school.controllers.dto;

import br.com.school.domain.Address;
import br.com.school.domain.Student;

import java.util.List;

public class StudentDto {


    private String name;

    private int age;

    private String email;


    private List<Address> addresses;


    public StudentDto(Student student) {
        this.name = student.getName();
        this.age = student.getAge();
        this.email = student.getEmail();
        this.addresses = student.getAdresses();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAdresses() {
        return addresses;
    }

    public void setAdresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
