public class Check_Data {

    // Method to Determine Condition and Recommendation
    public static String Suggested(int PHQ, int GAD){
        if ((GAD>21)||(GAD<0)||(PHQ>27)||(PHQ<0)) {
            return ("Data Not Found");
        }
        else if ((PHQ<10)&&(GAD>9)){
            return ("Primarily Anxiety. Begin Sertraline starting dose 50mg. Reassess after 4 weeks");
        }
        else if ((GAD>9)&&(PHQ>9)){
            return("Mixed Anxiety/Depression. Begin Fluoxetine starting dose 10 mg QD. Reassess after 4 weeks");
        }
        else if ((GAD<10)&&(PHQ>9)){
            return("Primarily Depression. Begin Buproprion XL 150mg QD. Reassess after 4 weeks");
        }
        else if ((GAD>=0)&&(PHQ>=0)) {
            return("Negative for both Anxiety and Depression");
        }
        else {
            return ("Data Not Found");
        }
    }

    public static String Suggested_ISI(int ISI){
        if(ISI<=7){
            return ("Insomnia Result: No clinically significant insomnia");
        }
        else if((8<=ISI)&&(ISI<=14)){
            return ("Insomnia Result: Subthreshold insomnia");
        }
        else if((15<=ISI)&&(ISI<=21)){
            return ("Insomnia Result: Clinical insomnia (moderate severity)");
        }
        else if((21<=ISI)&&(ISI<=28)){
            return ("Insomnia Result: Clinical insomnia (severe)");
        }
        return("Data Not Found");
    }

    public static String Clean(String dirty){
        //clean string init
        String clean = null;
        boolean space = false;
        //check all characters for valid alphabet
        for(int i = 0; i < dirty.length(); i++){
            char current_character = dirty.charAt(i);
            int current_character_ascii = (int)current_character;
            if((current_character_ascii > 64 && current_character_ascii < 91) ||
                    (current_character_ascii > 96 && current_character_ascii < 123)){
                if(clean != null){
                    clean += current_character;}
                //first character in clean string
                else{clean = ""; clean += current_character;}
                //makes sure that there is only one space at most between each letter
                if(space)
                {
                    space = false;
                }
            }
            //adds a space if applicable
            else if(current_character_ascii == 32 && !space){
                clean += current_character;
                space = true;
            }
        }
        return clean;
    }

    // line is sent through call function in Questionnaire_Application
    public static String[] main(String line){

        // while line isn't null
        if (line != ""){
            int PHQ_total = 0, GAD_total = 0, ISI_total = 0, ASRS_total = 0;
            String ASRS_recommendation = "";
            String[] testArray = line.split(",");

            if(testArray[0] == "Patient not found"){

                String result[] = new String[11];
                result[0] = ("<html><h1>Patient: Patient not found </h1></html>");
                result[1] = ("<html>DOB: NA </html>");
                result[2] = ("<html><h1>Columbia Total: NA </h1><p>Scale: 0-7</p></html>");
                result[3] = ("<html> NA </html>");
                result[4] = ("<html><h1>ASRS Total: NA </h1><p>Scale: 0-6</p></html>");
                result[5] = ("<html>ASRS Result: NA </html>");
                result[6] = ("<html><h1>ISI Total: NA </h1><p>Scale: 0-28</p></html>");
                result[7] = ("<html> NA </html>");
                result[8] = ("<html><h1>GAD-7 Total: NA </h1><p>Scale: 0-21</p></html>");
                result[9] = ("<html>GAD/PHQ Results: NA </html>");
                result[10] = ("<html><h1>PHQ-9 Total: NA </h1><p>Scale: 0-27</p></html>");
                return result;
            }
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

            // ISI TEST
            if (testArray[21].equals("ISI")){
                for (int i = 22; i < 22+7; i++) ISI_total += Integer.parseInt(testArray[i]);
            }

            //CSS Recommendation------------
            String CSS_EMERGENCY = "Get immediate help: Call or text 988, call 911, or go to the emergency room. STAY WITH THEM until they can be evaluated";
            String CSS_Recommendation = "Patient is able to continue screening";
            int CSS_total = 0;
            boolean CSS_Trouble = false;

            // If PHQ Question 9 is anything but 0, take CSS
            if (!(testArray[12].equals("0"))){
                for(int i = 37; i < 44; i++) CSS_total += Integer.parseInt(testArray[i]);

                if (!(testArray[40].equals("0")) || !(testArray[41].equals("0")) || !(testArray[43].equals("0"))) {
                    CSS_Trouble = true;
                }
            }

            if (testArray[29].equals("ASRS")){
                for (int i = 30; i < 30+6; i++) ASRS_total += Integer.parseInt(testArray[i]);
                if(ASRS_total >= 14){
                    ASRS_recommendation = "Patient is likely to have ADHD";
                }else{
                    ASRS_recommendation = "Patient is not likely to have ADHD";
                }
            }

            // End of Current Testing
            // This string array will have to be modified to include more tests
            // Suggested method will have to be modified to take all data, and return right recommendation
            // HTML tag added to fit all screen sizes
            String result[] = new String[11];
            result[0] = ("<html><h1>Patient: " + first + " " + last + "</h1></html>");
            result[1] = ("<html>DOB: " + DOB + "</html>");
            result[2] = ("<html><h1>Columbia Total: " + CSS_total + "</h1><p>Scale: 0-7</p></html>");
            if(CSS_Trouble) { result[3] =  "<html>" + CSS_EMERGENCY + "</html>"; }
            else { result[3] = "<html>" + CSS_Recommendation + "</html>"; }
            result[4] = ("<html><h1>ASRS Total: " + ASRS_total + "</h1><p>Scale: 0-36</p></html>");
            result[5] = ("<html>ASRS Result: " + ASRS_recommendation + "</html>");
            result[6] = ("<html><h1>ISI Total: " + ISI_total + "</h1><p>Scale: 0-28</p></html>");
            result[7] = ("<html>" + Suggested_ISI(ISI_total)  + "</html>");
            result[8] = ("<html><h1>GAD-7 Total: " + GAD_total + "</h1><p>Scale: 0-21</p></html>");
            result[9] = ("<html>GAD/PHQ Results: " + Suggested(PHQ_total,GAD_total)  + "</html>");
            result[10] = ("<html><h1>PHQ-9 Total: " + PHQ_total + "</h1><p>Scale: 0-27</p></html>");
            return(result);
        }

        return new String[0];
    }
}