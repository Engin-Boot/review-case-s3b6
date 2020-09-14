import java.io.IOException;

public class receiverTest {
    public static void main(String[] args) throws IOException {
        //sender.readDataLineByLine("sample-review/review-report.csv");
        //sender.readDataBySpecificColoumn("sample-review/review-report.csv","Comments");
        // sender.readDataBySpecificColoumn("sample-review/review-report.csv","ReviewDate");
        receiver.sendWordCountTotheCsvFile();
    }
}
