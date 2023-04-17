import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Check_DataTest {

    @Test
    void suggested_handles_data_within_range() {
        //assertTrue(true);
        String suggested = Check_Data.Suggested(0, 0);
        assertEquals("Negative for both Anxiety and Depression", suggested);
        suggested = Check_Data.Suggested(0, 21);
        assertEquals("Primarily Anxiety. Begin Sertraline starting dose 50mg. Reassess after 4 weeks", suggested);
        suggested = Check_Data.Suggested(10, 10);
        assertEquals("Mixed Anxiety/Depression. Begin Fluoxetine starting dose 10 mg QD. Reassess after 4 weeks", suggested);
        suggested = Check_Data.Suggested(27, 0);
        assertEquals("Primarily Depression. Begin Buproprion XL 150mg QD. Reassess after 4 weeks", suggested);
        suggested = Check_Data.Suggested(27, 21);
        assertEquals("Mixed Anxiety/Depression. Begin Fluoxetine starting dose 10 mg QD. Reassess after 4 weeks", suggested);
    }
    @Test
    void suggested_handles_data_outside_range(){
        String suggested = Check_Data.Suggested(-99,-99);
        assertEquals("Data Not Found",suggested);
        suggested = Check_Data.Suggested(99,99);
        assertEquals("Data Not Found",suggested);
        suggested = Check_Data.Suggested(-99,99);
        assertEquals("Data Not Found",suggested);
        suggested = Check_Data.Suggested(99,-99);
        assertEquals("Data Not Found",suggested);
    }

    @Test
    void suggested_ISI_handles_data_within_range() {
        String suggested = Check_Data.Suggested_ISI(0);
        assertEquals("Insomnia Result: No clinically significant insomnia", suggested);
        suggested = Check_Data.Suggested_ISI(5);
        assertEquals("Insomnia Result: No clinically significant insomnia", suggested);
        suggested = Check_Data.Suggested_ISI(10);
        assertEquals("Insomnia Result: Subthreshold insomnia", suggested);
        suggested = Check_Data.Suggested_ISI(15);
        assertEquals("Insomnia Result: Clinical insomnia (moderate severity)", suggested);
        suggested = Check_Data.Suggested_ISI(25);
        assertEquals("Insomnia Result: Clinical insomnia (severe)", suggested);
        suggested = Check_Data.Suggested_ISI(28);
        assertEquals("Insomnia Result: Clinical insomnia (severe)", suggested);
    }

    @Test
    void suggested_ISI_handles_data_outside_range() {
        String suggested = Check_Data.Suggested_ISI(99);
        assertEquals("Data Not Found", suggested);
        suggested = Check_Data.Suggested_ISI(-99);
        assertEquals("Data Not Found", suggested);
    }

    @Test
    void clean_numbers() {
        //assertTrue(true);
        String patient_name = Check_Data.Clean("39Jess52");
        assertEquals("Jess", patient_name);
    }

    @Test
    void clean_symbols() {
        String patient_name = Check_Data.Clean("__Jess*");
        assertEquals("Jess", patient_name);
        patient_name = Check_Data.Clean("Jess;");
        assertEquals("Jess", patient_name);
        patient_name = Check_Data.Clean("\\Jess?!");
        assertEquals("Jess", patient_name);
    }

    @Test
    void clean_whitespace(){
        String patient_name = Check_Data.Clean("   Jess");
        assertEquals("Jess", patient_name);
        patient_name = Check_Data.Clean("Jess   ");
        assertEquals("Jess", patient_name);
        patient_name = Check_Data.Clean("   Jess   ");
        assertEquals("Jess", patient_name);
    }

    @Test
    void main_handles_no_patient() {
        String line = "Patient not found";
        String[] testArray = Check_Data.main(line);
        assertTrue(testArray[0] == "<html><h1>Patient: Patient not found </h1></html>");
        assertTrue(testArray.length == 11);
        for (int i=1;i<11;i++) {
            assertTrue(testArray[i].contains("NA"));
        }
    }

    @Test
    void main_handles_patients(){
        String line = "Joe,Smith,3_29_2019,PHQ-9,2,1,1,2,3,1,0,1,1,GAD-7,0,0,3,1,0,2,1,ISI,2,2,2,2,2,2,2,ASRS,0,1,2,3,4,0,CSS,1,1,1,1,1,1,1";
        String[] testArray = Check_Data.main(line);
        assertTrue(testArray.length==11);

        // Correct Name and DOB
        String[] expected = line.split(",");
        assertTrue(testArray[0].contains(expected[0]));
        assertTrue(testArray[0].contains(expected[1]));
        assertTrue(testArray[1].contains(expected[2]));
    }
}