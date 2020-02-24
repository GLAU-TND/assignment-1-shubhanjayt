package contact;

import java.io.Serializable;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private String contactNumber;
    private String anotherContactNumber;
    private String e_mailAddress;
    private Person next;


    public Person() {
        next = null;
    }
}
