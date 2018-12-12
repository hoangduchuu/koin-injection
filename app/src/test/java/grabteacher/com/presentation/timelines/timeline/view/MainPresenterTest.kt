package grabteacher.com.presentation.timelines.timeline.view

import android.content.Context
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import grabteacher.com.datasource.cache.UserDataSourceRemote
import grabteacher.com.datasource.cache.UserDataSourceRemoteTest
import grabteacher.com.datasource.factory.UserDataSourceFactory
import grabteacher.com.datasource.remote.UserDataSourceCache
import grabteacher.com.di.AppModule
import grabteacher.com.di.dataModule
import grabteacher.com.interactor.mainUseCase.FirstUseCase
import grabteacher.com.interactor.mainUseCase.SecondUseCase
import grabteacher.com.interactor.repository.UserRepository
import grabteacher.com.interactor.schedulers.PostExecutionThread
import grabteacher.com.interactor.schedulers.ThreadExecutor
import grabteacher.com.presentation.timelines.timeline.di.mainModule
import io.reactivex.Observable
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Huu Hoang on 16/12/2018
 */
@RunWith(MockitoJUnitRunner::class)

class MainPresenterTest : KodeinAware {

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var view: MainContract.View
    @Mock
    lateinit var cache: UserDataSourceCache
    @Mock
    lateinit var remote: UserDataSourceRemote
    @Mock
    lateinit var factory: UserDataSourceFactory
    @Mock
    lateinit var mainPresenter: MainContract.Presenter
    @Mock
    lateinit var firstUseCase: FirstUseCase
    @Mock
    lateinit var secondUseCase: SecondUseCase

    @Mock
    lateinit var thread: ThreadExecutor

    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    lateinit var userRepository: UserRepository


    /**
     * A Kodein Aware class must be within reach of a [Kodein] object.
     */
    override val kodein = Kodein.lazy {
        // production modules
        import(AppModule(context))
        import(dataModule())
        import(mainModule(view))
        bind<UserDataSourceCache>(true) with provider { cache }
        bind<UserDataSourceRemote>(true) with provider { remote }
        bind<UserDataSourceFactory>(true) with provider { factory }
        bind<FirstUseCase>(true) with provider { firstUseCase }
        userRepository = grabteacher.com.repository.UserRepository(factory)
        bind<SecondUseCase>(true) with provider { SecondUseCase(userRepository, thread, postExecutionThread) }
        bind<MainContract.Presenter>(true) with provider { MainPresenter(firstUseCase, secondUseCase, view) }


    }

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testUseCaseShouldBeComplete() {
        println(cache.toString())
        println(remote.toString())
        println(factory.toString())
        println(mainPresenter.toString())
        println(firstUseCase.toString())
        println(secondUseCase.toString())
    }

    @Test
    fun makeSureCacheDataSourceReturnExactlyData() {
        whenever(cache.getUsers()).thenReturn(Observable.just(UserDataSourceRemoteTest.makeUsers()))
        val obs = cache.getUsers().test()
        obs.assertValue(UserDataSourceRemoteTest.makeUsers())
    }


    @Test
    fun makeSureRemoteDataSourceReturnExactlyData() {
        whenever(remote.getUsers()).thenReturn(Observable.just(UserDataSourceRemoteTest.makeUsers()))
        val obs = remote.getUsers().test()
        obs.assertValue(UserDataSourceRemoteTest.makeUsers())
    }

    @Test
    fun makeSureFactoryShoudWorking() {
        val users = UserDataSourceRemoteTest.makeUsers()
        val userOvertheWorld = UserDataSourceRemoteTest.makeUsersOverTheWorld()
        val userMerge = mutableListOf<String>()
        userMerge.addAll(userOvertheWorld)
        userMerge.addAll(users)

        whenever(factory.getUsers()).thenReturn(Observable.just(userMerge))
        val obs = factory.getUsers().test()
        obs.assertValue(userMerge)
    }

    @Test
    fun testPresenterRunning() {
        val users = UserDataSourceRemoteTest.makeUsers()
        val userOvertheWorld = UserDataSourceRemoteTest.makeUsersOverTheWorld()
        val userMerged = mutableListOf<String>()
        userMerged.addAll(userOvertheWorld)
        userMerged.addAll(users)

        whenever(secondUseCase.buildUseCaseObservable("a")).thenReturn(Observable.just(userMerged))
        secondUseCase.buildUseCaseObservable("a")

        verify(secondUseCase).buildUseCaseObservable("a")
 



    }
}