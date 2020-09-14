public class senderTest {
    public static void main(String[] args){
        //sender.readDataLineByLine("sample-review/review-report.csv");
       sender.readDataBySpecificColoumn("sample-review/review-report.csv","Comments");
       // sender.readDataBySpecificColoumn("sample-review/review-report.csv","ReviewDate");
        //reciever.sendWordCountTotheCsvFile();

    }
}
