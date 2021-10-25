package control;

import model.PhoneList;
import storage.PhoneListFIleManager;

import java.util.List;

public class PhoneListManager implements IGeneralManager<PhoneList> {
    private List<PhoneList> phoneLists;
    private PhoneListFIleManager phoneListFIleManager;

    public PhoneListFIleManager getPhoneListFIleManager() {
        return phoneListFIleManager;
    }

    public void setPhoneListFIleManager(PhoneListFIleManager phoneListFIleManager) {
        this.phoneListFIleManager = phoneListFIleManager;
    }

    public List<PhoneList> getPhoneLists() {
        return phoneLists;
    }

    public void setPhoneLists(List<PhoneList> phoneLists) {
        this.phoneLists = phoneLists;
    }

    @Override
    public List<PhoneList> findAll() {
        return phoneLists;
    }



    @Override
    public void saveList(PhoneList phoneList) {
phoneLists.add(phoneList);
    }

    @Override
    public void removeByIndex(int index) {
phoneLists.remove(index);
    }

    @Override
    public void updateByIndex(int index, PhoneList phoneList) {
phoneLists.set(index, phoneList);
    }

    @Override
    public PhoneList searchById(String id) {
        PhoneList phoneList = null;
        for (int i = phoneLists.size()-1; i >= 0; i--) {
            if (phoneLists.get(i).getId().equalsIgnoreCase(id)) {
                phoneList = phoneLists.get(i);
                break;
            }
        }
        return phoneList;
    }

    @Override
    public void showAllList() {
        for (PhoneList phoneList: phoneLists
             ) {
            System.out.println(phoneList);
        }
    }

    public int searchIndexByPhone(String phone) {
        int index = -1;
        for (int i = phoneLists.size()-1; i >= 0; i--) {
            if (phoneLists.get(i).getPhoneNumber().equalsIgnoreCase(phone)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public PhoneList searchPhoneListByIndex(String phone) {
        PhoneList phoneList = null;
        for (int i = phoneLists.size()-1; i >= 0; i--) {
            if (phoneLists.get(i).getPhoneNumber().equalsIgnoreCase(phone)) {
                phoneList = phoneLists.get(i);
                break;
            }
        }
        return phoneList;
    }
}
