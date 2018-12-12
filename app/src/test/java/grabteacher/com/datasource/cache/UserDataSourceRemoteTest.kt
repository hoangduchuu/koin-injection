package grabteacher.com.datasource.cache

import android.content.Context
import com.nhaarman.mockito_kotlin.whenever
import grabteacher.com.di.AppModule
import grabteacher.com.presentation.timelines.timeline.view.MainContract
import io.reactivex.Observable
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Huu Hoang on 16/12/2018
 */
@RunWith(MockitoJUnitRunner::class)
class UserDataSourceRemoteTest : KodeinAware {

    private val presenter by instance<MainContract.Presenter>("production")
    @Mock
    lateinit var context: Context
    @Mock
    lateinit var userDataSourceRemote: UserDataSourceRemote


    /**
     * A Kodein Aware class must be within reach of a [Kodein] object.
     */
    override val kodein: Kodein = Kodein.lazy {
        import(AppModule(context))
    }

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }

    @Test
    fun testthetest() {
        val x = 1;
        assertEquals(x, 1)
    }

    @Test
    fun testCompleteObservable() {
        val users = makeUsers()
        stubGetUserNameList(Observable.just(users))
        val testObserver = userDataSourceRemote.getUsers().test()
        testObserver.assertComplete()
    }

    @Test
    fun getAndreturnExactlyData() {
        val users = makeUsers()
        stubGetUserNameList(Observable.just(users))
        val obserVerTest = userDataSourceRemote.getUsers().test()
        obserVerTest.assertValue( users)
    }


    companion object {
        fun makeUsers(): List<String> {
            return mutableListOf("HUU", "NAM", "DUC", "Khoa");
        }

        fun makeUsersOverTheWorld(): List<String> {
            return mutableListOf("HUU", "NAM", "DUC", "Khoa");
        }

    }


    private fun stubGetUserNameList(observable: Observable<List<String>>) {
        whenever(userDataSourceRemote.getUsers())
                .thenReturn(observable)
    }

}