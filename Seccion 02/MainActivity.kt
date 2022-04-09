package com.jotajotavm.testbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    companion object {
        const val moneda: String = "EUR"
    }
    var saldo: Float = 300.54f
    var sueldo = 789.10f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("\n*********************************************")
        println("********** CURSO BASICO DE KOTLIN ***********")
        println("*********************************************")
        println("Hola")
        println("\n\n\n\n")

        var nombre = "jota"
        var vip: Boolean = false
        var saludo = "hola " + nombre

        if (vip == true) saludo += ", te queremos mucho"
        print(saludo)
        mostrar_saldo (saldo)
        ingresar_dinero (254.23f)
        retirar_dinero (50.7f)

        val fecha = "20/05/2022"
        //           0123456789

        print("\n" + fecha + "\n")

        val day  = fecha.subSequence(0,2).toString().toInt()
        if (day == 1) ingresar_sueldo()
        val month  = fecha.subSequence(3,5).toString().toInt()

        print("\nMes " + month + "\n")

        when (month){
            1, 2, 3 -> print ("\n En invierno no hay ofertas de inversiones")
            4, 5, 6 -> print ("\n En primavera hay ofertas de inversiones con el 1.5% de interés")
            7, 8, 9 -> print ("\n En verano hay ofertas de inversiones con el 2.5% de interés")
            10, 11, 12 -> print ("\n En otoño hay ofertas de inversiones con el 3.5% de interés")
        }


        var recibos: Array<String> = arrayOf("luz", "agua", "gas")
        recibos.set(2, "internet")

        recorrer_array(recibos)

        var matriz = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        for (i in (0 until 3)){
            println()
            for (j in (0 until 3)){
                print("${matriz[i][j]},")
            }
        }

        val clientesVIP: Set<Int> = setOf(1234, 5678, 2345)
        val setMezclado = setOf(2, 4.454, "casa", 'c')
        println()
        println("Clientes VIP: \n")
        println(clientesVIP)
        println("Numero de clientes VIP: ${clientesVIP.size}")
        if (clientesVIP.contains(123456)) println("123456 es cliente")

        if (clientesVIP.contains(1234)) println("1234 es VIP")

        val clientes: MutableSet<Int> = mutableSetOf(1234, 5678, 2345, 8970)
        clientes.add(4040)
        println()
        println("Clientes: \n")
        println(clientes)
        println("Numero de clientes: ${clientesVIP.size}")


        var divisas: List<String> = listOf("USD", "EUR", "YEN")
        recorrer_lista(divisas)


        var bolsa: MutableList<String> = mutableListOf("Coca-Cola", "Adidas", "Amazon", "Pfizer")
        println(bolsa)
        bolsa.add("Adobe")
        println(bolsa)
        bolsa.add(0, "Nvidia")
        println(bolsa)
        bolsa.removeAt(1)
        println(bolsa)

        for (item in bolsa)
            print(item + "\n")

        println(bolsa.first())
        println(bolsa.last())
        println(bolsa.elementAt(2))
        println(bolsa.none())

        bolsa.clear()
        println(bolsa)
        println(bolsa.firstOrNull()) //first() da error por eso hay que recurrer a esta otra, pero probamos tbn con first para que se vea
        println(bolsa.none())



        bolsa = mutableListOf("Coca-Cola", "Adidas", "Amazon", "Pfizer", "Nvidia", "Adobe")

        /*
        FUNCIONES EN MAPAS (diccionarios)

        size: tamaño de la colección.
        isEmpty(): indica si el mapa está vacío.
        containsKey(key: K): indica si el mapa contiene una clave.
        containsValue(value: V): indica si el mapa contiene un valor.
        get(key: K): valor asociado a la llave dada o null si no se encuentra.
        keys: devuelve un Set inmutable con todas las claves en el mapa.
        values: Collection inmutable de todos los valores en el mapa.
        */

        val inversiones = mutableMapOf(
            "abc" to 0.0f,
            "def" to 1.0f
        )
        mostrar_inversiones (inversiones)
        inversiones.clear()

        var index = 0
        var cantidad_inversion: Float = 90f
        var empresa: String?

        mostrar_saldo(saldo)

        empresa = "udemy"
        print(saldo)
        while (saldo >= cantidad_inversion){
            empresa = bolsa.elementAtOrNull(index)
            if (empresa != null){
                inversiones.put(empresa, cantidad_inversion)
                print ("\nSe ha invertido $cantidad_inversion ${Companion.moneda} en $empresa")
                saldo -= cantidad_inversion
            }
            else break
            index++

        }
        mostrar_saldo(saldo)
        mostrar_inversiones (inversiones)


        var intentos = 0
        var pin = 1234
        var clave_ingresada: Int = 1232
        do{
            print("\nIngrese el PIN: ")
            print("\nPIN ingresado: $clave_ingresada")
            intentos++
        }while (clave_ingresada++ != pin && intentos<3)


    }


    fun mostrar_saldo(cantidad: Float){
        print("\n\nTienes $cantidad ${Companion.moneda}")
    }

    fun ingresar_dinero(cantidad: Float){
        saldo += cantidad
        print("\nSe han ingresado $cantidad ${Companion.moneda}")
        mostrar_saldo (saldo)
    }
    fun ingresar_sueldo(){
        saldo += sueldo
        print("\nSe han ingresado tu sueldo de $sueldo ${Companion.moneda}")
        mostrar_saldo (saldo)
    }
    fun retirar_dinero(cantidad: Float){
        saldo -= cantidad
        print("\nSe han retirado $cantidad ${Companion.moneda}")
        mostrar_saldo (saldo)
    }
    fun mostrar_inversiones(m: MutableMap<String, Float>){

        println()
        println("mostrando mutablemap con println(m)")
        println(m)


        var total_invertido: Float = 0f
        m.forEach { total_invertido += it.value }
        println("Cantidad total invertida: $total_invertido")
    }
    fun recorrer_array(a: Array<String>){
        println()
        println("recorriendo array con for (i in 0 .. a.size-1)")
        for (i in 0 .. a.size-1)
            println("${i+1}: " + a.get(i))

        println()
        println("recorriendo array con for (i in a)")
        for (i in a)
            println(i)

        println()
        println("recorriendo array con for (i in a.indices)")
        for (i in a.indices)
            println(a.get(i))
    }

    fun recorrer_lista(lista: List<String>){
        println()
        println("recorriendo lista con for (i in 0 .. lista.size-1)")
        for (i in 0 .. lista.size-1)
            print("\n" + lista.get(i))

        println()
        println("recorriendo lista con for (i in lista)")
        for (i in lista)
            println(i)

        println()
        println("recorriendo lista con for (i in lista.indices)")
        for (i in lista.indices)
            println(lista.get(i))

        lista.size //Muestra el tamaño de la lista
        lista.get(2) //Devuelve el valor de la posición 3
        lista.first() //Devuelve el primer valor
        lista.last() //Devuelve el último valor

        println()
        println("mostrando lista con println(lista)")
        println(lista)
    }


}