package storage;

import model.Person;
import model.PhoneList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonFileManager extends BaseFileManager<Person> {
    private static PersonFileManager personFileManager;
    private PersonFileManager() {}
    public static PersonFileManager getInstance() {
        if (personFileManager == null) {
            personFileManager = new PersonFileManager();
        }
        return personFileManager;
    }
    @Override
   public void writeList(List<Person> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File("listPerson.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
   public List<Person> readList() {
        List<Person> personList = new ArrayList<>();
        File file = new File("listPerson.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() == 0) {
            return new ArrayList<>();
        }
        try {
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            personList = (List<Person>) ois.readObject();
            ois.close();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personList;
    }
    }

