package org.p0gram3r.codingdojo.v1;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by cabarca on 28/08/15.
 */
public class PhoneBookRecord {
    private String name;
    private Map<PhoneType, Collection<String>> phoneList;

    public PhoneBookRecord (String name, String phoneNumber) {
        this.name = name;
        this.phoneList = new TreeMap<>();

        TreeSet<String> phoneNumbers = new TreeSet<>();
        phoneNumbers.add(phoneNumber);
        this.phoneList.put(PhoneType.HOME, phoneNumbers);

    }

    public PhoneBookRecord (String name, PhoneType type, String phoneNumber) {
        this.name = name;
        this.phoneList = new TreeMap<>();

        TreeSet<String> phoneNumbers = new TreeSet<>();
        phoneNumbers.add(phoneNumber);
        this.phoneList.put(type, phoneNumbers);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPhoneNumber (PhoneType type, String number) {
        Collection<String> phoneNumbers = this.phoneList.get(type);
        if (phoneNumbers == null) {
            phoneNumbers = new TreeSet<>();
        }
        phoneNumbers.add(number);
        this.phoneList.put(type, phoneNumbers);
    }

    public void addPhoneNumber (String number) {
        Collection<String> phoneNumbers = this.phoneList.get(PhoneType.HOME);
        if (phoneNumbers == null) {
            phoneNumbers = new TreeSet<>();
        }
        phoneNumbers.add(number);
        this.phoneList.put(PhoneType.HOME, phoneNumbers);
    }

    public String getName() {
        return name;
    }

    public String phoneListStringify() {
        String phoneStr = "";
        for (Map.Entry<PhoneType, Collection<String>> phoneDir : this.phoneList.entrySet()) {
            for (String phoneNumber : phoneDir.getValue()) {
                phoneStr += "  "+phoneDir.getKey()+":"+phoneNumber+"\n";
            }
        }
        return phoneStr;
    }

    @Override
    public boolean equals(Object object) {
        boolean isTheSame = false;
        if (object != null && object instanceof PhoneBookRecord ) {
            isTheSame = this.getName() == ((PhoneBookRecord) object).getName();
        }
        return isTheSame;
    }
}
