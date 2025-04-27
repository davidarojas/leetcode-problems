package org.leetcode.problems.arrays

/**
 * EASY DIFFICULTY
 *
 * ? THOUGHT PROCESS:
 * * I DO NOT need to store previous elements for lookup nor tracking. Instead, it's just about keeping track of where
 * * the NEXT non-zero element should go.
 *
 * For this, I can use pointers to track the current index and where the next non-zero index should go.
 * As I find non-zero elements, I can swap them with the current index and THEN increment the current index.
 *
 * This is O(n) time complexity, and O(1) space complexity with no data structures.
 *
 * ! PATTERN: When I need to move elements that match a condition to the front/back while maintaining order, I can use a
 * ! two-pointer pattern: one for scanning, one for inserting - and swap only when needed, which is dependent on insertPosition.
 *
 * i.e. nums = [0,1,0,3,12]
 * -> First loop, nothing happens because the first element is 0
 * -> Second loop, 1 is not 0, so I swap it with insertPosition = 0, resulting in [1,0,0,3,12]
 * -> Third loop, nothing happens because the second element is 0
 * -> Fourth loop, 3 is not 0, so I swap it with insertPosition = 1, result in [1, 3, 0, 0, 12]
 * -> Fifth loop, 12 is not 0, so I swap it with insertPosition = 2, resulting in [1, 3, 12, 0, 0]
 */
class MoveZeroes {
    fun main(nums: IntArray) {
        var insertPosition = 0

        nums.forEachIndexed { index, num ->
            if (num != 0) {
                // Only swap if index is different from the insertPosition
                if (index != insertPosition) {
                    val temp = nums[insertPosition]
                    nums[insertPosition] = nums[index]
                    nums[index] = temp
                }
                insertPosition++
            }
        }
    }
}