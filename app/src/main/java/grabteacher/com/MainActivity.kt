package grabteacher.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import grabteacher.com.di.InjectedActivity

class MainActivity : InjectedActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
