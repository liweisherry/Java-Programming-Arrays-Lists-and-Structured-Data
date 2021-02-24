
/**
 * Write a description of CaesarCipher2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher2 {
    private String alphabat;
    private String shiftedAlphabet;
    private int mainkey;
    public CaesarCipher2(int key){
        alphabat = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabat.substring(key)+alphabat.substring(0,key);
    }

    public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        for ( int i = 0; i <sb.length(); i++){
            char c = sb.charAt(i);
            int idx = alphabat.indexOf(c);
            if(idx!= 1){
                c = shiftedAlphabet.charAt(idx);
                sb.setCharAt(i,c);
            }
        }
        return sb.toString();
    }

    public String decrypt(String input){

        CaesarCipher2 cc = new CaesarCipher2(26-mainkey);

        return cc.encrypt(input
        );
    }
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
        String encrypted = encrypt(input);

        System.out.println(decrypt(encrypted));
        System.out.println(breakCaesarCipher(input));
    }
    public int getKey (String s){
        int[] vals = countLetters(s);
        int maxDex = maxIndex(vals);
        int dkey = maxDex-4;
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }
    public String breakCaesarCipher(String input){

        int key = getKey(input);
        CaesarCipher2  cc = new CaesarCipher2(key);
        String encrypted = encrypt(input);
        return decrypt(encrypted);
    }


}
