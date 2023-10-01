// NAMES: Pablo Guerra, Vishnu Neduncheliyan, Sharadha Shivakumar, Katherine Soltani
// Assignment - Module 6

package hw4.src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CalMutantParamTest {

    // Test the original version against the no fault version
    @ParameterizedTest
    @CsvFileSource(resources = "TEST_CASES_S2.csv", numLinesToSkip = 1)
    public void testAssertEqualsNoFault(int month1, int month2, int day1, int day2, int year) {
        int officialResult = Cal.cal(month1, day1, month2, day2, year);

        CalMutants CalMutantsNoFault = new CalMutants(0);
        int mutantResult = CalMutantsNoFault.cal(month1, day1, month2, day2, year);

        assertEquals(officialResult, mutantResult);
    }

    // Test the original version against the 20 faulty versions (strength 2)
    @ParameterizedTest
    @CsvFileSource(resources = "TEST_CASES_S2.csv", numLinesToSkip = 1)
    public void testAssertEqualsMutants(int month1, int month2, int day1, int day2, int year) {
        int officialResult = Cal.cal(month1, day1, month2, day2, year);

        CalMutants[] CalMutants = new CalMutants[20];
        for (int i = 1; i < 21; i++) {
            CalMutants[i] = new CalMutants(i);
            int mutantResult = CalMutants[i].cal(month1, day1, month2, day2, year);
            assertEquals(officialResult, mutantResult);
        }

    }

    // Test the original version against the no fault version
    @ParameterizedTest
    @CsvFileSource(resources = "TEST_CASES_S5.csv", numLinesToSkip = 1)
    public void testAssertEqualsNoFault2(int month1, int month2, int day1, int day2, int year) {
        int officialResult = Cal.cal(month1, day1, month2, day2, year);

        CalMutants CalMutantsNoFault = new CalMutants(0);
        int mutantResult = CalMutantsNoFault.cal(month1, day1, month2, day2, year);

        assertEquals(officialResult, mutantResult);
    }

}
