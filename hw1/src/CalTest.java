package hw1.src;

import org.junit.Test;

public class CalTest {
    // ***********************************************************
    // Calculate the number of days between the two given days in
    // the same year in accordance with the Gregorian calendar.
    // Examples: January 1 to January 1 is 0 days
    // January 1 to January 2 is 1 day
    // January 1 to January 31 is 30 days
    // Preconditions:
    // 1. day1 and day2 must be in same year
    // 2. 1 <= month1, month2 <= 12
    // 3. 1 <= day1 <= maxDaysInMonth1
    // where maxDaysInMonth1 is defined as the largest valid
    // day in the specified month1 and year, including any
    // leap year, as per the Gregorian calendar
    // 4. 1 <= day2 <= maxDaysInMonth2
    // where maxDaysInMonth2 is defined as the largest valid
    // day in the specified month2 and year, including any
    // leap year, as per the Gregorian calendar
    // 5. month1 <= month2
    // 6. month1 == month2 implies day1 <= day2
    // 7. 1 <= year <= 10000
    // ********************************

    @Test
    public void test1() {
        int month1 = 1;
        int day1 = 1;
        int month2 = 1;
        int day2 = 1;
        int year = 1;
        int numDays = Cal.cal(month1, day1, month2, day2, year);
        assert numDays == 0;
    }

}
