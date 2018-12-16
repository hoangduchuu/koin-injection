package grabteacher.com.presentation.timelines.timeline.view;

import grabteacher.com.base.BaseView

//import grabteacher.com.base.BaseView

/**
 * Created by Huu Hoang on 14/12/2018
 */
interface MainContract {
    interface View: BaseView {
        fun callFragment()
    }

    interface Presenter{
        fun firstPresenter()
    }
}