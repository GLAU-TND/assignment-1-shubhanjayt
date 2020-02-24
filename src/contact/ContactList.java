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

        newNode.setFirstName(firstName);
        newNode.setLastName(lastName);
        newNode.setContactNumber(contactNumber);
        newNode.setAnotherContactNumber(anotherContactNumber);
        newNode.setE_mailAddress(emailAddress);

        if (isEmpty()) {
            head = newNode;
            contactListLength++;
        } else {

            /*
             compare firstName of entries for priority by first letter in firstName
             */
            for (int i = 0; i < contactListLength; i++) {
                String[] ourNames1 = current.getFirstName().split(" ");
                String[] ourNames2 = newNode.getFirstName().split(" ");

                int result = ourNames1[ourNames1.length - 1].compareToIgnoreCase(ourNames2[ourNames2.length - 1]);
            }
        }
    }

    public boolean isEmpty() {
        return (contactListLength == 0);
    }
}


