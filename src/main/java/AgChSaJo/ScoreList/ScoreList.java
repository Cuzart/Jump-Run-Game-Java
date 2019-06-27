package AgChSaJo.ScoreList;

import AgChSaJo.JumpOrDie.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ScoreList{

    private static Logger log = LogManager.getLogger(ScoreList.class);

    private List<Player> scoreList;


    /**
     * converts the ScoreList.json file into an ArrayList
     */
    public void readScoreList(){
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/resources/ScoreList.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            Player[] playerArray = objectMapper.readValue(content,Player[].class);
            scoreList =  new ArrayList<>(Arrays.asList(playerArray));
            log.debug("read ScoreList");
        } catch (IOException e) {
            log.error("ScoreListFile not found or damaged!");
            createNewScoreList();
        }
    }

    /**
     * saves the ScoreList (ArrayList) into a json file
     * so that the scoreList survive across multiple processes
     */
    public void saveScoreList(){
        sortScoreList();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/resources/ScoreList.json"), scoreList);
            log.info("ScoreList saved");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Unable to create new File!");
        }
    }

    /**
     * Saves a new Player with his score to the list
     * In case the user does not type a nickname a IllegalScoreException
     * gets thrown. A Score entry needs a valid score and a corresponding nickname
     *
     * @param player which gets added to the ScoreList
     * @throws IllegalScoreException invalid score or nickname
     */
    public void addNewScore(Player player) throws IllegalScoreException {
        if (player.getFinalScore()<0 || player.getNickname().equals("")){
            throw new IllegalScoreException();
        }else{
            scoreList.add(player);
        }
    }

    public ArrayList<Player> getScoreList() {
        List<Player> list;
        list = scoreList.parallelStream().sorted(Player::compareTo).collect(Collectors.toList());
        return new ArrayList<>(list);
    }
    public ArrayList<Player> getScoreList(final String search) {
        List<Player> list;
        list = scoreList.parallelStream().filter(p -> p.getNickname().equals(search)).sorted(Player::compareTo).collect(Collectors.toList());
        return new ArrayList<>(list);
    }

    private void sortScoreList(){
        scoreList.sort(Player::compareTo);
    }

    void createNewScoreList(){
        scoreList = new ArrayList<>();
        log.info("Creating a new ScoreList!");
    }

}