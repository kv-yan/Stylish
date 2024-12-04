package am.stylish.app.common_data.dao

import am.stylish.app.common_domain.entity.WishedItem
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WishlistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: WishedItem)

    @Update
    suspend fun update(note: WishedItem)

    @Delete
    suspend fun delete(note: WishedItem)

    @Query("DELETE FROM wishlist")
    suspend fun deleteAll()

    @Query("SELECT * FROM wishlist ORDER BY id DESC")
    fun getAllWishedItems(): Flow<List<WishedItem>>
}
