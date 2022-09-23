package br.com.amz.playground.mess

/**
 * Minesweeper is a game originating from the 1960’s where players reveal information by inspecting locations on a
 * playing area to attempt to deduce the locations of mines, without inspecting the mines themselves.
 */
object Minesweeper {

    /**
     * Given an input grid of mine locations, for each non-mine location compute the count of adjacent locations
     * containing mines of the 8 neighboring grid locations.
     *
     * E.g. input (1 -> mine, 0 -> free):
     * 1 0 0 0
     * 0 0 1 0
     * 0 1 0 0
     * 0 0 0 0
     *
     * result (-1 -> mine, others -> adjacent amount):
     * -1  2  1  1
     *  1  3 -1  1
     *  1 -1  2  1
     *  1  1  1  0
     *
     * So if the input is the grid above, and the coordinates were 0 and 1 (line, column), the output must be 2.
     **/
    fun main(args: Array<String>){
        val input = listOf(
            listOf(1, 0, 0, 0),
            listOf(0, 0, 1, 0),
            listOf(0, 1, 0, 0),
            listOf(0, 0, 0, 0)
        )

        val coordinateX = 0
        val coordinateY = 1

        val result = discoveryMines(input, coordinateX, coordinateY)

        print(result)
    }

    while a user is downloading a file which is X bytes in size

    private fun discoveryMines(input: List<List<Int>>, coordX: Int, coordY: Int): Int {
        var adjacents = 0

        val line = input[coordX]
        val field = line[coordY]

        if (field == 1) return -1

        if (coordX > 0) {
            repeat(input[coordX - 1].size) {
                if (coordY > 0) line[coordY - 1]
            }
        }

        return adjacents
    }
}
