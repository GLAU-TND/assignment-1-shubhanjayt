package contact;

import java.io.Serializable;

public class ContactList implements Serializable {

    private Person head;
    private int contactListLength;

    public ContactList() {
        head = null;
        contactListLength = 0;
    }
}
