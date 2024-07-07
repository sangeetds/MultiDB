package `in`.sangeet.multiDB

import `in`.sangeet.multiDB.dto.TransactionDTO
import `in`.sangeet.multiDB.service.PaymentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PaymentController(val paymentService: PaymentService) {

    @GetMapping(path = ["/{userId}/transaction/{id}"])
    fun viewTransaction(@PathVariable userId: Long, @PathVariable id: Long) =
        paymentService.getOneTransaction(userId = userId, id = id)

    @GetMapping(path = ["/{userId}/transactions"])
    fun viewAllTransaction(@PathVariable userId: Long) =
        paymentService.getTransactions(userId)

    @PostMapping(path = ["/{userId}/transaction"])
    fun storeTransaction(@PathVariable userId: Long, @RequestBody transaction: TransactionDTO) =
        paymentService.storeTransaction(transaction = transaction)
}