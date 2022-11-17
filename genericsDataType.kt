enum class Difficulty { EASY, MEDIUM, HARD }

data class Quiz<answerType>(
    val questionText: String,
    val difficulty: Difficulty,
    val answer: answerType,
) {
    companion object Student {
        val answered: Int = 3
        val total: Int = 10
    }
}

//Extension Property for above class
val Quiz.Student.progressText: String
    get() = "$answered out of $total questions."

//Extension functions
fun Quiz.Student.progressFunc() {
    repeat(answered) { print("▓") }
    repeat(Quiz.total) { print("▒") }
    println()
    //Accessing the extension property created above
    println(Quiz.progressText)
}


fun main() {

    //Object instantiation
    val q1 = Quiz<Int>("Exampler question?", Difficulty.EASY, 10)
//    val q2 = Quiz<Int>("Exampler question?", Difficulty.MEDIUM, 10)
//    val q3 = Quiz<Int>("Exampler question?", Difficulty.HARD, 10)
//    println(q1)
    //Accessing the singleton object inside a data class(or any class)
    // genericDataType.Student.answered can also be used to access data
//    println("Student has given right answers to ${Quiz.answered} questions out of ${Quiz.total} questions")

//    Quiz.Student.progressFunc() - See down below 👇

    q1.let { // It here is Quiz(since q1 is quiz's object)
        println(it.answer)
        println(it.difficulty)
        println(it.questionText)
    }

    Quiz.apply { progressFunc() } // Can also be called without any object instantiation(It is using companion object)
println("\nNew method call ->")
    val quizzed = Quiz.apply{
        progressFunc()
    }
}
