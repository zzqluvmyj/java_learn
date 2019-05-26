package com.myj
import java.util.Date
import java.text.SimpleDateFormat

/**
 * 简单的入门程序
 */

fun main(args:Array<String>){
    println("hello world")
    println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss".format(Date())).toString())
}