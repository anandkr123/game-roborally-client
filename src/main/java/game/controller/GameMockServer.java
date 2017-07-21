package game.controller;

import game.entity.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.*;
/**
 * <h1>Mock Server</h1>
 * Responds for all the requests from the client
 */

@Controller
public class GameMockServer {

    /**
     * This method returns mock response for get gamelist service
     * @return list of games
     */
    @RequestMapping(value="/games/list1", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Wrapper> greeting(){
        Wrapper wrapper=new Wrapper();
        wrapper.setGames(Arrays.asList(new GameViewOutputWrapper("1", "Tom's game", 6, 4), new GameViewOutputWrapper("2","john",6,2)));
        return ResponseEntity.ok(wrapper);
    }

    /**
     * This method returns mock response for get join game service
     * @return status
     */
    @PostMapping("/games/{id}/join1")
    public ResponseEntity<Void> joinGameServer(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Secret", "secretValue");
        return new ResponseEntity<>(headers,HttpStatus.valueOf(200));
    }

    /**
     * This method returns mock response for send register service
     * @return status
     */
    @PostMapping("/games/{id}/round/sendRegisters1")
    public ResponseEntity<Void> sendRegisterServer(@RequestBody SendRegisterInputWrapper register) {
        HttpHeaders headers = new HttpHeaders();
        Cards reg[] = register.getRegisters();

        if (reg.length == 5)
            return new ResponseEntity<>(headers, HttpStatus.valueOf(204));
        else
            return new ResponseEntity<>(headers, HttpStatus.valueOf(422));

    }
    /**
     * This method returns mock response for creat game service
     * @param game contains details about the game
     * @return details of the created game
     */
    @PostMapping("/games/create1")
    public ResponseEntity<GameViewOutputWrapper> newGame(@RequestBody Game game) {
        GameViewOutputWrapper gameViewOutputWrapper=new GameViewOutputWrapper();
        gameViewOutputWrapper.setId("ANCDEFR");
        gameViewOutputWrapper.setMaxRobotCount(game.getMaxRobotCount()+3);
        gameViewOutputWrapper.setCurrentRobotCount(0);
        gameViewOutputWrapper.setName(game.getName());
        return new ResponseEntity<>(gameViewOutputWrapper,HttpStatus.OK);
    }

    /**
     * This method returns mock response for leave game service
     * @return status
     */
    @PostMapping("/games/{id}/leave1")
    public ResponseEntity<Void> clientLeaveGame() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
