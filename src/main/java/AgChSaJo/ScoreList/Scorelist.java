package AgChSaJo.ScoreList;

import java.io.*;

import AgChSaJo.JumpOrDie.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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
    static Gson gson = new Gson();
    static JsonParser jsonParser = new JsonParser();

    public static void readFile(){


        try {
            BufferedReader br = new BufferedReader(new FileReader("ScoreList.json"));
            JsonElement jsonElement = jsonParser.parse(br);
            Type type = new TypeToken<ArrayList<Player>>() {}.getType();
            scoreList = gson.fromJson(jsonElement, type);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("ScoreListFile not found!");
        }


    }

    public void addPlayer(Player player){
        scoreList.add(player);
    }

    public void saveScoreList(){
        deleteExistingFile();



    }
    private void deleteExistingFile(){
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

    public ArrayList<Player> getScoreList() {
        return scoreList;
    }

    public static void main(String[] args) {
       readFile();
       System.out.println(scoreList);
    }

}