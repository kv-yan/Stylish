package am.stylish.app.common_domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wishlist")
data class WishedItem(
    @PrimaryKey val id: String,
)
