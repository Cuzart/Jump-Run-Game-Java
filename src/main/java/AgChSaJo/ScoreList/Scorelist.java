package AgChSaJo.ScoreList;

import java.io.*;

import AgChSaJo.JumpOrDie.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;




public class Scorelist {

    private static ArrayList<Player> scoreList;
    private static Logger log = LogManager.getLogger(Scorelist.class);

    public static void readScoreList(){


        try {
            JsonParser jsonParser = new JsonParser();
            BufferedReader br = new BufferedReader(new FileReader("ScoreList.json"));
            JsonElement jsonElement = jsonParser.parse(br);
            Type type = new TypeToken<ArrayList<Player>>() {}.getType();
            scoreList = new Gson().fromJson(jsonElement, type);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("ScoreListFile not found!");
        }


    }
    public static void saveScoreList(){
        try {
            final File f = new File("ScoreList.json");
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
        }catch (IOException e) {
            e.printStackTrace();
        }

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


    public void addNewScore(Player player){
        if (player.getFinalScore()<0 || player.getNickname()== null){
            throw new IllegalScoreExeption();
        }else{
            scoreList.add(player);
        }

    }
    public ArrayList<Player> getScoreList() {
        sortScoreList();
        return scoreList;
    }

    private static void sortScoreList(){
        scoreList.sort(Player::compareTo);
    }

    public static void main(String[] args) {
       readScoreList();
       System.out.println(scoreList);
    }

}