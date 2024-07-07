package `in`.sangeet.multiDB.service.impl

import `in`.sangeet.multiDB.dto.Result
import `in`.sangeet.multiDB.dto.Result.*
import `in`.sangeet.multiDB.dto.TransactionDTO
import `in`.sangeet.multiDB.repository.PaymentRepository
import `in`.sangeet.multiDB.model.Transaction
import `in`.sangeet.multiDB.service.PaymentService
import org.springframework.stereotype.Service

@Service
class PaymentServiceImpl(val paymentRepository: PaymentRepository) : PaymentService {

    override fun getTransactions(userId: Long): Result<List<Transaction>> =
         Success(paymentRepository.findByUserId(userId))


    override fun getOneTransaction(userId: Long, id: Long): Result<Transaction> {
        val transaction = paymentRepository.findByUserIdAndId(userId, id)

        transaction ?: return Failure("No transaction found for the user")

        return Success(data = transaction)
    }

    override fun storeTransaction(transaction: TransactionDTO) =
        try {
            val savedTransaction = paymentRepository.save(Transaction(
                userId = transaction.userId,
                amount = transaction.amount,
                payeeAccountId = transaction.payeeAccountId,
                payerAccountId = transaction.payerAccountId
            ))
            Success(data = savedTransaction)
        } catch (exception: Exception) {
            Failure("Saving transaction failed with reason ${exception.localizedMessage}")
        }
}