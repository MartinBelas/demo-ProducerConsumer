
# Producer – Consumer demo
A program in Java language that processes commands from FIFO queue using Producer – Consumer pattern.

## Supported commands are the following:
Add (...) adds a user into a database  
PrintAll – prints all users into standard output  
DeleteAll – deletes all users from database  

User is defined as database table SUSERS with columns (USER_ID, USER_GUID, USER_NAME).  
Demonstrate program on the following sequence (using main method or test):
Add (1, "a1", "Robert")  
Add (2, "a2", "Martin")  
PrintAll  
DeleteAll  
PrintAll  

## Installation

Standard gradle way.

### Prerequisites
Needs to run on JRE 8 or higher.


## Getting Started

To run the application execute command:

```
gradlew run
```


//TODO finish the document