package am.stylish.app.common_domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartItem(
    @PrimaryKey val id: String,
    val quantity: Int = 1,
)
