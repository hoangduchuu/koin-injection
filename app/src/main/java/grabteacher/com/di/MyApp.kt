package grabteacher.com.di;

import android.app.Application
import androidx.annotation.VisibleForTesting
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger



/**
 * Created by Huu Hoang on 06/12/2018
 */
class MyApp : Application(), KodeinAware {

    @VisibleForTesting
    var overrideBindings: Kodein.MainBuilder.() -> Unit = {}

    override val kodein = Kodein.lazy {
        import(AppModule(applicationContext))
    }

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())

    }
}
