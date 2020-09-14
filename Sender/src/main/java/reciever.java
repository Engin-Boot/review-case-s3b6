import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class reciever {
    public static void sendWordCountTotheCsvFile(){
        Scanner scan=new Scanner(System.in);
        Map<String,Integer> wordCount = new HashMap<String,Integer>();
        while(scan.hasNext()){
            String str = scan.next();
            if(str.equals("end"))
                break;
            if(wordCount.containsKey(str))
                wordCount.put(str,wordCount.get(str)+1);
            else
                wordCount.put(str,1);
        }
        System.out.println(wordCount.keySet());
        System.out.println(wordCount.entrySet());
    }
}
