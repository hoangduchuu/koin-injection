package grabteacher.com.presentation.timelines.timeline.di;

import grabteacher.com.interactor.mainUseCase.FirstUseCase
import grabteacher.com.interactor.mainUseCase.SecondUseCase
import grabteacher.com.presentation.timelines.timeline.view.MainPresenter
import grabteacher.com.presentation.timelines.timeline.view.MainContract
import grabteacher.com.presentation.timelines.timeline.view.MainPresenterBackup
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

/**
 * Created by Huu Hoang on 14/12/2018
 */
fun mainModule() = Kodein.Module("MainActivityModuleDI") {
    bind<MainContract.Presenter>(tag = "production") with provider { MainPresenter(instance(), instance()) }
    bind<MainContract.Presenter>(tag = "backup") with provider { MainPresenterBackup(instance(), instance()) }

    bind<FirstUseCase> () with provider { FirstUseCase(instance(), instance()) }
    bind<SecondUseCase>() with provider { SecondUseCase(instance(), instance(),instance()) }

}