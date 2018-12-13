package grabteacher.com.di;

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import grabteacher.com.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance

/**
 * Created by Huu Hoang on 14/12/2018
 */
abstract class InjectedActivity: AppCompatActivity(), KodeinAware {

    /**
     *  closestKodein() automatically fetches app Kodein scope.
     */
    private val appKodein by closestKodein()


    /**
     * A Kodein Aware class must be within reach of a [Kodein] object.
     */
    override val kodein : Kodein by retainedKodein {
        extend(appKodein)
        import(baseActivityModule(this@InjectedActivity))
        import(activityModule())
    }

    open fun activityModule() = Kodein.Module{

    }




}