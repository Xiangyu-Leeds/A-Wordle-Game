package comp1721.cwk1;



import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private int win=0;
    private int all;
    private int times;
    private int gameNumber;
    private final String target;
    private final List<String> h = new ArrayList<>();
    // TODO: Implement constructor with String parameter
    Game(String filename) throws IOException {
        //The difference between today and the specified date
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse("2021-06-19",fmt);
        LocalDate now = LocalDate.now();
        gameNumber= (int) start.until(now, ChronoUnit.DAYS);
        WordList a = new WordList(filename);
        //the new construction of Wordlist
        target = a.getWord(gameNumber);
    }
    // TODO: Implement constructor with int and String parameters
    Game(int num, String filename) throws IOException {
        WordList b = new WordList(filename);
        //the new construction of Wordlist
        target = b.getWord(num);
    }
    // TODO: Implement play() method
    public void play(){
        int i = 1;
        all++;
        while (i<=6) {
            //check the times of the game
            Guess a = new Guess(i);
            System.out.print("Enter guess (" + i + "/" + "6" + "): ");
            a.readFromPlayer();
            String b = a.compareWith(target);
            h.add(b);
            System.out.println(b);
            if (a.matches(target)){
                times=i;
                win++;
                if (i==1){
                    System.out.println("Superb - Got it in one!");
                    //guess successfully once
                }
                if (2<=i&&i<=5){
                System.out.println("Well done!");}
                else {
                    System.out.println("That was a close call!\n");
                }
                break;
            }else{
             times=6;
            }
            i++;
        }

    }
    public void play1(){
        int i = 1;
        while (i<=6) {
            Guess a = new Guess(i);
            System.out.print("Enter guess (" + i + "/" + "6" + "): ");
            a.readFromPlayer();
            //test for color-blind
            int b = a.compareWith2(target);
            if (b==1){
                break;
            }
            i++;
        }
    }
    public void history() {
        FileWriter fw = null;
        try {
            //Save the result of each entry into history.txt
            File f=new File("build/history.txt");
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert fw != null;
        PrintWriter pw = new PrintWriter(fw);
        pw.println(gameNumber);
        if (win==all){
            //check if guess it successfully
            pw.println("successfully!!!");
        }else {
            pw.println("fail");
        }
        pw.println(times);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void present() throws IOException {
        int i=0;
        int dd=0;
        List<Integer> ab = new ArrayList<>();
        FileReader reader = new FileReader("build/history.txt");
        BufferedReader br = new BufferedReader(reader);
        String line1;
        double mm=0;
        while ((line1 = br.readLine()) != null) {
            i++;
            if (line1.equals("successfully!!!")){
                dd++;
                mm++;
                ab.add(dd);
            }
            else if (line1.equals("fail")){
                dd=0;
                ab.add(dd);
            }
        }
        int t = i/3;
        //the times of the game
        double ss = mm/t;
        //the percentage
        System.out.println("Number of games played:"+t);
        DecimalFormat df = new DecimalFormat("0.00%");
        System.out.println("Percentage of games that were wins:"+df.format(ss));
        System.out.println("Length of the current winning streak:"+dd);
        System.out.println("Longest winning streak:"+Collections.max(ab));

    }


    // TODO: Implement save() method, with a String parameter
    public void save(String filename) throws IOException {
        PrintWriter p = new PrintWriter(new FileWriter(filename)) ;
        int i = 0;
        while (i<h.size()){
            p.println(h.get(i));
            //save it into lastname.txt
            i++;
        }
        p.flush();
        p.close();
    }
}
