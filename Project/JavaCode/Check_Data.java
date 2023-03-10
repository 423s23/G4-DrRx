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

    public static String Suggested_ISI(int ISI){
        if(ISI<=7){
            return ("Insomnia Result: No clinically significant insomnia\n");
        }
        else if((8<=ISI)&&(ISI<=14)){
            return ("Insomnia Result: Subthreshold insomnia\n");
        }
        else if((15<=ISI)&&(ISI<=21)){
            return ("Insomnia Result: Clinical insomnia (moderate severity)\n");
        }
        else if((21<=ISI)&&(ISI<=28)){
            return ("Insomnia Result: Clinical insomnia (severe)\n");
        }
        return("Data Not Found");
    }

    // line is sent through call function in Questionnaire_Application
    public static String[] main(String line){

        // while line isn't null
        if (line != ""){
            int PHQ_total = 0, GAD_total = 0, ISI_total = 0, ASRS_total = 0;
            String ASRS_recommendation = "";
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

            // ISI TEST
            if (testArray[21].equals("ISI")){
                for (int i = 22; i < 22+7; i++) ISI_total += Integer.parseInt(testArray[i]);
            }

            //CSS Reccomendation------------
            String CSS_Reccomendation = "<html>Get immediate help: Call or text 988, call 911 " +
                    "or go to the emergency room.<br>STAY WITH THEM until they can be evaluated.</html>";
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
            String result[] = new String[9];
            result[0] = ("Patient: " + first + " " + last);
            result[1] = ("PHQ-9 Results: " + PHQ_total);
            result[2] = ("GAD-7 Results: " + GAD_total);
            result[3] = ("ISI Results: "   + ISI_total);
            result[4] = ("ASRS Total: "  + ASRS_total);
            result[5] = ("ASRS Result: " + ASRS_recommendation);
            result[6] = Suggested(PHQ_total,GAD_total);
            result[7] = Suggested_ISI(ISI_total);
            if(CSS_Trouble)
            {
                result[8] = CSS_Reccomendation;
            }
            else
            {
                result[8] = ("CSS Total: " + CSS_total);
            }
            //System.out.println(result[0].toString()+"\n"+result[1]+"\n"+result[2]+"\n"+result[3]+"\n"+result[4]+"\n"+result[5]+"\n"+result[6]);
            return(result);
        }

        return new String[0];
    }
}