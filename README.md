# Informaion-Retrieval-System-for-moviedata

Description on how to run the program:
--------------------------------------
Download the .jar library and the java program. In order to test the retrieval system, you can download and use the sample movie reviews provided or you can use a file of your own. After entering the below commands to compile and run the program and then entering queries to test, the program will generate 4 files. They are:
1. Dictionary.csv = contains the term, document frequency and offset.
2. Postings.csv  = contains DocID and term frequency.
3. DocsTable.csv = contains the serial number, document name, title of the movie, the movie reviewer, snippet and rating of the movie.
4. Output.txt = contains the search results of the query entered.

Command for compiling the java program: 
---------------------------------------
javac -cp commons-lang3-3.7.jar IRProject.java

Command for running the java program on Windows: 
------------------------------------------------
java -cp .;commons-lang3-3.7.jar IRProject SampleMovieReviews Dictionary.csv Postings.csv DocsTable.csv Output.txt

Command for running the java program on Ubuntu:
-----------------------------------------------
java -cp .:"commons-lang3-3.7.jar" IRProject SampleMovieReviews Dictionary.csv Postings.csv DocsTable.csv Output.txt

The Query that can be used are:
-------------------------------
An AND query that starts with the word AND followed by a list of one or more words. For example (AND action war).  
An AND NOT query followed by one or more words.  For example: AND mystery AND NOT horror.  The AND must appear before the AND NOT.
An OR query that starts with the word OR followed by a list of two or more words. For example (OR action romance).
The queries are not case sensitive.


A short description of library used:
------------------------------------
I have used the library provided by Apache Commons. I have included the .jar file of it in the folder.
The standard Java libraries fail to provide enough methods for manipulation of its core classes. Apache Commons Lang provides these extra methods.
Lang provides a host of helper utilities for the java.lang API, notably String manipulation methods, basic numerical methods, object reflection, concurrency, creation and serialization and System properties. Additionally it contains basic enhancements to java.util.Date and a series of utilities dedicated to help with building methods, such as hashCode, toString and equals.
