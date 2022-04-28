package com.mramalldo.mvvmkotlinex.model

import kotlin.random.Random

class QuoteProvider {
    companion object {
        fun random():QuoteModel{
            val position = Random.nextInt(0, 9)
            return quote[position]
        }

        private val quote = listOf<QuoteModel>(
            QuoteModel(
                quote = "It's not a bug. It's an undocumented feature!",
                author = "Anonymous"
            ),
            QuoteModel(
                quote = "Software Developer - An organism that turns caffeine into software",
                author = "Anonymous"
            ),
            QuoteModel(
                quote = "If debugging is the process of removing software bugs, then programming must be the process of putting them in",
                author = "Edsger Dijkstra"
            ),
            QuoteModel(
                quote = "We build our computer (systems) the way we build our cities: over time, without a plan, on top of ruins",
                author = "Ellen Ullman"
            ),
            QuoteModel(
                quote = "One of the best programming skills you can have is knowing when to walk away for a while",
                author = "Oscar Godson"
            ),
            QuoteModel(
                quote = "The computer was born to solve problems that did not exist before.",
                author = "Bill Gates "
            ),
            QuoteModel(
                quote = "One of my most productive days was throwing away 1000 lines of code.",
                author = "Ken Thompson"
            ),
            QuoteModel(
                quote = "Good code is its own best documentation. As you’re about to add a comment, ask yourself, “How can I improve the code so that this comment isn’t needed?” Improve the code and then document it to make it even clearer",
                author = "Steve McConnell"
            ),
            QuoteModel(
                quote = "The first 90% of the code accounts for the first 90% of the development time. The remaining 10% of the code accounts for the other 90% of the development time.",
                author = "Tom Cargill"
            ),
            QuoteModel(
                quote = "It’s hard enough to find an error in your code when you’re looking for it; it’s even harder when you’ve assumed your code is error-free.",
                author = "Steve McConnell"
            ),
        )
    }
}