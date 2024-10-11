# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

1. 
isValidDate(int day, int month, int year) :
Characteristics : 
- Checks the boundaries for the year, month, and day.
- Takes into account whether it's a leap year when determining the days in February.
- The leap year check is shared with the isLeapYear method.
Blocks :
- Verifies that the year is at least 1, the month is between 1 and 12, and the day is at least 1.
- Uses an array to store the number of days for each month, adjusting for February in leap years.

isLeapYear(int year) :
Characteristics : 
- Determines if a year is a leap year based on divisibility rules.
- This leap year calculation logic is used in the isValidDate method.
Blocks :
- Divisible by 4 but not by 100, or divisible by 400.

nextDate() :
Characteristics : 
- Calculates the next day, month, and year.
- Leap year check
Blocks :
- Adjusts the day, and if necessary, the month or year

previousDate() :
Characteristics : 
- Calculates the previous day, month, and year.
- Leap year check
Blocks :
- Adjusts the day, and if necessary, the month or year

compareTo() :
Characteristics : 
- Check if the date is null
- Compares two Date objects by there year, months and day to determine their relative order
Blocks :
- Compares the year fields of the two dates first
- If the years are the same, it compares the month fields
- If both the year and month fields are the same, it finally compares the day fields

2. 
After evaluating the test cases coverage and adding some tests to improve the initial coverage, we get a score of 92%.
To do this, we launch the test coverage with VSCode, this indicates the score and the areas where the code passes or does not pass. It is thanks to this visualization that we can create new tests to test the areas of non-coverage.

3. 
There isn't any predicate that uses more than two boolean operators in that class.

4. 
