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
        try (FileReader reader =new FileReader("ScoreList.json")){

            Object obj = parser.parse(reader);

            JSONArray players = (JSONArray) obj;
            players.forEach( player -> parsePlayersObject( (JSONObject) player));

            return players;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void parsePlayersObject(JSONObject player) {
        JSONObject playersObject = (JSONObject) player.get("player");
        String name = (String) playersObject.get("name");
        double score = (double) playersObject.get("score");


    }
    private JSONArray addPlayer(){
        JSONArray players = readPlayerList();
        JSONObject player = parsePlayersObject();
        Player p = new Player();
        double finalScore = p.getFinalScore();
        String nickname = p.getNickname();
        int place= 0;
        for (int i = 0; i<players.size();i++){

            double score = players.get("score");

            if(score< finalScore) {
                break;
            }else{
                place++;
            }

        }
        if (place<10){
            JSONObject player = new JSONObject();

            players.getJsonArray(place).put;
            players[11].delete();
        }
        return players;


    }
    private void deleteExistingFile(){
            try(File f = new File("ScoreList.json")) {

                if (f.exists()) {
                    f.delete("ScoreList.json"); //you might want to check if delete was successfull
                }
                f.createNewFile("ScoreList.json");
            }catch (IOException e) {
                e.printStackTrace();
            }
    }
    private void writePlayerList(){
        JSONArray players = addPlayer();
        try (FileWriter file = new FileWriter("ScoreList.json")) {
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
        Scorelist a = new Scorelist();
        readPlayerList();
        addPlayer();
        deleteExistingFile();
        writePlayerList();
    }

}
