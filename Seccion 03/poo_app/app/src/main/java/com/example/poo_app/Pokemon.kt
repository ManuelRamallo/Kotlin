package com.example.poo_app

class Pokemon ( private var name:String = "Pok",
                private var attackPower:Float = 30f,
                private var life:Float = 100f) {

    fun Pokemon(n:String, aP:Float) {
        this.name = n
        this.attackPower = aP
        this.life = 100f
    }

    fun getName(): String {return this.name}
    fun getAttackPower(): Float {return this.attackPower}
    fun getlife(): Float {return this.life}
    fun setLife(life:Float) {this.life = life}

}