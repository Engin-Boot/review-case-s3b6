import java.io.BufferedReader;
import java.io.FileReader;

public class sender {
    private static BufferedReader br = null;
    private static String line = "";
    private static String[] lineData;
    public static void readDataLineByLine(String file)
    {
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                lineData = line.split(",");
                for (String cell : lineData) {
                    System.out.print(cell + "  ");
                }
                System.out.println();
            }
            System.out.println("done");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void readDataBySpecificColoumn(String file, String coloumn)
    {
        try {
            br = new BufferedReader(new FileReader(file));
            line=br.readLine();
            lineData = line.split(",");
            int cnt=0;
            for (String col : lineData) {
                if(coloumn.equals(col))
                    break;
                cnt++;
            }
            System.out.println(cnt);
            while ((line = br.readLine()) != null) {
                lineData = line.split(",");
                if(lineData.length >cnt)
                 System.out.println(lineData[cnt]);
            }
            System.out.println("done");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args){
		readDataLineByLine("C:\\Users\\320091455\\BootCamp\\CaseStudy\\review-case-s3b6\\sample-review\\review-report.csv");
	}
}
