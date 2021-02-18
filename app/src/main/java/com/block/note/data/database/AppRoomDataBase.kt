package com.block.note.data.database

import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.RoomDatabase
import com.block.note.data.entity.Note
import com.block.note.data.entity.NoteFolderItem

@Database(
    entities = [
        Note::class,
        NoteFolderItem.Folder::class
    ],
    version = 3,
    exportSchema = false
)

abstract class AppRoomDataBase: RoomDatabase() {
}