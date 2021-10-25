package model;

import java.io.Serializable;

public class WorkList extends PhoneList implements Serializable {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WorkList(Person person, String phoneNumber, String email, String id) {
        super(person, phoneNumber, email, id);
        setType("Work");
    }

    @Override
    public String toString() {
        return "WorkList{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }
}
