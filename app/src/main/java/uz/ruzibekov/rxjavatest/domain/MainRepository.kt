package uz.ruzibekov.rxjavatest.domain

import io.reactivex.Observable
import uz.ruzibekov.rxjavatest.data.model.PostResponse

interface MainRepository {

    fun getPosts(): Observable<List<PostResponse>>
}