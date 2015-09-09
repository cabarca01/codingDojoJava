package org.p0gram3r.codingdojo.phonebook.v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {
	
	private Map<String, Map<String, PhoneType>> phoneBook = new TreeMap<>();
	
	public void add(String name, String number) {
		Map<String, PhoneType> phoneList;
		if (phoneBook.containsKey(name)) {
			phoneList = phoneBook.get(name);
		} else {
			phoneList = new TreeMap<>();
		}
		phoneList.put(number, PhoneType.HOME);
		phoneBook.put(name, phoneList);
	}
	
	public void add(String name, PhoneType type, String number) {
		Map<String, PhoneType> phoneList;
		if (phoneBook.containsKey(name)) {
			phoneList = phoneBook.get(name);
		} else {
			phoneList = new TreeMap<>();
		}
		phoneList.put(number, type);
		phoneBook.put(name, phoneList);
	}
	
	public Collection<String> getAllNames() {
		Collection<String> phoneNameList = new TreeSet<>();
		phoneNameList.addAll(phoneBook.keySet());
		return phoneNameList;
	}
	
	public String[] getNumber (String name) {
		ArrayList<String> phoneNumber = new ArrayList<>(10);
		Map<String, PhoneType> phoneList = phoneBook.get(name);
		for ( Entry<String, PhoneType> phoneRecord : phoneList.entrySet()) {
			phoneNumber.add(phoneRecord.getValue()+" : "+phoneRecord.getKey());
		}
		return phoneNumber.toArray(new String[phoneNumber.size()]);
	}
	
	@Override
	public String toString() {
		String returnStr = "";
		for (String name : getAllNames()) {
			returnStr += name + " :\n";
			for (String phone : getNumber(name)) {
				returnStr += "  "+phone+ "\n";
			}
		}
		return returnStr.substring(0, returnStr.lastIndexOf("\n"));
	}

	public void remove(String name, PhoneType type, String number) {
		Map<String, PhoneType> phoneNumber = phoneBook.get(name);
		PhoneType recordPT = phoneNumber.get(number);
		if (recordPT == type) {
			phoneNumber.remove(number);
		}
		if (phoneNumber.isEmpty()) {
			phoneBook.remove(name);
		}
	}
	
}
