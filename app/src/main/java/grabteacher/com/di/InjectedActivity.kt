package grabteacher.com.di;

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import grabteacher.com.R
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein


/**
 * Created by Huu Hoang on 14/12/2018
 */
abstract class InjectedActivity: AppCompatActivity(), KodeinAware {
    //region variable region
    /**
     * the activity requests
     */
    private var activityRequests = HashMap<Int, (resultCode: Int, data: Intent?) -> Unit>()

    /**
     * the dialog
     * //TODO upgrade the dialog to another Widget
     */
    var progressDialog: ProgressDialog? = null

    // endregion

    //region DI region
    // closestKodein() automatically fetches app Kodein scope.
    private val appKodein by closestKodein()

    override val kodein: Kodein by retainedKodein {
        extend(appKodein)
        import(baseActivityModule(this@InjectedActivity), allowOverride = true)
        import(activityModule())
        (app().overrideBindings)()
    }

    /**
     * Optional to override, if your activity needs specific DI.
     */
    open fun activityModule() = Kodein.Module("activityModule") {
    }

    // endregion

    //region BaseClass region

    /**
     * @param toolbarId The toolbar view ID in this layout. Set as [.NONE] if no toolbar in this activity
     */
    protected fun initToolbar(@IdRes toolbarId: Int) {
        val toolbar = findViewById<View>(toolbarId) as Toolbar
        setSupportActionBar(toolbar)
    }

    protected fun setupToolbar(toolbar: Toolbar, toolbarTitle: TextView, homeAsUpEnabled: Boolean, title: String) {
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(homeAsUpEnabled)
            it.setHomeAsUpIndicator(R.drawable.ic_launcher_background)
            it.setDisplayShowTitleEnabled(false)
            toolbarTitle.text = title
        }
    }
    protected fun toggleBackButton(isShow: Boolean = true) {
        // Get a support ActionBar corresponding to this toolbar
        val ab = supportActionBar
        // Enable the Up button
        ab?.setDisplayHomeAsUpEnabled(isShow)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount == 0) {
            // Call the default action
            try {
                super.onBackPressed()
            } catch (e: Exception) {
                Log.e(this.javaClass.name, Log.getStackTraceString(e))
            }
        } else {
            try {
                fragmentManager.popBackStack()
            } catch (e: Exception) {
                Log.e(this.javaClass.name, Log.getStackTraceString(e))
            }
        }
    }

    private fun showAlertDialog(@StringRes messageId: Int) {
        showAlertDialog(getString(messageId))
    }


    private fun showAlertDialog(message: String) {
        AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok)) { dialog, _ -> dialog.dismiss() }
                .show()
    }

    /**
     * Hide keyboard immediately
     */
    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun showErrorMessage(@StringRes messageId: Int) {
        showAlertDialog(messageId)
    }

    fun showErrorMessage(message: String) {
        showAlertDialog(message)
    }

    fun showProgressDialog() {
        progressDialog = ProgressDialog(this, R.style.ProgressBar)
        progressDialog?.setCancelable(false)
        progressDialog?.setProgressStyle(android.R.style.Widget_ProgressBar_Small)
        progressDialog?.show()
    }

    fun hideProgressDialog() {
        progressDialog?.hide()
    }


    fun getBBApplication(): MyApp {
        return application as MyApp
    }

    fun startActivityForResult(intent: Intent, requestCode: Int, callback: (resultCode: Int, data: Intent?) -> Unit) {
        startActivityForResult(intent, requestCode)
        activityRequests.put(requestCode, callback)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (activityRequests.containsKey(requestCode)) {
            val callback = activityRequests[requestCode]
            callback?.let { it(resultCode, data) }
            activityRequests.remove(requestCode)
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
        //To fix the crash when loading vector drawable on Android 4.
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }


    // endregion
}

fun Activity.app() = applicationContext as MyApp

