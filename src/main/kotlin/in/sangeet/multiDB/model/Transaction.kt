package `in`.sangeet.multiDB.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import java.time.LocalDateTime

@Entity
data class Transaction(

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,

    val userId: Long,

    val amount: Double,

    val payeeAccountId: String,

    val payerAccountId: String,

    val transactionTimeStamp: LocalDateTime? = null
)