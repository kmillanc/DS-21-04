package e3;

import java.time.Period;
import java.lang.IllegalArgumentException;

public class Clock {

    /**
     * Creates a Clock instance parsing a String .
     * @param s The string representing the hour in 24h format (17:25:15) or in
     * 12h format (05:25:15 PM ).
     * @throws IllegalArgumentException if the string is not a valid hour .
     */

    public Clock(String s){

        throw new IllegalArgumentException("The String is not a valid hour");
    }

    /**
     * Creates a clock given the values in 24h format .
     * @param hours Hours in 24h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */

    public Clock(int hours, int minutes, int seconds){

        throw new IllegalArgumentException("The value is not a valid hour");
    }

    /**
     * Creates a clock given the values in 12h format . Period is a enumeration
     * located inside the Clock class with two values : AM and PM.
     * @param hours Hours in 12h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @param period Period used by the Clock ( represented by an enum ).
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */

    public Clock(int hours, int minutes, int seconds, Period period){

        throw new IllegalArgumentException("The value is not a valid hour");
    }

    /**
     * Returns the hours of the clock in 24h format
     * @return the hours in 24h format
     */

    public int getHours24(){

    }

    /**
     * Returns the hours of the clock in 12h format
     * @return the hours in 12h format
     */

    public int getHours12(){

    }

    /**
     * Returns the minutes of the clock
     * @return the minutes
     */

    public int getMinutes(){

    }

    /**
     * Returns the seconds of the clock .
     * @return the seconds .
     */

    public int getSeconds(){

    }

    /**
     * Returns the period of the day (AM or PM) that the clock is representing
     * @return An instance of the Clock . Period enum depending if the time is
     * before noon (AM) or after noon (PM ).
     */

    public int getPeriod(){

    }

    /**
     * Prints a String representation of the clock in 24h format .
     * @return An string in 24h format
     * @see String . format function to format integers with leading zeroes
     */

    public String printHour24(){

    }

    /**
     * Prints a String representation of the clock in 12h format .
     * @return An string in 12h format
     * @see String . format function to format integers with leading zeroes
     */

    public String printHour12(){

    }

    /**
     * Performs the equality tests of the current clock with another clock
     * passed as a parameter . Two clock are equal if they represent the same
     * instant regardless of being in 12h or 24h format .
     * @param o The clock to be compared with the current clock .
     * @return true if the clocks are equals , false otherwise .
     */

    @Override
    public boolean equals(Object o){

    }

    /**
     * Returns a integer that is a hash code representation of the clock using
     * the " hash 31" algorithm .
     * Clocks that are equals must have the same hash code .
     * @return the hash code
     */

    @Override
    public int hashCode(){

    }
}
