
package test;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Ali_Raza
 */
public class Student {
     private String name;
     private String Reg_No;
     private double CGPA;
     private String CNIC;
     private Date DOB;
     
     // Default Construtor
     public Student()
     {
         name=Reg_No=CNIC=null;
         CGPA=0.0;
         DOB=null;
     }
     
     // Two parameter constuctor
     public Student(String name, String Reg_No)
     {
         this.setName(name);
         this.setRegNo(Reg_No);
         CNIC=null;
         DOB=null;
         CGPA=0.0;
     }
     
     // Setting all the values
     public void setValues(String name, String Reg_No, String CNIC, Double CGPA, String DOB)
     {
         this.setName(name);
         this.setCGPA(CGPA);
         this.setCNIC(CNIC);
         this.setRegNo(Reg_No);
         this.setDOB(DOB);
     }
     
     // Getter and Setter Functions
     public void setName(String name)
     {
         if(!this.validateName(name)||name.length()==0)
         {
            System.out.println("Invlid name\n");
         }
         else
            this.name=name;
     }
     public String getName()
     {
        return this.name; 
     }
     
     public void setRegNo(String Reg_No)
     {
         this.Reg_No=Reg_No;
     }
     public String getRegNo()
     {
         return this.Reg_No;
     }
     
     public void setDOB(String DOB)
     {
        Date dob=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            //Parsing the String
            dob = dateFormat.parse(DOB);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            System.out.println("Unable to parse " + DOB);
            e.printStackTrace();
        }
        Date d1=new Date();
        try {
            //Parsing the String
            d1 = dateFormat.parse("01-01-2005");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date d2=new Date();
        try {
            //Parsing the String
            d2 = dateFormat.parse("31-12-1990");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        if((dob.compareTo(d1)>0)||(dob.compareTo(d2)<0))
        {
            System.out.println("Date is not in the given range");
        }
        else
            this.DOB=dob;
        
     }
     
     public Date getDOB()
     {
         return this.DOB;
     }
     
     public void setCNIC(String CNIC)
     {
        if(!this.validateCNIC(CNIC))
            System.out.println("CNIC is invalid.\n");
        else
            this.CNIC=CNIC;
     }
     public String getCNIC()
     {
         return CNIC;
     }
     
     public void setCGPA(double CGPA)
     {
         if(this.CGPA<0||this.CGPA>4)
         {
             System.out.println("Your CGPA is not valid.\n");
         }
         this.CGPA=CGPA;
     }
     public double getCGPA()
     {
         return CGPA;
     }
     
     // Function to test a valid name. It will return true if name is valid otherwise false...
     public Boolean validateName(String name)
     {
         for(int i=0;i<name.length();i++)
         {
             // Condition for checking a charactor for English Alphabet or space...
             if(((name.charAt(i)<65)||(name.charAt(i)>90))&&((name.charAt(i)<97)||(name.charAt(i)>122))&&name.charAt(i)!=32)
             {
                 return false;
             }
         }
         return true;
     }
     
     // This funtion will check CNIC for correct length and Numbers only...
     public Boolean validateCNIC(String CNIC)
     {
         // Length should be equal to 13...
         if(CNIC.length()!=13)
             return false;
         else{
             for(int i=0;i<CNIC.length();i++)
             {
                 if(CNIC.charAt(i)<48||CNIC.charAt(i)>57)
                     return false;
             }
         }
         return true;
     }
     
     // This method will return the number of words in Name
     public int numberOfWordsInName()
     {
         int number=1;
         for(int i=0; i<this.name.length(); i++)
         {
             if(this.name.charAt(i)==32)
                number++;
         }
         return number;
     }
     
     // Finding the gender of Student...
     public String getGender()
     {
         switch(this.CNIC.charAt(this.CNIC.length()-1))
         {
             case '1':
             case '3':
             case '5':
             case '7':
             case '9':
                 return "Male";
         }
         return "Female";
     }
     
     // Function to get value of Status...
     public String getStatus()
     {
         if(this.CGPA<2.0)
             return "Suspended";
         else if(this.CGPA<=2.5)
             return "Below Average";
         else if(this.CGPA<=3.3)
             return "Average";
         else if(this.CGPA<=3.5)
             return "Below Good";
         else
             return "Excellent";
     }
     
     // Function to get value of Age...
     public String getAge()
     {
        if(this.DOB!=null)
        {
            LocalDate birthday = new java.sql.Date(this.DOB.getTime()).toLocalDate();
            Date d = new Date(System.currentTimeMillis());
            LocalDate today = new java.sql.Date(d.getTime()).toLocalDate();
            Period p = Period.between(birthday, today);
            return "(Age is " + p.getYears() + " years, " + (p.getMonths()) +
                       " months, and " + p.getDays() + " days)";
        }
        else
            return null;
     }
     
     // Displaying all the values...
     public void display()
     {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.DOB);
        //System.out.println(calendar.get(Calendar.YEAR));
         System.out.println("Name: " + this.name + "(Contains " + this.numberOfWordsInName() + " words)");
         System.out.println("Registration Number: " + this.getRegNo());
         System.out.println("CGPA: " + this.getCGPA() + " " + this.getStatus());
         System.out.println("Date of Birth: " + this.getMonth(calendar.get(Calendar.MONTH)+1) + " " + calendar.get(Calendar.DAY_OF_MONTH)+
                            ", " + calendar.get(Calendar.YEAR) + this.getAge());
         System.out.println("CNIC: " + this.getCNIC());
         System.out.println("Gender: " + this.getGender());
     }
     
     // Getting Charactor value of month...
     public String getMonth(int month)
     {
         switch(month)
         {
            case 1:
                 return "January";
            case 2:
                 return "Feburary";
            case 3:
                 return "March";
            case 4:
                 return "April";
            case 5:
                 return "May";
            case 6:
                 return "June";
            case 7:
                 return "July";
            case 8:
                 return "August";
            case 9:
                 return "September";
            case 10:
                 return "October";
            case 11:
                 return "November";
            case 12:
                 return "December";
            default:
                return null;
         }
         
     }
     // Destructor
     protected void finalize()throws Throwable
     {
         try{
         System.out.print("Destructor called");
     }
         finally{
         super.finalize();
     }
     }
}
