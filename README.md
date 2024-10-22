# Date Class Implementation with Design by Contract

## Overview
This project implements a `Date` class in Java using Design by Contract (DbC) principles with CoFoJa (Contracts for Java). The class models a date with day, month, and year attributes, offering methods to manipulate and compare dates. DbC annotations ensure the validity of operations with preconditions, postconditions, and class invariants.

## Features
- **Date Constructor**: Initialize a `Date` object with day, month, and year values.
- **Leap Year Check**: Determines if the current year is a leap year.
- **Equality Check**: Compares two `Date` objects for equality.
- **Tomorrow Method**: Advances the current date by one day.
- **Yesterday Method**: Moves the current date back by one day.
- **String Representation**: Outputs the date in `mm:dd:yyyy` format.

## Methods

### `public Date(int m, int d, int y)`
Constructor to initialize the `Date` object with specified month, day, and year.

### `public boolean isLeapYear()`
Returns `true` if the year of the current `Date` object is a leap year.

### `public boolean equals(Date d)`
Checks if the current `Date` object is equal to another `Date` object.

### `public void tomorrow()`
Advances the `Date` object to represent the next day.

### `public void yesterday()`
Moves the `Date` object to represent the previous day.

### `public String toString()`
Returns a string representation of the `Date` object in the format `mm:dd:yyyy`.

## Design by Contract (DbC)
Each method is annotated with CoFoJa syntax to ensure:
- **@Invariant**: Ensures the class's internal state remains consistent.
- **@Requires**: Specifies the preconditions for method execution.
- **@Ensures**: Specifies the postconditions after method execution.

These annotations help in identifying invalid inputs and ensure method correctness.

## Testing
A separate test class `DateTest.java` is provided to validate the functionality of the `Date` class. This class tests:
- Correctness of method implementations.
- Triggering of `@Requires` and `@Ensures` conditions.
- Proper formatting and handling of edge cases.

## How to Run
1. Compile the `Date.java` class with CoFoJa enabled.
2. Use the `DateTest.java` class to test the functionality of the `Date` class.

## Requirements
- **Java version**: 8 or later.
- **CoFoJa Library**: Install and configure the CoFoJa library to support DbC annotations.

## Notes
- **Do not use the standard Java Date class** in this implementation.
