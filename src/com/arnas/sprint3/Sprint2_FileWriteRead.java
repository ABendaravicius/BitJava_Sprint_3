package com.arnas.app;

import java.io.*;
import java.util.Scanner;

public class Sprint2_FileWriteRead {

    public static void main(String[] args) {
        Scanner userChoice = new Scanner(System.in);
        int choice = 9;

        while (choice != 0) {

            // File to write data to / read data from
            File newFile = new File("./duomenys.csv");

            // Input choice output to console
            System.out.println("> Choose what you want to do:\n" +
                    "1) Create and write new Employee data.\n" +
                    "2) Create and write new Visitor data.\n" +
                    "3) Read data from file.\n" +
                    "\n" +
                    "0) Quit program.");
            choice = Integer.parseInt(userChoice.nextLine());

            switch (choice) {
                case 1:
                    newEmployee(newFile); // creates object called: employee
                    break;
                case 2:
                    newVisitor(newFile); // creates object called: visitor
                    break;
                case 3:
                    readFile(newFile); // reads data currently stored in the file
                    break;
                case 0: // QUITS
                    break;
                default:
                    System.err.println("> Please choose one of the options above!");
                    break;
            }
        }

        System.out.println("> End of program...");

    }

    static void newEmployee(File file) {
        // Collecting console input
        Scanner userInput = new Scanner(System.in);
        System.out.println("> Data about the new employee: ");
        System.out.println("... Enter the person's name: ");
        String eName = userInput.nextLine(); // name input
        System.out.println("... Enter the person's last name: ");
        String eLastName = userInput.nextLine(); // last name input
        System.out.println("... Enter the person's age: ");
        int eAge = Integer.parseInt(userInput.nextLine()); // age input, then parsed to integer
        System.out.println("... Enter the person's position: ");
        String ePosition = userInput.nextLine(); // position input
        System.out.println("... Enter the person's years working here: ");
        double eWorkYears = Double.parseDouble(userInput.nextLine()); // years working input

        Employee employee = new Employee(eName, eLastName, eAge, ePosition, eWorkYears);

        writeFile(file, employee); // Method call to write employee object data to file
    }

    static void newVisitor(File file) {
        // Collecting console input
        Scanner userInput = new Scanner(System.in);
        System.out.println("> Data about the visitor: ");
        System.out.println("... Enter the visitor's name: ");
        String vName = userInput.nextLine(); // name input
        System.out.println("... Enter the visitor's last name: ");
        String vLastName = userInput.nextLine(); // last name input
        System.out.println("... Enter the visitor's age: ");
        int vAge = Integer.parseInt(userInput.nextLine()); // age input
        System.out.println("... Enter the visitor's intent of visit: ");
        String vIntent = userInput.nextLine(); // intent of visit input
        System.out.println("... Enter the visitor's duration of visit: ");
        int vDuration = Integer.parseInt(userInput.nextLine()); // visit duration input

        Visitor visitor = new Visitor(vName, vLastName, vAge, vIntent, vDuration);

        writeFile(file, visitor); // Method call to write visitor object data to file
    }

    static void readFile(File file) {
        System.out.println("> Reading data from file... ---");

        BufferedReader bR;

        try {
            bR = new BufferedReader(new FileReader(file));
            String fileLine = bR.readLine();
            if (fileLine == null) {
                System.err.println("> File is currently empty. ---");
            } else {
                while (fileLine != null) {
                    System.out.println(fileLine);
                    fileLine = bR.readLine();
                }
                System.out.println("> End of File. ---");
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static void writeFile(File file, Person person) { // Write to File method takes in file and object as parameters
        BufferedWriter bW;

        try {
            bW = new BufferedWriter(new FileWriter(file, true));
            bW.write(person.toString() + "\n");
            bW.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
