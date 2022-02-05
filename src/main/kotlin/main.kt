fun main() {
    val masterCard = "MasterCard"
    val maestro = "Maestro"
    val mir = "Мир"
    val visaCard = "Visa"
    val vkPay = "Vk pay"

    val amount = 2_000_000
    val recentPayments = 8_000_000

    result(mir, amount, recentPayments)
    result(masterCard, amount, recentPayments)
    result(vkPay, amount, recentPayments)
}


fun result(cardType: String, amount: Int, recentPayments: Int = 0) {
    when (cardType) {
        "MasterCard" -> masterCardMaestro(amount, recentPayments)
        "Maestro" -> masterCardMaestro(amount, recentPayments)
        "Мир" -> visaMir(amount)
        "Visa" -> visaMir(amount)
        "Vk pay" -> println("Для Vk Pay комиссии нет")
    }
}

fun visaMir(amount: Int) {
    val commissionInPercent = amount / 100 * 0.75
    val commissionСalculation = if (commissionInPercent < 3_500) amount - 3_500 else amount - commissionInPercent
    var result = amount - commissionСalculation.toInt()
    println("Для карт Visa или Mir Комиссия равна $result копейкам")
}

fun masterCardMaestro(amount: Int, recentPayments: Int = 0) {
    if (amount + recentPayments < 7_500_000) {
        println("Для карт Master Card или Maestro до 75 000р в месяц комиссии нет")
    } else {
        val commission = ((amount / 100) * 0.6 + 20).toInt()
        println("Для карт Master Card или Maestro (при превышении месячного лимита в 75 000р) комиссия равна $commission копейкам")
    }
}