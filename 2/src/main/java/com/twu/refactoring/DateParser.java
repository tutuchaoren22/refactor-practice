package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<>();
    private static final String STRING_LESS_THAN_CHARACTERS = "%s string is less than %d characters";
    private static final String STRING_IS_NOT_AN_INTEGER = "%s is not an integer";
    private static final String CANNOT_BE_LESS_THEN_OR_MORE_THEN = "%s cannot be less than %d or more than %d";


    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(getYear(), getMonth() - 1, getDate(), getHour(), getMinute(), 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public int getYear() {
        return getIntFromString(0, 4, "Year", 4, 2000, 2012);
    }

    public int getMonth() {
        return getIntFromString(5, 7, "Month", 2, 1, 12);
    }

    public int getDate() {
        return getIntFromString(8, 10, "Date", 2, 1, 31);
    }

    public int getHour() {
        int hour;
        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
        } else {
            hour = getIntFromString(11, 13, "Hour", 2, 0, 23);
        }
        return hour;
    }

    public int getMinute() {
        int minute;
        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            minute = 0;
        } else {
            minute = getIntFromString(14, 16, "Minute", 2, 0, 59);
        }
        return minute;
    }

    public int getIntFromString(int indexBegin, int indexEnd, String type, int characters, int lessThan, int moreThan) {
        int resultInt;
        try {
            String subString = dateAndTimeString.substring(indexBegin, indexEnd);
            resultInt = Integer.parseInt(subString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format(STRING_LESS_THAN_CHARACTERS, type, characters));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(STRING_IS_NOT_AN_INTEGER, type));
        }
        if (resultInt < lessThan || resultInt > moreThan) {
            throw new IllegalArgumentException(String.format(CANNOT_BE_LESS_THEN_OR_MORE_THEN, type, lessThan, moreThan));
        }
        return resultInt;
    }
}
