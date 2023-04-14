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
        assertArrayEquals("Jess".toCharArray(), patient_name.toCharArray());
        patient_name = Check_Data.Clean("Jess   ");
        assertArrayEquals("Jess".toCharArray(), patient_name.toCharArray());
        patient_name = Check_Data.Clean("   Jess   ");
        assertEquals("Jess", patient_name.toCharArray());
    }

    @Test
    void main() {
        assertTrue(true);
    }
}