
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;
public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        FileResource fr = new FileResource();
        la.readFile(fr.getName());
        la.printAll();
    }

    public void testUniqueIPs(){
        LogAnalyzer la = new LogAnalyzer();
        FileResource fr = new FileResource();
        la.readFile(fr.getName());
        la.countUniqueIPs();

    }

    public void testprintAllHigherThanNum(){
        LogAnalyzer la = new LogAnalyzer();
        FileResource fr = new FileResource();
        la.readFile(fr.getName());
        la.printAllHigherThanNum(4);
    }

    public void testuniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        FileResource fr = new FileResource();
        la.readFile(fr.getName());
        la.uniqueIPVisitsOnDay("Mar 17");

    }

    public void testcountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        FileResource fr = new FileResource();
        la.readFile(fr.getName());
        int countinRange_first = la.countUniqueIPsInRange(200, 299);
        //int countinRange_second = Analyser.countUniqueIPsInRange(300, 399);
        System.out.println("There are firstly " + countinRange_first + " IPs");
        //System.out.println("There are secondly " + countinRange_second + " IPs");
    }
}
