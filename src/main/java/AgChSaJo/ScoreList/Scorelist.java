package AgChSaJo.ScoreList;

import java.io.*;

import AgChSaJo.JumpOrDie.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.IOException;

public class Scorelist {

    private JSONArray readPlayerList() {
        JSONParser parser = new JSONParser();
        JSONArray players=null;
        try {
            FileReader reader =new FileReader("ScoreList.json");

            Object obj = parser.parse(reader);

            players = (JSONArray) obj;
            //players.forEach( player -> parsePlayersObject( (JSONObject) player));


        }
        catch (FileNotFoundException e) {
            try {
                new File("ScoreList.json").createNewFile();
                Object obj = parser.parse(new FileReader("ScoreList.json"));

                players = (JSONArray) obj;
                return players;
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ParseException e1) {
                e1.printStackTrace();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return players;
    }

    private static void parsePlayersObject(JSONObject player) {
        JSONObject playersObject = (JSONObject) player.get("player");
        String name = (String) playersObject.get("name");
        double score = (double) playersObject.get("score");


    }
    private JSONArray addPlayer(Player p){
        JSONArray players = readPlayerList();
        double finalScore = p.getFinalScore();
        String nickname = p.getNickname();
        for (int i = 0; i<players.size();i++){
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


    }
    private void deleteExistingFile(){
            try {
                final File f = new File("AgChSaJo/ScoreList/ScoreList.json");
                if (f.exists()) {
                    f.delete();
                }
                f.createNewFile();
            }catch (IOException e) {
                e.printStackTrace();
            }
    }
    private void writePlayerList(JSONArray players){
        try {
            FileWriter file = new FileWriter("AgChSaJo/ScoreList/ScoreList.json");
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
