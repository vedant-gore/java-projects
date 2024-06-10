import java.util.Scanner;

public class Student {
    private String firstName, lastName;
    private int gradeYear;
    private String studentId;
    private String courses="";
    private int tuitionBalance=0;
    private static int costOfCourse=600;
    private static int id=1000;

    // constructor: prompt user to enter student name and year
    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Student First Name: ");
        this.firstName=in.nextLine();
        System.out.println("Enter Student Last Name: ");
        this.lastName=in.nextLine();
        System.out.println("1-Freshman\n2-Sophomore\n3-Junior\n4-Senior | Enter Student Grade Year: ");
        this.gradeYear=in.nextInt();

        setStudentID();;
    }

    // generate an id
    private String setStudentID(){
        id++;
        // GRADE ELVEL + ID
        this.studentId=gradeYear+""+id;
        return studentId;
    }

    // enroll in courses
    public void enroll(){
        do{
            System.out.println("Enter to enroll (Q to quit): ");
            Scanner in=new Scanner(System.in);
            String course=in.nextLine();
            if(!course.equals("Q")){ 
                courses=courses+"\n"+course;
                tuitionBalance = tuitionBalance+costOfCourse;
            }
            else{
                break;
            }
        }while(1!=0);
    }

    // view balance 
    public void viewBalance(){
        System.out.println("Your balance is : $"+tuitionBalance);
    }

    // pay tuition
    public void payTuition(){
        viewBalance();
        System.out.println("Enter your payment: $");
        Scanner in=new Scanner(System.in);
        int payment=in.nextInt();
        tuitionBalance = tuitionBalance-payment;
        System.out.println("Thank you for your payment of $"+payment);
        viewBalance();
    }

    // show status
    public String toString(){
        return "\nYour Info is: "+"\nName: "+firstName+" "+lastName+
        "\nGrade level: "+gradeYear+
        "\nStudent ID: "+studentId+
        "\nCourses Enrolled"+courses+
        "\nBalance: $"+tuitionBalance;
    }
}
