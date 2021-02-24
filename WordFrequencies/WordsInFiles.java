
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WordsInFiles {
    private HashMap<String,ArrayList<String>> map;
    public WordsInFiles(){
        map = new HashMap<String,ArrayList<String>>();
    }

    private  void addWordsFromFile(File f){
        FileResource fileResource = new FileResource(f);
        String name = f.getName();
        for (String s : fileResource.words()){
            if(map.containsKey(s) && !map.get(s).contains(name)){
                ArrayList<String> currentNameList = map.get(s);
                currentNameList.add(name);
                map.put(s,currentNameList);

            }else if
             ( !map.containsKey(s)){
                ArrayList<String> currentNameList = map.get(s);
                currentNameList.add(name);
                map.put(s,currentNameList);
            }
        }
    }

    public void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }

    public int maxNumber(){
        int maxNumber = 0;
        for(String word:map.keySet()){
            ArrayList<String> currentFileList = map.get(word);
            int currentNum = currentFileList.size();
            if (currentNum > maxNumber) {
                maxNumber = currentNum;
            }
        }
        return maxNumber;
    }

    public ArrayList<String> wordsInNumFiles(int number) {
        ArrayList<String> returnList = new ArrayList<String>();
        for (String w : map.keySet()) {
            ArrayList<String> currentList = new ArrayList<String>();
            for (String word : map.keySet()) {
                ArrayList<String> currentFileList = map.get(word);
                int currentNum = currentFileList.size();
                if (currentNum == number) {
                    returnList.add(word);
                }
            }
        }
        return  returnList;
    }
    private void printFilesIn(String word) {
        ArrayList<String> fileNames = word_filename.get(word);
        for (int index = 0; index < fileNames.size(); index++) {
            System.out.println(fileNames.get(index));
        }
    }
    public void test(){
        buildWordFileMap();
        int maximum = maxNumber();
        //ArrayList<String> TestList = wordsInNumFiles(maximum);
        ArrayList<String> TestList = wordsInNumFiles(4);
        System.out.println("The maximum number of files word is in: "+maximum +" and there are "+TestList.size());
        for (int k =0;k< TestList.size(); k++)
        {
            System.out.println("All the words in the files "+TestList.get(k)+"");
        }
        System.out.println("\t");

        for (int k =0;k <TestList.size();k++){
            System.out.println("Filenames where the words are ");
            printFilesIn(TestList.get(k));
        }
        //System.out.println("\n");
        //printFilesIn("word");
    }
}
