package com.arnas.sprint3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

interface Writeable {
    String toFile();
}

public class Sprint3{

    public static void main(String[] args) {
        Scanner userChoice = new Scanner(System.in);

        // Files to store data in
        File empData = new File("./data/employees.csv");
        File visData = new File("./data/visitors.csv");

        // Initialization of ArrayLists for storing data about people
        // > ArrayList for Employees
        ArrayList<Employee> employees = new ArrayList<>();
        // > ArrayList for Visitors
        ArrayList<Visitor> visitors = new ArrayList<>();

        int choice = 9;

        while (choice != 0) {

            // Input choice output to console
            System.out.println("> WHAT DO YOU WANT TO DO?:\n" +
                    "1) Create new Employee entry.\n" +
                    "2) Create new Visitor entry.\n" +
                    "3) Save data to file.\n" +
                    "4) Load data from file.\n" +
                    "5) View and filter data.\n" +
                    "\n" +
                    "0) Quit program.");
            choice = Integer.parseInt(userChoice.nextLine());

            switch (choice) {
                case 1:
                    newEmployee(employees); // creates object called: employee . stores it into a list
                    break;
                case 2:
                    newVisitor(visitors); // creates object called: visitor . stores it into a list
                    break;
                case 3:
                    writeFile(empData, employees); // writes data currently stored in the employees ArrayList to empData.csv
                    writeFile(visData, visitors); // writes data currently stored in the visitors ArrayList to visData.csv
                    break;
                case 4:
                    // Load data from files and store into ArrayLists
                    System.out.println("> LOAD DATA FROM FILE:\n" +
                            "1) Load Employee data.\n" +
                            "2) Load Visitor data.\n" +
                            "3) Load ALL data.\n" +
                            "\n" +
                            "0) Go back.");
                    choice = Integer.parseInt(userChoice.nextLine());

                    switch (choice) {
                        case 1:
                            loadEmployees(empData,employees);
                            break;
                        case 2:
                            loadVisitors(visData,visitors);
                            break;
                        case 3:
                            loadEmployees(empData,employees);
                            loadVisitors(visData,visitors);
                            break;
                        case 0:
                            choice = 1; // Setting the value to (1) to avoid program termination and invalid choice error
                            break;
                    }

                    break;
                case 5:
                    // Displays data currently stored in ArrayLists and offers filter options
                    System.out.println("> Employee data_________________________");
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    System.out.println("> ______________________________________");

                    System.out.println("> Visitor data_________________________");
                    for (Visitor v : visitors) {
                        System.out.println(v);
                    }
                    System.out.println("> ______________________________________");

                    System.out.println("> VIEW AND FILTER DATA:\n" +
                            "1) Sort Employees by age ascending.\n" +
                            "2) Sort Visitors by visit time descending.\n" +
                            "3) Filter unique visitors.\n" +
                            "\n" +
                            "0) Go back.");
                    choice = Integer.parseInt(userChoice.nextLine());

                    switch (choice) {
                        case 1:

                            System.out.println("> Employee data_________________________");
                            for (Employee e : employees) {
                                System.out.println(e);
                            }
                            System.out.println("> ______________________________________");
                            break;
                        case 2:

                            System.out.println("> Visitor data_________________________");
                            for (Visitor v : visitors) {
                                System.out.println(v);
                            }
                            System.out.println("> ______________________________________");
                            break;
                        case 3:
                            for (Visitor v : visitors)

                            System.out.println("> Visitor data_________________________");
                            for (Visitor v : visitors) {
                                System.out.println(v);
                            }
                            System.out.println("> ______________________________________");
                            break;
                        case 0:
                            choice = 1; // Setting the value to (1) to avoid program termination and invalid choice error
                            break;
                    }

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

    static void newEmployee(ArrayList arr) {
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

        arr.add(employee); // Stores new employee entry to a list
    }

    static void newVisitor(ArrayList arr) {
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

        arr.add(visitor); // Stores new visitor entry to a list
    }

    static void loadEmployees(File file, ArrayList arr) {
        System.out.println("> Reading employee data from file... ---");

        BufferedReader bR;

        try {
            bR = new BufferedReader(new FileReader(file));
            String fileLine = bR.readLine();
            if (fileLine == null) {
                System.err.println("> File is currently empty. ---");
            } else {
                while (fileLine != null) {
                    String[] fileLineAsArray = fileLine.split(";");
                    Employee emp = new Employee(fileLineAsArray[0], fileLineAsArray[1], Integer.parseInt(fileLineAsArray[2]), fileLineAsArray[3], Double.parseDouble(fileLineAsArray[4]));
                    arr.add(emp);
                    fileLine = bR.readLine();
                }
                System.out.println("> Employee list loaded from file. ---");
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static void loadVisitors(File file, ArrayList arr) {
        System.out.println("> Reading visitor data from file... ---");

        BufferedReader bR;

        try {
            bR = new BufferedReader(new FileReader(file));
            String fileLine = bR.readLine();
            if (fileLine == null) {
                System.err.println("> File is currently empty. ---");
            } else {
                while (fileLine != null) {
                    String[] fileLineAsArray = fileLine.split(";");
                    Visitor emp = new Visitor(fileLineAsArray[0], fileLineAsArray[1], Integer.parseInt(fileLineAsArray[2]), fileLineAsArray[3], Integer.parseInt(fileLineAsArray[4]));
                    arr.add(emp);
                    fileLine = bR.readLine();
                }
                System.out.println("> Visitor list loaded from file. ---");
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static void writeFile(File file, ArrayList arr) { // Write to File method . takes in File and ArrayList as parameters
        BufferedWriter bW;
        Object person;

        try {
            bW = new BufferedWriter(new FileWriter(file, true));
            for (int i = 0; i < arr.size();i++) { // For loop to iterate through each object stored in the list
                person = arr.get(i);
                bW.write(((Person)person).toFile() + "\n"); // Calling .toFile() on each ArrayList item cast to Person class object
            }
            bW.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
