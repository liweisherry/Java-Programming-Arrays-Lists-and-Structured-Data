
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher {
        public String encrypt(String input, int key){
            StringBuilder encrypted = new StringBuilder(input);
            String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String alphabetsmall = "abcdefghijklmnopqrstuvwxyz";
            String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
            System.out.println(shiftedAlphabet);
            String shiftedAlphabetsmall = alphabetsmall.substring(key) + alphabetsmall.substring(0,key);
            for (int i = 0; i < encrypted.length(); i++){
                char currChar = encrypted.charAt(i);
                int idx =0;
                if(Character.toLowerCase(currChar) == currChar){
                     idx = alphabetsmall.indexOf(currChar);
                    if (idx != -1){
                        char newChar = shiftedAlphabetsmall.charAt(idx);
                        encrypted.setCharAt(i,newChar);
                    }
                }
                else{
                     idx = alphabet.indexOf(currChar);
                    if (idx != -1){
                        char newChar = shiftedAlphabet.charAt(idx);
                        encrypted.setCharAt(i,newChar);
                    }
                }
            }
            return encrypted.toString();
        }

        public void testEncrypt(){

            String encrypted = encrypt("First Legion", 23);
            System.out.println(  encrypted);
            encrypted = encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", 15);
            System.out.println(  encrypted);
        }

        public String encryptTwoKeys(String input, int key1, int key2){
            StringBuilder encrypted = new StringBuilder(input);
            String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String alphabetsmall = "abcdefghijklmnopqrstuvwxyz";
            String shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0,key1);
             
            String shiftedAlphabetsmall = alphabetsmall.substring(key1) + alphabetsmall.substring(0,key1);
          
            String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
            
            String shiftedAlphabet2small = alphabetsmall.substring(key2) + alphabetsmall.substring(0,key2);
         
            for (int i = 0; i < encrypted.length(); i++){
                char currChar = encrypted.charAt(i);
                int idxLower =  alphabetsmall.indexOf(currChar);
                int idxUpper = alphabet.indexOf(currChar);
           
                if (idxUpper != -1) {
                    
                    if (i % 2 == 1) {
                       encrypted.setCharAt(i,shiftedAlphabet2.charAt(idxUpper));
                    } else {
                        encrypted.setCharAt(i,shiftedAlphabet.charAt(idxUpper));
                    }
                 
                }
                if (idxLower != -1) {

                    if (i % 2 == 1) {
                       encrypted.setCharAt(i,shiftedAlphabet2small.charAt(idxLower));
                    } else {
                        encrypted.setCharAt(i,shiftedAlphabetsmall.charAt(idxLower));

                    }
                  
                }
                  
                 }

            return encrypted.toString();
            }

            public void testEncryptTwoKeys(){
                String encrypted = encryptTwoKeys("First Legion", 23,17);
                System.out.println(encrypted);
                encrypted = encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21,8);
                System.out.println(  encrypted);
            }
}
