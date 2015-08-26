package org.p0gram3r.codingdojo;

/**
 * Created by cabarca on 26/08/15.
 */
public class PhoneBookTest {

    public static void main(String[] args) {
        PhoneBookV2 book = new PhoneBookV2();

        book.add("André", "777");
        book.add("Carlos", "007");
        book.add("Claus", "456");
        book.add("Marie", "456");
        book.add("Sonia", "456");
        book.add("Juan", "456");

        System.out.println(book);

        book.add("André", "5678");
        book.add("André", "5678");

        System.out.println(book);
    }

}
