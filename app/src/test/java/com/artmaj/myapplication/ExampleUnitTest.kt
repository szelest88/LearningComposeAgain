package com.artmaj.myapplication

import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

import android.os.Build
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1], manifest = Config.NONE) // Specify the target SDK
class ExampleUnitTest {


    @Test
    fun addition_isCorrect() {
        val act = MainActivity()

        assertEquals(2.0f, 2.0f)

    }

    @Test
    fun addition_isCorrect2(){
        val act = MainActivity()

        assertEquals(2.0f, 2.0f)
    }


}