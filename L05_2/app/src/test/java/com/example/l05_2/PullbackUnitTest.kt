package com.example.l05_2

import junit.framework.Assert
import junit.framework.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class FormatGroup {
    fun formatSetToString(srcSet : Set<triplet>) : String {
        var groupOutput : String = ""
        groupOutput += "{ "
        for (item in srcSet) {
            var zVal : String? = ""
            if (item.z != null)
                zVal = item.z + ","
            val itemstr : String = "(" + item.x + "," + zVal + item.y + ") "
            groupOutput += itemstr
        }
        groupOutput += "}"
        return groupOutput
    }
}

class PullbackTestL05Ex2 {
    @Test
    fun pullbackMainExample() {
        // Pair(src, trg)
        val fi = setOf(Pair("x1","z1"), Pair("x2","z2"), Pair("x3", "z2"))
        val gi = setOf(Pair("y1","z1"), Pair("y2","z2"), Pair("y3", "z4"), Pair("y4", "z2"))
        val codomi = setOf("z1", "z2", "z3", "z4")
        val domfi = setOf("x1", "x2", "x3")
        val domgi = setOf("y1", "y2", "y3", "y4")

        val expected : Set<triplet> = setOf(triplet("x1", "z1", "y1"), triplet("x2", "z2", "y2"),
            triplet("x2", "z2", "y4"), triplet("x3", "z2", "y2"), triplet("x3", "z2", "y4"))
        val res : Set<triplet> = PullbackImplementation().getPullback(fi = fi, gi = gi, codomi = codomi, domfi = domfi, domgi = domgi)

        val expStr : String = FormatGroup().formatSetToString(expected)
        val resStr : String = FormatGroup().formatSetToString(res)

        println(expStr)
        println(resStr)

        assert(expStr == resStr)
    }

    @Test
    fun emptyPullbackfi() {
        // Pair(src, trg)
        val fi = emptySet<Pair<String, String>>()
        val gi = setOf(Pair("y1","z1"), Pair("y2","z2"), Pair("y3", "z4"), Pair("y4", "z2"))
        val codomi = setOf("z1", "z2", "z3", "z4")
        val domfi = emptySet<String>()
        val domgi = setOf("y1", "y2", "y3", "y4")

        val expected : Set<triplet> = setOf()
        val res : Set<triplet> = PullbackImplementation().getPullback(fi = fi, gi = gi, codomi = codomi, domfi = domfi, domgi = domgi)

        val expStr : String = FormatGroup().formatSetToString(expected)
        val resStr : String = FormatGroup().formatSetToString(res)

        println(expStr)
        println(resStr)

        assert(expStr == resStr)
    }

    @Test
    fun emptyPullbackgi() {
        // Pair(src, trg)
        val fi = setOf(Pair("x1","z1"), Pair("x2","z2"), Pair("x3", "z2"))
        val gi = emptySet<Pair<String, String>>()
        val codomi = setOf("z1", "z2", "z3", "z4")
        val domfi = setOf("x1", "x2", "x3")
        val domgi = emptySet<String>()

        val expected : Set<triplet> = setOf()
        val res : Set<triplet> = PullbackImplementation().getPullback(fi = fi, gi = gi, codomi = codomi, domfi = domfi, domgi = domgi)

        val expStr : String = FormatGroup().formatSetToString(expected)
        val resStr : String = FormatGroup().formatSetToString(res)

        println(expStr)
        println(resStr)

        assert(expStr == resStr)
    }

    @Test
    fun pullbackSoloZ() {
        // Pair(src, trg)
        val fi = setOf(Pair("x1","z1"), Pair("x2","z1"))
        val gi = setOf(Pair("y1","z1"), Pair("y3", "z1"), Pair("y4", "z1"))
        val codomi = setOf("z1")
        val domfi = setOf("x1", "x2", "x3")
        val domgi = setOf("y1", "y2", "y3", "y4")

        val expected : Set<triplet> = setOf(triplet("x1", null, "y1"), triplet("x1", null, "y3"),
            triplet("x1", null, "y4"), triplet("x2", null, "y1"), triplet("x2", null, "y3"),
            triplet("x2", null, "y4"))
        val res : Set<triplet> = PullbackImplementation().getPullback(fi = fi, gi = gi, codomi = codomi, domfi = domfi, domgi = domgi)

        val expStr : String = FormatGroup().formatSetToString(expected)
        val resStr : String = FormatGroup().formatSetToString(res)

        println(expStr)
        println(resStr)

        assert(expStr == resStr)
    }
}

class PullbackTestL05Ex3 {
    fun Print3S1() {

    }
}
