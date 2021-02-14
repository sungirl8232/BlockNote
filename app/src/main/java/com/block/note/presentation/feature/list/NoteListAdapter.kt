package com.block.note.presentation.feature.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.block.note.R
import com.block.note.data.entity.NoteFolderItem
import com.block.note.data.entity.NoteFolderItem.*
import com.block.note.presentation.utils.DateUtils


class NoteListAdapter(val callback: Callback) :
    PagingDataAdapter<NoteFolderItem, RecyclerView.ViewHolder>(NOTE_LIST_COMPARATOR) {

    private var selectedViewType: ViewType = ViewType.LIST_MODE

    companion object {
        private val NOTE_LIST_COMPARATOR =
            object : DiffUtil.ItemCallback<NoteFolderItem>() {
                override fun areItemsTheSame(
                    oldItem: NoteFolderItem,
                    newItem: NoteFolderItem
                ): Boolean = oldItem == newItem

                override fun areContentsTheSame(
                    oldItem: NoteFolderItem,
                    newItem: NoteFolderItem
                ): Boolean = newItem == oldItem
            }
    }

    fun setViewType(type: ViewType) {
        selectedViewType = type
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (selectedViewType) {
            ViewType.LIST_MODE -> {
                NoteListModeViewHolder(LayoutInflater.from(parent.context), parent)
            }
            else -> {
                NoteModelModeViewHolder(LayoutInflater.from(parent.context), parent)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position) ?: return
        if(holder is NoteListModeViewHolder){
            holder.bind(item)
        } else if(holder is NoteModelModeViewHolder){
            holder.bind(item)
        }
    }

    class NoteListModeViewHolder internal constructor(
        inflater: LayoutInflater,
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(
        inflater.inflate(R.layout.item_note_list_mode, parent, false)
    ) {
        private val acivIcon: AppCompatImageView = itemView.findViewById(R.id.acivIcon)
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvUpdatedAt: TextView = itemView.findViewById(R.id.tvUpdatedAt)
        private val acivMenu: AppCompatImageView = itemView.findViewById(R.id.acivMenu)
        fun bind(item: NoteFolderItem) {
            when(item) {
                is Folder -> {
                    bindFolder(item)
                }
                is NoteShort -> {
                    bindNote(item)
                }
            }
        }

        private fun bindFolder(item: Folder) {
            acivIcon.setImageResource(R.drawable.ic_folder)
            tvTitle.text = item.title
            tvUpdatedAt.text = DateUtils.convertToStringDateHourMinuteMiles(item.updatedAt)
            acivMenu.setOnClickListener {
                val popup = PopupMenu(itemView.context, itemView)
                popup.menuInflater
                    .inflate(R.menu.folder_menu, popup.getMenu())
            }
        }
        private fun bindNote(item: NoteFolderItem.NoteShort) {
            acivIcon.setImageResource(R.drawable.ic_note)
            tvTitle.text = item.title
            tvUpdatedAt.text = DateUtils.convertToStringDateHourMinuteMiles(item.updatedAt)
        }
    }

    class NoteModelModeViewHolder internal constructor(
        inflater: LayoutInflater,
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(
        inflater.inflate(R.layout.item_note_model_mode, parent, false)
    ) {
        private val acivIcon: AppCompatImageView = itemView.findViewById(R.id.acivIcon)
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        fun bind(item: NoteFolderItem) {
            when(item) {
                is Folder -> {
                    bindFolder(item)
                }
                is NoteShort -> {
                    bindNote(item)
                }
            }
        }

        private fun bindFolder(item: Folder) {
            acivIcon.setImageResource(R.drawable.ic_folder)
            tvTitle.text = item.title
        }
        private fun bindNote(item: NoteShort) {
            acivIcon.setImageResource(R.drawable.ic_note)
            tvTitle.text = item.title
        }
    }

    enum class ViewType {
        LIST_MODE,
        MODEL_MODE
    }

    interface Callback {
        fun onFolderClick(folderId: Folder)
        fun onNoteClick(noteId: Int)
        fun onFolderDeleteClick(folderId: Int)
        fun onNoteDeleteClick(noteId: Int)
        fun onNoteReplaceClick(noteId: Int)
    }
}