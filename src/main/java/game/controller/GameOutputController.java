package game.controller;

import game.Application;
import game.exception.IllegalAccessException;
import game.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
/**
 * <h1>Game output controller</h1>
 * Client controller which contains all the
 * client-server requests
 *
 */
@RestController
public class GameOutputController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Application.URIBuilder server;

    @Autowired
    private SecretContainer container;
    private String key="Secret";
    private String g= "games/";

    /**
     * This method is used to get the list available games from the server
     * @return This returns list of games
     */
    @GetMapping("/games/list")
    public List<GameViewOutputWrapper> getGameList() {
        return restTemplate.getForEntity(server.buildURI("/games/list1"),Wrapper.class).getBody().getGames();
    }

    /**
     * This method is used to join the game with the given id
     * @param id This is the id of the game
     * @param joinGame This contains details of the joining client
     * @return String This contains the status of the request
     * @throws IllegalAccessException if there is a mismatch in the secret header value
     */
    @PostMapping("/games/{id}/join")

    public String joinGame(@PathVariable String id,@RequestBody GameJoinInputWrapper joinGame) throws IllegalAccessException {
        ResponseEntity<Void> input= restTemplate.postForEntity(server.buildURI(g+id+"/join1"),joinGame,Void.class);
        String secretHeader=input.getHeaders().containsKey(key)?input.getHeaders().getFirst(key):"";
        if(secretHeader !=null) {
            container.setSecreValue(input.getHeaders().getFirst(key));
            int status = input.getStatusCodeValue();
            switch (status) {
                case 200:
                    return "Successfully joined game";
                case 404:
                    return "Game not found";
                case 403:
                    return "Sorry , joining of the game failed";
                default:
                    return "Something went wrong";
            }
        }else {
            throw new IllegalAccessException("Secret key value not found");
        }
    }

    /**
     * This method is used to send the selected registers to the server
     * @param id This is the id of the game
     * @param register This contains list of selected registers
     * @return String This contains the status of the request
     */
    @PostMapping("/games/{id}/round/sendRegisters")
    public String sendRegisters(@PathVariable String id,@RequestBody SendRegisterInputWrapper register) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Secret", container.getSecreValue());
        HttpEntity request = new HttpEntity(register, headers);
        ResponseEntity<Void> input= restTemplate.postForEntity(server.buildURI(g+id+"/round/sendRegisters1"),register,Void.class);
        int status= input.getStatusCodeValue();
        switch (status){
            case 204 : return "Successfully sent the registers";
            case 422 :return "invalid registers! try sending again within the time limit";
            default :  return "Something went wrong";

        }
    }
    /**
     * This method is used to create a new game on the server
     * @param game This contains the details of the client
     * @return GameViewOutputWrapper This contains the details of the created game
     */
    @PostMapping("/games/create")
    public ResponseEntity<GameViewOutputWrapper> createGame(@RequestBody Game game ){
        return restTemplate.postForEntity(server.buildURI("/games/create1"), game,GameViewOutputWrapper.class);
    }

    /**
     * This method is used to Inform the server that the client left the game.
     * @param id This contains the id of the game
     * @return This contains the status of the result
     */
    @PostMapping("/games/{id}/leave")
    public ResponseEntity<Void> leaveTheGame(@PathVariable(value="id") String id) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(key,container.getSecreValue());
        HttpEntity httpEntity=new HttpEntity(httpHeaders);
        return restTemplate.postForEntity(server.buildURI("/games/"+id+"/leave1"),httpEntity,Void.class);
    }

}


