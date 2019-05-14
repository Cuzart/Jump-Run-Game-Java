package AgChSaJo.ScoreList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import AgChSaJo.JumpOrDie.*;

/*public class Scorelist {
    double finalScore = 0;
    String finalScores = null;
    String nickname = null;
    public void createEntry() { //writes the new score in the file ScoreList.txt if the finalScore is bigger than the ones in the file or the file has less than 20 scores
        try {
            int lines = CountLines();
            if (lines < 20) {
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


    /*void readFile(){
        Scanner s = new Scanner(new File("ScoreList.txt"));
        ArrayList<String> scores = new ArrayList<String>();
        while (s.hasNext()){
            scores.add(s.next());
        }
        s.close();

    }
}*/
