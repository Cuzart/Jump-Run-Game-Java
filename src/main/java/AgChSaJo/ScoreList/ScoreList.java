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




public class ScoreList {

    private static ArrayList<Player> scoreList;
    private static Logger log = LogManager.getLogger(ScoreList.class);

    public static void readScoreList(){

        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/resources/ScoreList.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            Player[] playerArray = objectMapper.readValue(content,Player[].class);
            scoreList =  new ArrayList<>(Arrays.asList(playerArray));
            log.debug("read ScoreList");
        } catch (IOException e) {
            //e.printStackTrace();
            log.error("ScoreListFile not found or damaged! - Creating a new one");
            scoreList = new ArrayList<>();
        }
    }
    public static void saveScoreList(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/resources/ScoreList.json"), scoreList);
            log.info("ScoreList saved");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Unable to create new File!");
        }
    }

    public static void addNewScore(Player player) throws IllegalScoreExeption{
        if (player.getFinalScore()<0 || player.getNickname()== null){
            throw new IllegalScoreExeption();
        }else{
            scoreList.add(player);
        }

    }
    public static ArrayList<Player> getScoreList() {
        sortScoreList();
        return scoreList;
    }

    private static void sortScoreList(){
        scoreList.sort(Player::compareTo);
    }

}