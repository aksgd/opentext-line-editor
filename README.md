
### Goal:

Write a line-oriented text editor that reads a text file and allows basic editing
commands

### Building the app
```
mvn clean install
```

### How to run the program:

### using maven
```
mvn clean install exec:java -Dexec.mainClass="com.opentext.assignment.linereader.App" -Dexec.args="/path/to/file"
```

### using shell script (on linux machines)
There is a shell script in the root directory of this repo with name `lineeditor`, it could be used as a convenience tool to run the program after it is built using maven.
From project root following can be run on a terminal to achieve this goal.
```
 chmod u+x ./lineditor
./lineeditor /path/to/file
```

### using bat file (for windows machines)
There is a bat file in the root directory of this repo with name `lineeditor.bat`, it could be used as a convenience tool to run the program after it is built using maven.
From project root following can be run on a terminal to achieve this goal.
Note: This was not tested.
```
./lineeditor /path/to/file
```