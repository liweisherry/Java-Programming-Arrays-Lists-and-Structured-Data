import java.util.ArrayList;

/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public  WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();

    }
    public void findUnique(){
        FileResource resource = new FileResource();
        for (String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
        }
    }

    public void tester(){
        findUnique();

        
        for (int k =0; k <myWords.size(); k++){
            System.out.println(myFreqs.get(k)+"\t"+myWords.get(k));
        }
        int k =findIndexOfMax();
        System.out.println("# unique words"+myWords.size());
        System.out.println("Max unique words "+myWords.get(k)+"Freq "+myFreqs.get(k));

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
}
