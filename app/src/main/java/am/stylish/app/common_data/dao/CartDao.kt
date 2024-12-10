package am.stylish.app.common_data.dao

import am.stylish.app.common_domain.entity.CartItem
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: CartItem)

    @Delete
    suspend fun delete(note: CartItem)

    @Update
    suspend fun update(note: CartItem)

    @Query("SELECT * FROM cart ORDER BY id DESC")
    fun getAllWishedItems(): Flow<List<CartItem>>
}
