package model;

import java.io.Serializable;

public class PhoneList extends BasePhoneList implements Serializable {
    private Person person;
    private String phoneNumber;
    private String email;
    private String id;

    public PhoneList(Person person, String phoneNumber, String email) {
        this.person = person;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public PhoneList(Person person, String phoneNumber, String email, String id) {
        this.person = person;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = id;
    }

    public PhoneList() {
    }

    @Override
   public Person getPerson() {
        return null;
    }

    @Override
   public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
   public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
    }

    @Override
   public String getEmail() {
        return email;
    }

    @Override
   public void setEmail(String email) {
this.email = email;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
this.id = id;
    }

    @Override
    public String toString() {
        return "PhoneList{" +
                "person=" + person +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                "} ";
    }
}
