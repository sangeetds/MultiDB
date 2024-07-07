package `in`.sangeet.multiDB.dto


data class TransactionDTO(
    val userId: Long,
    val amount: Double,
    val payeeAccountId: String,
    val payerAccountId: String,
)
