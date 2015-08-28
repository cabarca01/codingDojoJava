package org.p0gram3r.codingdojo;

/**
 * Created by cabarca on 26/08/15.
 */
public class PhoneBookMain {

    public static void main(String[] args) {
        PhoneBookV3 book = new PhoneBookV3();

        book.add("André", "777");
        book.add("Carlos", "007");
        book.add("Claus", "456");
        book.add("Marie", PhoneType.MOBILE, "456");
        book.add("Sonia", PhoneType.MOBILE, "456");
        book.add("Juan", "456");

        book.add("André", PhoneType.MOBILE, "5678");
        book.add("André", PhoneType.MOBILE, "9876");

        System.out.println(book);
    }

}
