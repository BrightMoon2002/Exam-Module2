package model;

public class Person extends BasePerson {
    private String fullName;
    private String doB;
    private String address;
    private String gender;
    private String id;

    public Person(String fullName, String doB, String address, String gender, String id) {
        this.fullName = fullName;
        this.doB = doB;
        this.address = address;
        this.gender = gender;
        this.id = id;
    }

    @Override
   public String getFullName() {
        return fullName;
    }

    @Override
   public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
   public String getDoB() {
        return doB;
    }

    @Override
   public void setDoB(String dob) {
        this.doB = dob;
    }

    @Override
   public String getAddress() {
        return address;
    }

    @Override
   public void setAddress(String address) {
        this.address = address;
    }

    @Override
   public String getGender() {
        return gender;
    }

    @Override
  public  void setGender() {
        this.gender = gender;
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
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", doB='" + doB + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                "} " + super.toString();
    }
}
