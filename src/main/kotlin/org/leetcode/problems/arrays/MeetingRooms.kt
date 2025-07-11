package org.leetcode.problems.arrays

/**
 * EASY DIFFICULTY
 *
 * ? THOUGHT PROCESS:
 * * I don't need to remember EVERY past meeting interval here, but rather, just compare end time of the previous
 * * meeting to the start time of the current meeting.
 *
 * I only care about ordering and direct comparison AFTER SORTING (just like time of day).
 *
 * ! PATTERN: If I'm only scanning FORWARD, tracking trends, comparing best/worst values, I can use tracking variables
 *
 * This would be O(n log n) time complexity due to the sorting, and O(1) space complexity since I don't need a hash map or set
 *
 * i.e. [[0, 30], [5, 10], [15, 20]] (after sorting)
 * -> First loop: [0, 30] and [5, 10]. 5 < 30, so return false
 */
class MeetingRooms {
    fun main(intervals: List<Interval?>): Boolean {
        // Sort is NEEDED to organize the meeting times properly
        intervals.sortedBy { it?.start }

        for (i in 1 until intervals.size) {
            val previousEnd = intervals[i - 1]!!.end

            if (intervals[i]!!.start < previousEnd) {
                return true
            }
        }

        return false
    }
}

data class Interval(val start: Int, val end: Int)