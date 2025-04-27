package org.leetcode.problems.arrays

/**
 * EASY DIFFICULTY
 *
 * ? THOUGHT PROCESS:
 * * Immediately, my first thought was either hash map or hash set, because here I need to check what I have already
 * * seen in the array, to check if I have duplicates. This is different from using variables because I need to keep
 * * track of past values, not just what's currently happening.
 *
 * ! PATTERN: If I need to check that a matching value exists in the past, finding something that happened, I can use a map or a set
 *
 * This solution is O(n) time complexity and O(n) space complexity, due to the hash set.
 *
 * i.e. [1,2,3,1]
 * -> First 3 loops, none of the values are in the hashSet, so I add it into the hashSet
 * -> 4th loop, I see 1 is already in the hashSet, so I return true
 */
class ContainsDuplicate {
    fun main(nums: IntArray): Boolean {
        val hashSet = HashSet<Int>()

        nums.forEach { num ->
            if (hashSet.contains(num)) {
                return true
            }

            hashSet.add(num)
        }
        return false
    }
}