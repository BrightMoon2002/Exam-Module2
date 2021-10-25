package model;

import java.io.Serializable;

public class FriendList extends PhoneList implements Serializable {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FriendList(Person person, String phoneNumber, String email, String id) {
        super(person, phoneNumber, email, id);
        setType("Friend");
    }

    @Override
    public String toString() {
        return "FriendList{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }



}
