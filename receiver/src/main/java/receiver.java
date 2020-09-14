import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class receiver {
    public static void sendWordCountTotheCsvFile() throws IOException {
        Map<String, Integer> wordCount = new LinkedHashMap<String, Integer>();
        Map<String, String> wordWithDate = new LinkedHashMap<String, String>();
        String sw = "and,a,the,an,or,is";
        String[] stopWords=sw.split(",");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter csvWriter = new FileWriter("New.csv");
        String str = null;
        try {
            str = br.readLine();
            while (!str.equals("")) {
                String[] words=str.split(" ");
                int flag=0;
                String date="";
                for(String word:words) {
                    if(flag==0){
                        flag++;
                        date=word;
                        continue;
                    }
                    if(flag==1){
                        flag++;
                        continue;
                    }
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                        wordWithDate.put(word,wordWithDate.get(word)+"  " +date);
                    }
                    else {
                        wordCount.put(word, 1);
                        wordWithDate.put(word, date);
                    }
                }
                str = br.readLine();
            }
            csvWriter.append("Word,Count\n");
            for(Map.Entry<String,Integer> kv:wordCount.entrySet()){
                if(sw.contains(kv.getKey()))
                    continue;
                csvWriter.append(kv.getKey());
                csvWriter.append(",");
                String val = kv.getValue().toString();
                csvWriter.append(val);
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
            System.out.println(wordCount.entrySet());
            System.out.println(wordWithDate.entrySet());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
