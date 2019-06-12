package AgChSaJo.ScoreList;

import java.io.*;

import AgChSaJo.JumpOrDie.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import com.google.gson.Gson;




public class Scorelist {

    private ArrayList<Player> scoreList;

    public static void readFile(){

        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        try {
            BufferedReader br = new BufferedReader(new FileReader("ScoreList.json"));
            JsonElement jsonElement = jsonParser.parse(br);

        //Create generic type
            Type type = new TypeToken<ArrayList<Player>>() {}.getType();
            scoreList = gson.fromJson(jsonElement, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

    //return ScoreList;
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
        try {
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
        }

    }
    public ArrayList<Player> getScoreList() {
        return scoreList;
    }

    /*public static void main(String[] args) {
        Scorelist scorelist = new Scorelist();
        Player p1 = new Player("Agil",1000);
        JSONArray scorelistJSONArray = scorelist.addPlayer(p1);
        scorelist.deleteExistingFile();
        scorelist.writePlayerList(scorelistJSONArray);
    }*/

}