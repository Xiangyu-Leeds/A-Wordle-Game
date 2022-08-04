package comp1721.cwk1;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WordList {
    private final List<String> words = new ArrayList<>();
     // TODO: Implement constructor with a String parameter
     WordList(String filename) throws IOException {
            FileReader reader = new FileReader(filename);
            //load words.txt in to the program
            BufferedReader br = new BufferedReader(reader);
            String line1;
            while ((line1 = br.readLine()) != null) {
                    words.add(line1);
                }
            }


    // TODO: Implement size() method, returning an int

    public int size(){
        return words.size();
    }
    // TODO: Implement getWord() with an int parameter, returning a String
    public String getWord(int n){
         if (n<0||n>=words.size()){
             throw new GameException("Invalid number!");}
         //make sure if the value of this parameter is invalid
         else {
             return words.get(n);
         }
    }
}
