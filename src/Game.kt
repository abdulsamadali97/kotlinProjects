import java.awt.Choice

fun main(args: Array<String>){
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParams: Array<String>) =
    optionsParams[(Math.random() * optionsParams.size).toInt()]

fun getUserChoice(optionsParams: Array<String>): String{
    var isValidChoice = false
    var userChoice = ""
    while (!isValidChoice){
        print("Please enter one of the following:")
        for (item in optionsParams) print(" $item")
        println(".")

        val userInput = readlnOrNull()

        if (userInput != null && userInput in optionsParams){
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("You must enter a valid choice.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String){

    val result: String =
        if (userChoice == gameChoice) "Tie"
        else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") || (userChoice == "Scissors" && gameChoice == "Paper"))
        "You win!"
        else "You Loose"
    println("You chose $userChoice. I chose $gameChoice. $result")
}