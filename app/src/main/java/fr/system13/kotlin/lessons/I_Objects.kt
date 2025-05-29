package fr.system13.kotlin.lessons

import fr.system13.kotlin.Logger

class I_Objects {

    fun callAll() {
        val serge = User("Dupont", "Serge", 34, 1, "Le grand Serge")
        val bob = User(firstname = "Durand", age = 43, name = "Robert", id = 2, desc = "Le petit Bob")
        bob.age = 44

        // print(bob.id) // erreur : private

        // Récupération d'une propriété
        Logger.debug("callAll", "serge.name : ${serge.firstname}")

        // Appel de la fonction
        serge.sayHello()
        bob.sayHello()
        serge.fullName
        Logger.debug("callAll", "serge.fullName : ${serge.fullName}")
        serge.firstname = "Sergeï"
        Logger.debug("callAll", "serge.firstFullName : ${serge.firstFullName}")
        Logger.debug("callAll", "serge.fullName : ${serge.fullName}")

        Logger.debug("callAll", "serge.desc : ${serge.description}")

        // BankAccount
        val bankAccount = LoggingBankAccount()
        bankAccount.deposit(1000)
        bankAccount.withdraw(200)
        Logger.debug("callAll", "bankAccount.balance : ${bankAccount.balance}")

        // Data class
        val color = CustomColor(23, 123, 42)
        Logger.debug("callAll", "data class color : ${color}")

        // Enum
        val direction = Direction.EAST
        Logger.debug("callAll", "enum class Direction : ${direction}")

        val element = Element.FIRE
        Logger.debug("callAll", "enum class Element : ${element}, valeur : ${element.value}, text : ${element.text} ")
    }

    class User(
        var name: String, var firstname: String, var age: Int,
        private val id: Int, desc: String
    ) {
        // entre () : header, optionnel si vide
        // entre {} : body

        val firstFullName: String = "$firstname $name"
            get() = field

        val fullName: String
            get() = "$firstname $name"

        var description = desc
            get() = field
            set(value) {
                field = value
            }

        init {
            checkId()
        }

        fun sayHello() {
            Logger.debug(
                "sayHello",
                "Hello, je m'appelle $firstname $name et j'ai $age ans"
            )
        }

        private fun checkId() {
            Logger.debug("checkId", "Id : $id")
        }

    }

    class LoggingBankAccount {
        var balance: Int = 0
            private set(value) {
                println("Balance changed from $field to $value")
                field = value
            }

        fun deposit(amount: Int) {
            require(amount > 0) { "Deposit Amount cannot be negative or zero" }
            balance += amount
        }

        fun withdraw(amount: Int) {
            require(amount > 0) { "Withdraw Amount cannot be negative or zero" }
            require(amount <= balance) { "Withdraw Amount cannot be greater than balance" }
            balance -= amount
        }
    }

    // Les data classes sont équivalentes aux records
    data class CustomColor(val red: Int, val green: Int, val blue: Int)

    // Enum
    enum class Direction {
        NORTH, SOUTH, EAST, WEST,
    }

    // Enum
    enum class Element(val value: Int, val text: String) {
        EARTH(1, "Terre"),
        WATER(2, "Eau"),
        AIR(4, "Air"),
        FIRE(8, "Feu"),
    }

    // Classe scellée
    // plus de contrôle sur l'héritage : pas d'héritage possible
    // Pas d'instanciation possible en dehors de la classe
    // Les sous-classes doivent être décrites dans le corps de la classe
    sealed class Shape {
        // les classes filles doivent avoir un constructeur par défaut
        class Circle(val radius: Double) : Shape()
        class Rectangle(val width: Double, val height: Double) : Shape()
        object NotAShape : Shape()
    }

    fun describeShape(shape: Shape): String {
        return when (shape) {
            is Shape.Circle -> "A circle with radius ${shape.radius}"
            is Shape.Rectangle -> "A rectangle with width ${shape.width} and height ${shape.height}"
            Shape.NotAShape -> "Not a shape"
        }
    }
}