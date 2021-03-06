package grabteacher.com.logger;

import android.util.Log

/**
 * Created by Huu Hoang on 06/12/2018
 */
class AndroidLogger : Logger {
    override fun log(tag: String, level: Logger.Level, message: String) {
        when(level){
            Logger.Level.Info -> Log.i(tag,message)
            Logger.Level.Debug -> Log.d(tag,message)
            Logger.Level.Warning -> Log.w(tag,message)
            Logger.Level.Error -> Log.e(tag,message)
            Logger.Level.Verbose -> Log.v(tag,message)
        }
    }
}