# Drawing program

### Introduction

This is an application written by **Intellij (Community 2017.2)** with **Java 8** and **Gradle 4.2.1**
No extra library other than Core Java is used. For the testing part, JUnit 4 is introduced.
Some of the IDE configuration file is not included, according to prevent problem cause by different platform and OS, but the project still can be imported and activate again.

### Installation

Requires Java 8 to run. The application can run as standard java program, or by a simple shell executor.

```sh
$ java -jar application.creditsuisse.jar
```

For Windows
```sh
$ run.bat
```

For Linux/Mac
```sh
$ run.sh
```

### Assumptions

- The command is case-sensitive.
- Each command only have single operation, in the other word, one command get single handler.
- The canvas size is in a suitable range, which can handled by a normal PC memory size. Also, the value does not larger than max value of data type **int**.
- The application will not be asked for handle multi-threading.
- 

### Candidate
Mountain Man
<xmountainx@gmail.com>