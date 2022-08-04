package comp1721.cwk1;

import java.util.Scanner;


public class Guess {
    // Use this to get player input in readFromPlayer()
    private final int guessNumber;
    private String chosenWord;
    private static final Scanner INPUT = new Scanner(System.in);

    // TODO: Implement constructor with int parameter
    Guess(int num) {
        if (1<=num&&num<=6){
        guessNumber = num;}
        //make sure that it is in the allowed range of 1–6
        else {
            throw new GameException("invalid num");
        }
    }

    // TODO: Implement constructor with int and String parameters
    Guess(int num, String word) {
        int i=0;
        while (i<word.length()){
            if ('a'<=word.charAt(i)&&word.charAt(i)<='z'){
                i++;
                //make sure it is from 'a' to 'z'
            }
            else {
                break;
            }
        }
        if (i==5)
        {
            guessNumber = num;
            //make sure the length of it equals to 5;
            chosenWord = word;
            chosenWord=chosenWord.toUpperCase();
        }
        else {
            throw new GameException("invalid word");
        }
    }

    // TODO: Implement getGuessNumber(), returning an int
    public int getGuessNumber() {
        return guessNumber;
        //return guess-number
    }

    // TODO: Implement getChosenWord(), returning a String

    public String getChosenWord() {
        return chosenWord;
        //return chosen
    }

    // TODO: Implement readFromPlayer()
    public void readFromPlayer() {
        chosenWord = INPUT.nextLine();
        //users input chosen-word
        if (chosenWord.length()>5){
            System.out.println("please input again");
            chosenWord = INPUT.nextLine();
            //users input chosen-word
        }
    }

    // TODO: Implement compareWith(), giving it a String parameter and String return type
    public String compareWith(String target) {
        int m = 0;
        chosenWord = chosenWord.toUpperCase();
        //Convert it to uppercase
        char[] target0 = target.toCharArray();
        char[] chosenWord0 = chosenWord.toCharArray();
        StringBuilder s = new StringBuilder();
        int x = 1;
        int t =0;
        int y ;
        int ww=1;
        int nn;
        while (m < 5) {
            if (target0[m] != chosenWord0[m]) {
                while (x <5) {
                    if ((m+x<5&&target0[m+x] ==
                            chosenWord0[m])||(m-x>=0&&target0[m-x] == chosenWord0[m])){
                        y=m;
                        //Check if it exists but not in the right place
                        nn=m;
                        while (ww<=m){
                            if (chosenWord0[y] != chosenWord0[y - ww]) {
                                ww++;
                                nn--;
                            }else {
                                break;
                            }
                        }
                        if (nn==0) {
                            //it exists but not in the right place
                            s.append("\033[30;103m ").append(chosenWord0[m]).append(" \033[0m");
                        }
                        else {
                            //it exists but not in the right place and 'you ve seen it before
                            s.append("\033[30;107m ").append(chosenWord0[m]).append(" \033[0m");
                        }
                        t = x;
                        break;
                    }
                    x++;
                }
                if (t==0) {
                    //it doesn't exist
                    s.append("\033[30;107m ").append(chosenWord0[m]).append(" \033[0m");
                }
            }
            if (target0[m] == chosenWord0[m]) {
                //it exists and in the proper position
                s.append("\033[30;102m ").append(chosenWord0[m]).append(" \033[0m");
            }
                    ww=1;
                    t=0;
                    x=1;
                    m++;
                }
        return s.toString();
            }

     public String trans(char a){
        //convert number to ordinal numeral
        if (a=='0'){
            return "1st";
        }
         if (a=='1'){
             return "2nd";
         }
         if (a=='2'){
             return "3rd";
         }
         if (a=='3'){
             return "4th";
         }
         if (a=='4'){
             return "5th";
         }
        else {
            return null;
         }
     }

    public int compareWith2(String target) {
        //color-bling test
        int m = 0;
        chosenWord = chosenWord.toUpperCase();
        char[] target0 = target.toCharArray();
        char[] chosenWord0 = chosenWord.toCharArray();
        System.out.println(target);
        int x = 1;
        int y;
        int ww = 1;
        int nn;
        StringBuilder p = new StringBuilder(5);
        StringBuilder s = new StringBuilder(5);
        while (m < 5) {

            if (target0[m] != chosenWord0[m]) {
                while (x < 5) {
                    if (m + x < 5
                            && target0[m + x] == chosenWord0[m] || m - x >= 0 && target0[m - x]
                            == chosenWord0[m]) {
                        y = m;
                        nn = m;
                        while (ww <= m) {
                            if (chosenWord0[y] != chosenWord0[y - ww]) {
                                ww++;
                                nn--;
                            } else {
                                break;
                            }
                        }
                        if (nn == 0) {
                            s.append(m);
                        }
                        break;
                    }
                    x++;
                }

            }
            if (target0[m] == chosenWord0[m]) {
                p.append(m);
            }
            ww = 1;
            x = 1;
            m++;
        }
            int xx = 0;
            int pp = 0;
            if (p.length() == 5) {
                System.out.println("You won!");
                //successfully
                return 1;
            }
            else {
                if (s.length() > 2) {
                    while (xx < (s.length() - 2) && s.length() > 1) {
                        System.out.print(trans(s.charAt(xx)) + ", ");
                        xx++;
                    }
                    System.out.print(trans(s.charAt(xx)) + " ");
                    xx++;
                    if (p.length() == 0) {
                        System.out.println("and " +
                                trans(s.charAt(xx)) + " correct but in wrong place");
                    } else {
                        System.out.print("and " +
                                trans(s.charAt(xx)) + " correct but in wrong place");
                    }
                }
                else if (s.length() == 2) {
                    if (p.length() == 0) {
                        System.out.println(trans(s.charAt(0)) +
                                " and "+trans(s.charAt(1)) +" correct but in wrong place");
                    } else {
                        System.out.print(trans(s.charAt(0)) +
                                " and "+trans(s.charAt(1)) +" correct but in wrong place");
                    }
                }
                else if (s.length() == 1) {
                    if (p.length() == 0) {
                        System.out.println(trans(s.charAt(xx)) + " correct but in wrong place");
                    } else {
                        System.out.print(trans(s.charAt(xx)) + " correct but in wrong place");
                    }

                }
                if (p.length() > 2) {
                    if (s.length() > 0) {
                        System.out.print(", ");
                    }
                    while (pp < p.length() - 2 && p.length() > 1) {

                        System.out.print(trans(p.charAt(pp)) + ", ");
                        pp++;
                    }
                    System.out.print(trans(p.charAt(pp)) + " ");
                    pp++;
                    System.out.println("and " + trans(p.charAt(pp)) + " perfect");
                }
                else if (p.length() == 2) {
                    if (s.length() > 0) {
                        System.out.print(", ");
                    }
                    System.out.println(trans(p.charAt(0)) + " and "+trans(p.charAt(1)) +" perfect");
                }
                else if (p.length() == 1) {
                    if (s.length() > 0) {
                        System.out.print(", ");
                    }
                    System.out.println(trans(p.charAt(pp)) + " perfect");
                }
                return 0;
            }


    }
    // TODO: Implement matches(), giving it a String parameter and boolean return type
    public boolean matches(String target) {
        //the comparison of target and chosen
        return target.equalsIgnoreCase(chosenWord);
    }
}

