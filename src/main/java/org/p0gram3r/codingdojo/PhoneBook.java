package org.p0gram3r.codingdojo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cabarca on 26/08/15.
 */
public class PhoneBook {

    private Map<String, String> phoneBook;

    public  PhoneBook() {
        phoneBook = new HashMap<String, String>();
    }
    public void add (String name, String phone) {
        phoneBook.put(name, phone);
    }


    @Override
    public String toString(){
        String returnstr = "";
        /** changing it for a much cooler implementation
        Set<String> keys = phoneBook.keySet();
        for (String key : keys) {
            returnstr += key + ":" + phoneBook.get(key) + "\n";
        }
         **/

        for (Map.Entry<String, String> record : phoneBook.entrySet()) {
            returnstr += record.getKey() +":"+record.getValue()+"\n";
        }
        return returnstr;
    }
}
