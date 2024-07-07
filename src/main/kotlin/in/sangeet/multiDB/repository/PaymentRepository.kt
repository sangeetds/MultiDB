package `in`.sangeet.multiDB.repository

import `in`.sangeet.multiDB.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository : JpaRepository<Transaction, Long> {

    fun findByUserIdAndId(userId: Long, id: Long): Transaction?

    fun findByUserId(userId: Long): List<Transaction>
}