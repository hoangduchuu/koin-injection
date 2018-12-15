package grabteacher.com.di;

import grabteacher.com.datasource.cache.UserDataSourceRemote
import grabteacher.com.datasource.factory.UserDataSourceFactory
import grabteacher.com.datasource.remote.UserDataSourceCache
import grabteacher.com.interactor.repository.UserRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * Created by Huu Hoang on 15/12/2018
 */
fun dataModule() = Kodein.Module("dataModule"){
    bind<UserDataSourceCache>() with singleton { UserDataSourceCache() }
    bind<UserDataSourceRemote>() with singleton { UserDataSourceRemote() }
    bind<UserDataSourceFactory>() with singleton { UserDataSourceFactory(instance(), instance()) }

    bind<UserRepository>() with singleton { grabteacher.com.repository.UserRepository(instance()) }

}