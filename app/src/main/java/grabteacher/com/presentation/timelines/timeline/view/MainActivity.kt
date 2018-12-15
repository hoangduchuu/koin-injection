package grabteacher.com.presentation.timelines.timeline.view

import android.os.Bundle
import grabteacher.com.R
import grabteacher.com.di.InjectedActivity
import grabteacher.com.presentation.timelines.timeline.di.mainModule
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class MainActivity : InjectedActivity() {
    //region VARIABLE region

    private val presenter by instance<MainContract.Presenter>()

    // endregion


    //region Android LifeCycle region

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.firstPresenter()
    }

    // endregion

    //region DI region

    override fun activityModule() = Kodein.Module("mainModule") {
        import(mainModule())
    }
    // endregion



}
