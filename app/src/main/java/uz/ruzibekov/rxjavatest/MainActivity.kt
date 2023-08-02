package uz.ruzibekov.rxjavatest

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.initObservers()
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetch()
    }

    private fun MainViewModel.initObservers() {

        loadingLiveData.observe(this@MainActivity) {
            Log.i("RRR", it.toString())
        }

        messageLiveData.observe(this@MainActivity) {
            Log.i("RRR", it.toString())
        }

        postsLiveData.observe(this@MainActivity) { posts ->
            Log.i("RRR", posts.toString())
        }
    }
}