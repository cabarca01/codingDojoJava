package org.p0gram3r.codingdojo;

import java.util.ArrayList;

/**
 * Created by cabarca on 30/08/15.
 */
public class PhoneBookV4 {
    private ArrayList<PhoneBookRecord> records = new ArrayList<>();
    private PhoneBookRecordComparator phoneComparator = new PhoneBookRecordComparator();

    public void addRecord (String name, String phoneNumber) {
        PhoneBookRecord phoneRecord = new PhoneBookRecord(name, phoneNumber);
        if (records.contains(phoneRecord)) {
            int recordIndex = records.indexOf(phoneRecord);
            phoneRecord = records.get(recordIndex);
            phoneRecord.addPhoneNumber(phoneNumber);
            records.add(recordIndex, phoneRecord);
        } else {
            records.add(phoneRecord);
        }
        records.sort(phoneComparator);
    }

    public void addRecord (String name, PhoneType type, String phoneNumber) {
        PhoneBookRecord phoneRecord = new PhoneBookRecord(name, type, phoneNumber);
        if (records.contains(phoneRecord)) {
            int recordIndex = records.indexOf(phoneRecord);
            phoneRecord = records.get(recordIndex);
            phoneRecord.addPhoneNumber(type, phoneNumber);
            records.add(recordIndex, phoneRecord);
        } else {
            records.add(phoneRecord);
        }
        records.sort(phoneComparator);
    }

    @Override
    public String toString() {
        String recordStr = "";
        for (PhoneBookRecord record : this.records) {
            recordStr += record.getName()+":\n"+record.phoneListStringify();
        }
        return recordStr;
    }

}
