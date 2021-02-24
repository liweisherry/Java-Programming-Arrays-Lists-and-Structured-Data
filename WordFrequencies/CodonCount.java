import java.util.HashMap;

/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CodonCount {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    public CodonCount(){
        map = new HashMap<String, Integer>();

    }

    public void buildCodonMap(int start, String dna){
        map.clear();
        int num = 0;
        String current;
        for (int k = start; k < dna.length(); k+=3){
            current = dna.substring(k,k+3);
            if (map.containsKey(current)) {
                map.put(current, num);
            }
            else {
                map.put(current,1);
            }
        }
    }

    public String getMostCommonCodon(){
        int max = 0;
        String maxDna = null;
        for (String w : map.keySet()){
            
            if (map.get(w) > max){
                max = map.get(w);
                maxDna = w;
            }
        }
        return  maxDna;
    }

    public void printCodonCounts(int start, int end){
        for(String w: map.keySet()){
            if (map.get(w) >= start && map.get(w) <= end){
                System.out.println("Codon between "+start+"and "+end+":"+w);
            }
        }
    }

    public void tester(){
        FileResource DNA = new FileResource("dnaMystery1.txt");
        String dna = DNA.asString();
        int start = 1;
        int end = 5;

        buildCodonMap(0, dna);
        System.out.println("Reading frame starting with 0 results in "+DNA_count.size()+" unique codons"+"\t");
        String the_largest_count = getMostCommonCodon();
        System.out.println("and most common codon is "+the_largest_count+" with count "+DNA_count.get(the_largest_count)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

        buildCodonMap(1, dna);
        System.out.println("Reading frame starting with 1 results in "+DNA_count.size()+" unique codons"+"\t");
        the_largest_count = getMostCommonCodon();
        System.out.println("and most common codon is "+the_largest_count+" with count "+DNA_count.get(the_largest_count)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

        buildCodonMap(2, dna);
        System.out.println("Reading frame starting with 2 results in "+DNA_count.size()+" unique codons"+"\t");
        the_largest_count = getMostCommonCodon();
        System.out.println("and most common codon is "+the_largest_count+" with count "+DNA_count.get(the_largest_count)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);
    }
}
