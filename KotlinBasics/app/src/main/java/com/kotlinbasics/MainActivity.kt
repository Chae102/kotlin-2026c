package com.kotlinbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
//        week03Variables()
//        week03Functions()

        week04Classes()
    }
}

private fun week04Classes() {
    println("=================Kotlin Classes=================")

    class Student{
        var name: String = ""
        var age: Int =0

        fun introduce(){
            println("Hi, I'm $name and I'm $age years old")
        }
    }

    val student1 = Student()
    student1.name="Mirae"
    student1.age=21
    student1.introduce()


    // data 는 자료 저장
    data class Person(val name:String, val age:Int)

    val person1 = Person("Kim", 23)
    val person2 = Person("Lee", 21)

    println("Person1 : $person1") // Java toString()
    println("Person1 : ${person1.name}")
    println("Person2 : ${person2.age}")
}

private fun week03Variables() {
    println("Week 03 : Variables")

    val courseName = "Mobile Programming"  // Java final keyword
    //courseName = "DataStructure"  // error

    var week = 2
    week = 3
    println("Course : $courseName")
    println("Week : $week")

    println("========= Kotlin Variables =========")

    // val(immutable) vs var(mutable)
    val name = "Android"
    var version = 8

    println("Hi $name $version")

    val age: Int = 24
    val height: Double = 177.7
    val isStudent: Boolean = false

    println("Age: $age, Height: $height, Student: $isStudent")

    //var nickname:String = null
    var nickname:String? = null
    nickname = "mirae"
    println("Nickname: $nickname ${nickname?.length}")
}

private fun week03Functions() {
//    println("Week 03: Functions")
//
//    fun greet(name: String) = "Hello, $name!"
//
//    println(greet("Android developer"))

    println("== Kotlin Functions ==")

    fun greet(name: String): String {  // fun 함수이름(매개변수명 : 타입) : 리턴타입 { return --- }
        return "Hello, $name!"
    }

    // *************새로운 타입
    fun add(a: Int, b: Int) = a + b
    // fun add(a: Int, b: Int) : Int {
    //    return a + b
    //}

    // 디폴트 매개변수
    fun introduce(name: String, age: Int = 19){  // Int = 19는 default 매개변수
        println("My name is $name and I'm $age years old")
    }

    println(greet("Kotlin"))
    println("Sum: ${add(5, -71)}")
    introduce("Kim", 7)  // introduce는 리턴 값이 없다.
    introduce("Park")  // age는 디폴트 19로 동작

    fun printAll(vip:Boolean, name:String){
        println("$vip,$name")
    }

// 가변인수
//    fun printMany(msg: String){
// vararg : variable arguments 가변 매개변수
    // vararg 써줘야 여러개 매개변수 가능.
    fun printMany(vararg msg: String){
        for(m in msg) println(m)
    }

    printAll(true,"dy")
    // printAll("dy",true) // Error : 순서 지키기
    // 지정 인수
    printAll(name="mirae",vip=true)  // named argument 지정 가능.

    printMany("A","B","C","D")
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}