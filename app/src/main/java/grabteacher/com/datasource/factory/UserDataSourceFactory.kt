package grabteacher.com.datasource.factory;

import grabteacher.com.datasource.cache.UserDataSourceRemote
import grabteacher.com.datasource.remote.UserDataSourceCache
import io.reactivex.Observable
import io.reactivex.Observer

/**
 * Created by Huu Hoang on 15/12/2018
 */
class UserDataSourceFactory (val cache: UserDataSourceCache, val remote: UserDataSourceRemote) {
    fun getUsers(): Observable<List<String>>{
        return cache.getUsers()
                .concatWith(remote.getUsers())

    }
}