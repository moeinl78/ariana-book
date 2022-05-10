package ir.ariyana.arianabooks.repository

import ir.ariyana.arianabooks.repository.local.BookDao
import ir.ariyana.arianabooks.repository.model.Book
import ir.ariyana.arianabooks.repository.remote.ServiceAPI
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val retrofitAPI: ServiceAPI,
    private val bookDAO: BookDao
) {

    suspend fun getBooksOverview() =
        retrofitAPI.getBooksOverview()

    suspend fun requestInsertion(book: Book) =
        bookDAO.requestInsertion(book)

    suspend fun requestDeletion(book: Book) =
        bookDAO.requestDeletion(book)

    suspend fun requestBooks() =
        bookDAO.requestBooks()
}