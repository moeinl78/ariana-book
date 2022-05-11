package ir.ariyana.arianabooks.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import ir.ariyana.arianabooks.R
import ir.ariyana.arianabooks.databinding.FragmentHomeBinding
import ir.ariyana.arianabooks.repository.model.Book
import ir.ariyana.arianabooks.ui.adapter.AdapterBook
import ir.ariyana.arianabooks.ui.main.MainViewModel
import ir.ariyana.arianabooks.utils.Constants
import ir.ariyana.arianabooks.utils.Resource

class FragmentHome: Fragment(), AdapterBook.Events {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: AdapterBook
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel
            .getBooksOverview()

        adapter = AdapterBook(this)

        viewModel
            .response
            .observe(viewLifecycleOwner) { response ->

                when(response) {

                    is Resource.Success -> {

                        val books = mutableListOf<Book>()
                        response.data?.let { res ->
                            res.results.lists.map {
                                it.books.map { book ->
                                    books.add(book)
                                }
                            }
                        }
                        adapter.submitList(books)
                        binding.homeProgressBar.visibility = View.GONE
                    }

                    is Resource.Error -> {

                        Toast.makeText(binding.root.context, response.message, Toast.LENGTH_SHORT).show()
                        binding.homeProgressBar.visibility = View.GONE
                    }

                    is Resource.Loading -> {

                        binding.homeProgressBar.visibility = View.VISIBLE
                    }
                }
            }

        binding.homeRecyclerViewBook.adapter = adapter
        binding.homeRecyclerViewBook.layoutManager =
            GridLayoutManager(binding.root.context, 2)
    }

    override fun onItemClick(item: Book) {
        val bundle = Bundle()
        bundle.putSerializable(Constants.INFO_NAVIGATION_ARG, item)
        findNavController().navigate(R.id.action_fragmentHome_to_fragmentInfo, bundle)
    }
}