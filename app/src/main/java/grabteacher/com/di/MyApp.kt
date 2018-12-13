package grabteacher.com.di;

import android.app.Application
import android.content.Context
import grabteacher.com.di.AppModule
import grabteacher.com.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

/**
 * Created by Huu Hoang on 06/12/2018
 */
class MyApp :Application(), KodeinAware {

    private val logger by instance<Logger>()


    /**
     * remember bem the `lazy`.
     */
    override var kodein =Kodein.lazy{

        import(AppModule(applicationContext))
    }

    override fun onCreate() {
        super.onCreate()
        logger.log("MyTAG",message = "oncreate method")
    }
}