package day4

import kotlin.collections.ArrayList

class Guard(val id: Int) {
    fun addSleep(fellAsleepAt: Int, wokeUpAt: Int) {
        if(fellAsleepAt == -1){
            throw Exception("can't add sleep if guard never fell asleep")
        }

        for (i in fellAsleepAt until wokeUpAt) {
            totalSleep++

            val currentMinute = sleepMinutes.getForMinute(i)
            val sleepMinute = currentMinute ?: SleepMinute(i).also {
                sleepMinutes.add(it)
            }

            sleepMinute.timesSleptAtMinute++

                println("Guard $id, total $totalSleep, sleepminute ${sleepMinute.minute}, times ${sleepMinute.timesSleptAtMinute}")
        }
    }

    var totalSleep: Int = 0

    private var sleepMinutes: ArrayList<SleepMinute> = ArrayList()

    fun getMinuteMostSlept(): SleepMinute {
        if(sleepMinutes.isEmpty()){
            throw Exception("Guard hasn't slept, so no minute most asleep")
        }
        sleepMinutes.sortByDescending {
            it.timesSleptAtMinute
        }

        return sleepMinutes[0]
    }

    private fun ArrayList<SleepMinute>.getForMinute(minute: Int): SleepMinute? {
        return filter { it.minute == minute }.getOrNull(0)
    }

}