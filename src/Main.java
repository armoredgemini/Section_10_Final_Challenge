/**
 * Created by ac003588 on 8/31/2017.
 */
public class Main {

    private static Person currentPosition;
    private static Person head = new Employee("", "");

    public static void main(String[] args) {
        //Person head = new Employee("", "");
        Person smith = new Employee("Tony", "Smith");
        Person rogers = new Employee("Bob", "Rogers");
        Person doe = new Employee("John","Doe");
        Person ericson = new Employee("John", "Ericson");
        Person adams = new Employee("John", "Adams");
        Person zenith = new Employee("Eric", "Zenith");


//        head.setNext(doe);
//        doe.setPrevious(head);
//        doe.setNext(rogers);
//        rogers.setPrevious(doe);
//        rogers.setNext(smith);
//        smith.setPrevious(rogers);


       //  Person personFound = findByLast(ericson);


//        if(personFound != null) {
//            System.out.println("Found person " + personFound.getLastName());
//        } else {
//            System.out.println("Person not found");
//        }

        insertPerson(ericson);
        insertPerson(doe);
        insertPerson(smith);
        insertPerson(rogers);
        printList();
        System.out.println(findByLast(ericson));
        System.out.println("Removing ericson");
        removePerson(ericson);
        printList();
        insertPerson(ericson);
        printList();
        System.out.println("removing smith");
        removePerson(smith);
        printList();
        insertPerson(doe);
        removePerson(doe);
        printList();
        insertPerson(adams);
        System.out.println("Current Employee List");
        printList();
        System.out.println("User " + findByLast(adams).getFirst()  + " found." );
        insertPerson(zenith);
        printList();

    }


//    public static void setCurrentPosition(Person p) {
//        currentPosition = p;
//    }

    public static Person findByLast (Person p) {
        currentPosition = head.getNext();
        boolean isNotLast = true;

        while (isNotLast) {
//            System.out.println("Current position is " + currentPosition.getLastName());
//            System.out.println("Trying " + currentPosition.getLastName());
//            System.out.println("Testing " + p.getLastName().toLowerCase() + " to " + currentPosition.getLastName().toLowerCase());

            if (currentPosition.getLastName().toLowerCase().equals(p.getLastName().toLowerCase())) {
                return currentPosition;
            }

            if (currentPosition.getNext() == null) {
                isNotLast = false;
            } else {
                currentPosition = currentPosition.getNext();
            }

        } return null;

    }


    public static void insertPerson(Person p) {

        currentPosition = head;
        System.out.println("Trying to Insert " + p.getLastName());
        // if head's hasNext is null, then this is the first entry
        if (!currentPosition.hasNext()) {
            currentPosition.setNext(p);
            p.setPrevious(currentPosition);
            System.out.println(currentPosition.getLastName() + "'s next has been set to " + p.getLastName());
            System.out.println(p.getLastName() + "'s previous has been set to " + currentPosition.getLastName());
            return;
        }

        //currentPosition = currentPosition.getNext();
        while(currentPosition.hasNext()) {
//            System.out.println("Starting insert process");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(currentPosition.getLastName());
//            System.out.println("Checking " + currentPosition.getLastName() + ", Next is " + currentPosition.getNext().getLastName());
//             If p equals current position, exit.  No duplicates allowed
            // System.out.println("");
            if (p.compareTo(currentPosition) == 0) {
                System.out.println("Duplicate last names not allowed at this time");
                return;
                // Else if p is greater than the current position, go to next position (Borris.compareTo.Abel = 1
            } else if (p.compareTo(currentPosition) > 0) {
                System.out.println("Current Postion is switching to: " + currentPosition.getNext().getLastName());
                currentPosition = currentPosition.getNext();
                // Else if p is less than the current position, insert here   (ericson.compareTo.Fargo = -1)
            } else if (currentPosition.compareTo(p) > 0 && currentPosition.getNext().compareTo(p) < 0) {
                p.setNext(currentPosition.getNext());
//                System.out.println(p.getLastName() + "'s next has been set to " + p.getNext().getLastName() );
                p.setPrevious(currentPosition);
//                System.out.println(p.getLastName() + "'s previous has been set to " + p.getPrevious().getLastName());
                currentPosition.getNext().setPrevious(p);
//                System.out.println(currentPosition.getNext().getLastName() + "'s previous has been set to " + currentPosition.getNext().getPrevious().getLastName());
                currentPosition.setNext(p);
//                System.out.println(currentPosition.getLastName() + "'s next has been set to " + currentPosition.getNext().getLastName());
                return;
            } else {
                System.out.println("Changing position to " + currentPosition.getNext().getLastName());
                currentPosition = currentPosition.getNext();
            }



        }
        if(currentPosition.hasPrev() && ! currentPosition.hasNext()) {
            currentPosition.setNext(p);
            p.setPrevious(currentPosition);
            return;
        }
    }

    public static void printList(){
        currentPosition = head.getNext();
        while(currentPosition.hasPrev()) {
            System.out.println(currentPosition.getLastName());
            if(currentPosition.hasNext()) {
                currentPosition = currentPosition.getNext();
            } else {
                return;
            }
        }
    }

    public static void removePerson (Person p){
        Person found = findByLast(p);
        if(found != null) {
            // If the search for the passed person argument is not null
            // Get the object's previous and next objects

            //Person newPrev = p.getPrevious();

            if(p.getNext() != null) {
                System.out.println("User " + p.getLastName() + " found, setting the next object's previous to " + p.getPrevious().getLastName());
                p.getNext().setPrevious(p.getPrevious());
                System.out.println(" and setting the previous object's next to " + p.getNext().getLastName());
                //Person newNext = p.getNext();
                p.getPrevious().setNext(p.getNext());
            } else {
                p.getPrevious().setNext(null);
            }
            // Set the previous object's next value to the new previous value (which was the passed objects next value
            //p.getPrevious().setNext(newNext);


            // remove the passed object's references
            System.out.println("Now removing " + p.getLastName() + "'s references...");
            found.setPrevious(null);
            if (found.getNext() != null) {
                found.setNext(null);
            }
            return;
        } else {
            System.out.println(p.getLastName() + " was not found");
        }
    }
}
