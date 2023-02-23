public class Check_Data {

    // Method to Determine Condition and Recommendation
    public static String Suggested(int PHQ, int GAD){
        if ((PHQ<10)&&(GAD>9)){
            return ("Primarily Anxiety: Begin Sertraline starting dose 50mg and reassess in after 4 weeks\n");
        }
        else if ((GAD>9)&&(PHQ>9)){
            return("Mixed Anxiety and Depression: Begin Fluoxetine starting dose 10 mg QD and reassess in 4 weeks\n");
        }
        else if ((GAD<10)&&(PHQ>9)){
            return("Primarily Depression: Begin Buproprion XL 150mg QD and reassess in 4 weeks\n");
        }
        return("Data Not Found");
    }
    // Currently reads the full file 'sampleinput.csv'
    // Can change to take in a string from the patient search
    public static String[] main(String line){
//            File myObj = new File("Project/testData/sampleinput.csv");
//            Scanner myReader = new Scanner(myObj);
//
//            // while file has next line
//            while (myReader.hasNextLine()){
//                String data = myReader.nextLine();

                // while line isn't null
                if (line != ""){
                    int PHQ_total = 0, GAD_total = 0;
                    String[] testArray = line.split(",");
                    String first = testArray[0];
                    String last = testArray[1];
                    String DOB = testArray[2];
                    // tests for PHQ-9 in format, should be there
                    if (testArray[3].equals("PHQ-9")){
                        for (int i = 4; i < 4+9; i++) PHQ_total += Integer.parseInt(testArray[i]);
                    }
                    // tests for GAD-7 in format, should be there
                    if (testArray[13].equals("GAD-7")){
                        for (int i = 14; i < 14+7; i++) GAD_total += Integer.parseInt(testArray[i]);
                    }
                    // End of Current Testing
                    String result[] = new String[4];
                    result[0] = ("Patient: " + first + " " + last);
                    result[1] = ("PHQ-9 Results: " + PHQ_total);
                    result[2] = ("GAD-7 Results: " + GAD_total);
                    result[3] = Suggested(PHQ_total,GAD_total);
                    return(result);
                }

        return new String[0];
    }
}
