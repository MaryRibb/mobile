package com.example.fourthlab

typealias HumansListener = (humans: List<Human>) -> Unit

object HumanHolder {

    private var humans = mutableListOf<Human>()
    private var listeners = mutableListOf<HumansListener>()


    fun addListener(listener: HumansListener) {
        listeners.add(listener)
        listener.invoke(humans)
    }

    init {
        humans.add(
            Human(
                "Борис",
                "Бабаев",
                "Хороший человек",
                R.drawable.bor

            )
        )
        humans.add(
            Human(
                "Роберт",
                "Мартин",
                "Хороший человек",
                R.drawable.bjar


        )
        )
        humans.add(
            Human(
                "Жарм",
                "Строуст",
                "Хороший человек",
                R.drawable.rob

            )
        )




    }
}