package com.kotlinbasics

import android.os.Bundle
import android.util.Log
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
//        week04Collections()
    }
}
private fun week04Collections(){
    println("== Kotlin Collections ==")

    val fruits = listOf("apple", "banana", "orange")
    val mutableFruits = mutableListOf("kiwi", "watermelon")

    //fruits.add("kiwi")
    println("Fruits : $fruits")
    mutableFruits.add("banana")
    println("Mutable fruits : $mutableFruits")

    val scores = mapOf("Kim" to 100, "Park" to 97, "Lee" to 99)
    println("Scores : $scores")

    for(fruit in mutableFruits){
        println("I like $fruit")
    }

    scores.forEach{(name, score) -> println("$name scored $score")}
    fruits.forEach { fruit -> println("$fruit") }
}

private fun week04Classes(){
    Log.d("KotlinWeek04", "== Kotlin Classes ==")

    class Person(val name: String, var age: Int){
        fun introduce(){
            Log.d("KotlinWeek04", "안녕하세요, $name ($age 세)입니다.")
        }
        fun birthday(){
            age++
            Log.d("KotlinWeek04", "$name 의 생일! 이제 $age 세...")
        }
    }
    val person1 = Person("홍길동", 27)
    person1.introduce()
    person1.birthday()

    class Animal(var species: String){
        var weight: Double = 0.0
        constructor(species: String, weight: Double) : this(species){
            this.weight = weight
            Log.d("KotlinWeek04", "${species}의 무게 : $weight kg")
        }
        fun makeSound(){
            Log.d("KotlinWeek04", "${species}가 소리를 냅니다.")
        }
    }
    val puppy = Animal("웰시코기", 10.5)
    puppy.makeSound()
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