package uz.ruzibekov.rxjavatest.domain

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uz.ruzibekov.rxjavatest.data.model.PostResponse
import uz.ruzibekov.rxjavatest.data.service.ApiService
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val service: ApiService
) : MainRepository {

    override fun getPosts(): Observable<List<PostResponse>> {
        return service.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}