package com.example.myfirsttests

import junit.framework.TestCase
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.*
import org.junit.Before
import org.junit.Test

class AssertsTests: TestCase() {

    private lateinit var string1: String
    private lateinit var string2: String
    private lateinit var string3: String
    private lateinit var array1: List<String>
    private lateinit var array2: List<String>


    @Before
    override fun setUp() {
        string1 = "a"
        string2 = "a"
        string3 = "b"
        array1 = arrayListOf("1", "2", "3")
        array2 = arrayListOf("1", "2", "3")
    }


    @Test
    fun test1(){
        assertThat(string1, equalTo(string2))

    }
    @Test
    fun test2(){
        assertThat(string2, nullValue())

    }
    @Test
    fun test3(){
        assertThat(string3, notNullValue())

    }
    @Test
    fun test4(){
        assertThat(string3, equalTo(string1))

    }
    @Test
    fun test5(){
        assertThat(string1, instanceOf(String::class.java))

    }
    @Test
    fun test6(){
        assertThat(array1, equalTo(array2))

    }
}