import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEMail;
    private String email;
    private int defaultPasswordLength = 10;
    private  String companyName = "aeycompany.com";

    //constructor to receive firstname and lastname
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email created: "+ this.firstName + " " + this.lastName);

        //call a method to ask for department - return department
        this.department = setDepartment();
        //System.out.println("department: " + this.department);

        //call a method to generate random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Password is: " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companyName;
        //System.out.println("Your email is: " + email);

    }

    //ask for dept
    private String setDepartment(){
        System.out.print("New Employee: " + firstName + " " + lastName + "\nDepartment Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department:");
        Scanner input = new Scanner(System.in);
        int deptId = input.nextInt();
        if (deptId == 1){
            return "Sales";
        } else if (deptId == 2) {
            return "Development";
        } else if (deptId == 3) {
            return "Accountung";
        }else { return "";}
    }

    //generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuioplkjhgfdsazxcvbnm_+-!@#$%^&*0123456789";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            int rand =(int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set mailbox capacity
    public void setMailBoxCapacity(){
        this.mailboxCapacity = mailboxCapacity;
    }


    //set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEMail = altEmail;
    }


    //change password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){ return mailboxCapacity; }
    public String getAlternateEMail(){ return alternateEMail;}
    public String getPassword(){
        return password;
    }

    public String toString(){
        return "DISPLAY NAME: " + firstName + " " + lastName +"\n" +
                "COMPANY EMAIL: "+ email + "\n" +
                "MAILBOX CAPACITY: " + mailboxCapacity;
    }
}
