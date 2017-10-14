// This is the simple Implementation of Classes in java.
// Here I have used a class Student. Made its two objects
// set their values and then display the values


package test;

/**
 *
 * @author Ali_Raza
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creating first object of class Student with default values...
        Student std1=new Student();
        
        // Setting values of std1
        std1.setName("Ali Raza");
        std1.setRegNo("2015-CS-52");
        std1.setCNIC("3410116155589");
        std1.setCGPA(3.591);
        std1.setDOB("01-06-1997");
   
        // Creating Second object of class Student with overloaded constructor...
        Student std2=new Student("Sameer","2015-CS-71");
        // Setting other values of std2...
        std2.setCGPA(3.4);
        std2.setCNIC("1234123412341");
        std2.setDOB("28-10-1996");
        
        // Displaying the values of students...
        std1.display();
        std2.display();
    }
}  
