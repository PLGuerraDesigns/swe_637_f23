// NAMES: Pablo Guerra, Vishnu Neduncheliyan, Sharadha Shivakumar, Katherine Soltani
// Assignment - Module 3

package hw1.src;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalTest {
    // Use the intuitive test development approach from earlier in this module to
    // develop a set of JUnit test cases for the cal() method.
    // JUnit 5 is preferred, but JUnit 4 is also acceptable
    // Execute the tests and note the results
    // For any fault(s) found, describe the fault and the test(s) that found the
    // fault.
    // Describe the fix for the fault
    // Implement those test cases using a JUnit parameterized test. Identify,
    // describe, and fix any faults that you find in the code

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

    // ********************************
    // Test precondition 1: day1 and day2 must be in the same year
    // There isn't a way to test this as there is only one year input accepted into
    // the cal function

    // ********************************
    // Test precondition 2: 1 <= month1, month2 <= 12
    // (code should throw IllegalArgumentException)
    @Test
    public void testMonthNumberCorrect() {
        int month1 = 1;
        int month2 = 11;
        int day1 = 1;
        int day2 = 13;
        int year = 2023;

        int numDays = Cal.cal(month1, day1, month2, day2, year);
        assertEquals(315, numDays);
    }

    // (code should throw IllegalArgumentException)
    @Test
    public void testMonthNumberLessThanNumMonths() {
        int month1 = 0;
        int month2 = 12;
        int day1 = 16;
        int day2 = 13;
        int year = 2023;

        assertThrows(
                IllegalArgumentException.class,
                () -> Cal.cal(month1, day1, month2, day2, year));
    }

    // (code should throw IllegalArgumentException)
    @Test
    public void testMonthNumberGreaterThanNumMonths() {
        int month1 = 2;
        int month2 = 14;
        int day1 = 16;
        int day2 = 13;
        int year = 2023;

        assertThrows(
                IllegalArgumentException.class,
                () -> Cal.cal(month1, day1, month2, day2, year));
    }

    // ********************************
    // Test preconditions 3 and 4: day1 and day2 should be within the number of days
    // in the month
    // Here, test correct values within number of days in a month
    @Test
    public void testDayNumberIsWithinMonthRange() {
        int month1 = 3;
        int month2 = 4;
        int day1 = 15;
        int day2 = 15;
        int year = 2000;

        int numDays = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(31, numDays);

    }

    // Here we are using a test case where the day number is less than the number of
    // days in the month, or greater than the number of days in the month
    // (code should throw Exception)
    @Test
    public void testDayNumberIsNotWithinMonthRange() {
        int month1 = 3;
        int month2 = 4; // April has 30 days
        int day1 = 15;
        int day2 = 31; // day2 not in range of month2
        int year = 2000;

        assertThrows(IllegalArgumentException.class,
                () -> Cal.cal(month1, day1, month2, day2, year));

    }

    // Test if function can see day is within the month range for february in a
    // non-leap year
    @Test
    public void testDayNumberIsNotWithinMonthRangeNonLeapYearFeb() {
        int month1 = 2; // feb in non-leap year has 28 days
        int month2 = 4;
        int day1 = 29; // 29th day of feb
        int day2 = 18;
        int year = 2001;
        assertThrows(IllegalArgumentException.class,
                () -> Cal.cal(month1, day1, month2, day2, year));

    }

    // Test if the dates are in the same month, will the code check to see if the
    // days of the month are valid
    // (code should throw Exception)
    @Test
    public void testSameMonthDaysOutOfMaxMonth() {
        int month1 = 2;
        int month2 = 2;
        int day1 = 28;
        int day2 = 31;
        int year = 2023;

        // java.lang.Error
        assertThrows(IllegalArgumentException.class, () -> Cal.cal(month1, day1, month2, day2, year));
    }

    // ********************************
    // Test precondition 5: month1<=month2
    @Test
    public void testDifferentMonth() {
        int month1 = 3;
        int month2 = 4;
        int day1 = 16;
        int day2 = 13;
        int year = 2023;

        int numDays = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(28, numDays);

    }

    // Test precondition 5: month1 should be <= month2
    // (code should throw Exception)
    @Test
    public void testDifferentMonthMonth1GreaterThanMonth2() {
        int month1 = 4;
        int month2 = 3;
        int day1 = 30;
        int day2 = 2;
        int year = 2023;

        assertThrows(IllegalArgumentException.class,
                () -> Cal.cal(month1, day1, month2, day2, year));
    }

    // ********************************
    // Test precondition 6: If the months are the same, day1 <= day2
    // (code should throw Exception)
    @Test
    public void testSameMonthDay1GreaterThanDay2() {
        int month1 = 1; // February
        int month2 = 1; // February
        int year = 1;
        int day1 = 16;
        int day2 = 3;

        assertThrows(IllegalArgumentException.class,
                () -> Cal.cal(month1, day1, month2, day2, year));
    }

    // Test precondition 6: If the months are the same, day1 should be <= day2
    @Test
    public void testSameMonthDay1LessThanDay2() {
        int day1 = 10;
        int day2 = 20;
        int year = 2022;
        int month1 = 4;
        int month2 = 4;

        int numDays = Cal.cal(month1, day1, month2, day2, year);
        assertEquals(10, numDays);

    }

    // ********************************
    // Test precondition 7: 1 <= year <= 10000
    // (code should throw IllegalArgumentException)
    @Test
    public void testYearInCorrectValue1() {
        int month1 = 3;
        int month2 = 4;
        int day1 = 16;
        int day2 = 13;
        int year = 20000;

        assertThrows(
                IllegalArgumentException.class,
                () -> Cal.cal(month1, day1, month2, day2, year));

    }

    // (code should throw IllegalArgumentException)
    @Test
    public void testYearInCorrectValue2() {
        int month1 = 3;
        int month2 = 4;
        int day1 = 16;
        int day2 = 13;
        int year = 0;

        assertThrows(
                IllegalArgumentException.class,
                () -> Cal.cal(month1, day1, month2, day2, year));

    }

    // Test for leap years
    @Test
    public void testForCenturyLeapYear() {
        int month1 = 1;
        int month2 = 2;
        int day1 = 26;
        int day2 = 29;
        int year = 2400;

        assertEquals(34, Cal.cal(month1, day1, month2, day2, year));
    }

    @Test
    public void testForNonCenturyLeapYear() {
        int month1 = 1;
        int month2 = 2;
        int day1 = 26;
        int day2 = 29;
        int year = 2024;

        assertEquals(34, Cal.cal(month1, day1, month2, day2, year));
    }

}
