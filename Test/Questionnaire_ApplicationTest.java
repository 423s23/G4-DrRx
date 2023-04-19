import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Questionnaire_ApplicationTest {

    @Test
    void patient_file_exists() {
        try {
            Scanner sc = new Scanner(new File("Project\\testData\\sampleinput.csv"));
            assertTrue(true);
        } catch (FileNotFoundException e) {
            assertTrue(false);
        }
    }

    @Test
    void patient_file_is_not_empty() {
        try {
            String line;
            Scanner sc = new Scanner(new File("Project\\testData\\sampleinput.csv"));
            while (sc.hasNext())  //returns a boolean value
            {
                line = sc.nextLine();
                String[] current_line = (line.toLowerCase()).split(",");

                //Checking if Empty
                for (int i=0;i<44;i++) {
                    assertTrue(!current_line[i].isEmpty());
                    assertTrue(!current_line[i].isBlank());
                }
            }

        } catch (FileNotFoundException e) {
            fail();
        }
    }

    @Test
    void patient_file_format() {
        try {
            String line;
            Scanner sc = new Scanner(new File("Project\\testData\\sampleinput.csv"));
            while (sc.hasNext())  //returns a boolean value
            {
                line = sc.nextLine();
                String[] current_line = (line.toLowerCase()).split(",");

                //Checking format of patient line
                //Check if First Name, Last Name and DOB contain letters.
                assertTrue(current_line[0].matches("[a-zA-Z]+"));
                assertTrue(current_line[1].matches("[a-zA-Z]+"));
                assertFalse(current_line[2].matches(("[a-zA-Z]+")));
                for (int i=3; i<44;i++){
                    //Check Test Titles
                    if (i == 3){
                        assertTrue(current_line[i].equals("phq-9"));
                    } else if (i == 13) {
                        assertTrue(current_line[i].equals("gad-7"));
                    } else if (i == 21) {
                        assertTrue(current_line[i].equals("isi"));
                    } else if (i == 29) {
                        assertTrue(current_line[i].equals("asrs"));
                    } else if (i == 36) {
                        assertTrue(current_line[i].equals("css"));
                    } else {
                        //Check answers from tests
                        //Number 0-5
                        assertTrue(Integer.parseInt(current_line[i]) <= 5);
                        assertTrue(Integer.parseInt(current_line[i]) >= 0);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            fail();
        }
    }
}