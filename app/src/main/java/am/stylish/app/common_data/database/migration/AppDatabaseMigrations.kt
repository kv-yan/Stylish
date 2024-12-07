package am.stylish.app.common_data.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


class AppDatabaseMigrations {
    companion object {
        val App_Database_MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Create the new Cart table
                database.execSQL(
                    """
            CREATE TABLE IF NOT EXISTS `cart` (
                `id` TEXT NOT NULL, 
                `quantity` INTEGER NOT NULL, 
                PRIMARY KEY(`id`)
            )
            """
                )
            }
        }
    }
}
