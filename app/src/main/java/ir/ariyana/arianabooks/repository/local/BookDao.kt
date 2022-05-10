package ir.ariyana.arianabooks.repository.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ir.ariyana.arianabooks.repository.model.Book

@Dao
interface BookDao {

    @Insert(onConflict = REPLACE)
    suspend fun requestInsertion(book: Book)

    @Delete
    suspend fun requestDeletion(book: Book)

    @Query("SELECT * FROM table_book")
    fun requestBooks(): LiveData<List<Book>>
}