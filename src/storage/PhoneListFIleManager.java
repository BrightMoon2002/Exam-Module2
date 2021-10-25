package storage;

import model.PhoneList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneListFIleManager extends BaseFileManager<PhoneList> {
    private static PhoneListFIleManager phoneListFIleManager;
    private PhoneListFIleManager() {}
    public static PhoneListFIleManager getInstance() {
        if (phoneListFIleManager == null) {
            phoneListFIleManager = new PhoneListFIleManager();
        }
        return phoneListFIleManager;
    }

    @Override
    public void writeList(List<PhoneList> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File("listPhone.txt");
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
   public List<PhoneList> readList() {
        List<PhoneList> phoneList = new ArrayList<>();
        File file = new File("listPhone.txt");
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
            phoneList = (List<PhoneList>) ois.readObject();
            ois.close();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return phoneList;
    }
}
