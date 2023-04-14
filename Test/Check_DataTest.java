import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Check_DataTest {

    @Test
    void suggested() {
        //assertTrue(true);
        String suggested = Check_Data.Suggested(0,0);
        assertEquals("Negative for both Anxiety and Depression", suggested);
        suggested = Check_Data.Suggested(5,10);
        assertEquals("Primarily Anxiety. Begin Sertraline starting dose 50mg. Reassess after 4 weeks",suggested);
        suggested = Check_Data.Suggested(10,10);
        assertEquals("Mixed Anxiety/Depression. Begin Fluoxetine starting dose 10 mg QD. Reassess after 4 weeks",suggested);
        suggested = Check_Data.Suggested(10,5);
        assertEquals("Primarily Depression. Begin Buproprion XL 150mg QD. Reassess after 4 weeks",suggested);
        suggested = Check_Data.Suggested(-99,-99);
        assertEquals("Data Not Found",suggested);
        suggested = Check_Data.Suggested(99,99);
        assertEquals("Data Not Found",suggested);
        suggested = Check_Data.Suggested(-99,99);
        assertEquals("Data Not Found",suggested);
        suggested = Check_Data.Suggested(99,-99);
        assertEquals("Data Not Found",suggested);
    }

    @Test
    void suggested_ISI() {
        //assertTrue(true);
    }

    @Test
    void clean() {
        //assertTrue(true);
        String patient_name = Check_Data.Clean("39Jess52");
        assertArrayEquals("Jess".toCharArray(), patient_name.toCharArray());
        patient_name = Check_Data.Clean("__Jess*");
        assertArrayEquals("Jess".toCharArray(), patient_name.toCharArray());
        patient_name = Check_Data.Clean("Jess;");
        assertArrayEquals("Jess".toCharArray(), patient_name.toCharArray());
        patient_name = Check_Data.Clean("\\Jess?!");
        assertArrayEquals("Jess".toCharArray(), patient_name.toCharArray());
    }

    @Test
    void main() {
        assertTrue(true);
    }
}