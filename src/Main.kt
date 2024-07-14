import kotlinx.coroutines.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
suspend fun main() = runBlocking {
    println("=============================1=============================")
    println("Программа покупки продуктов")
    delay(1000L)
    println("Купить товар:\n1.Да\n2.Нет")
    val num = readln().toInt()
    when (num) {
        1 -> payment()
        2 -> cancellation()
        else -> println("Ошибка!!!")
    }
    end()

    println("=============================2=============================")
    launch {
        delay(1000L)
        for (i in 1..4){
            println(i)
            delay(1000L)
        }
    }

    val lazyStart = launch(start = CoroutineStart.LAZY) {
        delay(2500L)
        println("Произошел ленивый запуск")
    }
    launch {
        delay(5000)
        println("Программа завершена")
    }
    print("Начало программы")
    lazyStart.start()
    println()
}
suspend fun payment() = runBlocking {
    launch { println("Оплата покупки началась")
        delay(2000L)
        println("Сканирование и обработка..")
        delay(2000L)
        println("Покупка оплачена.") }

}
suspend fun cancellation() = runBlocking {
    launch {
        println("Отмена покупки...")
        delay(2000L)
        println("Покупка отменена.")
    }
}
suspend fun end() = runBlocking {
    launch {
        delay(2000L)
        println("До свидания!")
    }
}