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

    public void printContactsList() {
        Person tempNode = head;
        if (head == null) {
            System.out.println("***************************************\n|    OPPss!!  The list is empty!      |\n***************************************\n");
        } else {
            for (int i = 0; i < contactListLength; i++) {
                System.out.print("-------- * -------- * -------- * --------");
                System.out.println(tempNode);
                tempNode = tempNode.getNext();
                System.out.println("-------- * -------- * -------- * --------");
            }

        }
        System.out.println();
    }

    public void searchByFirstName(String firstName) {
        Person current = head;
        boolean empty = true;
        if (isEmpty()) {
            System.out.println("***************************************\n|    OPPss!!  The list is empty!      |\n***************************************\n");
        } else {
            for (int i = 0; i < contactListLength; i++) {
                if (current.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {
                    System.out.println((i + 1) + " match found!");
                    System.out.print("-------- * -------- * -------- * --------");
                    System.out.println(current);
                    System.out.println("-------- * -------- * -------- * --------");
                    empty = false;
                }
                current = current.getNext();
            }
            if (empty) {
                System.out.println("NO RESULTS FOUND!");
            }
        }

    }

    public void displayContactsName() {
        Person current = head;
        System.out.println("Here are all your contacts:");
        for (int i = 0; i < contactListLength; i++) {
            System.out.println((i + 1) + ". " + current.getFirstName() + " " + current.getLastName());
            current = current.getNext();
        }
    }

    public void deleteFromContactsList(int index) {
        Person current = head;
        Person previous = null;
        boolean empty = true;
        if (isEmpty()) {
            System.out.println("***************************************\n|    OPPss!!  The list is empty!      |\n***************************************\n");
        } else {
            for (int i = 0; i < contactListLength; i++) {
                if ((index - 1) == i) {
                    if (previous == null) {
                        head = head.getNext();
                        contactListLength--;
                        empty = false;
                        break;
                    } else if (current.getNext() == null) {
                        previous.setNext(null);
                        contactListLength--;
                        empty = false;
                        break;
                    } else {
                        previous.setNext(current.getNext());
                        contactListLength--;
                        empty = false;
                        break;
                    }
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
            if (empty) {
                System.out.println("Contact Not Found");
            } else {
                System.out.println(current.getFirstName() + " " + current.getLastName() + "'s contact deleted from list!");
            }
        }
    }
}




