package org.leetcode.problems.arrays

/**
 * EASY DIFFICULTY
 *
 * ? THOUGHT PROCESS:
 * Instantly, the first solution that came to mind was to use a hash map to count the number of times each number
 * appears in the list.
 *
 * This was a good O(n) time complexity solution with O(n) space complexity since I keep adding +1 to the hash map for each number I see.
 *
 * * HOWEVER, I found out there was an even BETTER O(1) space complexity solution using the Boyer-Moore Voting Algorithm.
 * * This is because this problem is about tracking dominance over time (like an election), to see which number along
 * * the way has the most occurrences. This is more about tracking than looking at the past values.
 *
 * ! PATTERN: Map not needed if verification isn't important - just COUNT and then track the dominant value
 *
 * i.e. nums = [2,2,1,1,1,2,2]
 */
class MajorityElement {
    fun main(nums: IntArray): Int {
        // ! 1st solution - Hash Map
//        val hashMap = HashMap<Int, Int>()
//
//        nums.forEach { num ->
//            hashMap[num] = hashMap.getOrDefault(num, 0) + 1
//        }
//
//        return hashMap.maxByOrNull { it.value }!!.key

        // ! 2nd solution - Boyer-Moore Voting Algorithm
        var count = 0
        var candidate = 0

        for (num in nums) {
            if (count == 0) {
                candidate = num
            }

            count += if (num == candidate) 1 else -1
        }

        return candidate
    }
}