class Solution {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        // cumulate sum
        val oneRow = IntArray(grid.size)
        val oneCol = IntArray(grid[0].size)
        val zeroRow = IntArray(grid.size)
        val zeroCol = IntArray(grid[0].size)

        for (i in 0..grid.lastIndex) {
            for (j in 0..grid[i].lastIndex) {
                when (grid[i][j]) {
                    1 -> {
                        oneRow[i]++
                        oneCol[j]++
                    }

                    0 -> {
                        zeroRow[i]++
                        zeroCol[j]++
                    }
                }
            }
        }
        // allocate diff value
        val diff = Array(grid.size) { IntArray(grid[it].size) }

        for (r in 0..grid.lastIndex) {
            for (c in 0..grid[r].lastIndex) {
                diff[r][c] = oneRow[r] + oneCol[c] - zeroRow[r] - zeroCol[c]
            }
        }

        return diff
    }
}