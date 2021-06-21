package com.radio.jams

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GitRepository::class], version = 1)
abstract class GitDatabase : RoomDatabase() {

    abstract fun gitDao(): GitDao

    companion object {
        const val dbName = "GitDB"
    }
}
