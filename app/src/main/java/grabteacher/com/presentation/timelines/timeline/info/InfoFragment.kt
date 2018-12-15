package grabteacher.com.presentation.timelines.timeline.info;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import grabteacher.com.R
import grabteacher.com.presentation.timelines.timeline.di.infoModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

/**
 * Created by Huu Hoang on 15/12/2018
 */
class InfoFragment : Fragment(), KodeinAware, InfoContract.View {

    //region VARIABLE region

    // endregion

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(context,"123",Toast.LENGTH_SHORT).show()
    }
    //// endregion

    //region DI region

    override val kodein: Kodein = Kodein.lazy {
        val activityKodein by closestKodein(context!!)

        extend(activityKodein)
        import(infoModule())
    }

    // endregion
}