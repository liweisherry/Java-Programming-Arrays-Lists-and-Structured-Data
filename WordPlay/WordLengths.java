
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {
        public void countWordLengths(FileResource resource, int[] counts ){

                for (String word: resource.words()){
                        int k = 0;
                        for (int i = 0; i < word.length(); i++){
                                if (Character.isLetter(word.charAt(i))){
                                        k ++;
                                }
                        }
                       if (k > counts.length){
                                    counts[counts.length] +=1;
                            }
                        counts[k]+=1;
                        
                        System.out.println(k+" "+counts[k]);
                }
        }

        public  void  testCountWordLengths(){
                FileResource fr = new FileResource();
                int[] counts = new int[31];
                countWordLengths(fr,counts);
                System.out.println("Most common length is " + indexOfMax(counts));
        }

        public int indexOfMax(int[] values){
                int largest = 0;
                int indexMax = 0;
                for (int i =0; i < values.length;i++){
                        if(values[i]> largest){
                                largest = values[i];
                                indexMax = i;
                        }
                }
                return indexMax;
        }
}
