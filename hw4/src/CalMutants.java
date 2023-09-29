package hw4.src;

// This is a version of the Cal program that contains 20 different injected faults ("mutants")
// Create an instance of the CalMutants class with mutation=0 for the original working version,
// or set mutation to 1..20 to get one of the faulty versions instead.

public class CalMutants {
    private int mutation;

    public CalMutants(int mutation) {
        this.mutation = mutation;
    }

    public int cal(int month1, int day1, int month2, int day2, int year) {
        // ***********************************************************
        // Calculate the number of Days between the two given days in
        // the same year.
        // preconditions : day1 and day2 must be in same year
        // 1 <= month1, month2 <= 12
        // 1 <= day1, day2 <= 31
        // month1 <= month2
        // The range for year: 1 ... 10000
        // ***********************************************************

        int numDays;

        if (month2 == month1) // in the same month
        {
            numDays = day2 - day1;
            if (mutation == 1)
                numDays = day2 % day1;
            else if (mutation == 2)
                numDays = day2;
        }

        else {
            // The first array element is just a placeholder because there is no
            // month zero
            int daysIn[] = { 0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            if (mutation == 3)
                daysIn[8] = 30;
            else if (mutation == 4) {
                daysIn[4] = 31;
                daysIn[5] = 30;
            } else if (mutation == 5)
                daysIn[11] = 31;

            // Are we in a leap year?
            int m4 = year % 4;
            if (mutation == 6)
                m4 = year / 4;

            int m100 = year % 100;
            if (mutation == 7)
                m100 = year / 100;
            else if (mutation == 8)
                m100 = year % 400;

            int m400 = year % 400;
            if (mutation == 9)
                m400 = year + 400;
            else if (mutation == 10)
                m400 = year % 100;

            boolean notLeap = (m4 != 0) || ((m100 == 0) && (m400 != 0));
            if (mutation == 11)
                notLeap = (m4 != 0) || ((m100 == 0) || (m400 != 0));
            else if (mutation == 12)
                notLeap = (m4 != 0) || ((m100 != 0) && (m400 != 0));
            else if (mutation == 13)
                notLeap = (m4 == 0) || ((m100 == 0) && (m400 != 0));
            else if (mutation == 14)
                notLeap = (m4 != 0) && ((m100 == 0) && (m400 != 0));

            if (notLeap) {
                daysIn[2] = 28;
                if (mutation == 15)
                    daysIn[2] = 29;
            } else {
                daysIn[2] = 29;
                if (mutation == 16)
                    daysIn[3] = 29;
            }

            // start with days in the two months
            numDays = day2 + (daysIn[month1] - day1);
            if (mutation == 17)
                numDays = day2 + (daysIn[month1 + 1] - day1);
            else if (mutation == 18)
                numDays = day2 + (daysIn[month1]);

            // add the days in the intervening months
            if (mutation == 19)
                for (int i = month1 + 1; i <= month2; i++)
                    numDays = daysIn[i] + numDays;
            else if (mutation == 20)
                for (int i = month1; i < month2; i++)
                    numDays = daysIn[i] + numDays;
            else
                for (int i = month1 + 1; i < month2; i++)
                    numDays = daysIn[i] + numDays;

        }
        return (numDays);
    }
}
