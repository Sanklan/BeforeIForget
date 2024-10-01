# Sudoku Solver
A Java-based Sudoku solver that takes a Sudoku puzzle as input and solves it.

## How it Works
The Sudoku solver uses a backtracking algorithm to solve the puzzle. It iterates through each empty cell, tries a number from 1 to 9, and checks if the number is valid. If the number is valid, it recursively calls the solver to fill in the rest of the puzzle. If the number is not valid, it backtracks and tries the next number.

## Code Structure
The code is organized into the following packages:

### com.fortify.game: 
This package contains classes related to the game logic, including the Game class, which represents game with injected rules, and the Validator class, which is responsible for validating game against the rules.
### com.fortify.solver: 
This package contains classes related to the solver algorithm, including the Solver class, which implements the backtracking algorithm.

### com.fortify.data: 
This package contains classes related to data storage and retrieval, including the Board class, which represents the Sudoku puzzle board.
### com.fortify.game.factory: 
This package contains the GameFactory class, which is responsible for creating instances of the Game class. The GameFactory class uses the GameType enum to determine which type of game to create.
### GameFactory Class
The GameFactory class is a factory class that creates instances of the Game class based on the GameType enum. The GameFactory class uses a switch statement to determine which type of game to create, and then returns an instance of the corresponding game class.

For example, if the GameType is Sudoku, the GameFactory class will create an instance of the SudokuGame class and return it.


### IRule Interface
The IRule interface is used to define custom games. The IRule interface provides a way to define the rules of a game, such as the rules for Sudoku.

The IRule interface has several methods that must be implemented, including updateState, which is called when the game state changes, and isValid, which is called to check if a move is valid.

`` By implementing the IRule interface, you can create custom games that can be used with the GameFactory class.``

#### Creating Custom games
Rules of games can be implemented by implementing interface IRules. In GameFactory, a combination of rules can be used to create a custom game.

## Test Case Generator
The test case generator is not implemented as part of this solution. Although, an input formatter is added to easy up testing using `fortify/src/com/fortify/__dev_tools/input_formatter.py`. 

Generate Test cases by visiting https://qqwing.com/generate.html and use input formatter to print it in usable format. Add information to test.data to run through solver.

### Test Data
The resource/test.data file contains a list of pre-generated test cases that can be used to test the Sudoku solver. 

## Main Classes
### Main.java: 
Running the main function
```bash
mvn clean install
mvn exec:java -D"exec.mainClass"="com.fortify.Main"
```

## Future
Game object holds current game and GameFactory can be used to define new types of games. So, an API layer can be build on top Gamefactory with distributed caching to launch this as an online game or an UI with any framework, can be build to create an Game Application. Also, a map or in-memory caching (like Gauva) can be used to play multiple game at the same time. Map or Cache will store gameId->Game-Object.

## Todo List
1. Update Board, Game, Builder classes to input board size as well. Right now, it's hardcoded to 9.
2. Add IRule for size check as well
3. GameGenerator module to generate random games supporting different game types. 


# Sample Output

