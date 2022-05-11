package ir.ariyana.arianabooks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import ir.ariyana.arianabooks.R
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

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainFragmentContainerView)
        val bottomNavigationView = binding.mainBottomNavigationView

        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment!!.findNavController())
    }
}