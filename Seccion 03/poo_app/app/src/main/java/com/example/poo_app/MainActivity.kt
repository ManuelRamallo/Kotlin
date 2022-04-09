package com.example.poo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

typealias aliasDato = MutableMap<Int, ArrayList<String>>
typealias aliasFuncion = (a: Int, b: Int) -> Int
typealias aliasObjeto = SubClasses.Anidada

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*var bicho: Pokemon = Pokemon()
        println(bicho.getName())
        println(bicho.getAttackPower())
        println(bicho.getlife())

        bicho.setLife(50f)
        println(bicho.getlife())*/





        private lateinit var cadena: String
        private var resi : Boolean = false


        class IllegalPasswordException(message: String): Exception(message)


        var usuario = "   soy   yo   "
        println("${usuario} (${usuario.length})  - ${usuario.noSpaces()} (${usuario.noSpaces().length})")

        var array1 : Array<Int> = arrayOf(5,4,3,2,1)

        var array2 = IntArray(3)
        array2[0] = 10
        array2[1] = 20
        array2[2] = 30
        println("array2: "); array2.show();
        var array3: IntArray = intArrayOf (1,2,3,4,5)
        println("array3: "); array3.show();

        println("La suma de 80 y 20 es ${calculadora(80, 20, ::suma)}")
        println("La resta de 50 y 10 es ${calculadora(50, 10, ::resta)}")
        println("El producto entre 7 y 7 es ${calculadora(7, 7, ::multiplica)}")
        println("La división entre 12 y 3 es ${calculadora(12, 3, ::divide)}")


        var funcion = { x: Int, y:Int -> x+y }
        println("La suma de 80 y 20 con variable es ${calculadora(80, 20, funcion)}")

        funcion = { x: Int, y:Int -> x-y }
        println("La resta de 50 y 10 con variable es ${calculadora(50, 10, funcion)}")

        println("La suma de 80 y 20 con lambda es ${calculadora(80, 20,{ x: Int, y:Int -> x+y })}")
        println("La resta de 50 y 10 con lambda es ${calculadora(50, 10,{ x: Int, y:Int -> x-y })}")
        println("La potencia de 2 elevado a 5 con lambda es ${calculadora(2, 5) { x, y ->
            var valor = 1
            for (i in 1..y) valor *= x

            valor
        }
        }")

        var array4 = IntArray(10) {5}
        println("array4: "); array4.show();
        var array5 = IntArray(10) {it}
        println("array5: "); array5.show();
        var array6 = IntArray(10) {it*2}
        println("array5: "); array6.show();


        var array7 = IntArray(10) { i -> i*3}
        println("array7: "); array7.show();

        var suma = 0
        recorrerArray(array7){
            suma += it
        }
        println("la suma de todos los elementos del array7 es $suma")



        var jota: Person = Person("Jota", "A891567", 1.62f)
        println(jota.alive)
        println(jota.name)
        println(jota.passport)

        if (jota.checkPolice(::inColombia)) println("${jota.name} puede ser Policia en Colombia")
        if (jota.checkPolice(::inSpain)) println("${jota.name} puede ser Policia en España")

        jota.let{
            it.die()
            it.height = 1.8f
            it.passport = "C345346"
        }

        var Jose = Person("Jose", "D894864").apply{
            this.die()
            this.height = 1.9f
            this.passport = "D89416"
        }.also{
            it.alive = true
        }

        var maria = Person("Maria", "R080980", 1.7f).run{
            this.height = 1.9f
            this.passport = "D89416"

            "Maria es muy alta"
        }

        var marta = with(Person("Marta", "D7098080", 1.6f)){
            this.height = 1.9f
            this.passport = "D89416"

            "Maria no es muy alta"
        }

        var pais : String? = "Rusia"
        pais = pais?.uppercase() ?: "DESCONOCIDO"
        println(pais)

        var ciudad : String? = null
        ciudad = ciudad?.uppercase() ?: "DESCONOCIDA"
        println(ciudad)

        val calle: String by lazy { "Nueva" }

        var direccion = "$pais - $ciudad - $calle"
        println(direccion)

        var anidada = aliasObjeto()
        println(anidada.presentar())

        var saludos: aliasDato = mutableMapOf()
        saludos[0] = arrayListOf("Hola", "Adios")
        saludos[1] = arrayListOf("Hi", "Bye")

        for ((id, palabras) in saludos)
            println("$id, $palabras")

        var (name_star2, radius_star2, galaxy2) = star("Sol2", 696340f, "Vía Láctea2")
        println("Datos Star2 Desestructurada: $name_star2, $radius_star2, $galaxy2")

        var (name_star3, radius_star3) = star("Sol3", 696340f, "Vía Láctea3")
        println("Datos Star3 Desestructurada: $name_star3, $radius_star3")
        var (name_star4, _, galaxy4) = star("Sol4", 696340f, "Vía Láctea4")
        println("Datos Star4 Desestructurada: $name_star4, $galaxy4")

        var componente = star("Sol5", 696340f, "Vía Láctea5")
        println("Datos Star5 con Componentes: ${componente.component1()}, ${componente.component2()}, ${componente.component3()}")

        /*
        NullPointerException
        ArithmeticException
        SecurityException
        ArrayIndexOutOfBoundException
         */

        try{
            //ejemplo queremos abrir un archivo para modificar algo y aqui hacemos el cambio
            println("Divison de 5/0 = ${5/0}")
        }catch (e: Exception){ //Exception es un TYPEALIAS!! PONER RATON ENCIMA PARA VERLO

            //si da error avisamos
            println("Vamos a manejar este error")
        }finally {
            //Sea como sea cerramos el archivo para que no quede abierte
            println("Pase lo que pase, hagamos cositas")
        }


        var res1 = value_try(10,2) //execute try block
        println(res1)
        var res2 = value_try(10,0)   // execute catch block
        println(res2)

        var password: String = "1234"
        if (password.length < 6){
            throw IllegalPasswordException("Password muy corta")
        }
        else println("Password segura")




        var btFight = findViewById<Button>(R.id.btFight)
        btFight.setOnClickListener({
                view ->
            fight(firePok, earthPok)
        })

        btFight.setOnClickListener({
            fight(firePok, earthPok)
        })

        btFight.setOnClickListener{
            fight(firePok, earthPok)
        }


    }

    private fun String.noSpaces(): String{
        return this.replace(" ","")
    }
    private fun IntArray.show() {
        print("[")
        for(i in this) print("$i ")
        println("]");
    }


    private fun calculadora(n1: Int, n2: Int, fn: (Int, Int)->Int): Int{
        return fn(n1, n2)
    }

    private fun suma(x: Int, y: Int): Int {  return x+y  }
    private fun resta(x: Int, y: Int): Int {  return x-y  }
    private fun multiplica(x: Int, y: Int) = x*y
    private fun divide(x: Int, y: Int) = x/y

    private fun inColombia(h: Float): Boolean{
        return h >= 1.6f
    }
    private fun inSpain(h: Float): Boolean{
        return h >= 1.65f
    }

    private fun Person.checkPolice(fn: (Float)->Boolean): Boolean{
        return fn(height)
    }

    private fun recorrerArray(array: IntArray, fn: (Int) -> Unit){
        for (i in array)
            fn(i)
    }

    private fun value_try(a: Int, b:Int): Any{
        var res =
            try{

                println("Division $a/$b")

                a/b
            }catch (e: Exception){
                println("Vamos a manejar este error")

                "Division no permitida"
            }

        return res
    }
}

