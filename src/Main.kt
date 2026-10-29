interface HorseInterface {
    val food: String
    val location: String

    fun makeNoise()
    fun runspeed()
}

interface EagleInterface {
    val size: Double
    val wingLength: Double

    fun flightAltitude()
    fun flightSpeed()
}

class Horse(
    override val food: String,
    override val location: String,
    private val runSpeedKmH: Double = 60.0
) : HorseInterface {

    override fun makeNoise() {
        println("И-го-го! Я ем $food и живу в $location.")
    }

    override fun runspeed() {
        println("Моя скорость бега — $runSpeedKmH км/ч.")
    }
}

class Eagle(
    override val size: Double,
    override val wingLength: Double,
    private val flightAltitudeM: Double = 3000.0,
    private val flightSpeed: Double = 120.0
) : EagleInterface {

    override fun flightAltitude() {
        println("Я поднимаюсь на высоту $flightAltitudeM м.")
    }

    override fun flightSpeed() {
        println("Моя скорость полёта — $flightSpeed км/ч.")
    }
}

class Pegasus(
    horse: HorseInterface,
    eagle: EagleInterface
) : HorseInterface by horse, EagleInterface by eagle

fun main() {
    val horse = Horse(food = "трава и нектар", location = "Олимп", runSpeedKmH = 55.0)
    val eagle = Eagle(size = 2.5, wingLength = 4.0, flightAltitudeM = 3100.0, flightSpeed = 110.0)

    val pegasus = Pegasus(horse, eagle)


    pegasus.makeNoise()
    pegasus.runspeed()
    pegasus.flightAltitude()
    pegasus.flightSpeed()

    println()
    println("Характеристики Пегаса:")
    println("Еда: ${pegasus.food}")
    println("Локация: ${pegasus.location}")
    println("Размер: ${pegasus.size} м")
    println("Размах крыльев: ${pegasus.wingLength} м")
}
