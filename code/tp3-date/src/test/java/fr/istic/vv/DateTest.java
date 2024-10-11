package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @Test
    public void testIsValidDate() {
        assertTrue(Date.isValidDate(1, 1, 2024));
        assertTrue(Date.isValidDate(29, 2, 2024));
        assertFalse(Date.isValidDate(29, 2, 2023));
        assertFalse(Date.isValidDate(31, 4, 2024));
        assertFalse(Date.isValidDate(0, 1, 2024));
        assertFalse(Date.isValidDate(1, 13, 2024));
    }

    @Test
    public void testIsLeapYear() {
        assertTrue(Date.isLeapYear(2024));
        assertFalse(Date.isLeapYear(2023));
        assertTrue(Date.isLeapYear(2000));
        assertFalse(Date.isLeapYear(1900));
    }

    @Test
    public void testNextDate() {
        Date date1 = new Date(28, 2, 2024);
        Date nextDate1 = date1.nextDate();
        assertEquals(29, nextDate1.getDay());
        assertEquals(2, nextDate1.getMonth());
        assertEquals(2024, nextDate1.getYear());

        Date date2 = new Date(31, 12, 2024);
        Date nextDate2 = date2.nextDate();
        assertEquals(1, nextDate2.getDay());
        assertEquals(1, nextDate2.getMonth());
        assertEquals(2025, nextDate2.getYear());
    }

    @Test
    public void testPreviousDate() {
        Date date1 = new Date(28, 2, 2024);
        Date previousDate1 = date1.previousDate();
        assertEquals(27, previousDate1.getDay());
        assertEquals(2, previousDate1.getMonth());
        assertEquals(2024, previousDate1.getYear());

        Date date2 = new Date(1, 1, 2025);
        Date previousDate2 = date2.previousDate();
        assertEquals(31, previousDate2.getDay());
        assertEquals(12, previousDate2.getMonth());
        assertEquals(2024, previousDate2.getYear());
    }

    @Test
    public void testCompareTo() {
        Date date1 = new Date(15, 5, 2024);
        Date date2 = new Date(15, 5, 2024);
        Date date3 = new Date(16, 5, 2024);
        Date date4 = new Date(14, 5, 2024);
        Date date5 = new Date(15, 6, 2024);
        Date date6 = new Date(15, 5, 2025);

        assertEquals(0, date1.compareTo(date2));
        assertTrue(date1.compareTo(date3) < 0);
        assertTrue(date1.compareTo(date4) > 0);
        assertTrue(date1.compareTo(date5) < 0);
        assertTrue(date1.compareTo(date6) < 0);
    }
}