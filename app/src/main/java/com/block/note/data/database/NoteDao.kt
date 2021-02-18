package com.block.note.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.block.note.data.entity.Note
import com.block.note.data.entity.NoteFolderItem

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertNoteFolder(folder: NoteFolderItem.Folder)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertNote(note: Note)

    @Query("DELETE FROM note WHERE id=:id LIMIT 1")
    suspend fun deleteNoteById(id: Int)

    @Query("SELECT * FROM folder ORDER BY updatedAt DESC")
    suspend fun getAllFolders(): List<NoteFolderItem.Folder>

    @Query("SELECT * FROM note WHERE parentFolderId=:parentId")
    suspend fun getAllNoteByParentId(parentId: Int?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)
}