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

            for (int i = 0; i < contactListLength; i++) {
                String[] ourNames1 = current.getFirstName().split(" ");
                String[] ourNames2 = newNode.getFirstName().split(" ");

                int result = ourNames1[ourNames1.length - 1].compareToIgnoreCase(ourNames2[ourNames2.length - 1]);
                if (result > 0) {
                    if (previous == null) {
                        newNode.setNext(current);
                        head = newNode;
                        contactListLength++;
                        break;
                    }
                    previous.setNext(newNode);
                    newNode.setNext(current);
                    contactListLength++;
                    break;
                } else {
                    if (current.getNext() == null) {
                        current.setNext(newNode);
                        newNode.setNext(null);
                        contactListLength++;
                        break;
                    }
                    previous = current;
                    current = current.getNext();
                }
            }
        }
            }


    public boolean isEmpty() {
        return (contactListLength == 0);
    }

}


