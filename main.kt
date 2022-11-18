// forEach({ () -> Unit })

data class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snicker doodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    //forEach()
    cookies.forEach() {
        println("Cookie: ${it.name}")
        println("Soft baked?: ${it.softBaked}")
        println("Does it have filling?: ${it.hasFilling}")
        println("Price: ${it.price}?")
        println("-------------------------------------\n")
    }

    //filter
   println(cookies.filter { it.hasFilling == true })

    //map -- doubling the prices
   println(cookies.map { it.price * 2 } )

    //map and filter together
    println( (cookies
            .map { it.price * 2 })
            .filter { it < 3.00 } )

    //groupBy
    val groupedMenu = cookies.groupBy { it.softBaked }
     println(groupedMenu) // all true and false values of softBaked(i.e. either true of false)
//     will be made into two groups
    val isSoftBaked = groupedMenu[true] ?: emptyList()
    val isNotSoftBaked = groupedMenu[false] ?: emptyList()
    println(isSoftBaked)
    isSoftBaked.forEach { println("${it.name} -- $${it.price}") }
    println()
    isNotSoftBaked.forEach { println("${it.name} -- $${it.price}") }

    // Fold
    println("-------------------------")
    val totalCost = cookies.fold(0.0) { total, cookies ->
        total + cookies.price
    }
    println("Total Cost: $totalCost")

    //Sorted By
    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
    println("-------------------------\nAlphabetic Menu:")
    alphabeticalMenu.forEach { println(it.name) }
}//Main End


//smaller map and filter use
//fun main(){
//    val nums = listOf(223,36,5,98,56,23,4,8755,69,65,420,84,65,97,56)
//    val newlist = nums.map { it * 2 }
//    println("Numbers after multiplying by 2: $newlist")
//
//    val evenNums = nums.filter{ it%2 != 0 }
//    println("Even numbers: $evenNums")
//
//}
