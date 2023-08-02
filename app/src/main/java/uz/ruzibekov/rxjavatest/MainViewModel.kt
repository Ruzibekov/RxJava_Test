package uz.ruzibekov.rxjavatest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import uz.ruzibekov.rxjavatest.data.model.PostResponse
import uz.ruzibekov.rxjavatest.domain.MainRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    val loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val messageLiveData: MutableLiveData<String> = MutableLiveData()
    val postsLiveData: MutableLiveData<List<PostResponse>> = MutableLiveData()

    fun fetch() {
        repository.getPosts().subscribe(object : Observer<List<PostResponse>> {

            override fun onSubscribe(d: Disposable) {
                loadingLiveData.value = true
            }

            override fun onNext(value: List<PostResponse>) {
                postsLiveData.value = value
            }

            override fun onError(e: Throwable) {
                messageLiveData.value = e.message
            }

            override fun onComplete() {
                loadingLiveData.value = false
            }
        })
    }
}