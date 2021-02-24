import java.util.ArrayList;
import java.util.Date;
import  edu.duke.*;
import java.text.*; 
/**
 * Write a description of LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LogAnalyzer{
    private ArrayList<LogEntry> records;
    public LogAnalyzer(){
        records = new ArrayList<LogEntry>();
    }
    public void readFile(String filename){
        FileResource fr = new FileResource(filename);
        for (String s : fr.lines()){
            WebLogParser.parseEntry(s);
            records.add(WebLogParser.parseEntry(s));}
    }


    public void printAll(){
        for (LogEntry le : records){
            System.out.println(le);
        }
    }

    public int countUniqueIPs(){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le : records){
            String ipArr = le.getIpAddress();
            if (!uniqueIPs.contains(ipArr)){
                uniqueIPs.add(ipArr);

            }
        }
        return uniqueIPs.size();
    }

    public void printAllHigherThanNum(int num){
        for (LogEntry le : records){
            int statusCode = le.getStatusCode();
            if (statusCode > num){
                System.out.println(le);
            }
        }
    }

    public ArrayList uniqueIPVisitsOnDay(String someday){
        ArrayList<String> uniqueIPDay = new ArrayList<String>();
        for (LogEntry le: records){
            Date t = le.getAccessTime();
            String mystirng = t.toString();
            String ipArr = le.getIpAddress();
            if (mystirng.contains(someday) && !uniqueIPDay.contains(ipArr)){
                uniqueIPDay.add(ipArr);
            }
        }
        return uniqueIPDay;
    }

    public int countUniqueIPsInRange(int low, int high){
        int count = 0;
        for (LogEntry le : records){
            int stateCode = le.getStatusCode();
            if (stateCode <= low && stateCode >= high){
                count ++;
            }
        }
        return  count;
    }
}