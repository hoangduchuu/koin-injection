package grabteacher.com.presentation.timelines.timeline.di;

import grabteacher.com.interactor.mainUseCase.FirstUseCase
import grabteacher.com.presentation.timelines.timeline.view.MainPresenter
import grabteacher.com.presentation.timelines.timeline.view.MainContract
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

/**
 * Created by Huu Hoang on 14/12/2018
 */
fun mainModule() = Kodein.Module("MainActivityModuleDI") {
    bind<MainContract.Presenter>() with provider { MainPresenter(instance()) }

    bind<FirstUseCase> () with provider { FirstUseCase(instance(), instance()) }

}