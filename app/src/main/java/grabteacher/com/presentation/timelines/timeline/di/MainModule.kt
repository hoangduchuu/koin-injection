package grabteacher.com.presentation.timelines.timeline.di;

import grabteacher.com.interactor.mainUseCase.FirstUseCase
import grabteacher.com.interactor.mainUseCase.SecondUseCase
import grabteacher.com.presentation.timelines.timeline.view.MainActivity
import grabteacher.com.presentation.timelines.timeline.view.MainPresenter
import grabteacher.com.presentation.timelines.timeline.view.MainContract
import grabteacher.com.presentation.timelines.timeline.view.MainPresenterBackup
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * Created by Huu Hoang on 14/12/2018
 */
fun mainModule(view: MainContract.View) = Kodein.Module("MainActivityModuleDI") {
    bind<MainContract.Presenter>(tag = "production") with singleton { MainPresenter(instance(), instance(),instance()) }
    bind<MainContract.Presenter>(tag = "backup") with singleton { MainPresenterBackup(instance(), instance(),instance()) }

    bind<FirstUseCase> () with singleton { FirstUseCase(instance(), instance()) }
    bind<SecondUseCase>() with singleton { SecondUseCase(instance(), instance(),instance()) }



    bind<MainContract.View>() with singleton { view }

}