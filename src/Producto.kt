data class Producto(
    val codigo: String,
    var nombre: String,
    var precio: Double,
    var cantidadStock: Int
) {
    fun vender(cantidad: Int) {
        if (cantidadStock >= cantidad) {
            cantidadStock -= cantidad
            println("Se han vendido $cantidad unidades de $nombre.")
        } else {
            println("No hay suficiente stock para vender $cantidad unidades de $nombre.")
        }
    }

    fun reponer(cantidad: Int) {
        cantidadStock += cantidad
        println("Se han repuesto $cantidad unidades de $nombre.")
    }

    fun aplicarDescuento(porcentaje: Double) {
        precio -= precio * (porcentaje / 100)
        println("Descuento del $porcentaje% aplicado a $nombre. Nuevo precio: $precio")
    }

    fun mostrarInformacion() {
        println("Código: $codigo, Nombre: $nombre, Precio: $precio, Stock: $cantidadStock")
    }

    fun aumentarPrecio(porcentaje: Double) {
        precio += precio * (porcentaje / 100)
        println("Precio de $nombre aumentado en $porcentaje%. Nuevo precio: $precio")
    }

    fun calcularValorInventario(): Double {
        return precio * cantidadStock
    }
}


