import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        String userName; // asks name of user
        String userAge; // asks how old user is
        String userHome; // ask where user is from

        System.out.print("Hello. What is your name? ");
        userName = scnr.next();

        System.out.print("It's nice to meet you, " + userName + ". How old are you? ");
        userAge = scnr.next();

        System.out.print("I see that you are still quite young at only " + userAge + ". ");
        System.out.print("Where do you live? ");
        userHome = scnr.next();

        System.out.print("Wow! I've always wanted to go to " + userHome + ". Thanks for chatting with me. Bye! ");

    }
}
