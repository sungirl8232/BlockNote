package com.block.note.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var title: String? = null,
    var content: String,
    var parentFolderId: Int? = null,
    var isNeedPassword: Boolean = false
    var updatedAt: Long
)