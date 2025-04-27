package org.leetcode.problems.arrays

/**
 * ? THOUGHT PROCESS:
 * * It's not about finding a relationship between values in the last, but rather about TRACKING the lowest buy price
 * * and the maximum profit.
 * * - We're always looking at the lowest price seen so far, and the maximum profit seen so far.
 * ! PATTERN: If I'm only scanning FORWARD, tracking trends, comparing best/worst values, I can use tracking variables
 *
 * 1. Again, the important question here is: how can I track the values I NEED as I loop through? Here, I need to remember
 * that the only things that matter are the minimum price, and maximum profit. This will help me to determine the best day
 * to buy and sell stocks. Therefore, we don't need to STORE all past values, just the minimum price and maximum profit.
 *
 * This solution works in O(n) time complexity, and O(1) space complexity, due to the variables we are using.
 *
 * i.e. prices = [7,1,5,3,6,4]
 * -> First loop: 7 is the standard minimum price, and max profit is naturally 0
 * -> Second loop: 1 is the new minimum price, and max profit is still 0
 * -> Third loop: 5 - 1 = 4. This is the new max profit, and min price is still 1
 * -> Fourth loop: 3 - 1 = 2. This is NOT the new max profit nor new min price, so we keep the same values
 * -> Fifth loop: 6 - 1 = 5. This is the NEW max profit (5 > 4), and min price is still 1
 * -> Sixth loop: 4 - 1 = 3. This is NOT the new max profit nor new min price, so we keep the same values
 * -> We return the Max Profit value, which is 5
 */
class MaxProfit {
    fun main(prices: IntArray): Int {
        var minPrice = prices[0]
        var maxProfit = 0

        for (price in prices) {
            if (price < minPrice) {
                minPrice = price
            } else {
                val profit = price - minPrice
                if (profit > maxProfit) {
                    maxProfit = profit
                }
            }
        }

        return maxProfit
    }
}