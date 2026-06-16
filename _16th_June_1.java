import java.util.*;


// "Problem Statement:
// A registration system must validate user input before processing.

// Task:  Validate fields like age and email.

// Requirements:
// Throw IllegalArgumentException for invalid inputs
// Validate:
// Age > 18
// Email format contains '@'
// Allow user to retry input (loop)
// Display clear error messages"

public class _16th_June_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter mail:");
        String mail = sc.next();

        System.out.println("Enter age:");
        int age = sc.nextInt();

        while(true){
            Registration r = new Registration(age, mail);
            if(age >= 18 && mail.contains("@")){
                System.out.println("Registration successful");
                break;
            } else {
                System.out.println("Enter mail:");
                mail = sc.next();

                System.out.println("Enter age:");
                age = sc.nextInt();
            }
        }
    }
}

class Registration{
    int age;
    String email;

    Registration(int age, String email){
        this.age = age;
        this.email = email;

        try{
            if(age < 18){
                throw new Exception("Age is less than 18");
            }
            if(!email.contains("@")){
                throw new Exception("Invalid email");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}