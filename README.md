# Spring Boot Powered ToDo List
This is a Spring Boot CLI Application to demonstrate Dependency Injection

### Running The Code
use the .jar file directly with the command: 
```
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

or build it from the demo directory with the command:
```
mvn spring-boot:run
```

### Using the commands
/help will list all commands needed to operate this tool.

## Dependecy Injection
Dependency Injection is demonstrated in the FilesClient, which switches between .txt and .dat file formats for saving and reading using setter-based injection. You can switch between these formats by typing into the shell:
```
change txt
change dat
```

### For the future:
The Spring Boot groundwork has been laid for swapping between memory data structures as well. The TasksClient is injected into the FilesClient as well as the UserCommands file, and proper configuration (with Springboot IoC in mind) ensures that the TasksClient will always be accessed as a singleton.
