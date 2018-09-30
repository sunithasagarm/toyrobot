Toy Robot Simulator
Description
The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5
units x 5 units.
There are no other obstructions on the table surface.
The robot is free to roam around the surface of the table, but must be prevented from
falling to destruction
Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.
Create an application that can read in commands of the following form:
PLACE X,Y,F
MOVE
LEFT
RIGHT
REPORT

Application Development Decisions
1. Spring Boot application has been chose for the following reasons
    a. Minimize the development effort and time and application framw.
    b. Make use of the IOC frame work.
    c. Framework allows us go write unit test with maximum coverage.
2. Build using Maven
3. For testing I have chosen combination of Junit and Mockito Frameworks. Junit has been used for java object testing,  and Mockito framework has been used for behviourial testing.

Application Design Decisions.

1. ToyRobot - Is the player. It needs to record the current position on the board and new position.
2. Position - Is an attribute for ToyRobot, which defines the position in terms of x and y values and Direction.
3. Direction - Enumeration of direction NORTH, SOUTH, EAST and WEST.  It also implements methods for find the a new direction when the direction changes to left or right.
4. Board - Interface which determines the valid position on the Board.  Any object implementing this interface will define the rules for validation the position on the board.
5. SquareBoard - Dimensions of the board are driven by the applicationProperties File.  It is configured to a 5 by 5 size.  Board should dictate what its valid position is there its responsibility is to validate the position.
   Number of rows and columns cannot be less than 0 and cannot me more than 4.
6. Command - Enumeration of Valid list of command that are understood by the game.
7. Game - Provides a framworke to setup the game with a valid Board and a valid Player. It validates the commands and executes them accordingly. As a result there could changes to the position of the toyRobot.
8. StartGame -  Enable console interaction to start sending the commands to the game.
9. ToyRobotApplication - Spring boot application which start the spring container and initialized it with the required beans and spawns a single thread (StartGame) to Start the Game. to start the game.  Application can be executed multile times to start other games in parallel.


Class Diagram

![Alt text](./uml/ClassDiagram.png?raw=true "Class Diagram")


Pre-requisites
1. Maven installed locally and configured to execute maven commands
2. JDK 1.8 Environment installed locally.

Build Application and run the tests
1. Download or clone the git repository locally
2. Change to toyrobot directory
3. Compile :At the command prompt 
mvn clean
mvn install
mvn package
4. Execute
java -jar target/toyrobot-0.0.1-SNAPSHOT.jar

5. Command to stop the play is 
EXIT

