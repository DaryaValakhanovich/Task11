import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("log-file");
        ArrayList<Activity> list = new ArrayList<>(new Timetable(readFile(file)).getList());
        for (Activity activity: list) {
            System.out.println(activity.toString());
        }
        ReportGenerator reportGenerator = new ReportGenerator((list));
        System.out.println();
       System.out.println(new ReportGenerator(list).summaryTimeReport());

        File file1 = new File("file1");
        file1.createNewFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter((file1))))){
            bufferedWriter.write(reportGenerator.timeLineReport());
        } catch (IOException e){
            e.printStackTrace();
        }
        File file2 = new File("file2");
        file2.createNewFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter((file2))))){
            bufferedWriter.write(reportGenerator.summaryTimeReport());
        } catch (IOException e){
            e.printStackTrace();
        }
}

    public static String readFile(File file){
        StringBuilder text = new StringBuilder();
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)))){
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                text.append(s + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return text.toString();
    }
}
