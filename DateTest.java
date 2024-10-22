public class DateTest {
    public static void main(String[] args) {
        // Test constructor and toString
        Date d1 = new Date(12, 31, 2023);
        System.out.println("Date 1: " + d1.toString());

        // Test isLeapYear
        System.out.println("Is 2023 a leap year? " + d1.isLeapYear());

        // Test equals
        Date d2 = new Date(12, 31, 2023);
        System.out.println("d1 equals d2? " + d1.equals(d2));

        // Test tomorrow
        d1.tomorrow();
        System.out.println("Date 1 after tomorrow: " + d1.toString());

        // Test yesterday
        d1.yesterday();
        System.out.println("Date 1 after yesterday: " + d1.toString());

        // Test edge cases
        Date leapYear = new Date(2, 28, 2024);
        System.out.println("Leap year date: " + leapYear.toString());
        leapYear.tomorrow();
        System.out.println("Leap year date after tomorrow: " + leapYear.toString());

        // Test invalid dates (should throw exceptions due to CoFoJa annotations)
        try {
            Date invalid = new Date(13, 1, 2023); // Invalid month
        } catch (Exception e) {
            System.out.println("Caught exception for invalid month: " + e.getMessage());
        }

        try {
            Date invalid = new Date(2, 30, 2023); // Invalid day for February
        } catch (Exception e) {
            System.out.println("Caught exception for invalid day: " + e.getMessage());
        }
    }
}
