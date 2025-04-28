package org.leetcode.problems.arrays

/**
 * MEDIUM DIFFICULTY
 *
 * ? THOUGHT PROCESS:
 * * Intervals are sorted and non-overlapping initially. This helps us to insert the new interval in a sorted manner, and merge easier.
 * * At each interval, we have 3 possibilities:
 * * 1) Current interval ends BEFORE new interval starts - no overlap, add current interval ([3, 4] < [5, 7])
 * * 2) Current interval starts AFTER new interval ends - no overlap, add new interval ([9, 7] > [6, 3])
 * * 3) Overlapping intervals - merge them by choosing the MIN start and MAX end between the two intervals
 * For this, I can use a mutableList of IntArray to dynamically add the correct intervals as I go. Also, I can use a
 * mutableNewInterval variable to track/update the new interval.
 * - will also make use of Math.min() / Math.max() to merge start/end values easily, choosing the right value between
 * - the new interval and the current interval
 *
 * ! PATTERN: For each interval, if no overlap before, add current interval. If no overlap after, add new interval.
 * ! If overlapped, merge intervals by choosing the MIN start and MAX end between the two intervals.
 *
 * Overlap conditions:
 * interval.start <= new.end && interval.end >= new.start (i.e. [2, 5] and [3, 4] returns [2, 5])
 *
 * This solution is O(n) time complexity and O(n) space complexity, due to the mutableList.
 */
class InsertInterval {
    fun main(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var mutableNewInterval = newInterval

        for (interval in intervals) {
            // Current interval ends BEFORE new interval starts - no overlap, add current interval
            if (interval[1] < mutableNewInterval[0]) {
                result.add(interval)
            } else if (interval[0] > mutableNewInterval[1]) {
                // Current interval starts AFTER new interval ends - no overlap, add new interval
                result.add(newInterval)
                // Update new interval to track current interval that wasn't inserted
                mutableNewInterval = interval
            } else {
                // Overlapping intervals - merge them by choosing the MIN start and MAX end between the two intervals
                mutableNewInterval[0] = Math.min(mutableNewInterval[0], interval[0])
                mutableNewInterval[1] = Math.max(mutableNewInterval[1], interval[1])
            }
        }

        result.add(mutableNewInterval)
        return result.toTypedArray()
    }
}