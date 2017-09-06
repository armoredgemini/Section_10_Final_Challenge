/**
 * Created by ac003588 on 8/31/2017.
 */
public class Employee extends Person {

    public Employee(String first, String last) {
        super(first, last);
    }



    @Override
    public boolean hasNext() {
        if(this.getNext() != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPrev() {
        if(this.getPrevious() != null) {
            return true;
        }
        return false;
    }

    @Override
    public Integer compareTo(Person p) {

        return p.getLastName().compareToIgnoreCase(this.getLastName());
//        System.out.println("Result is " + result );
        //return result;

    }

    @Override
    public void setNext(Person p) {
        this.next = p;
    }

    @Override
    public void setPrevious(Person p) {
        this.previous = p;

    }
}
