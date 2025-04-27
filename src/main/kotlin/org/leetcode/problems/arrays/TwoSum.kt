package org.leetcode.problems.arrays

/**
 *
 * ? THOUGHT PROCESS:
 * * This is about finding a relationship between two numbers in an array, to see if they add up to a target value. This may
 * * involve looking at numbers in the past, to find a complement value.
 * ! PATTERN: If I need to check that a matching value exists in the past, finding something that happened, I can use a map or a set
 *
 * 1. The ideal solution is to find a way to track what I've ALREADY SEEN throughout the array. Since in this
 * case, I need to check all values in some way to see which ones add up to the target. In this way, I can see if
 * target - index[1] == index[0], for example.
 *
 * 2. For this, a hash map helps to store k, v pairs. If I'm able to find the complement value in the hash map,
 * that means I found the pair that adds up to the target. If not, I add it to the map and continue to the next number.
 *
 * This is O(n) time complexity and O(n) space complexity, due to the hash map.
 *
 * i.e. [2, 7, 11, 15], target = 9
 * -> First loop: 9 - 2 = 7. This number 7 is not in the map, so I add 2 to the map
 * -> Second loop: 9 - 7 = 2. This number 2 IS in the map, so I return the index of 2 and 7 because they add to 9
 */
class TwoSum {
    fun main(nums: IntArray, target: Int): IntArray {
        val hashMap = HashMap<Int, Int>()

        nums.forEachIndexed { index, num ->
            val complement = target - num
            if (hashMap.containsKey(complement)) {
                return intArrayOf(hashMap[complement]!!, index)
            }
            hashMap[num] = index
        }

        throw Exception("No two sum can be found with the current array.")
    }
}