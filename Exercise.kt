enum class Daypart {
    MORNING, AFTERNOON, EVENING, NIGHT
}

data class Event(
    var title: String,
    var description: String? = null,
    var daypart: Daypart,
    var duration: Int
)

val Event.durationOfEvent:String
    get() = if(duration<60) "short" else "long"

fun main() {
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, duration = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, duration = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.NIGHT, duration = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, duration = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, duration = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, duration = 45)

    //TASK 3
    val eventlist = mutableListOf(event1, event2, event3, event4, event5, event6)

    //TASK 4
    val shortEvents = eventlist.filter { it.duration < 60 }
    val shortEventsCount = shortEvents.size
    println("The total number of events less than 60 minutes are: $shortEventsCount") // Redundant but unambiguous

    // TASK 5
    val groupByDaypart = eventlist.groupBy { it.daypart } //Trailing Lambda
    groupByDaypart.forEach {
        println("${it.key}: ${it.value.size} Events")
    }

    // TASK 6
    println("Last event of the day: ${eventlist.last().title}")

    // TASK 7
    println("Duration of first event of the day: ${eventlist[0].durationOfEvent}")

}

/********************* Task 1 + 2 ***********************************/
//  val nightEvent = Event(
//        "Study Kotlin",
//        "Commit to studying Kotlin at least 15 minutes per day.",
//        TimePart.NIGHT,
//        15
//    )

//    println(nightEvent)

/******************** Task 3 *****************************************/
// All the values that are stored within eventList are already declared, the original solution was a bit messed.
//val eventlist = mutableListOf(event1, event2, event3, event4, event5, event6)

/******************** Task 4 *****************************************/
//val shortEvents = eventlist.filter { it.duration < 60 }
//val shortEventsCount = shortEvents.size
//println("The total number of events less than 60 minutes are: $shortEventsCount")

/******************** Task 5 *****************************************/
//groupByDayPart utilises the groupBy function over it's daypart argument, which returns a map The keys are the Daypart
// values while the "values" are the arrays inside which the grouped events are stored. So the size of the array becomes
// the total events count for each Daypart

//val groupByDaypart = eventlist.groupBy { it.daypart }
//groupByDaypart.forEach {
//    println("${it.key}: ${it.value.size} Events")
//}

/******************** Task 6 *****************************************/
//The first() and last() functions returns the first and last elements of an array respectively.

//println("Last event of the day: ${eventlist.last().title}")

/******************** Task 7 *****************************************/
// Extension property outside main function
//val Event.durationOfEvent:String
//    get() = if(duration<60) "short" else "long"

//println("Duration of first event of the day: ${eventlist[0].durationOfEvent}")