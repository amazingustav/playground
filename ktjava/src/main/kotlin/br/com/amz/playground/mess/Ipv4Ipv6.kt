package br.com.amz.playground.mess

object Ipv4Ipv6 {

    /**
     * Given a inputted IP address list, it must return another list with the following content:
     * If the actual IP is a Ipv4  -> "IPv4"
     * If the actual IP is a Ipv6  -> "IPv6"
     * If the actual IP is invalid -> "Neither"
     *
     * Complete the 'validateAddresses' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY addresses as parameter.
     */
    fun main(args: Array<String>) {
        val addressesCount = readLine()!!.trim().toInt()

        val addresses = Array(addressesCount) { "" }

        for (i in 0 until addressesCount) {
            val addressesItem = readLine()!!
            addresses[i] = addressesItem
        }

        val result = validateAddresses(addresses)

        println(result.joinToString("\n"))
    }

    private fun validateAddresses(addresses: Array<String>): Array<String> {
        val results = mutableListOf<String>()

        addresses.forEach {
            results.add(
                when {
                    it.contains(":") -> validateIpv6(it)
                    it.contains(".") -> validateIpv4(it)
                    else -> "Neither"
                }
            )
        }

        return results.toTypedArray()
    }

    private fun validateIpv6(ip: String): String {
        TODO("Implement me")
    }

    private fun validateIpv4(ip: String): String {
        var result = true

        ip.split(".").forEach {
            if (it == "") return "Neither"
            //255.003.008.10

            val intElement = it.toInt()

            if (intElement >= 8 && it.startsWith("0")) result = false

            if (intElement in 0..255) result = true
        }

        return if (result) "Ipv4" else "Neither"
    }
}
