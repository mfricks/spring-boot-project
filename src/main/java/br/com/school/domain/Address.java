package br.com.school.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String street;

    private String city;

    private String state;

    private Integer zipCode;

    private String country;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public Address() {
    }

    public Address(String street, String city, String state, Integer zipCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address adress = (Address) o;
        return Objects.equals(id, adress.id) && Objects.equals(street, adress.street) && Objects.equals(city, adress.city) && Objects.equals(state, adress.state) && Objects.equals(zipCode, adress.zipCode) && Objects.equals(country, adress.country) && Objects.equals(student, adress.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, state, zipCode, country, student);
    }
}
