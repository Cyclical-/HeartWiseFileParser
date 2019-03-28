import java.util.ArrayList;
import java.util.Scanner;


public class Parser {

    public int[][] beats;
    public int length;
    private Scanner input;
    private ArrayList<Integer> timeStamps;
    private int offset;
    private int runTime;



    public Parser(String path, int startOffset){
        this.input = new Scanner(path);
        this.offset = startOffset;
        this.timeStamps = new ArrayList<>();
        this.parse();

    }


    private void parse(){
        if (input.hasNext()){
            this.length = input.nextInt();
            this.beats = new int[2][this.length];
            for (int i = 0; i < this.length; i++){
                if (input.hasNextLine()){
                    this.beats[0][i] = input.nextInt();
                    this.beats[1][i] = input.nextInt();
                }
            }
        }
        int currentTime = this.offset;
        for (int i = 0; i < this.length; i++){
            for (int beatNum = 0; beatNum < this.beats[0][i]; beatNum++){
                this.timeStamps.add(currentTime);
                currentTime += this.beats[1][i];
            }
        }
        this.runTime = currentTime;
    }

    public ArrayList<Integer> getTimeStamps(){
        return this.timeStamps;
    }

    public int getRunTime() {
        return runTime;
    }


}

