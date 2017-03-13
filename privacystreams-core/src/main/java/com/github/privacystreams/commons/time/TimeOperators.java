package com.github.privacystreams.commons.time;

import com.github.privacystreams.core.Function;
import com.github.privacystreams.core.Item;
import com.github.privacystreams.utils.annotations.PSOperatorWrapper;

/**
 * A helper class to access time-related functions
 */
@PSOperatorWrapper
public class TimeOperators {

    /**
     * Check whether the timestamp value of a field is after a given timestamp.
     *
     * @param timestampField the name of the timestamp field
     * @param timestampToCompare the timestamp to compare
     * @return the predicate
     */
    public static Function<Item, Boolean> since(final String timestampField, final Long timestampToCompare) {
        return new TimeSincePredicate(timestampField, timestampToCompare);
    }

    /**
     * Check whether the timestamp field value of a field is recent from now (less than a given duration).
     *
     * @param timestampField the name of the timestamp field
     * @param duration the millisecond duration from now
     * @return the predicate
     */
    public static Function<Item, Boolean> recent(final String timestampField, final Long duration) {
        return new TimeRecentPredicate(timestampField, duration);
    }
}