/**
 * @author Bishal Bhandari
 * CSE 671 (Assignment) Exercise II.b
 */

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

// Class invariant: ensures that month, day, and year are always within valid ranges
@Invariant({
    "month >= 1 && month <= 12",
    "day >= 1 && day <= daysInMonth(month, year)",
    "year > 0"
})
public class Date {
    private int day;
    private int month;
    private int year;

    // Constructor for the Date class
    @Requires({
        "m >= 1 && m <= 12",
        "d >= 1 && d <= daysInMonth(m, y)",
        "y > 0"
    })
    @Ensures({
        "month == m",
        "day == d",
        "year == y"
    })
    public Date(int m, int d, int y) {
        this.month = m;
        this.day = d;
        this.year = y;
    }

    // Returns true if the current Date object is a leap year
    @Ensures("result == (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))")
    public boolean isLeapYear() {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    // Compares the specified Date object with the current Date for equality
    @Requires("d != null")
    @Ensures("result == (this.day == d.day && this.month == d.month && this.year == d.year)")
    public boolean equals(Date d) {
        return this.day == d.day && this.month == d.month && this.year == d.year;
    }

    // Modifies the Date class object to represent the following day
    @Ensures({
        "old(day) == daysInMonth(old(month), old(year)) && old(month) == 12 ? (day == 1 && month == 1 && year == old(year) + 1) : " +
        "old(day) == daysInMonth(old(month), old(year)) ? (day == 1 && month == old(month) + 1 && year == old(year)) : " +
        "(day == old(day) + 1 && month == old(month) && year == old(year))"
    })
    public void tomorrow() {
        if (day < daysInMonth(month, year)) {
            day++;
        } else {
            day = 1;
            if (month == 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
        }
    }

    // Modifies the Date class object to represent the prior day
    @Ensures({
        "old(day) == 1 && old(month) == 1 ? (day == 31 && month == 12 && year == old(year) - 1) : " +
        "old(day) == 1 ? (day == daysInMonth(old(month) - 1, old(year)) && month == old(month) - 1 && year == old(year)) : " +
        "(day == old(day) - 1 && month == old(month) && year == old(year))"
    })
    public void yesterday() {
        if (day > 1) {
            day--;
        } else {
            if (month == 1) {
                month = 12;
                year--;
                day = 31;
            } else {
                month--;
                day = daysInMonth(month, year);
            }
        }
    }

    // Returns the date of the current Date class object in mm:dd:yyyy format
    @Ensures("result.equals(String.format(\"%02d:%02d:%04d\", month, day, year))")
    public String toString() {
        return String.format("%02d:%02d:%04d", month, day, year);
    }

    // Helper method to determine the number of days in the current month and year
    private int daysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (isLeapYear() ? 29 : 28);
            default:
                return 31;
        }
    }
}