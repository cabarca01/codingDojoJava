package org.p0gram3r.codingdojo;

import java.util.*;

/**
 * Created by cabarca on 26/08/15.
 */
public class PhoneBookV3 {

    private Map<String, Map<PhoneType, Collection<String>>> phoneBook = new TreeMap<>();

    public void add (String name, String phone) {
        Map<PhoneType, Collection<String>> phoneList;
        if ( phoneBook.get(name) == null) {
            phoneList = new TreeMap<>();
        } else {
            phoneList = phoneBook.get(name);
        }

        Collection<String> phoneNumbers;

        if (phoneList.get(PhoneType.HOME) == null) {
            phoneNumbers = new TreeSet<>();
        } else {
            phoneNumbers = phoneList.get(PhoneType.HOME);
        }

        phoneNumbers.add(phone);
        phoneList.put(PhoneType.HOME, phoneNumbers);
        phoneBook.put(name, phoneList );
    }

    public void add (String name, PhoneType type, String phone) {
        Map<PhoneType, Collection<String>> phoneList;
        if ( phoneBook.get(name) == null) {
            phoneList = new TreeMap<>();
        } else {
            phoneList = phoneBook.get(name);
        }

        Collection<String> phoneNumbers;

        if (phoneList.get(type) == null) {
            phoneNumbers = new TreeSet<>();
        } else {
            phoneNumbers = phoneList.get(type);
        }

        phoneNumbers.add(phone);
        phoneList.put(type, phoneNumbers);
        phoneBook.put(name, phoneList );
    }

    public void remove (String name, PhoneType type, String number) {
        if (phoneBook.get(name) != null) {
            phoneBook.get(name).get(type).remove(number);
            if (phoneBook.get(name).get(type).isEmpty()) {
                phoneBook.get(name).remove(type);
            }
            if (phoneBook.get(name).isEmpty()) {
                phoneBook.remove(name);
            }
        }
    }

    @Override
    public String toString(){
        String returnstr = "";

        for (Map.Entry<String, Map<PhoneType, Collection<String>>> record : phoneBook.entrySet()) {
            returnstr += record.getKey() +":"+"\n";
            for (Map.Entry<PhoneType, Collection<String>> phone : record.getValue().entrySet()) {
                for (String phoneNumber : phone.getValue()) {
                    returnstr += "  "+phone.getKey()+":"+phoneNumber+"\n";
                }
            }
        }
        return returnstr;
    }
}
