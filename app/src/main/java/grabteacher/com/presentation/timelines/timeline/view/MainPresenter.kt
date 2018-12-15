package grabteacher.com.presentation.timelines.timeline.view;

import grabteacher.com.Utils.logs.ALog
import grabteacher.com.interactor.mainUseCase.FirstUseCase
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver


/**
 * Created by Huu Hoang on 14/12/2018
 */
class MainPresenter(val firstUseCase: FirstUseCase): MainContract.Presenter {

    override fun firstPresenter() {
        firstUseCase.run("bla ble", object : DisposableObserver<String>(){

            override fun onComplete() {
                ALog.e(" complete")
            }

            override fun onNext(t: String) {
                ALog.e(" onNext $t")

            }

            override fun onError(e: Throwable) {
                ALog.e(" onError ${e.localizedMessage}")

            }
        })

    }
}