package game.controller;

import game.entity.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.ExpectedCount.manyTimes;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@WebMvcTest(controllers = {GameOutputController.class})
@RunWith(SpringRunner.class)
public class GameOutputControllerTest {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GameOutputController controller;

    MockRestServiceServer mockRestServiceServer;
    @Before
    public void setUp() {
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void getGameList() throws Exception {

        String responseBody="{\"games\":[{\"id\": \"haam\",\"name\":\"hi\",\"maxRobotCount\":6,\"currentRobotCount\":1}]}";
        mockRestServiceServer.expect(manyTimes(),
                requestTo("http://localhost:8080/games/list1"))
                .andExpect(method(GET))
                .andRespond(withSuccess(responseBody,APPLICATION_JSON));
        List<GameViewOutputWrapper> input= controller.getGameList();
        assertEquals("haam",input.get(0).getId());
        mockRestServiceServer.verify();

    }

    @Test
    public void joinGame() throws Exception {
        mockRestServiceServer.expect(
                requestTo("http://localhost:8080/games/1/join1"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.valueOf(200)));
        String input= controller.joinGame("1",new GameJoinInputWrapper("mike","http://10.1.11.101:8080/rest/"));
        assertEquals("Successfully joined game",input);
        mockRestServiceServer.verify();
    }

    @Test
    public void sendRegister() throws Exception {
        mockRestServiceServer.expect(
                requestTo("http://localhost:8080/games/1/round/sendRegisters1"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.valueOf(204)));
        String input=controller.sendRegisters("1",new SendRegisterInputWrapper(Arrays.asList("MOVE1","MOVE2","UTURN")));
        assertEquals("Successfully sent the registers",input);
        mockRestServiceServer.verify();
    }

    @Test
    public void createGame() throws Exception {
        String responseBody="{\"id\": \"11\",\"name\":\"max\",\"maxRobotCount\":6,\"currentRobotCount\":1}";
        mockRestServiceServer.expect(
                requestTo("http://localhost:8080/games/create1"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess(responseBody,APPLICATION_JSON));
        Game game=new Game();
        game.setName("max");
        game.setMaxRobotCount(3);
        ResponseEntity<GameViewOutputWrapper> output= controller.createGame(game);
        assertEquals("max",output.getBody().getName());
        assertEquals("11",output.getBody().getId());
        assertEquals(6,output.getBody().getMaxRobotCount());
        assertEquals(1,output.getBody().getCurrentRobotCount());
    }

    @Test
    public void leaveTheGame() throws Exception {
        mockRestServiceServer.expect(
                requestTo("http://localhost:8080/games/1/leave1"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.valueOf(204)));
        ResponseEntity<Void> output = controller.leaveTheGame("1");
        assertEquals(204,output.getStatusCodeValue());
        mockRestServiceServer.verify();
    }


}