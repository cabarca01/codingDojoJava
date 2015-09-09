package org.p0gram3r.codingdojo.phonebook.v2;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PhoneBookTest {
	
	private PhoneBook phonebook;
	private Collection<String> nameList;
	
	@Test
	public void getAllNames_ReturnsEmptyWithNoRecords() {
		phonebook = new PhoneBook();
		nameList = phonebook.getAllNames();
		
		assertTrue("The list is not empty", nameList.isEmpty());
	}
	
	@Test
	public void getAllNames_ReturnsOnlyOneRecord() {
		phonebook = new PhoneBook();
		phonebook.add("SomeName", "SomeNumber");
		
		nameList = phonebook.getAllNames();
		assertTrue("The list doesn't contain only 1 element", nameList.size()==1);
		assertTrue("The list does't contain SomeName", nameList.contains("SomeName"));
		
	}

	@Test
	public void getAllNames_ReturnsMultipleRecordsOrdered() {
		phonebook = new PhoneBook();
		phonebook.add("D Name", "SomeNumber");
		phonebook.add("A Name", "SomeOtherNumber");
		
		nameList = phonebook.getAllNames();
		String[] expectedArray = {"A Name", "D Name"};
		
		assertTrue("The list doesn't contain exactly 2 elements", nameList.size()==2);
		assertArrayEquals("Name records not ordered", expectedArray, nameList.toArray(new String[nameList.size()]));		
		
	}
	
	@Test
	public void getAllNames_DoesNotAllowDuplicateNames() {
		phonebook = new PhoneBook();
		phonebook.add("D Name", "SomeNumber");
		phonebook.add("A Name", "SomeOtherNumber");
		phonebook.add("D Name", "AThirdNumber");
		
		nameList = phonebook.getAllNames();
		String[] expectedArray = {"A Name", "D Name"};
		
		assertTrue("The list doesn't contain exactly 2 elements", nameList.size()==2);
		assertArrayEquals("There are duplicate Names in the array", expectedArray, nameList.toArray(new String[nameList.size()]));
	}
	
	@Test
	public void getNumber_PhoneTypeCorrectFormat() {
		phonebook = new PhoneBook();
		phonebook.add("SomeName", PhoneType.CELL, "SomeNumber");
		String[] phoneNumber = phonebook.getNumber("SomeName");
		assertEquals("The format is not correct", "CELL : SomeNumber", phoneNumber[0]);
	}
	
	@Test
	public void getNumber_PhonesNotDuplicated() {
		phonebook = new PhoneBook();
		phonebook.add("SomeName", PhoneType.CELL, "SomeNumber");
		phonebook.add("SomeName", PhoneType.FAX, "SomeNumber");
		phonebook.add("SomeName", PhoneType.FAX, "SomeOtherNUmber");
		
		String[] phoneNumber = phonebook.getNumber("SomeName");
		assertTrue("There should be 2 phone numbers", phoneNumber.length == 2);
		
		int count = 0;
		for (String phone : phoneNumber) {
			if (phone.contains("SomeNumber")) {
				count++;
			}
		}
		assertTrue("There are duplicated phone numbers", count == 1);
	}
	
	@Test
	public void getNumber_PhonesShouldBeOrdered() {
		phonebook = new PhoneBook();
		phonebook.add("SomeName", PhoneType.HOME, "SomeNumber");
		phonebook.add("SomeName", PhoneType.FAX, "SomeOtherNumber");
		phonebook.add("SomeName", PhoneType.CELL, "AThirdNumber");
		
		String[] phoneNumber = phonebook.getNumber("SomeName");
		String[] expectedPhoneNumber = {"CELL : AThirdNumber", 
				"HOME : SomeNumber",
				"FAX : SomeOtherNumber"};
		
		assertArrayEquals("The phone list is not ordered", expectedPhoneNumber, phoneNumber);
	}
	
	@Test
	public void getNumber_AllowsMultipleNumbersPerType() {
		phonebook = new PhoneBook();
		phonebook.add("SomeName", PhoneType.HOME, "SomeNumber");
		phonebook.add("SomeName", PhoneType.HOME, "SomeOtherNumber");
		phonebook.add("SomeName", PhoneType.CELL, "AThirdNumber");
		
		String[] phoneNumber = phonebook.getNumber("SomeName");
		String[] expectedPhoneNumber = {"CELL : AThirdNumber", 
				"HOME : SomeNumber",
				"HOME : SomeOtherNumber"};
		
		assertArrayEquals("Second phone number for type not there", expectedPhoneNumber, phoneNumber);
	}
	
	@Test
	public void toString_PhoneListFormat() {
		phonebook = new PhoneBook();
		phonebook.add("D Name", PhoneType.HOME, "HomeNumberD");
		phonebook.add("D Name", PhoneType.CELL, "CellNumberD");
		phonebook.add("A Name", PhoneType.HOME, "HomeNumberA");
		phonebook.add("E Name", PhoneType.PAGER, "PagerNumberE");
		
		String expectedOutput = "A Name :\n"+
				"  HOME : HomeNumberA\n" +
				"D Name :\n" +
				"  CELL : CellNumberD\n"+
				"  HOME : HomeNumberD\n" +
				"E Name :\n" +
				"  PAGER : PagerNumberE";
		
		assertEquals("Output is not as expected", expectedOutput, phonebook.toString());
	}
	
	@Test
	public void remove_PhoneListShouldHaveLessEntries() {
		phonebook = new PhoneBook();
		phonebook.add("D Name", PhoneType.HOME, "HomeNumberD");
		phonebook.add("D Name", PhoneType.CELL, "CellNumberD");
		phonebook.add("A Name", PhoneType.HOME, "HomeNumberA");
		
		phonebook.remove("A Name", PhoneType.HOME, "HomeNumberA");
		String[] phonebookNames = phonebook.getAllNames().toArray(new String[phonebook.getAllNames().size()]);
		assertTrue("PhoneBook has too many entries", phonebookNames.length == 1);
		
	}
}
