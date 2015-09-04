package org.p0gram3r.codingdojo.v1;

/**
 * Created by cabarca on 26/08/15.
 */
public class PhoneBookRecordMain {

    public static void main(String[] args) {
        PhoneBookV4 book = new PhoneBookV4();

        book.addRecord("André", "777");
        book.addRecord("Carlos", "007");
        book.addRecord("Claus", "456");
        book.addRecord("Marie", PhoneType.MOBILE, "456");
        book.addRecord("Sonia", PhoneType.MOBILE, "456");
        book.addRecord("Juan", "456");

        book.addRecord("André", PhoneType.MOBILE, "5678");
        book.addRecord("André", PhoneType.MOBILE, "9876");

        System.out.println(book);
    }

}
