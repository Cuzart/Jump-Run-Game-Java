package AgChSaJo.ScoreList;

import AgChSaJo.JumpOrDie.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;




public class Scorelist {

    private static ArrayList<Player> scoreList;
    private static Logger log = LogManager.getLogger(Scorelist.class);

    public static void readScoreList(){


        try {
            String content = new String(Files.readAllBytes(Paths.get("ScoreList.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            Player[] playerArray = objectMapper.readValue(content,Player[].class);
            scoreList =  new ArrayList<Player>(Arrays.asList(playerArray));
        } catch (IOException e) {
            e.printStackTrace();
            log.error("ScoreListFile not found!");
        }


    }
    public static void saveScoreList(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("ScoreList.json"), scoreList);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Unable to create new File!");
        }
        /*try {
            final File f = new File("ScoreList.json");
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
        }catch (IOException e) {
            e.printStackTrace();
        }*/

    }
    private void writePlayerList(ArrayList<Player> ScoreList){
        /*try {
            ArrayList<Player> scoreList = addPlayer();
            Gson gson = new Gson();

            JsonElement element =
                    gson.toJsonTree(customerList , new TypeToken<List<Customer>>() {}.getType());

            JsonArray jsonArray = element.getAsJsonArray();
            FileWriter file = new FileWriter("ScoreList.json");
            file.write(players.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }


    public static void addNewScore(Player player){
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

    public static void main(String[] args) {
       readScoreList();
       addNewScore(new Player("Carles", 56));
       sortScoreList();
       saveScoreList();
       System.out.println(scoreList);
    }

}