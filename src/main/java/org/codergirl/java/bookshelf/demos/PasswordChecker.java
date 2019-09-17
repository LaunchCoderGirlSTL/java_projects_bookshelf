package org.codergirl.java.bookshelf.demos;


import java.util.Scanner;

public class PasswordChecker {
    private static String PASSWORD_MUCH_SECRET_DONT_TELL = "db85db777f67685f23f4fc292a21269675d2ae7e33f7782cd123071227f9eed0";

    public static boolean isPasswordCorrect(String enteredPassword){
        return PASSWORD_MUCH_SECRET_DONT_TELL
                .equals(Sha256.to256(enteredPassword));
    }

    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);
        int remainingAttempts = 3;
        String enteredPassword = "";

        while (remainingAttempts > 0 && !isPasswordCorrect(enteredPassword)){
            System.out.println(String.format("You have %d attempts to guess the right password:",
                    remainingAttempts));

            enteredPassword = keyboard.nextLine();
            remainingAttempts -= 1;
        }

        if (isPasswordCorrect(enteredPassword)){
            System.out.println(String.format("%s That's the combination to my luggage!", enteredPassword));
        }
        else {
            System.out.println("You didn't crack my code. My secrets remain " +
                    "enshrouded in mystery. Good bye.");
        }
    }
}
