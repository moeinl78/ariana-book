package ir.ariyana.arianabooks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.ariyana.arianabooks.databinding.ItemRecyclerViewBinding
import ir.ariyana.arianabooks.repository.model.Book
import ir.ariyana.arianabooks.repository.model.BooksOverviewResponse

class AdapterBook: ListAdapter<Book, AdapterBook.ViewHolder>(BookDiffCallback()) {

    inner class ViewHolder(private val binding: ItemRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Book) {

            binding.itemBookTitle.text = item.title
            binding.itemBookWriter.text = item.author
            binding.itemBookPrice.text = item.price
            Glide
                .with(binding.root.context)
                .load(item.bookImage)
                .into(binding.itemBookImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class BookDiffCallback: DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(
        oldItem: Book,
        newItem: Book
    ): Boolean {
        return oldItem.bookUri == newItem.bookUri
    }

    override fun areContentsTheSame(
        oldItem: Book,
        newItem: Book
    ): Boolean {
        return oldItem == newItem
    }
}