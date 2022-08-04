// Main program for COMP1721 Coursework 1
// DO NOT CHANGE THIS!
package comp1721.cwk1;


import java.io.IOException;
import java.util.Objects;


public class Wordle {
  public static void main(String[] args) throws IOException {
    Game game;
    Game game1;
    // New color-blind option
    if (args.length > 0 && Objects.equals(args[0], "-a")) {
      game1 = new Game("data/words.txt");
      game1.play1();
    }
    else if (args.length > 0) {
      // Player wants to specify the game
      game = new Game(Integer.parseInt(args[0]), "data/words.txt");
      game.play();
      game.save("build/lastgame.txt");
          game.history();
          game.present();
    }

    else {
      // Play today's game
      game = new Game("data/words.txt");
      game.play();
      game.save("build/lastgame.txt");
    game.history();
    //save it in history.txt
    game.present();
    //present the outcome

    }

  }
}
