package ir.ariyana.arianabooks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.ariyana.arianabooks.databinding.ActivityMainBinding
import ir.ariyana.arianabooks.ui.main.MainViewModel
import ir.ariyana.arianabooks.utils.Resource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel
            .getBooksOverview()

        viewModel
            .response
            .observe(this) { response ->
                when(response) {

                    is Resource.Success -> {
                        Log.i("main", response.data!!.results.toString())
                    }

                    is Resource.Error -> {
                        Log.e("main", response.message!!)
                    }

                    is Resource.Loading -> {
                        Log.i("main", "ok")
                    }
                }
            }
    }
}