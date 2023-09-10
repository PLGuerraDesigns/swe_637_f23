// NAMES: Pablo Guerra, Vishnu Neduncheliyan, Sharadha Shivakumar, Katherine Soltani
// Assignment - Module 3

package hw1.src;

public class Cal {
    public static int cal(int month1, int day1, int month2,
            int day2, int year) {
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
        // ***********************************************************

        if (month1 < 1 || month1 > 12 || month2 < 1 || month2 > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }

        if (year < 1 || year > 10000) {
            throw new IllegalArgumentException("Year must be between 1 and 10000");
        }

        if (month1 > month2) {
            throw new IllegalArgumentException("End date must be greater than start date");
        }

        // The first array element is just a placeholder
        // because there is no month zero
        int daysIn[] = { 0, 31, 0, 31, 30, 31, 30, 31, 30, 30, 31, 30, 31 };
        // Are we in a leap year?
        int m4 = year % 4;
        int m100 = year % 100;

        // int m400 = year / 400; **** FAULT!
        int m400 = year % 400; // changes

        // LEAP YEAR CONDITIONS
        // the year is multiple of 400.
        // The year is a multiple of 4 and not a multiple of 100.

        // if ((m4 != 0) || ((m100 == 0) || (m400 != 0))) **** FAULT!
        if (((m4 == 0) && (m100 != 0)) || (m400 == 0)) // changes
            daysIn[2] = 29;
        else
            daysIn[2] = 28;

        if (day1 < 1 || day2 < 1 || day1 > daysIn[month1] || day2 > daysIn[month2]) {
            throw new IllegalArgumentException("Day of the month must be within valid number of days in the month");
        }

        int numDays;

        if (month2 == month1) { // in the same month
            if (day1 > day2) {
                throw new IllegalArgumentException("End date must be greater than start date");
            } else {
                // numDays = day2 % day2; ****FAULT!
                numDays = day2 - day1;
            }
        } else {
            // start with days in the two months
            numDays = day2 + (daysIn[month1] - day1);

            // add the days in the intervening months

            // for(int i = month1 + 1; i <= month2; i++) **** FAULT!
            for (int i = month1 + 1; i < month2; i++)
                numDays = daysIn[i] + numDays;
        }
        return (numDays);
    }
}