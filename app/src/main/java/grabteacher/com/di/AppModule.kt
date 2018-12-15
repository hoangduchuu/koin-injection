package grabteacher.com.di;

import android.content.Context
import grabteacher.com.logger.AndroidLogger
import grabteacher.com.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by Huu Hoang on 06/12/2018
 */
fun AppModule(context: Context) = Kodein.Module("appModule"){
    // TODO remember bind the context over here
    bind<Context>() with provider { context }
    bind<Logger>() with singleton { AndroidLogger() }

}