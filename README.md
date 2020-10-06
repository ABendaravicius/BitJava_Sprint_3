###### by Arnas Bendaravičius_ 10-01 / 2020
# OOP Java : Sprint Task No.3


## OBJECT-BASED FILE READING AND WRITING JAVA PROGRAM USING LISTS

### THE TASK:
To create an object-oriented program, that would use lists to store and manipulate data (i.g. create and fill lists, edit lists, store lists into files, load lists from files, filter lists.

### THE PROGRAM:
It is an updated version of the program developed in the 2nd Sprint task.
What's new?:
* Storing created Employee/Visitor entries in readily-available ArrayLists;
* Selective Employee and Visitor data loading;
* Option to review currently stored data;
* Multiple options to filter currently stored data;
* Implementation of **Interfaces** and **Anonymous Comparators** for custom list filtering

### HOW IT WORKS:
The program consists of several methods, that are called through a switch block, that checks the value of the user input and then calls the according method.

### HOW TO USE:
The user is expected to use the CLI where using console input he can chose from one of the following options:
```
> WHAT DO YOU WANT TO DO?:
1) Create new Employee entry
2) Create new Visitor entry.
3) Save data to file.
4) Load data from file.
5) View and filter data.

0) Quit program.
```
Entering any other input than `0`, `1`, `2`, `3`, `4` or `5` will result in the following message being printed into the console, with the available choices being repeated again:
```
> Please choose one of the options above!
```
By choosing options `1` or `2` the user can create Employee or Visitor data through CLI input that is then stored into seperate employee and visitor ArrayLists automatically. This data can then be viewed by calling the `5`th menu option. Data, currently stored in the ArrayLists is then printed out as follows:
```
> Employee data_________________________
  
> ______________________________________
> Visitor data__________________________

> ______________________________________
```
Moreover, the user is presented with the following options for further action:
```
> VIEW AND FILTER DATA:
1) Sort Employees by age ascending.
2) Sort Visitors by visit time descending.
3) Filter unique visitors.

0) Go back.
```
At any time, from the initial menu the user can choose to save (*write*) current ArrayList data to prepared files (empData.csv and visData.csv) by choosing the `3`rd option via input.

In addition, choosing the `4`th option in the initial menu will call the data loading functionality, that will read the files and store data entries back into ArrayLists, depending on the chosen menu option:
```
> LOAD DATA FROM FILE:
1) Load Employee data.
2) Load Visitor data.
3) Load ALL data.

0) Go back
```

*NOTE: if the file is empty however, it will not be read, and instead a message saying: `> File is currently empty. ---`, will be returned to the console.*
