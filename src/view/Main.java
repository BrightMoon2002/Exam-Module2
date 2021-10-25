package view;

import control.PersonManager;
import control.PhoneListManager;
import model.FactoryPhoneList;
import model.Person;
import model.PhoneList;
import model.TypeGroupPhoneList;
import storage.PersonFileManager;
import storage.PhoneListFIleManager;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("App Manager Phonebook");
        System.out.println("Author is Nguyễn Hoàng Duy - C0821H1");

        PersonManager personManager = new PersonManager();
        PhoneListManager phoneListManager = new PhoneListManager();

        PersonFileManager personFileManager = PersonFileManager.getInstance();
        personManager.setPersonFileManager(personFileManager);

        PhoneListFIleManager phoneListFileManager = PhoneListFIleManager.getInstance();
        phoneListManager.setPhoneListFIleManager(phoneListFileManager);


        List<Person> personList = personFileManager.readList();
        List<PhoneList> phoneLists = phoneListFileManager.readList();
        personManager.setPersonList(personList);
        phoneListManager.setPhoneLists(phoneLists);

        Pattern pattern  = Pattern.compile("^[0-9]{1,15}$") ;




        while (true) {
            System.out.println("Chương trình quản lý danh bạ:");
            System.out.println("chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            Scanner inputChoice = new Scanner(System.in);
            int choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    phoneListManager.showAllList();
                    break;
                case 2:
                    Person person = creatNewPerson();
                    System.out.println("Enter the group of phone list");
                    Scanner inputGroup = new Scanner(System.in);
                    String group = inputGroup.nextLine();
                    PhoneList phoneList = new PhoneList();
                    String phoneNumber;
                    do {
                        System.out.println("Enter the phone number:");
                        Scanner inputPhoneNumber = new Scanner(System.in);
                        phoneNumber = inputPhoneNumber.nextLine();
                    } while(!pattern.matcher(phoneNumber).matches());
                    System.out.println("Enter the email");
                    Scanner inputEmail = new Scanner(System.in);
                    String email = inputEmail.nextLine();
                    System.out.println("Enter the id");
                    Scanner inputIdPhone = new Scanner(System.in);
                    String idPhone = inputIdPhone.nextLine();
                    switch (group) {
                        case "FAMILY":
                            phoneList= FactoryPhoneList.getPhoneList(TypeGroupPhoneList.FAMILY, person, phoneNumber, email, idPhone);
                            phoneListManager.saveList(phoneList);
                            break;
                        case "WORK":
                            phoneList= FactoryPhoneList.getPhoneList(TypeGroupPhoneList.WORK, person, phoneNumber, email, idPhone);
                            phoneListManager.saveList(phoneList);
                            break;
                        case "FRIEND":
                            phoneList= FactoryPhoneList.getPhoneList(TypeGroupPhoneList.FRIEND, person, phoneNumber, email, idPhone);
                            phoneListManager.saveList(phoneList);
                            break;
                        default:
                            System.err.println("NO TYPE PHONE LIKE THAT");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Enter the Phone number:");
                    Scanner inputPhone = new Scanner(System.in);
                    String phone = inputPhone.nextLine();
                    int index = phoneListManager.searchIndexByPhone(phone);
                    if (index == -1) {
                        System.out.println("No body has this phone");
                    } else {
                        Person person1 = creatNewPerson();
                        System.out.println("Enter the group of phone list");
                        Scanner inputGroup1 = new Scanner(System.in);
                        String group1 = inputGroup1.nextLine();
                        PhoneList phoneList1 = new PhoneList();
                        System.out.println("Etner the phone number:");
                        Scanner inputPhoneNumber1 = new Scanner(System.in);
                        String phoneNumber1 = inputPhoneNumber1.nextLine();
                        System.out.println("Enter the email");
                        Scanner inputEmail1 = new Scanner(System.in);
                        String email1 = inputEmail1.nextLine();
                        System.out.println("Etnerr the id");
                        Scanner inputIdPhone1 = new Scanner(System.in);
                        String idPhone1 = inputIdPhone1.nextLine();
                        switch (group1) {
                            case "FAMILY":
                                phoneList1= FactoryPhoneList.getPhoneList(TypeGroupPhoneList.FAMILY, person1, phoneNumber1, email1, idPhone1);
                                phoneListManager.updateByIndex(index, phoneList1);
                                break;
                            case "WORK":
                                phoneList1= FactoryPhoneList.getPhoneList(TypeGroupPhoneList.WORK, person1, phoneNumber1, email1, idPhone1);
                                phoneListManager.updateByIndex(index, phoneList1);
                                break;
                            case "FRIEND":
                                phoneList1= FactoryPhoneList.getPhoneList(TypeGroupPhoneList.FRIEND, person1, phoneNumber1, email1, idPhone1);
                                phoneListManager.updateByIndex(index, phoneList1);
                                break;
                            default:
                                System.err.println("NO TYPE PHONE LIKE THAT");
                                break;
                        }
                    }
                    break;

                case 4:
                    String phone2 = inputPhoneNumber();
                    int index2 = phoneListManager.searchIndexByPhone(phone2);
                    if (index2 == -1) {
                        System.out.println("Nobody have this phone number");
                    } else {
                        phoneListManager.removeByIndex(index2);
                    }
                    break;
                case 5:
                    String phone3 = inputPhoneNumber();
                    System.out.println(phoneListManager.searchPhoneListByIndex(phone3));
                    break;
                case 6:
                    phoneLists = phoneListFileManager.readList();
                    personList = personFileManager.readList();
                    break;
                case 7:
                    phoneListFileManager.writeList(phoneLists);
                    personFileManager.writeList(personList);
                    break;
                case 8:
                    System.exit(8);
                default:
            }
        }

    }

    private static String inputPhoneNumber() {

        System.out.println("Enter the Phone number:");
        Scanner inputPhone2 = new Scanner(System.in);
        return inputPhone2.nextLine();
    }

    private static Person creatNewPerson() {
        System.out.println("Enter the fullname:");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.println("Enter the doB:");
        Scanner inputDoB = new Scanner(System.in);
        String doB = inputDoB.nextLine();
        System.out.println("Enter the address");
        Scanner inputAddress = new Scanner(System.in);
        String address = inputAddress.nextLine();
        System.out.println("Enter the gender");
        Scanner inputGender = new Scanner(System.in);
        String gender = inputGender.nextLine();
        System.out.println("Enter the id");
        Scanner inputId =  new Scanner(System.in);
        String id = inputId.nextLine();
        Person person = new Person(name, doB, address, gender, id);
        return person;
    }
}
