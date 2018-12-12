package grabteacher.com.presentation.timelines.timeline.view;

import grabteacher.com.Utils.logs.ALog
import grabteacher.com.interactor.mainUseCase.FirstUseCase
import grabteacher.com.interactor.mainUseCase.SecondUseCase
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver


/**
 * Created by Huu Hoang on 14/12/2018
 */
class MainPresenterBackup(val view: MainContract.View,val firstUseCase: FirstUseCase, val secondUseCase: SecondUseCase): MainContract.Presenter {

    val TAG = "MainPresenterBackup"
    override fun firstPresenter() {
        firstUseCase.run("bla ble", object : DisposableObserver<String>(){

            override fun onComplete() {
                ALog.e("$TAG complete firstUseCase")
                view.callFragment()


            }

            override fun onNext(t: String) {
                ALog.e("$TAG  onNext firstUseCase $t")
                view.callFragment()


            }

            override fun onError(e: Throwable) {
                ALog.e("$TAG  onError firstUseCase  ${e.localizedMessage}")
                view.callFragment()


            }
        })

        secondUseCase.run("bla ble", object : DisposableObserver<List<String>>(){

            override fun onComplete() {
                ALog.e("$TAG  complete secondUseCase")
                view.callFragment()
            }

            override fun onNext(t: List<String>) {
                ALog.e("$TAG  onNext secondUseCase$t")
                view.callFragment()

            }

            override fun onError(e: Throwable) {
                ALog.e(" $TAG  onError secondUseCase ${e.localizedMessage}")
                view.callFragment()

            }
        })


    }
}