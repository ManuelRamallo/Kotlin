package com.mramalldo.rvkotlinex

class SuperHeroProvider {
    companion object {
        val superHeroList = listOf<SuperHero>(
            SuperHero(
                "KotlinMan",
                "JetBrains",
                "Manuel",
                "https://superkotlin.com/wp-content/uploads/2017/06/superkotlinman_16x9-1500x630.png"
            ),
            SuperHero(
                "Batman",
                "DC",
                "Bruce Wayne",
                "https://sm.ign.com/ign_es/review/t/the-batman/the-batman-review_2fcp.jpg"
            ),
            SuperHero(
                "SuperMan",
                "DC",
                "Fernando",
                "https://media.revistagq.com/photos/5eaa92505a16590008bff7c4/master/pass/superman.jpg"
            ),
            SuperHero(
                "Thor",
                "Marvel",
                "Anthornio",
                "https://pics.filmaffinity.com/Thor-917000994-large.jpg"
            ),
            SuperHero(
                "Spiderman",
                "Marvel",
                "Peter Parker",
                "https://www.muycomputer.com/wp-content/uploads/2021/08/Spider-Man.jpg"
            ),
            SuperHero(
                "Doctor Strange",
                "Marvel",
                "Jhon Strange",
                "https://static.wikia.nocookie.net/marveldatabase/images/6/67/Stephen_Strange_%28Earth-199999%29_from_Spider-Man_No_Way_Home_Promo_001.jpg/revision/latest?cb=20211216172929"
            )


        )
    }
}