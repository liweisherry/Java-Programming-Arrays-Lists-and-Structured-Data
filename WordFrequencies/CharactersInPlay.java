import java.util.ArrayList;

/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CharactersInPlay {
        private ArrayList<String> myWords;
        private ArrayList<Integer> myFreqs;

        public CharactersInPlay(){
            myWords = new ArrayList<String>();
            myFreqs = new ArrayList<Integer>();
        }
        public  void update(String person){
                int index = myWords.indexOf(person);
                if (index == -1) {
                    myWords.add(person);
                    myFreqs.add(1);
                } else {
                    int value = myFreqs.get(index);
                    myFreqs.set(index, value + 1);
                }
            }


        public void findAllCharacters(){
            FileResource resource = new FileResource();
            for (String s : resource.words()) {
                if (s.contains(".")) {
               
                   int idx = s.indexOf(".");
                   String possible_name = s.substring(0,idx);
                   update(possible_name);
            
            }
            }
        }

        public void tester(){
            findAllCharacters();
            System.out.println("# main characters"+myWords.size());
            for (int k =0; k <myWords.size(); k++){
                System.out.println(myFreqs.get(k)+"\t"+myWords.get(k));
            }
            charactersithNumParts(10,15);
            int k = findIndexOfMax();
            System.out.println(myWords.get(k)+"\t"+myFreqs.get(k));
        }
        
        public int findIndexOfMax(){
        int largest = 0;
        int MaxIndex = 0;
        for (int k = 0; k <myWords.size(); k ++){
            if (myFreqs.get(k) > largest){
                largest = myFreqs.get(k);
                MaxIndex = k;

            }
        }
        return MaxIndex;
    }
        public  void charactersithNumParts(int num1, int num2){
            for ( int k = 0; k<myFreqs.size();k++){
                if (myFreqs.get(k) >= num1 && myFreqs.get(k) <=num2){
                    System.out.println(myFreqs.get(k) +"\t"+myWords.get(k));
                }
            }
        }
}
