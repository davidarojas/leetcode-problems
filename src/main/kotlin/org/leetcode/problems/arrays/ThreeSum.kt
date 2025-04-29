package org.leetcode.problems.arrays

/**
 * MEDIUM DIFFICULTY
 *
 * ? THOUGHT PROCESS:
 * * 1. We need to sort the array as this makes it easier to use pointers and avoid duplicates.
 * * 2. Then, we can use a for loop to iterate through the array. Inside of that for loop, we will need two extra pointers
 * * (left [index + 1] and right [nums.size - 1]) to work with the current index.
 * * 3. We can then check if the sum of the three numbers is equal to 0. If it is, we can add the triplet to our result list.
 * * * 4. If the sum is less than 0, we need to move the left pointer to the right to increase the sum.
 * * * 5. If the sum is greater than 0, we need to move the right pointer to the left to decrease the sum.
 * * 6. We also need to skip duplicates for all the numbers of the triplets by comparing it with the previous number.
 *
 * ! PATTERN: "Find triplets" means that we need to fix one element and use two pointers to find the other two elements.
 *
 * We need an outer for loop to fix one element, and then an inner while loop to find the other two elements. This way,
 * we TRULY try every single combination of three numbers in the array.
 *
 * This gives us a time complexity of O(n^2) because we have a nested loop.
 * "Sort the array, fix the first number with a for loop, use two pointers with a while loop to find two numbers matching target sum, skip duplicates carefully."
 *
 * i.e. nums = [-1,0,1,2,-1,-4]
 * 1. Sort the array: [-4,-1,-1,0,1,2]
 * 2. Fix the first number: -4
 * 3. Use two pointers to find the other two numbers: -1 and 2
 * 4. Check if the sum is equal to 0: -4 + -1 + 2 = -3 (not equal to 0)
 * 5. Move the left pointer to the right: -1 and 2
 * 6. Check if the sum is equal to 0: -1 + -1 + 2 = 0 (equal to 0)
 * 7. Add the triplet to the result list: [-1, -1, 2]
 * CONTINUE TO FIND OTHER TRIPLETS
 */
class ThreeSum {
    fun main(nums: IntArray): List<List<Int>> {
        // Sort numbers to make it easier to avoid duplicates
        nums.sort()
        val result = mutableListOf<List<Int>>()

        for (index in 0 until nums.size) {
            // Skip duplicates for the firt number of the triplet by comparing with the previous number
            if (index > 0 && nums[index] == nums[index-1]) continue

            // Use two pointers - one starts after the current index and the other at the end of the array
            var left = index + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[index] + nums[left] + nums[right]

                if (sum == 0) {
                    result.add(listOf(nums[index], nums[left], nums[right]))

                    // Increment left and decrement right to find the next unique triplet
                    left++
                    right--

                    // Skip duplicates for the second number of the triplet by comparing with the previous number
                    while (left < right && nums[left] == nums[left - 1]) left++
                    // Skip duplicates for the third number of the triplet by comparing with the previous number
                    while (left < right && nums[right] == nums[right + 1]) right--
                }
                // If the sum is less than 0, we need a larger number, so we move the left pointer to the right
                if (sum < 0) {
                    left++
                }
                // If the sum is greater than 0, we need a smaller number, so we move the right pointer to the left
                else if (sum > 0) {
                    right--
                }
            }
        }

        return result
    }
}