package ir.ariyana.arianabooks.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.ariyana.arianabooks.repository.model.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDatabase: RoomDatabase() {

    abstract val bookDao: BookDao

    companion object {

        @Volatile
        private var database: BookDatabase ?= null

        fun createDatabase(context: Context): BookDatabase {
            synchronized(this) {
                if(database == null) {
                    database = Room
                        .databaseBuilder(
                            context.applicationContext,
                            BookDatabase::class.java,
                            "database"
                        )
                        .build()
                }
            }
            return database!!
        }
    }
}