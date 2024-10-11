package fr.istic.vv;

class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        assert isValidDate(day, month, year) : "La date est invalide";
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }
        int[] daysInMonth = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //nb de jour dans chaque mois
        return day <= daysInMonth[month - 1];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public Date nextDate() {
        int newDay = day;
        int newMonth = month;
        int newYear = year;
        int[] daysInMonth = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        newDay++;
        if (newDay > daysInMonth[month - 1]) {
            newDay = 1;
            newMonth++;
            if (newMonth > 12) {
                newMonth = 1;
                newYear++;
            }
        }
        return new Date(newDay, newMonth, newYear);
    }

    public Date previousDate() {
        int newDay = day;
        int newMonth = month;
        int newYear = year;
        int[] daysInMonth = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        newDay--;
        if (newDay < 1) {
            newMonth--;
            if (newMonth < 1) {
                newMonth = 12;
                newYear--;
            }
            newDay = daysInMonth[newMonth - 1];
        }
        return new Date(newDay, newMonth, newYear);
    }

    public int compareTo(Date other) {
        assert other != null : "La date est vide";
        if (this.year != other.year) {
            return this.year - other.year;
        } else if (this.month != other.month) {
            return this.month - other.month;
        } else {
            return this.day - other.day;
        }
    }

    public int getDay(){
        return this.day;
    }
    
    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }
}