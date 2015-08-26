package org.p0gram3r.codingdojo;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by cabarca on 26/08/15.
 */
public class PhoneBookV2 {

    private Map<String, TreeSet<String>> phoneBook = new TreeMap<>();

    public void add (String name, String phone) {
        TreeSet<String> phoneList;
        if ( phoneBook.get(name) == null) {
             phoneList = new TreeSet<>();
        } else {
            phoneList = phoneBook.get(name);
        }
        phoneList.add(phone);
        phoneBook.put(name, phoneList );
    }


    @Override
    public String toString(){
        String returnstr = "";

        for (Map.Entry<String, TreeSet<String>> record : phoneBook.entrySet()) {
            returnstr += record.getKey() +":"+"\n";
            for (String phone : record.getValue()) {
                returnstr += "  "+phone+"\n";
            }
        }
        return returnstr;
    }
}
