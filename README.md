# Informaion-Retrieval-System
Description on how to run the program:

Command for compiling the java program: 
javac -cp commons-lang3-3.7.jar assignmentP3.java

Command for running the java program on Windows: 
java -cp .;commons-lang3-3.7.jar assignmentP3 Reviews Dictionary.csv Postings.csv DocsTable.csv Output.txt

Command for running the java program on Ubuntu: 
java -cp .:"commons-lang3-3.7.jar" assignmentP3 Reviews Dictionary.csv Postings.csv DocsTable.csv Output.txt


A short description of library used:

I have used the library provided by Apache Commons. I have included the .jar file of it in the folder.
The standard Java libraries fail to provide enough methods for manipulation of its core classes. Apache Commons Lang provides these extra methods.
Lang provides a host of helper utilities for the java.lang API, notably String manipulation methods, basic numerical methods, object reflection, concurrency, creation and serialization and System properties. Additionally it contains basic enhancements to java.util.Date and a series of utilities dedicated to help with building methods, such as hashCode, toString and equals.
