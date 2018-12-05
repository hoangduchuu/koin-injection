package grabteacher.com.di;

import android.app.Application
import grabteacher.com.di.AppModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

/**
 * Created by Huu Hoang on 06/12/2018
 */
class MyApp :Application(), KodeinAware {
    override var kodein =Kodein{
        import(AppModule(applicationContext))
    }
}