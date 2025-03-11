fun main() {
    val productos = mutableListOf<Producto>()

    while (true) {
        println("\n1. Crear produscto")
        println("2. Vender produco")
        println("3. Reponer stock")
        println("4. Aplicar descuento")
        println("5. Mostrar pproductos")
        println("6. Aumentar precio")
        println("7. Valor total en inventario")
        println("8. Eliminar producto")
        println("9. Salir")
        print("Seleccione una opción: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Código: ")
                val codigo = readLine() ?: ""
                print("Nombre: ")
                val nombre = readLine() ?: ""
                print("Precio: ")
                val precio = readLine()?.toDoubleOrNull() ?: 0.0
                print("Stock: ")
                val cantidadStock = readLine()?.toIntOrNull() ?: 0
                productos.add(Producto(codigo, nombre, precio, cantidadStock))
                println("Producto creado.")
            }

            2 -> {
                print("Código del producto a vender: ")
                val codigo = readLine() ?: ""
                val producto = productos.find { it.codigo == codigo }
                if (producto != null) {
                    print("Cantidad a vender: ")
                    val cantidad = readLine()?.toIntOrNull() ?: 0
                    producto.vender(cantidad)
                } else {
                    println("Producto no encontrado.")
                }
            }

            3 -> {
                print("Código del producto a reponer: ")
                val codigo = readLine() ?: ""
                val producto = productos.find { it.codigo == codigo }
                if (producto != null) {
                    print("Cantidad a reponer: ")
                    val cantidad = readLine()?.toIntOrNull() ?: 0
                    producto.reponer(cantidad)
                } else {
                    println("Producto no encontrado.")
                }
            }

            4 -> {
                print("Código del producto para descuento: ")
                val codigo = readLine() ?: ""
                val producto = productos.find { it.codigo == codigo }
                if (producto != null) {
                    producto.aplicarDescuento(2.0)
                } else {
                    println("Producto no encontrado.")
                }
            }

            5 -> {
                println("--- Productos ---")
                for (producto in productos) {
                    producto.mostrarInformacion()
                }
            }

            6 -> {
                print("Código del producto para aumentar precio: ")
                val codigo = readLine() ?: ""
                val producto = productos.find { it.codigo == codigo }
                if (producto != null) {
                    producto.aumentarPrecio(6.0)
                } else {
                    println("Producto no encontrado.")
                }
            }

            7 -> {
                val totalInventario = productos.sumOf { it.calcularValorInventario() }
                println("Valor total en inventario: $totalInventario")
            }
        }
    }
}



