package grabteacher.com.interactor.repository

import io.reactivex.Observable


/**
 * Created by Huu Hoang on 15/12/2018
 */
interface UserRepository {
    fun getUsers() : Observable<List<String>>
}