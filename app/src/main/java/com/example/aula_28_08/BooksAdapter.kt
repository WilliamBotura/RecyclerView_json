package com.example.aula_28_08

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BooksAdapter () : ListAdapter<Book, BooksAdapter.BookViewHolder>(BookDiffUtils()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book_layout, null)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val title : TextView = itemView.findViewById(R.id.title)
        private val page : TextView = itemView.findViewById(R.id.pages)
        private val description : TextView = itemView.findViewById(R.id.description)

        fun bind(book:Book){
            title.text = book.title
            page.text = book.pageCount.toString()
            description.text = book.shortDescription
        }
    }

    class BookDiffUtils: DiffUtil.ItemCallback<Book>(){
        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.title == newItem.title
        }
    }

}