package grabteacher.com.base;

import androidx.annotation.StringRes

/**
 * Created by Huu Hoang on 14/12/2018
 */
interface BaseView {
    fun hideKeyboard()
    fun showErrorMessage(@StringRes messageId: Int)
    fun showErrorMessage(message: String)
    fun showProgressDialog()
}