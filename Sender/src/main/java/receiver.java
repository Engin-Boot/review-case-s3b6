import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class receiver {
    public static void sendWordCountTotheCsvFile() throws IOException {
        Map<String, Integer> wordCount = new LinkedHashMap<String, Integer>();
        Map<String, String> wordWithDate = new LinkedHashMap<String, String>();
        String sw = "and,a,the,an,or,is";
        String[] stopWords=sw.split(",");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter csvWriter = new FileWriter("New.csv");
        FileWriter csvWriter2 = new FileWriter("wordUsedOn.csv");
        String str = null;
        try {
            String colNames = br.readLine();
            str=br.readLine();
            String regex = "[0-9]*";
            Pattern p = Pattern.compile(regex);
            while (!str.equals("done")) {
                str=str.replace("{"," ");
                str=str.replace("}"," ");
                str=str.replace("("," ");
                str=str.replace(")"," ");
                str=str.replace("["," ");
                str=str.replace("]"," ");
                str=str.replace("."," ");

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
                    Matcher m = p.matcher(word);
                    if(m.matches()==true)
                        continue;
                    word=word.replace("“","");
                    word=word.replace("\"","");
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                        wordWithDate.put(word,wordWithDate.get(word)+" " +date);
                    }
                    else {
                        wordCount.put(word, 1);
                        wordWithDate.put(word, date);
                    }
                }
                str = br.readLine();
            }
            csvWriter.append("Word,Count\n");
            csvWriter2.append("Word,Dates\n");
            for(Map.Entry<String,Integer> kv:wordCount.entrySet()){
                if(sw.contains(kv.getKey()))
                    continue;
                csvWriter.append(kv.getKey());
                csvWriter.append(",");
                csvWriter2.append(kv.getKey());
                csvWriter2.append(",");
                String val = kv.getValue().toString();
                csvWriter.append(val);
                csvWriter.append("\n");
                csvWriter2.append(wordWithDate.get(kv.getKey()));
                csvWriter2.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
            csvWriter2.flush();
            csvWriter2.close();
            System.out.println(wordCount.entrySet());
            System.out.println(wordWithDate.entrySet());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        //sender.readDataLineByLine("sample-review/review-report.csv");
        //sender.readDataBySpecificColoumn("sample-review/review-report.csv","Comments");
        // sender.readDataBySpecificColoumn("sample-review/review-report.csv","ReviewDate");
        receiver.sendWordCountTotheCsvFile();
    }
}
