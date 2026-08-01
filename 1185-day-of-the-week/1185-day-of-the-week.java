class Solution {
    public String dayOfTheWeek(int day, int month, int year) {

        String[] week = {
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday"
        };

        int[] months = {
            31,28,31,30,31,30,
            31,31,30,31,30,31
        };

        int days = 0;

        for (int y = 1971; y < year; y++) {
            if (isLeap(y))
                days += 366;
            else
                days += 365;
        }

        for (int i = 0; i < month - 1; i++) {
            days += months[i];
        }
        if (isLeap(year) && month > 2)
            days++;

        days += day;

        return week[days % 7];
    }

    private boolean isLeap(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}