import java.util.Scanner

data class Item(val id: Int, var name: String, var quantity: Int)

class Inventory {
    private val items = mutableListOf<Item>()

    fun addItem(item: Item) {
        items.add(item)
        println("Item added successfully.")
    }

    fun removeItem(id: Int) {
        val iterator = items.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item.id == id) {
                iterator.remove()
                println("Item removed successfully.")
                return
            }
        }
        println("Item not found.")
    }

    fun displayItems() {
        if (items.isEmpty()) {
            println("No items in inventory.")
            return
        }
        println("Inventory Items:")
        items.forEach { item ->
            println("ID: ${item.id}, Name: ${item.name}, Quantity: ${item.quantity}")
        }
    }

    fun updateItemQuantity(id: Int, quantity: Int) {
        for (item in items) {
            if (item.id == id) {
                item.quantity = quantity
                println("Item quantity updated successfully.")
                return
            }
        }
        println("Item not found.")
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val inventory = Inventory()

    while (true) {
        println("\nInventory Management System")
        println("1. Add Item")
        println("2. Remove Item")
        println("3. Display Items")
        println("4. Update Item Quantity")
        println("5. Exit")
        print("Enter your choice: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Enter item ID: ")
                val id = scanner.nextInt()
                print("Enter item name: ")
                val name = scanner.next()
                print("Enter item quantity: ")
                val quantity = scanner.nextInt()
                inventory.addItem(Item(id, name, quantity))
            }
            2 -> {
                print("Enter item ID to remove: ")
                val id = scanner.nextInt()
                inventory.removeItem(id)
            }
            3 -> inventory.displayItems()
            4 -> {
                print("Enter item ID to update: ")
                val id = scanner.nextInt()
                print("Enter new quantity: ")
                val quantity = scanner.nextInt()
                inventory.updateItemQuantity(id, quantity)
            }
            5 -> return
            else -> println("Invalid choice. Please try again.")
        }
    }
}