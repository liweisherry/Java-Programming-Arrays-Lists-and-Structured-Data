
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
        public boolean isVowel(char ch){
//           StringBuilder encrypted = new StringBuilder(ch);
           String vowel = "aeiouAEIOU";

           for (int i = 0; i <vowel.length(); i++){
              char a = vowel.charAt(i);
              if (a == ch){
                  return  true;
              }
           }
           return  false;
        }

        public  void testisVowel(){
            System.out.println(isVowel('a'));
            System.out.println(isVowel('f'));
            System.out.println(isVowel('F'));
        }

        public String replaceVowels(String phrase, char ch){
            String result = "";
            for(int i =0; i < phrase.length();i ++){
                char a = phrase.charAt(i);
                if (isVowel(a)){
                    a = ch;
                }
                result = result + a;
            }
            return  result;
        }

        public  void testreplaceVowels(){
            System.out.println(replaceVowels("Hello World", '*'));

        }

        public String emphasize (String phrase, char ch){
            String result = "";
            String c = String.valueOf(ch);
            for(int i =0; i < phrase.length();i ++){
                String a = phrase.substring(i,i+1);
                if (a.equals(c.toLowerCase()) || a.equals(c.toUpperCase())){
                    if (i % 2 == 0){
                        a = "+";
                    }else{
                        a = "*";
                    }
                }
                result = result + a;
            }
            return  result;
        }

        public  void testemphasize(){
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
        }


}
