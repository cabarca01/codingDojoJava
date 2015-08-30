package org.p0gram3r.codingdojo;

import java.util.Comparator;

/**
 * Created by cabarca on 30/08/15.
 */
public class PhoneBookRecordComparator implements Comparator<PhoneBookRecord> {
    @Override
    public int compare(PhoneBookRecord o1, PhoneBookRecord o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
