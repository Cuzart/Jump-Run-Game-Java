package AgChSaJo.ScoreList;

import java.io.*;

import AgChSaJo.JumpOrDie.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;

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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
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
            double score = (double) player.get("score");

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
    /*private void deleteExistingFile(){
            try {
                File f = new File("ScoreList.json");
                if (f.exists()) {
                    f.delete("ScoreList.json"); //you might want to check if delete was successfull
                }
                f.createNewFile("ScoreList.json");
            }catch (IOException e) {
                e.printStackTrace();
            }
    }*/
    private void writePlayerList(JSONArray players){
        try {
            FileWriter file = new FileWriter("ScoreList.json");
            file.write(players.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*double finalScore = 0;
    String finalScores = null;
    String nickname = null;
    ArrayList<Player> = null;
    public void createEntry() { //writes the new score in the file ScoreList.txt if the finalScore is bigger than the ones in the file or the file has less than 20 scores
        try {

            if () {
                public Player player = new Player();
                finalScore = player.getFinalScore();
                finalScores = Double.toString(finalScore);
                nickname = player.getNickname();
                FileWriter fw = new FileWriter("ScoreList.txt");
                fw.write(nickname + " : " + finalScores);
                fw.close();
            } else if (finalScore > LowerScore()) {

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private int CountLines(){ //count the lines in ScoreList.txt to see how many scores are saved on it
        int numberOfLines = 0;

        try {
            BufferedReader br = new BufferedReader("ScoreList.txt");
            String thisLine;
            while ((thisLine = br.readLine()) != null) {
                numberOfLines ++;
            }
            return numberOfLines;
        } catch(Exception e) {
                e.printStackTrace();
        }
    }
    public void ScoreLists(){ //convert the file into two lists one for the nicknames and one for the scores
        String inputFileName = "ScoreList.txt";
        File inputFile = new File(inputFileName);
        HashMap<String,double> sL = new HashMap<String, double>();
        //List<String> nicknames= null;
        //List<Double> values=new ArrayList<>();
        try{
            Scanner sc = new Scanner(inputFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String [] parts = line.split(" : ");
                sL.put(parts[0], Double.parseDouble(parts[1]));
                //nicknames.add(parts[0]);
                //values.add(Double.parseDouble(parts[1]));

            }
            return nicknames;
            return values;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    void getLowerScore() {

    }


    void readFile(){
        Scanner s = new Scanner(new File("ScoreList.txt"));
        ArrayList<String> scores = new ArrayList<String>();
        while (s.hasNext()){
            scores.add(s.next());
        }
        s.close();

    } */
    public static void main(String[] args) {
        Scorelist scorelist = new Scorelist();
        Player p1 = new Player("Agil",1000);
        JSONArray scorelistJSONArray = scorelist.addPlayer(p1);
        scorelist.writePlayerList(scorelistJSONArray);
    }

}
