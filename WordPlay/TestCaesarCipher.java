
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class TestCaesarCipher {
    public int[] countLetters(String encrypted){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < encrypted.length(); k++){
            char ch = Character.toLowerCase(encrypted.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }

    public int maxIndex(int[] vals){
        int maxDex = 0;
        int maxLength = 0;
        for (int k = 0; k <vals.length; k++){
            if (vals[k] > maxLength){
                maxDex = k;
                maxLength = vals[k];
            }
        }
        return maxDex;
    }


    public void simpleTests(){
        FileResource fr = new FileResource();
        String input = fr.asString();
        CaesarCipher2  cc = new CaesarCipher2(18);
        System.out.println();
    }
}
