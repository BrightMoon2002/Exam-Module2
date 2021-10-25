package model;

public class FactoryPhoneList {
    private FactoryPhoneList() {}
    public static final PhoneList getPhoneList(TypeGroupPhoneList typeGroupPhoneListType, Person person, String phoneNumber, String email, String id) {
        switch (typeGroupPhoneListType) {
            case WORK:
                return new WorkList(person, phoneNumber, email, id);
            case FAMILY:
                return new FamilyList(person, phoneNumber, email, id);
            case FRIEND:
                return new FriendList(person, phoneNumber, email, id);
            default:
                throw new IllegalArgumentException("This type of group is unsupported");
        }
    }
}
