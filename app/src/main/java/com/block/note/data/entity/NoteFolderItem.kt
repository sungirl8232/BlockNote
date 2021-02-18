package com.block.note.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class NoteFolderItem {

    @Entity(tableName = "folder")
    data class Folder(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        var title: String,
        var updatedAt: Long
    ) : NoteFolderItem()

    data class NoteShort(
        val id: Int,
        val title: String?,
        val content: String,
        val parentFolderId: Int?,
        var isNeedPassword: Boolean = false,
        val updatedAt: Long
    ) : NoteFolderItem()
}