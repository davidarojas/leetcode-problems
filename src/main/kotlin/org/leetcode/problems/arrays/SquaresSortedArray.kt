package org.leetcode.problems.arrays

/**
 * EASY DIFFICULTY
 *
 * ? THOUGHT PROCESS:
 * * Squaring the numbers is easy as I can just loop through and do that, but I need to think about the sorting too.
 * * The key here is that the problem states: "Given an integer array nums sorted in non-decreasing order". Since the
 * * array is initially sorted, I can use that, because it means, when squared, the left and right sides will have the
 * * largest values (due to negatives squaring to positive).
 *
 * ! PATTERN: If the input has structure (like sorted order), think about using two pointers or smarter traversal to avoid O(n log n) sort function.
 * ! "The input is sorted, so I'll try a two-pointer approach to avoid re-sorting and get an O(n) solution."
 *
 * While I can certainly use map and sort in-built functions, it's not the BEST solution.
 *
 * i.e. nums = [-4,-1,0,3,10]
 * -> After first loop, it becomes [_, _, _, _, 100]
 * -> After second loop, it becomes [_, _, _, 16, 100]
 * -> After third loop, it becomes [_, _, 9, 16, 100]
 * -> After fourth loop, it becomes [_, 1, 9, 16, 100]
 * -> After fifth loop, it becomes [0, 1, 9, 16, 100]
 */
class SquaresSortedArray {
    fun main(nums: IntArray): IntArray {
        // 1st solution - Using in-built map and sort functions (O(n log n))
//        val squares = nums.map { it * it }.toIntArray()
//        squares.sort()
//
//        return squares

        // 2nd solution - Using two pointers to square and compare values as we go (O(n))
        val sorted = IntArray(nums.size)
        var largePosition = nums.size - 1
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val leftSq = nums[left] * nums[left]
            val rightSq = nums[right] * nums[right]

            if (leftSq > rightSq) {
                sorted[largePosition] = leftSq
                left++
            } else {
                sorted[largePosition] = rightSq
                right--
            }
            largePosition--
        }

        return sorted
    }
}