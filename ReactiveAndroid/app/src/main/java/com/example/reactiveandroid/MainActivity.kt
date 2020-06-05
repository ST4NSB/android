package com.example.reactiveandroid
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.security.PublicKey
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val city: TextView = findViewById(R.id.city) as TextView
        val fscale: TextView = findViewById(R.id.fscale) as TextView
        val cscale: TextView = findViewById(R.id.cscale) as TextView

        val time: Long = 2000

        val TempSubject = ReplaySubject.create<Float>()
        TempSubject.filter {it -> it < 0}.subscribe({ //onNext
            cscale.text = "Celsius scale: ${it.toString()}"
            if(it == -100f)
                cscale.text = "Celsius scale: "
        },{ //onError
            // error
        },{ //onComplete
            // sub completed
        })

        val TempSubscriber: Observer<Int> = object : Observer<Int> {
            override fun onComplete() {
                // empty here
            }
            override fun onNext(item: Int) {
                fscale.text = "Fahrenheit scale: ${item.toString()}"
                val celsius:Float = (item - 32f) * (5f/9f)
                TempSubject.onNext(-100f)
                TempSubject.onNext(celsius)
            }
            override fun onError(e: Throwable) {
                // error
            }
            override fun onSubscribe(d: Disposable) {
                // subscribed
            }
        }

        // 4 +
        val cities: List<String> = listOf("Sibiu", "Cluj", "Bucuresti", "Iasi", "Timisoara")
        val TempInfo = PublishSubject.create<Int>()
        TempInfo.subscribe({ //onNext
            val c = cities[it]
            city.text = "City: ${c.toString()}"
            fun randTemp():Int = (0..99).random() // 99 inclusive
            TempSubscriber.onNext(randTemp())
        },{ //onError
            // error
        },{ //onComplete
            // sub completed
        })
        //

        // pt 3
       // fun randTemp():Int = (0..99).random() // 99 inclusive
       // val TempInfo:Observable<Int> = Observable.interval(2000L, TimeUnit.MILLISECONDS).map({randTemp()}).observeOn(AndroidSchedulers.mainThread())
       // TempInfo.subscribe(TempSubscriber)

        // 4 +
        fun randCity():Int = (0..(cities.size-1)).random()
        val CityInfo:Observable<Int> = Observable.interval(time, TimeUnit.MILLISECONDS).map({randCity()}).observeOn(AndroidSchedulers.mainThread())
        CityInfo.subscribe(TempInfo)

    }
}
