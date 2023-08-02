package uz.ruzibekov.rxjavatest.data.service

import io.reactivex.Observable
import retrofit2.http.GET
import uz.ruzibekov.rxjavatest.data.model.PostResponse

interface ApiService {

    @GET("posts")
    fun getPosts(): Observable<List<PostResponse>>
}