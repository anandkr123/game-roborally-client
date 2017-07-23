# game-roborally-client

Prerequisites 

1)IntelliJ idea

2)build tool - gradle

3)framework  - springframework

4)Processing req & res using - Postman app (RESTful Web service)

Steps :-

1)clone the project in your local disk

2)type command in terminal:- gradle build. After successful build, type command:- gradle bootRun

3)process requests through postman app !

Major elements :-  Cards, Robots, Board, Board_Fields(PIT,REBOOT,EMPTY,START etc)

Client can create game. Afterwards, some other clients can join the game through request in the form of JSON. server can send the board layout, stating description of each position of board, The client can choose which position to start and choose the robot from the available robots.Client can send the cards for the movement of the robot.Mocked responses are being generated from the server side.

Note:- Implementation done on only client side.
