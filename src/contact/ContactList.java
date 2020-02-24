package contact;

import java.io.Serializable;

public class ContactList implements Serializable {

    private Person head;
    private int contactListLength;

    public ContactList() {
        head = null;
        contactListLength = 0;
    }

    public void addInContactsLast(String firstName, String lastName, String contactNumber,
                                  String anotherContactNumber, String emailAddress) {
        Person current = head;
        Person previous = null;
        Person newNode = new Person();
    }
}
