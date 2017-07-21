package game.controller;

import game.Application;
import game.entity.*;
import game.exception.IllegalAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>Game input controller</h1>
 * Client controller which contains all the
 * server-client requests
 */
@RestController
public class GameInputController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Application.URIBuilder server;

    @Autowired
    private SecretContainer container;

    private String s="Secret doesn't match";
    /**
     * This method receives the actions of the activation phase from the server
     * @param input This contains the order of the robot actions in a particular round
     * @param secret This contains the secret key in he header for communication
     * @return status of the equest
     * @throws IllegalAccessException if there is a mismatch in the secret header value
     */
    @PostMapping("/games/{id}/round/actions")
    public ResponseEntity<Void> roundAction( @RequestBody RoundActionInputWrapper input, @RequestHeader(value = "Secret") String secret)throws IllegalAccessException{
        if (secret.equals(container.getSecreValue())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new IllegalAccessException(s);
        }
     }

    /**
     * Inform all clients, that the game starts.It sends the board layout of the game.
     * @param boardLayout This is the board layout of the game
     * @param secret This contains the secret key in he header for communication
     * @return Selected robot and position
     * @throws IllegalAccessException if there is a mismatch in the secret header value
     */
    @PostMapping(value= "/games/{id}/start")
    public RobotPositionClientRespond startGame(@RequestBody BoardLayout boardLayout,@RequestHeader(value="Secret") String secret) throws IllegalAccessException {
        RobotPositionClientRespond robotPositionClientRespond = new RobotPositionClientRespond();
        if(secret.equals(container.getSecreValue()))
        {
            AvailableStartingPositions availableStartingPositions = boardLayout.getAvailableStartingPositions()[0];
            Position position = new Position();
            position.setX(availableStartingPositions.getX());
            position.setY(availableStartingPositions.getY());
            robotPositionClientRespond.setRobot(boardLayout.getAvailableRobots()[0]);
            robotPositionClientRespond.setPosition(position);
            return robotPositionClientRespond;
        }
        else{
            throw new IllegalAccessException(s);
        }
    }

    /**
     * Inform all clients, that the next round is about to start.
     * @param player This is the current board state and drawpile
     * @param secret This contains the secret key in he header for communication
     * @return status of the request
     * @throws IllegalAccessException if there is a mismatch in the secret header value
     */
    @PostMapping(value="/games/{id}/round/start",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> startRound( @RequestBody Player player,@RequestHeader(value="Secret") String secret)throws IllegalAccessException
    {
        if(secret.equals(container.getSecreValue())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            throw new IllegalAccessException(s);
        }

    }

    /**
     * Informs all clients, that the all the rounds are over now.
     * @param secret This contains the secret key in he header for communication
     * @return status of the request
     * @throws IllegalAccessException if there is a mismatch in the secret header value
     */
    @PostMapping(value="/games/{id}/round/ends",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus>endRound(@RequestHeader(value="Secret") String secret)throws IllegalAccessException
    {
        if(secret.equals(container.getSecreValue())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            throw new IllegalAccessException(s);
        }
    }

    /**
     * Server sends this timelimit warning if either a client has finished
     * programming the registers for this round or the server decides, that
     * it is time to finish the current round for some other reason.
     * @param timeLimitWarning Contains the details about the time limit
     * @param secret This contains the secret key in he header for communication
     * @return status of the request
     * @throws IllegalAccessException if there is a mismatch in the secret header value
     */
    @PostMapping(value = "/games/{id}/round/timeLimitWarning",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> timeLimit( @RequestBody TimeLimitWarning timeLimitWarning,@RequestHeader(value="Secret") String secret)throws IllegalAccessException
    {
        if(secret.equals(container.getSecreValue())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            throw new IllegalAccessException(s);
        }
    }

    /**
     * Informs all clients that the game has ended and why it ended.
     * @param reason This contains the reason for ending the game
     * @param secret This contains the secret key in the header for communication
     * @return status of the request
     * @throws IllegalAccessException if there is a mismatch in the secret header value
     */
    @PostMapping(value = "/games/{id}/end")
    public ResponseEntity<HttpStatus> endGame(@RequestBody String reason,@RequestHeader(value="secret") String secret)throws IllegalAccessException
    {
        if(secret.equals(container.getSecreValue())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            throw new IllegalAccessException(s);
        }
    }
}


