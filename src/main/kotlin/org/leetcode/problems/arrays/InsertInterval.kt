package org.leetcode.problems.arrays

/**
 * MEDIUM DIFFICULTY
 *
 * ? THOUGHT PROCESS:
 * *
 */
class InsertInterval {
    fun main(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var mutableNewInterval = newInterval

        for (interval in intervals) {
            if (interval[1] < mutableNewInterval[0]) {
                result.add(interval)
            } else if (interval[0] > mutableNewInterval[1]) {
                result.add(newInterval)
                mutableNewInterval = interval
            } else {
                mutableNewInterval[0] = Math.min(mutableNewInterval[0], interval[0])
                mutableNewInterval[1] = Math.max(mutableNewInterval[1], interval[1])
            }
        }

        result.add(mutableNewInterval)
        return result.toTypedArray()
    }
}