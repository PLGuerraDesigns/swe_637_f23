// NAMES: Pablo Guerra, Vishnu Neduncheliyan, Sharadha Shivakumar, Katherine Soltani
// Assignment - Module 3

package hw1.src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalParamTest {
    // Test Cases: 2,3,5,6,7,9,11,12,13
    @ParameterizedTest
    @CsvSource({ "0,16,12,13,2023", "2,16,14,13,2023", "3,15,4,31,2000", "2,29,4,18,2001", "2,28,2,31,2023",
            "4,30,3,2,2023", "1,16,1,3,1", "3,16,4,13,20000", "3,16,4,13,0" })
    public void testAssertThrows(int month1, int day1, int month2, int day2, int year) {
        assertThrows(IllegalArgumentException.class, () -> {
            Cal.cal(month1, day1, month2, day2, year);
        });
    }

    // Test Cases: 1,4,8,10,14,15
    @ParameterizedTest
    @CsvSource({ "1,1,11,13,2023,315", "3,15,4,15,2000,31", "3,16,4,13,2023,28", "4,10,4,20,2022,10",
            "1,26,2,29,2400,34", "1,26,2,29,2024,34" })
    public void testAssertEquals(int month1, int day1, int month2, int day2, int year, int expectedResult) {
        int numDays = Cal.cal(month1, day1, month2, day2, year);
        assertEquals(expectedResult, numDays);
    }

}
