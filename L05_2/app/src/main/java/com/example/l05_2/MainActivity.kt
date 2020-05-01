package com.example.l05_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


/*class connections {
    val x: String
    val y: String
    constructor(x: String, y: String) {
        this.x = x
        this.y = y
    }
} */

//var functie: (String, String) -> String

class triplet {
    val x: String
    val z: String?
    val y: String
    constructor(x: String,z:String?, y:String) {
        this.x = x
        this.z = z
        this.y = y
    }
}

abstract class PullbackAbstract{
    abstract fun getPullback(fi: Set<Pair<String, String>>, gi: Set<Pair<String, String>>, codomi: Set<String>,
                             domfi:Set<String>, domgi: Set<String>): MutableSet<triplet>
}

class PullbackImplementation : PullbackAbstract() {
    override fun getPullback(fi: Set<Pair<String, String>>, gi: Set<Pair<String, String>>, codomi: Set<String>,
                             domfi:Set<String>, domgi: Set<String>): MutableSet<triplet> {
        val res : MutableSet<triplet> = mutableSetOf<triplet>()
        if (domfi.isEmpty() or domgi.isEmpty() or codomi.isEmpty())
            return res
        for(z in codomi) {
            val fiSet : MutableSet<String> = mutableSetOf<String>()
            for (tgt in fi) {
                if(tgt.second == z) // daca target are z (element din domeniul Z)
                    fiSet.add(tgt.first) // adaugare sursa x (element din domeniul X)
            }

            val giSet : MutableSet<String> = mutableSetOf<String>()
            for (tgt in gi) {
                if(tgt.second == z) // daca target are z (element din domeniul Z)
                    giSet.add(tgt.first) // adaugare sursa y (element din domeniul Y)
            }

            for (x in fiSet)
                for (y in giSet)
                {
                    var zVal : String? = null
                    if (codomi.size > 1)
                        zVal = z
                    val tri : triplet = triplet(x, zVal, y)
                    res.add(tri)
                }
        }
        return res
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
