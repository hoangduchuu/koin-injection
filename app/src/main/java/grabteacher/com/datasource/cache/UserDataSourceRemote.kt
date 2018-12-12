package grabteacher.com.datasource.cache

import io.reactivex.Observable


/**
 * Created by Huu Hoang on 15/12/2018
 */
open class UserDataSourceRemote {
   open fun getUsers(): Observable<List<String>>{
        return Observable.just("DUC", "Khoa").toList().toObservable()
    }
}