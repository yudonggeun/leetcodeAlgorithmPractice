import java.util.LinkedList

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) }
        dp[0][0] = 1;

        val queue = LinkedList<Point>()
        queue.add(Point(0, 0))
        val visit = HashSet<Point>()

        while (queue.isNotEmpty()) {
            val point = queue.poll()
            if ((visit.contains(point)) or (isRange(point.r, point.c, m, n).not())) {
                continue
            }
            visit.add(point)

            val caseCount = dp[point.r][point.c]

            if (isRange(point.r + 1, point.c, m, n)) {
                dp[point.r + 1][point.c] += caseCount
                val next = Point(point.r + 1, point.c)
                queue.add(next)
            }
            if (isRange(point.r, point.c + 1, m, n)) {
                dp[point.r][point.c + 1] += caseCount
                val next = Point(point.r, point.c + 1)
                queue.add(next)
            }
        }

        return dp.last().last()
    }

    data class Point(val r: Int, val c: Int)

    fun isRange(r: Int, c: Int, m: Int, n: Int): Boolean = when {
        r < -1 -> false
        c < -1 -> false
        r >= m -> false
        c >= n -> false
        else -> true
    }
}