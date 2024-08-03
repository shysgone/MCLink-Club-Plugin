package org.mclink.mclinkclub.util;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class GenUtils {


    public static String banMessage(String expiry, String reason) {
        return "&4You have been banned from the server.\n" +
                "&4Reason: &c" + reason + "\n" +
                "&4Duration: &c" + expiry + "\n" +
                "&4If you believe this is a mistake, please appeal on our discord server.";
    }

    public static Map<TimeUnit,Long> computeDiff(Date date1, Date date2) {
        long diffInMillies = date2.getTime() - date1.getTime();
        List<TimeUnit> units = new ArrayList<TimeUnit>();
        units.add(TimeUnit.DAYS);
        units.add(TimeUnit.HOURS);
        units.add(TimeUnit.MINUTES);

        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;
        for ( TimeUnit unit : units ) {
            long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit,diff);
        }
        return result;
    }
}
