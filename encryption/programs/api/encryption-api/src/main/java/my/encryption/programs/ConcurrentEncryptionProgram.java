package my.encryption.programs;

import java.util.Scanner;

public class ConcurrentEncryptionProgram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // User interaction
        System.out.println("Please enter your name:");
        String name = scan.nextLine();
        System.out.println("Hello " + name + "! Welcome to our Encryption Program.");

        System.out.println("Select encryption level: ");
        System.out.println("1. Moderate (3DES)");
        System.out.println("2. High (AES-256 or RSA-2048)");
        int choice = scan.nextInt();
        scan.nextLine();

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Exiting.");
        }

        System.out.println("Enter text to encrypt or path to file: ");
        String input = scan.nextLine();

        if (FileHandler.isFilePath(input)) {
            FileHandler.encryptFiles(input, choice);
        } else {
            FileHandler.encryptMessage(input, choice);
        }

        scan.close();
    }
}
