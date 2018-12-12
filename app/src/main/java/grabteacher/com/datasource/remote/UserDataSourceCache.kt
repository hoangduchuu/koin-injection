package grabteacher.com.datasource.remote

import io.reactivex.Observable


/**
 * Created by Huu Hoang on 15/12/2018
 */
open class UserDataSourceCache {
  open  fun getUsers(): Observable<List<String>>{
        return Observable.just("HUU", "NAM").toList().toObservable()
    }
}