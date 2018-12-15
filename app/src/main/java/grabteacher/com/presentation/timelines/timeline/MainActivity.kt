package grabteacher.com.presentation.timelines.timeline

import android.os.Bundle
import android.util.Log
import grabteacher.com.R
import grabteacher.com.Utils.logs.ALog
import grabteacher.com.di.InjectedActivity
import grabteacher.com.presentation.timelines.timeline.di.photoListActivityModule
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class MainActivity : InjectedActivity() {

    private val presenter by instance<TimeLineContract.Presenter>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.firstPresenter()
    }

    override fun activityModule() = Kodein.Module("photoListActivityModule") {
        import(photoListActivityModule())
    }


}
