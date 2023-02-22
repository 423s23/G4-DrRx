import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Check_Data {
    public static void main(String[] args){
        try {
            File myObj = new File("Project/testData/sampleinput.csv");
            Scanner myReader = new Scanner(myObj);
            // Skip first line, getting Questionnaire data only
            String data = myReader.nextLine();

            while (myReader.hasNextLine()){
                int total = 0;
                String answers = "";
                data = myReader.nextLine();
                String[] testArray = data.split(",");
                int count = (testArray.length);
                System.out.println("Test: " + testArray[0]);
                for (int i = 1; i < count ; i++){
                    try {
                        total += Integer.parseInt(testArray[i]);
                    } catch (NumberFormatException e){
                        answers = answers + testArray[i] + ", ";
                    }
                }
                if (total > 0) {
                    System.out.println("Total Test Score: " + total);
                } else {
                    System.out.println("Test Answers: " + answers);
                }
                System.out.println("\n");
            }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        }
    }
}
