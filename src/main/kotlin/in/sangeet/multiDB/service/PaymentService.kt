package `in`.sangeet.multiDB.service

import `in`.sangeet.multiDB.dto.TransactionDTO
import `in`.sangeet.multiDB.model.Transaction

interface PaymentService {

    fun getTransactions(userId: Long): `in`.sangeet.multiDB.dto.Result<List<Transaction>>

    fun getOneTransaction(userId: Long, id: Long): `in`.sangeet.multiDB.dto.Result<Transaction>

    fun storeTransaction(transaction: TransactionDTO): `in`.sangeet.multiDB.dto.Result<Transaction>
}