import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength=8;
    private String department;
    private String email;
    private int mailboxCapacity=500;
    private String alternateEmail;
    private String companySuffix = "cognizant.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;

        // call a method asking for dept - return the dept
        this.department = setDepartment();
        System.out.println("Department: "+this.department);

        // call a method that return random password
        this.password=randomPassword(defaultPasswordLength);
        System.out.println("Your password is: "+this.password);

        // combine elements to generate email
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department.toLowerCase()+"."+companySuffix;
    }

    // ask for the department
    private String setDepartment(){
        System.out.println("DEPARTMENT CODES:\n1) Sales\n2) Development\n3) Accounting\n4) None\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        in.close();
        if(deptChoice == 1) return "sales";
        else if(deptChoice == 2) return "Development";
        else if(deptChoice == 3) return "Accounting";
        else return "N/A";
    }

    // generate a new random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int)(Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }

    // change the password
    public void changePassword(String password){
        this.password=password;
    }

    public int getMailBoxCapacity(){ return mailboxCapacity;}
    public String getAlternateEmail(){ return alternateEmail;}
    public String getPassword(){ return password;}

    public String showInfo(){
        return "DISPLAY NAME: "+firstName+" "+lastName+"\n"+"COMPANY EMAIL: "+email+"\n"+"MAILBOX CAPACITY: "+mailboxCapacity+" GB";
    }
}
