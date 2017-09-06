/**
 * Created by ac003588 on 8/31/2017.
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    protected Person next;
    protected Person previous;

    public Person(String first, String last) {
        this.firstName = first;
        this.lastName = last;
        next = null;
        previous = null;
    }

    public String getFirst() {
        return firstName;
    }



    public String getLastName() {
        return lastName;
    }


    public Person getNext() {
        return next;
    }

    public Person getPrevious() {
        return previous;
    }

    //public abstract boolean find(String last);
    public abstract boolean hasNext();
    public abstract boolean hasPrev();
    public abstract Integer compareTo(Person p);
    public abstract void setNext(Person p);
    public abstract void setPrevious(Person p);

}