```bash

~/github/BeforeIForget/fortify$ mvn clean install && mvn exec:java -D"exec.mainClass"="com.fortify.Main"
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< com.fortify:fortify >-------------------------
[INFO] Building Fortify 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ fortify ---
[INFO] Deleting /home/rashmi/github/BeforeIForget/fortify/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ fortify ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ fortify ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 16 source files to /home/rashmi/github/BeforeIForget/fortify/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ fortify ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/rashmi/github/BeforeIForget/fortify/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ fortify ---
[INFO] No sources to compile
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ fortify ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ fortify ---
[INFO] Building jar: /home/rashmi/github/BeforeIForget/fortify/target/fortify-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ fortify ---
[INFO] Installing /home/rashmi/github/BeforeIForget/fortify/target/fortify-1.0-SNAPSHOT.jar to /home/rashmi/.m2/repository/com/fortify/fortify/1.0-SNAPSHOT/fortify-1.0-SNAPSHOT.jar
[INFO] Installing /home/rashmi/github/BeforeIForget/fortify/pom.xml to /home/rashmi/.m2/repository/com/fortify/fortify/1.0-SNAPSHOT/fortify-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.695 s
[INFO] Finished at: 2024-10-01T15:37:34+05:30
[INFO] ------------------------------------------------------------------------
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< com.fortify:fortify >-------------------------
[INFO] Building Fortify 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:3.4.1:java (default-cli) @ fortify ---
processing test: [-1, 1, 3, 8, -1, -1, 4, -1, 5][-1, 2, 4, 6, -1, 5, -1, -1, -1][-1, 8, 7, -1, -1, -1, 9, 3, -1]  [4, 9, -1, 3, -1, 6, -1, -1, -1][-1, -1, 1, -1, -1, -1, 5, -1, -1][-1, -1, -1, 7, -1, 1, -1, 9, 3][-1, 6, 9, -1, -1, -1, 7, 4, -1][-1, -1, -1, 2, -1, 7, 6, 8, -1][1, -1, 2, -1, -1, 8, 3, 5, -1]
processing test: [-1, -1, 2, -1, -1, -1, -1, 4, 1][-1, -1, -1, -1, 8, 2, -1, 7, -1][-1, -1, -1, -1, 4, -1, -1, -1, 9][2, -1, -1, -1, 7, 9, 3, -1, -1][-1, 1, -1, -1, -1, -1, -1, 8, -1][-1, -1, 6, 8, 1, -1, -1, -1, 4][1, -1, -1, -1, 9, -1, -1, -1, -1][-1, 6, -1, 4, 3, -1, -1, -1, -1][8, 5, -1, -1, -1, -1, 4, -1, -1]
processing test: [-1, 7, 1, -1, -1, -1, -1, 8, -1] [-1, -1, 4, -1, 2, -1, -1, -1, -1] [5, -1, -1, -1, -1, -1, 3, -1, -1] [2, -1, 3, 6, -1, -1, -1, -1, -1] [4, 6, 8, -1, -1, 1, -1, 7, -1] [-1, 5, -1, -1, -1, -1, -1, -1, -1] [-1, -1, 6, -1, -1, -1, -1, -1, 5] [8, -1, -1, 7, -1, 2, -1, 1, 6] [-1, -1, -1, -1, 3, -1, -1, 4, -1]
processing test: [9, -1, -1, 8, -1, -1, -1, -1, -1] [-1, 3, 7, 2, 9, -1, 1, -1, -1] [-1, -1, 4, -1, -1, 7, -1, 6, -1] [-1, -1, -1, -1, 2, -1, -1, -1, -1] [1, 4, -1, 6, -1, -1, 3, 9, -1] [-1, -1, -1, 1, -1, -1, -1, -1, -1] [4, -1, -1, -1, -1, -1, -1, 8, 7] [-1, -1, 8, -1, 6, -1, -1, -1, -1] [7, -1, 2, -1, -1, -1, -1, 1, 9]
processing test: [5, -1, -1, -1, -1, 8, 9, 3, -1] [-1, -1, 6, 4, -1, -1, 5, -1, 1] [-1, -1, -1, -1, 5, -1, -1, 4, -1] [-1, -1, -1, 5, -1, -1, -1, -1, -1] [7, -1, -1, 6, 3, -1, -1, -1, -1] [-1, -1, -1, -1, 7, -1, -1, -1, -1] [3, 7, -1, -1, -1, -1, 8, 6, -1] [9, -1, -1, -1, -1, -1, 4, -1, 5] [-1, -1, 8, -1, 1, -1, -1, -1, 9]
processing test: [4, -1, -1, -1, 7, 6, -1, 9, -1] [3, -1, 6, -1, 5, -1, -1, 7, -1] [7, -1, -1, 3, -1, -1, 4, 8, -1] [-1, -1, 9, -1, -1, 3, -1, -1, -1] [-1, -1, -1, 8, 4, 7, -1, -1, 9] [-1, 5, -1, -1, -1, -1, -1, -1, 1] [-1, 3, 7, -1, -1, -1, -1, 6, -1] [-1, -1, 1, -1, -1, -1, -1, -1, -1] [-1, -1, -1, -1, -1, -1, -1, -1, 4]
processing test: [8, -1, -1, -1, -1, 2, -1, -1, 5] [-1, -1, -1, -1, 7, -1, -1, -1, -1] [-1, 9, 6, 5, -1, -1, -1, 8, 7] [-1, -1, 1, 2, -1, 9, -1, -1, 6] [-1, -1, -1, -1, -1, 7, -1, 5, -1] [-1, -1, 4, -1, -1, 1, 8, -1, -1] [-1, -1, 8, -1, -1, -1, -1, -1, -1] [-1, -1, -1, -1, -1, -1, 1, -1, -1] [5, -1, -1, -1, 6, -1, 9, -1, 2]
processing test: [2, -1, -1, -1, -1, 9, -1, 6, -1] [5, -1, 6, 7, -1, -1, -1, -1, -1] [1, 9, -1, -1, 5, -1, -1, 8, 2] [-1, -1, -1, -1, -1, -1, -1, -1, 5] [8, -1, -1, -1, 9, 1, -1, -1, -1] [-1, -1, -1, 6, 2, 5, -1, -1, -1] [-1, -1, -1, -1, -1, -1, -1, -1, -1] [6, 8, -1, -1, -1, 7, -1, 9, -1] [4, -1, 2, -1, 6, -1, -1, -1, 7]
processing test: [-1, 9, -1, -1, -1, 6, 5, -1, 3] [-1, -1, -1, -1, -1, -1, -1, 7, 6] [-1, -1, 4, -1, -1, -1, -1, -1, -1] [-1, 6, -1, -1, -1, 3, -1, 4, -1] [-1, -1, 2, 5, -1, -1, -1, -1, 8] [-1, -1, -1, 9, 6, -1, 3, -1, -1] [-1, -1, 8, -1, -1, -1, -1, -1, -1] [-1, -1, -1, -1, -1, -1, 7, 5, -1] [3, 2, 7, -1, -1, -1, 6, -1, 4]
processing test: [-1, -1, -1, -1, -1, -1, 5, 3, -1] [-1, 4, -1, 5, -1, -1, -1, -1, -1] [-1, -1, 7, -1, -1, -1, -1, -1, 6] [6, -1, -1, -1, 5, -1, -1, 7, -1] [2, 5, -1, -1, 6, -1, 1, 9, -1] [3, -1, 1, -1, 9, -1, -1, -1, -1] [7, 3, -1, -1, 1, -1, 9, -1, -1] [-1, -1, -1, 9, -1, -1, -1, -1, -1] [1, -1, -1, 7, -1, -1, -1, 5, 4]
processing test: [3, -1, -1, 2, -1, -1, -1, 6, 8] [-1, 8, -1, -1, -1, -1, -1, -1, -1] [2, -1, 5, -1, -1, -1, 4, -1, -1] [7, -1, -1, -1, -1, -1, -1, -1, -1] [-1, -1, -1, 5, 1, 8, -1, -1, -1] [-1, 1, 3, -1, -1, 7, -1, -1, -1] [5, -1, 8, -1, -1, 2, -1, -1, -1] [-1, 6, -1, -1, -1, 4, -1, 7, -1] [1, 7, -1, -1, 3, -1, 5, 8, -1]
processing test: [8, -1, -1, -1, -1, -1, -1, -1, -1] [9, -1, -1, -1, 7, -1, -1, -1, 3] [1, 5, 2, 4, 3, -1, -1, -1, -1] [-1, -1, -1, -1, 9, 8, -1, 5, 1] [-1, 9, -1, 5, -1, -1, 2, -1, 8] [4, -1, -1, -1, -1, -1, -1, -1, -1] [-1, -1, -1, 7, -1, -1, -1, 2, -1] [5, -1, -1, -1, -1, -1, 8, -1, -1] [-1, -1, 4, -1, -1, -1, 9, 3, -1]
Board created 
-1 1 3  | 8 -1 -1  | 4 -1 5
-1 2 4  | 6 -1 5  | -1 -1 -1
-1 8 7  | -1 -1 -1  | 9 3 -1
- - - - - - - - - - - - -
4 9 -1  | 3 -1 6  | -1 -1 -1
-1 -1 1  | -1 -1 -1  | 5 -1 -1
-1 -1 -1  | 7 -1 1  | -1 9 3
- - - - - - - - - - - - -
-1 6 9  | -1 -1 -1  | 7 4 -1
-1 -1 -1  | 2 -1 7  | 6 8 -1
1 -1 2  | -1 -1 8  | 3 5 -1

Solved Sudoku 
6 1 3  | 8 7 9  | 4 2 5
9 2 4  | 6 3 5  | 1 7 8
5 8 7  | 1 2 4  | 9 3 6
- - - - - - - - - - - - -
4 9 8  | 3 5 6  | 2 1 7
7 3 1  | 9 8 2  | 5 6 4
2 5 6  | 7 4 1  | 8 9 3
- - - - - - - - - - - - -
8 6 9  | 5 1 3  | 7 4 2
3 4 5  | 2 9 7  | 6 8 1
1 7 2  | 4 6 8  | 3 5 9

Board created 
-1 -1 2  | -1 -1 -1  | -1 4 1
-1 -1 -1  | -1 8 2  | -1 7 -1
-1 -1 -1  | -1 4 -1  | -1 -1 9
- - - - - - - - - - - - -
2 -1 -1  | -1 7 9  | 3 -1 -1
-1 1 -1  | -1 -1 -1  | -1 8 -1
-1 -1 6  | 8 1 -1  | -1 -1 4
- - - - - - - - - - - - -
1 -1 -1  | -1 9 -1  | -1 -1 -1
-1 6 -1  | 4 3 -1  | -1 -1 -1
8 5 -1  | -1 -1 -1  | 4 -1 -1

Solved Sudoku 
6 3 2  | 9 5 7  | 8 4 1
4 9 1  | 6 8 2  | 5 7 3
7 8 5  | 3 4 1  | 2 6 9
- - - - - - - - - - - - -
2 4 8  | 5 7 9  | 3 1 6
3 1 9  | 2 6 4  | 7 8 5
5 7 6  | 8 1 3  | 9 2 4
- - - - - - - - - - - - -
1 2 4  | 7 9 5  | 6 3 8
9 6 7  | 4 3 8  | 1 5 2
8 5 3  | 1 2 6  | 4 9 7

Board created 
-1 7 1  | -1 -1 -1  | -1 8 -1
-1 -1 4  | -1 2 -1  | -1 -1 -1
5 -1 -1  | -1 -1 -1  | 3 -1 -1
- - - - - - - - - - - - -
2 -1 3  | 6 -1 -1  | -1 -1 -1
4 6 8  | -1 -1 1  | -1 7 -1
-1 5 -1  | -1 -1 -1  | -1 -1 -1
- - - - - - - - - - - - -
-1 -1 6  | -1 -1 -1  | -1 -1 5
8 -1 -1  | 7 -1 2  | -1 1 6
-1 -1 -1  | -1 3 -1  | -1 4 -1

Solved Sudoku 
3 7 1  | 9 6 5  | 4 8 2
6 9 4  | 3 2 8  | 1 5 7
5 8 2  | 1 7 4  | 3 6 9
- - - - - - - - - - - - -
2 1 3  | 6 5 7  | 8 9 4
4 6 8  | 2 9 1  | 5 7 3
9 5 7  | 4 8 3  | 6 2 1
- - - - - - - - - - - - -
7 4 6  | 8 1 9  | 2 3 5
8 3 5  | 7 4 2  | 9 1 6
1 2 9  | 5 3 6  | 7 4 8

Board created 
9 -1 -1  | 8 -1 -1  | -1 -1 -1
-1 3 7  | 2 9 -1  | 1 -1 -1
-1 -1 4  | -1 -1 7  | -1 6 -1
- - - - - - - - - - - - -
-1 -1 -1  | -1 2 -1  | -1 -1 -1
1 4 -1  | 6 -1 -1  | 3 9 -1
-1 -1 -1  | 1 -1 -1  | -1 -1 -1
- - - - - - - - - - - - -
4 -1 -1  | -1 -1 -1  | -1 8 7
-1 -1 8  | -1 6 -1  | -1 -1 -1
7 -1 2  | -1 -1 -1  | -1 1 9

Solved Sudoku 
9 5 1  | 8 4 6  | 7 2 3
6 3 7  | 2 9 5  | 1 4 8
8 2 4  | 3 1 7  | 9 6 5
- - - - - - - - - - - - -
3 8 6  | 5 2 9  | 4 7 1
1 4 5  | 6 7 8  | 3 9 2
2 7 9  | 1 3 4  | 8 5 6
- - - - - - - - - - - - -
4 1 3  | 9 5 2  | 6 8 7
5 9 8  | 7 6 1  | 2 3 4
7 6 2  | 4 8 3  | 5 1 9

Board created 
5 -1 -1  | -1 -1 8  | 9 3 -1
-1 -1 6  | 4 -1 -1  | 5 -1 1
-1 -1 -1  | -1 5 -1  | -1 4 -1
- - - - - - - - - - - - -
-1 -1 -1  | 5 -1 -1  | -1 -1 -1
7 -1 -1  | 6 3 -1  | -1 -1 -1
-1 -1 -1  | -1 7 -1  | -1 -1 -1
- - - - - - - - - - - - -
3 7 -1  | -1 -1 -1  | 8 6 -1
9 -1 -1  | -1 -1 -1  | 4 -1 5
-1 -1 8  | -1 1 -1  | -1 -1 9

Solved Sudoku 
5 2 4  | 1 6 8  | 9 3 7
8 3 6  | 4 9 7  | 5 2 1
1 9 7  | 3 5 2  | 6 4 8
- - - - - - - - - - - - -
6 1 9  | 5 2 4  | 7 8 3
7 8 5  | 6 3 1  | 2 9 4
2 4 3  | 8 7 9  | 1 5 6
- - - - - - - - - - - - -
3 7 1  | 9 4 5  | 8 6 2
9 6 2  | 7 8 3  | 4 1 5
4 5 8  | 2 1 6  | 3 7 9

Board created 
4 -1 -1  | -1 7 6  | -1 9 -1
3 -1 6  | -1 5 -1  | -1 7 -1
7 -1 -1  | 3 -1 -1  | 4 8 -1
- - - - - - - - - - - - -
-1 -1 9  | -1 -1 3  | -1 -1 -1
-1 -1 -1  | 8 4 7  | -1 -1 9
-1 5 -1  | -1 -1 -1  | -1 -1 1
- - - - - - - - - - - - -
-1 3 7  | -1 -1 -1  | -1 6 -1
-1 -1 1  | -1 -1 -1  | -1 -1 -1
-1 -1 -1  | -1 -1 -1  | -1 -1 4

Solved Sudoku 
4 1 8  | 2 7 6  | 5 9 3
3 9 6  | 4 5 8  | 1 7 2
7 2 5  | 3 9 1  | 4 8 6
- - - - - - - - - - - - -
2 7 9  | 5 1 3  | 6 4 8
1 6 3  | 8 4 7  | 2 5 9
8 5 4  | 9 6 2  | 7 3 1
- - - - - - - - - - - - -
9 3 7  | 1 2 4  | 8 6 5
5 4 1  | 6 8 9  | 3 2 7
6 8 2  | 7 3 5  | 9 1 4

Board created 
8 -1 -1  | -1 -1 2  | -1 -1 5
-1 -1 -1  | -1 7 -1  | -1 -1 -1
-1 9 6  | 5 -1 -1  | -1 8 7
- - - - - - - - - - - - -
-1 -1 1  | 2 -1 9  | -1 -1 6
-1 -1 -1  | -1 -1 7  | -1 5 -1
-1 -1 4  | -1 -1 1  | 8 -1 -1
- - - - - - - - - - - - -
-1 -1 8  | -1 -1 -1  | -1 -1 -1
-1 -1 -1  | -1 -1 -1  | 1 -1 -1
5 -1 -1  | -1 6 -1  | 9 -1 2

Solved Sudoku 
8 4 7  | 9 3 2  | 6 1 5
1 3 5  | 8 7 6  | 4 2 9
2 9 6  | 5 1 4  | 3 8 7
- - - - - - - - - - - - -
3 5 1  | 2 8 9  | 7 4 6
6 8 9  | 3 4 7  | 2 5 1
7 2 4  | 6 5 1  | 8 9 3
- - - - - - - - - - - - -
9 7 8  | 1 2 3  | 5 6 4
4 6 2  | 7 9 5  | 1 3 8
5 1 3  | 4 6 8  | 9 7 2

Board created 
2 -1 -1  | -1 -1 9  | -1 6 -1
5 -1 6  | 7 -1 -1  | -1 -1 -1
1 9 -1  | -1 5 -1  | -1 8 2
- - - - - - - - - - - - -
-1 -1 -1  | -1 -1 -1  | -1 -1 5
8 -1 -1  | -1 9 1  | -1 -1 -1
-1 -1 -1  | 6 2 5  | -1 -1 -1
- - - - - - - - - - - - -
-1 -1 -1  | -1 -1 -1  | -1 -1 -1
6 8 -1  | -1 -1 7  | -1 9 -1
4 -1 2  | -1 6 -1  | -1 -1 7

Solved Sudoku 
2 7 8  | 1 4 9  | 5 6 3
5 3 6  | 7 8 2  | 9 4 1
1 9 4  | 3 5 6  | 7 8 2
- - - - - - - - - - - - -
9 6 1  | 8 7 3  | 4 2 5
8 2 5  | 4 9 1  | 3 7 6
3 4 7  | 6 2 5  | 8 1 9
- - - - - - - - - - - - -
7 1 9  | 2 3 4  | 6 5 8
6 8 3  | 5 1 7  | 2 9 4
4 5 2  | 9 6 8  | 1 3 7

Board created 
-1 9 -1  | -1 -1 6  | 5 -1 3
-1 -1 -1  | -1 -1 -1  | -1 7 6
-1 -1 4  | -1 -1 -1  | -1 -1 -1
- - - - - - - - - - - - -
-1 6 -1  | -1 -1 3  | -1 4 -1
-1 -1 2  | 5 -1 -1  | -1 -1 8
-1 -1 -1  | 9 6 -1  | 3 -1 -1
- - - - - - - - - - - - -
-1 -1 8  | -1 -1 -1  | -1 -1 -1
-1 -1 -1  | -1 -1 -1  | 7 5 -1
3 2 7  | -1 -1 -1  | 6 -1 4

Solved Sudoku 
8 9 1  | 4 7 6  | 5 2 3
2 5 3  | 8 9 1  | 4 7 6
6 7 4  | 2 3 5  | 8 9 1
- - - - - - - - - - - - -
1 6 9  | 7 8 3  | 2 4 5
7 3 2  | 5 1 4  | 9 6 8
4 8 5  | 9 6 2  | 3 1 7
- - - - - - - - - - - - -
5 4 8  | 6 2 7  | 1 3 9
9 1 6  | 3 4 8  | 7 5 2
3 2 7  | 1 5 9  | 6 8 4

Board created 
-1 -1 -1  | -1 -1 -1  | 5 3 -1
-1 4 -1  | 5 -1 -1  | -1 -1 -1
-1 -1 7  | -1 -1 -1  | -1 -1 6
- - - - - - - - - - - - -
6 -1 -1  | -1 5 -1  | -1 7 -1
2 5 -1  | -1 6 -1  | 1 9 -1
3 -1 1  | -1 9 -1  | -1 -1 -1
- - - - - - - - - - - - -
7 3 -1  | -1 1 -1  | 9 -1 -1
-1 -1 -1  | 9 -1 -1  | -1 -1 -1
1 -1 -1  | 7 -1 -1  | -1 5 4

Solved Sudoku 
9 2 6  | 8 4 1  | 5 3 7
8 4 3  | 5 7 6  | 2 1 9
5 1 7  | 3 2 9  | 4 8 6
- - - - - - - - - - - - -
6 9 4  | 1 5 3  | 8 7 2
2 5 8  | 4 6 7  | 1 9 3
3 7 1  | 2 9 8  | 6 4 5
- - - - - - - - - - - - -
7 3 5  | 6 1 4  | 9 2 8
4 8 2  | 9 3 5  | 7 6 1
1 6 9  | 7 8 2  | 3 5 4

Board created 
3 -1 -1  | 2 -1 -1  | -1 6 8
-1 8 -1  | -1 -1 -1  | -1 -1 -1
2 -1 5  | -1 -1 -1  | 4 -1 -1
- - - - - - - - - - - - -
7 -1 -1  | -1 -1 -1  | -1 -1 -1
-1 -1 -1  | 5 1 8  | -1 -1 -1
-1 1 3  | -1 -1 7  | -1 -1 -1
- - - - - - - - - - - - -
5 -1 8  | -1 -1 2  | -1 -1 -1
-1 6 -1  | -1 -1 4  | -1 7 -1
1 7 -1  | -1 3 -1  | 5 8 -1

Solved Sudoku 
3 4 1  | 2 9 5  | 7 6 8
6 8 7  | 3 4 1  | 9 2 5
2 9 5  | 7 8 6  | 4 3 1
- - - - - - - - - - - - -
7 5 9  | 4 2 3  | 8 1 6
4 2 6  | 5 1 8  | 3 9 7
8 1 3  | 9 6 7  | 2 5 4
- - - - - - - - - - - - -
5 3 8  | 1 7 2  | 6 4 9
9 6 2  | 8 5 4  | 1 7 3
1 7 4  | 6 3 9  | 5 8 2

Board created 
8 -1 -1  | -1 -1 -1  | -1 -1 -1
9 -1 -1  | -1 7 -1  | -1 -1 3
1 5 2  | 4 3 -1  | -1 -1 -1
- - - - - - - - - - - - -
-1 -1 -1  | -1 9 8  | -1 5 1
-1 9 -1  | 5 -1 -1  | 2 -1 8
4 -1 -1  | -1 -1 -1  | -1 -1 -1
- - - - - - - - - - - - -
-1 -1 -1  | 7 -1 -1  | -1 2 -1
5 -1 -1  | -1 -1 -1  | 8 -1 -1
-1 -1 4  | -1 -1 -1  | 9 3 -1

Solved Sudoku 
8 7 3  | 9 1 5  | 6 4 2
9 4 6  | 8 7 2  | 5 1 3
1 5 2  | 4 3 6  | 7 8 9
- - - - - - - - - - - - -
2 6 7  | 3 9 8  | 4 5 1
3 9 1  | 5 6 4  | 2 7 8
4 8 5  | 1 2 7  | 3 9 6
- - - - - - - - - - - - -
6 3 8  | 7 5 9  | 1 2 4
5 1 9  | 2 4 3  | 8 6 7
7 2 4  | 6 8 1  | 9 3 5

```