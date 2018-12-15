package grabteacher.com.presentation.timelines.timeline.di;

import grabteacher.com.presentation.timelines.timeline.view.MainPresenter
import grabteacher.com.presentation.timelines.timeline.view.MainContract
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

/**
 * Created by Huu Hoang on 14/12/2018
 */
fun mainModule() = Kodein.Module {
    bind<MainContract.Presenter>() with provider { MainPresenter() }
}