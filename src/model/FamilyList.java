package model;

public class FamilyList extends PhoneList{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FamilyList(Person person, String phoneNumber, String email, String id) {
        super(person, phoneNumber, email, id);
        setType("Family");

    }

    @Override
    public String toString() {
        return "FamilyList{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }
}
