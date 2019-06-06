package AgChSaJo.ScoreList;

import java.io.*;

import AgChSaJo.JumpOrDie.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Scorelist {

    //private static ArrayList<Player> ScoreList = new ArrayList(10);

    private ArrayList readPlayerList() {
        JSONParser parser = new JSONParser();
        JSONArray sList = null;
        ArrayList<Player> ScoreList = null;
        try {
            FileReader reader = new FileReader("ScoreList.json");

            Object obj = parser.parse(reader);

            sList = (JSONArray) obj;
            ScoreList = (ArrayList<Player>) new ArrayList(sList.size());
            for (int i = 0; i < sList.size(); i++) {
                JSONObject p = (JSONObject) sList.get(i);
                String name = (String) p.get("name");
                double score = (double) p.get("score");
                Player player = new Player(name, score);
                ScoreList.add(i, player);
            }

            return ScoreList;
            //players.forEach( player -> parsePlayersObject( (JSONObject) player));


        } catch (FileNotFoundException e) {
            try {
                new File("ScoreList.json").createNewFile();
                Object obj = parser.parse(new FileReader("ScoreList.json"));

                sList = (JSONArray) obj;
                return sList;
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ParseException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ScoreList;
    }

    /*private static void parsePlayersObject(JSONObject player) {
        JSONObject playersObject = (JSONObject) player.get("player");
        String name = (String) playersObject.get("name");
        double score = (double) playersObject.get("score");
        }
    */
    private ArrayList<Player> addPlayer(){
        ArrayList<Player> ScoreList = readPlayerList();
        Player player = JumpOrDie.getPlayer();
        ScoreList.add(player);
        /*for (int i = 0; i<players.size();i++){
            JSONObject player = (JSONObject) players.get(i);
            Long score = (Long) player.get("score");

            if(score< finalScore) {
                JSONObject playerjson = new JSONObject();
                playerjson.put("name",nickname);
                playerjson.put("score",finalScore);
                players.add(i,playerjson);
            }

        }
        if (players.size()>10){
            players.remove(10);
        }
        return players;

    */
        return ScoreList;
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
            ArrayList<Player> ScoreList = addPlayer();
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

    public static void main(String[] args) {
        Scorelist scorelist = new Scorelist();
        Player p1 = new Player("Agil",1000);
        JSONArray scorelistJSONArray = scorelist.addPlayer(p1);
        scorelist.deleteExistingFile();
        scorelist.writePlayerList(scorelistJSONArray);
    }

}
