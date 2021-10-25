package model;

public abstract class BasePhoneList {
    abstract Person getPerson();
    abstract void setPerson(Person person);
    abstract String getPhoneNumber();
    abstract void setPhoneNumber(String phoneNumber);
    abstract String getEmail();
    abstract void setEmail(String email);
    abstract String getId();
    abstract void setId(String id);
}
