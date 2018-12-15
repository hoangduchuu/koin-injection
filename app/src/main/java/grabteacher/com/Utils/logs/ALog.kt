package grabteacher.com.Utils.logs;

import com.orhanobut.logger.Logger


/**
 * Created by Huu Hoang on 15/12/2018
 */
// Logging must be use this class
object ALog {
    fun d(msg: String){
        Logger.d(msg)
    }

    fun e(msg: String){
        Logger.e(msg)
    }
    fun w(msg: String){
        Logger.w(msg)
    }
    fun v(msg: String){
        Logger.v(msg)
    }

    fun wtf(msg: String){
        Logger.wtf(msg)
    }

    fun i(msg: String){
        Logger.i(msg)
    }


}