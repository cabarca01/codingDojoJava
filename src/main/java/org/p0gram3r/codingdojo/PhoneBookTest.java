package org.p0gram3r.codingdojo;

/**
 * Created by cabarca on 26/08/15.
 */
public class PhoneBookTest {

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();

        book.add("André", "123");
        book.add("Carlos", "007");
        book.add("Claus", "456");

        System.out.println(book);
    }

}
