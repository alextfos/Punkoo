package com.alextfos.beer.data.api

import com.alextfos.beer.data.util.providesOkHttp
import com.alextfos.beer.data.util.providesRetrofit
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.BeforeClass
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
class BeerApiTest {

    @Test
    fun `WHEN makes a call EXPECT data`() = runTest {
        val res = beerApi.getBeerList(null, null, null)

        assertThat(res.isSuccessful, `is`(true))
        assertThat(res.body(), notNullValue())
        assertThat(res.body()?.get(0)?.id, notNullValue())
    }

    companion object {
        lateinit var beerApi: BeerApi
        @JvmStatic
        @BeforeClass
        fun setUp() {
            val retrofit = providesRetrofit(providesOkHttp())
            beerApi = retrofit.create(BeerApi::class.java)
        }
    }
}
