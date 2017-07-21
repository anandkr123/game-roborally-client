# game-roborally-client

build tool - gradle
framework  - springframework
Processing req & res using - Postman app (RESTful Web service)

steps :- 
clone the project 
type command in terminal:- gradle build. After successful build, type command:- gradle bootRun

Major elements :-  cards, Robots, Board, Board_Fields(PIT,REBOOT,EMPTY,START etc)

Client can create game. Afterwards, some other clients can join the game through request in the form of JSON. server can send the board layout, stating description of each position of board, The client can choose which position to start and choose the robot from the available robots.Client can send the cards for the movement of the robot.Mocked responses are being generated from the server side.

Note:- Implementation done on only client side.
