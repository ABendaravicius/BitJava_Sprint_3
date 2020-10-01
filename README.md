###### by Arnas Bendaravičius_ 09 / 2020
# OOP Java : Sprint Task No.2


## OBJECT-BASED FILE READING AND WRITING JAVA PROGRAM

### THE TASK:
To create an object-oriented program, that would store data into a file, read the data from the file and print it into the CLI.

### HOW IT WORKS:
The program consists of several methods, that are called through a switch block, that checks the value of the user input and then calls the according method.

**newEmployee(_File file_)**
This method collects user input data to create an Employee object, which is then written to the file, that is passed as a parameter to the method.

**newVisitor(_File file_)**
This method collects user input data to create an Visitor object, which is then written to the file, that is passed as a parameter to the method.

**readFile(_File file_)**
This method reads data from the file and prints it to the console line by line. The file read is passed as a parameter to the method.

**writeFile(_File file, Person person_)**
This method writes data by calling the `toString()` method on the object currently being written. This method is called inside the `newEmployee()` and `newVisitor()` methods. The file which is written to and the object being written are passed as parameters to the method.

### HOW TO USE:
The user is expected to use the CLI where using console input he can chose from one of the following options:
```
> Choose what you want to do:
1) Create and write new Employee data.
2) Create and write new Visitor data.
3) Read data from file.
0) Quit program.
```
Entering any other input than `0, 1, 2 or 3` will result in the following message being printed into the console, with the available choices being repeated again:
```
> Please choose one of the options above!
```
By choosing options `1` or `2` the user can create Employee or Visitor data through CLI input that is then stored into objects and written into the `.csv` data file automatically. This data can then be accessed by calling the `3`rd menu option.
*NOTE: if the file is empty however, it will not be read, and instead a message saying: `> File is currently empty. ---`, will be returned to the console.*
