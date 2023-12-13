class Solution {
    fun numSpecial(mat: Array<IntArray>): Int {
        var count = 0
        // calculate cumulated sum
        val rowSum = IntArray(mat.size)
        val colSum = IntArray(mat[0].size)

        for (r in 0..mat.lastIndex) {
            for (c in 0..mat[r].lastIndex) {
                rowSum[r] += mat[r][c]
                colSum[c] += mat[r][c]
            }
        }
        // count special position
        for (r in 0..mat.lastIndex) {
            for (c in 0..mat[r].lastIndex) {
                if ((mat[r][c] == 1) and (rowSum[r] == 1) and (colSum[c] == 1)) {
                    count++
                }
            }
        }
        return count
    }
}