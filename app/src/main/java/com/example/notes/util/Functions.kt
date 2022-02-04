package com.example.notes.util

val Any.TAG:String
get(){
    val tag = javaClass.simpleName
    return if(tag.length<24)tag else tag.substring(0,23)
}