package grabteacher.com.presentation.timelines.timeline.di;

import grabteacher.com.presentation.timelines.timeline.info.InfoContract
import grabteacher.com.presentation.timelines.timeline.info.InfoPresenter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

/**
 * Created by Huu Hoang on 15/12/2018
 */
/**
 * Specific android scoped module for the detail activity.
 */
fun infoModule() = Kodein.Module("infoModule") {
    bind<InfoContract.Presenter>() with provider { InfoPresenter() }
}