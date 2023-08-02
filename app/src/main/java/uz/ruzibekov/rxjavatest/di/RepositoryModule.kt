package uz.ruzibekov.rxjavatest.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.ruzibekov.rxjavatest.data.service.ApiService
import uz.ruzibekov.rxjavatest.domain.MainRepository
import uz.ruzibekov.rxjavatest.domain.MainRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(service: ApiService): MainRepository = MainRepositoryImpl(service)
}