package grabteacher.com.presentation.timelines.timeline.view;

import grabteacher.com.Utils.logs.ALog
import grabteacher.com.interactor.mainUseCase.FirstUseCase
import grabteacher.com.interactor.mainUseCase.SecondUseCase
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver


/**
 * Created by Huu Hoang on 14/12/2018
 */
class MainPresenter(val firstUseCase: FirstUseCase, val secondUseCase: SecondUseCase, val view: MainContract.View): MainContract.Presenter {


    override fun firstPresenter() {
        firstUseCase.run("bla ble", object : DisposableObserver<String>(){

            override fun onComplete() {
                ALog.e(" complete firstUseCase")
            }

            override fun onNext(t: String) {
                ALog.e(" onNext firstUseCase $t")

            }

            override fun onError(e: Throwable) {
                ALog.e(" onError firstUseCase  ${e.localizedMessage}")

            }
        })

        secondUseCase.run("bla ble", object : DisposableObserver<List<String>>(){

            override fun onComplete() {
                ALog.e(" complete secondUseCase")
                view.callFragment()
            }

            override fun onNext(t: List<String>) {
                ALog.e(" onNext secondUseCase$t")

            }

            override fun onError(e: Throwable) {
                ALog.e(" onError secondUseCase ${e.localizedMessage}")

            }
        })


    }
}