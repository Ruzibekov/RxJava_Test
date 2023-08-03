package uz.ruzibekov.rxjavatest.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.rxjavatest.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var rvPosts: RecyclerView? = null
    private val postListAdapter = PostListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initViews()

        viewModel.initObservers()
    }

    override fun onStart() {
        super.onStart()

        viewModel.fetch()
    }

    private fun initViews() {
        rvPosts = findViewById(R.id.rv_posts)
        rvPosts?.adapter = postListAdapter
    }

    private fun MainViewModel.initObservers() {

        loadingLiveData.observe(this@MainActivity) { showProgress ->
            if (showProgress)
                rvPosts?.visibility = View.GONE
            else
                rvPosts?.visibility = View.VISIBLE
        }

        messageLiveData.observe(this@MainActivity) { message ->
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
        }

        postsLiveData.observe(this@MainActivity) { posts ->
            postListAdapter.items = posts
        }
    }
}