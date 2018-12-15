package grabteacher.com.repository;

import grabteacher.com.datasource.factory.UserDataSourceFactory
import grabteacher.com.interactor.repository.UserRepository
import io.reactivex.Observable

/**
 * Created by Huu Hoang on 15/12/2018
 */
class UserRepository(val factory: UserDataSourceFactory) : UserRepository {
    override fun getUsers(): Observable<List<String>> {
        return  factory.getUsers()
    }
}