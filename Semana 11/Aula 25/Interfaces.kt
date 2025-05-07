package aula16

import kotlin.Comparator

/*
From Chapter 17: Interfaces, Kotlin Apprentice (Second Edition) Beginning Programming with Kotlin by Irina Galata, Joe Howard, Ellen Shapiro

You’ve learned about two Kotlin custom types: Classes and objects. There’s another
custom type that’s quite useful: Interfaces.
Unlike the other custom types, interfaces aren’t anything you instantiate directly.
Instead, they define a blueprint of behavior that concrete types conform to. With an
interface, you define a common set of properties and behaviors that concrete types
go and implement. The primary difference between interfaces and other custom
types is that interfaces themselves cannot contain state.
 */

interface Vehicle {
    fun accelerate()
    fun stop()
}

/*
An interface can be implemented by a class or object, and when another type
implements an interface, it’s required to define the methods and properties defined
in the interface. Once a type implements all members of an interface, the type is said
to conform to the interface.
Here’s how you declare interface conformance for your type. Define a new class that
will conform to Vehicle :
 */
class Unicycle : Vehicle {
    private var peddling = false
    override fun accelerate() {
        peddling = true
        println("peddling!")
    }

    //If you were to remove the definition of stop() from the class Unicycle below, Kotlin
    //would display an error since Unicycle wouldn’t have fully conformed to the
    //Vehicle interfaces
    override fun stop() {
        peddling = false
        println("Stop")
    }
}
//////////////////////////////////////////

enum class Direction {
    LEFT, RIGHT
}

interface OptionalDirectionalVehicle {
    fun turn(direction: Direction = Direction.LEFT)
}

class VehicleOptionalDirection : Vehicle, OptionalDirectionalVehicle {
    override fun accelerate() {
        println("accelerate!")
    }

    override fun stop() {
        println("Stop")
    }

    override fun turn(direction: Direction) {
        println(direction)
    }
}

//////////////////////////////////////////
// Default method implementations

interface SpaceVehicle {
    fun accelerate()
    fun stop() {
        println("Whoa, slow down!")
    }
}
class LightFreighter: SpaceVehicle {
    override fun accelerate() {
        println("Proceed to hyperspace!")
    }
    // Method stop is not overridden because it has a default implementation
    //
    // But, we could override it, if we want
//    override fun stop() {
//        println("Override stop")
//    }
}

// Properties in interfaces
// You can also define properties in an interface:
interface VehicleProperties {
    val weight: Int // abstract
    val name: String  // Getter property
        get() = "Vehicle"
}

// Interfaces cannot themselves hold state, as there are no backing fields to hold the
// data stored in an interface property. You must either let the property be abstract with
// no value, or give the property an implementation, like for name in
// VehicleProperties.
// Types that implement an interface with properties can either give abstract
// properties a value, or provide an implementation:
class Car: VehicleProperties {
    override val weight: Int = 1000
}

class Tank: VehicleProperties {
    override val weight: Int
        get() = 10000
    override val name: String
        get() = "Tank"
}
// Note the use of the override keyword on the property implementations. The Car
// class gives a value to weight and uses the default implementation of name , while the
// Tank class gives weight a custom getter and overrides name .

//////////////////////////////////////////


// Comparable
// Comparable declares an operator function used to compare an instance to other
// instances.
public interface Comparable<in T> {
    public operator fun compareTo(other: T): Int
}

// Suppose you want to create a Boat class and compare boat sizes, with each boat
// conforming to a SizedVehicle interface:
interface SizedVehicle {
    var length: Int // Abstract
}

// You can make Boat implement SizedVehicle and also conform to Comparable :
class Boat: SizedVehicle, Comparable<Boat> {
    override var length: Int = 0

    override fun compareTo(other: Boat): Int {
        return when {
            this.length > other.length -> 1
            length == other.length -> 0
            else -> -1
        }
        // Equivalent to
//        return this.length.compareTo(other.length)
        // If we want to order in the reversed order
//        return -this.length.compareTo(other.length)
    }

    override fun toString(): String {
        return length.toString()
    }

}

// Reversed order
//class Boat: SizedVehicle, Comparable<Boat> {
//    override var length: Int = 0
//
//    override fun compareTo(other: Boat): Int {
//        return -this.length.compareTo(other.length)
//    }
//}

//public interface Comparator<in T> {
//    public fun compare(elem1: T, elem2: T): Int
//}

class BoatComparator: Comparator<Boat> {
    override fun compare(elem1: Boat, elem2: Boat): Int {
        return when {
            elem1.length > elem2.length -> 1
            elem1.length == elem2.length -> 0
            else -> -1
        }
        // Equivalent to
//        return elem1.length.compareTo(elem2.length)
    }
}

class BoatComparatorReversedOrder: Comparator<Boat> {
    override fun compare(elem1: Boat, elem2: Boat): Int {
        return when {
            elem1.length > elem2.length -> -1
            elem1.length == elem2.length -> 0
            else -> 1
        }
        // Equivalent to
//        return -elem1.length.compareTo(elem2.length)
    }
}


class MotorBike : Vehicle {
    override fun accelerate() {
        println("Running by bike!")
    }
    override fun stop() {
        println("Stopping my bike")
    }
}


fun main() {
    // The big difference you’ll notice is
    //that the interface doesn’t have to contain any implementation.
    //That means you can’t instantiate a Vehicle directly:
//    val vehicle = Vehicle() // Error

//    val unicycle: Unicycle = Unicycle() // OK
//    val unicycle: Vehicle = Unicycle() // Also OK, an unicycle is a Vehicle also

//    unicycle.accelerate()
//    unicycle.stop()

//    // Advantages of using interfaces
//    // GTA - Grand Theft Auto
//    var gtaVehicle: Vehicle
//    gtaVehicle = Unicycle() // Set to Unicycle
//    gtaVehicle.accelerate()
//    gtaVehicle.stop()
//    // Player gets a motorbike
//    gtaVehicle = MotorBike() // Set to MotorBike
//    gtaVehicle.accelerate()
//    gtaVehicle.stop()

    //////////////////////////////////////////

//    val car = VehicleOptionalDirection()
//    car.turn() // > LEFT
//    car.turn(Direction.RIGHT) // > RIGHT

    //////////////////////////////////////////
    // Default method implementations

//    val falcon = LightFreighter()
//    falcon.accelerate() // > Proceed to hyperspace!
//    falcon.stop() // > "Whoa, slow down!"    or  "Override stop"
//

//    var myVehicleProperties: VehicleProperties
//
//    myVehicleProperties = Car()
//    println(myVehicleProperties.name)
//    println(myVehicleProperties.weight)
//
//    myVehicleProperties = Tank()
//    println(myVehicleProperties.name)
//    println(myVehicleProperties.weight)

    //////////////////////////////////////////

    val titanic = Boat()
    titanic.length = 883
    val qe2 = Boat()
    qe2.length = 963
//    println(titanic > qe2) // > false
//    println(titanic.compareTo(qe2)) // > -1

    // If we exchange order inside compareTo (reversed order):
//    println(titanic > qe2) // > true
//    println(titanic.compareTo(qe2)) // > 1

    val cmp = BoatComparator()
    println(cmp.compare(titanic, qe2))

    val cmpReversed = BoatComparatorReversedOrder()
    println(cmpReversed.compare(titanic, qe2))

    val array: Array<Boat> = Array<Boat>(2, { i -> Boat() })
    array[0] = titanic
    array[1] = qe2

    println(array.asList())

    array.sortWith(cmpReversed) // Sorts in decreasing order
    println(array.asList())

}


















