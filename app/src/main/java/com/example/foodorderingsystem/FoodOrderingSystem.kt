package com.example.foodorderingsystem



fun main() {
    //menu: item name and price
    val menu = mapOf(
        1 to Pair("Burger", 120),
        2 to Pair("Pizza", 250),
        3 to Pair("Pasta", 180),
        4 to Pair("Fries", 80),
        5 to Pair("Coke", 40)
    )
    //item name to quantity
    val cart = mutableMapOf<String, Int>()

    while (true) {
        println(
            """|---FOOD ORDERING SYSTEM---
               |1.View Menu
               |2.ADD TO CART
               |3.CHECKOUT
               |4.EXIT
      
                """.trimMargin()
        )
        println("Enter your choice(1-4): ")
        when (readLine()?.toIntOrNull()) {

            1 -> {
                println("---MENU---")
                menu.forEach { (key, value) ->
                    println("$key.${value.first} - Rs ${value.second}")
                }
            }

            2 -> {
                println("Enter item number to add: ")
                val itemNumber = readLine()?.toIntOrNull()
                val selectedItem = menu[itemNumber]
                if (selectedItem != null) {
                    val itemName = selectedItem.first
                    cart[itemName] = cart.getOrDefault(itemName, 0) + 1
                    println("$itemName added to cart")

                } else {
                    println("Invalid item number")
                }
            }

            3 -> {
                println("---YOUR CART---")
                if (cart.isEmpty()) {
                    println("Your cart is empty")
                } else {
                      println("---CART---")
                        var total = 0
                    cart.forEach {
                                (item, qty)->
                        val price = menu.values.find{it.first == item}?.second?:0
                        val subTotal = qty * price
                        println("$item * $qty = Rs.$subTotal")
                        total+= subTotal

                    }

                }
            }
            4->{
                if(cart.isEmpty()){
                    println("Add items before checkout")
                }else{
                    println("Processing checkout")
                    var total = 0
                    cart.forEach {
                        (item,qty)->
                        val price = menu.values.find{it.first == item}?.second?:0
                         total += qty* price

                    }
                    println("Your total bill is Rs.$total. Thank you for ordering.")
                    cart.clear()
                }
            }

            5 -> {
                println("Have a delicious day")
                break
            }

            else -> {
                println("Invalid choice.Please try again")
            }


        }
    }
}
