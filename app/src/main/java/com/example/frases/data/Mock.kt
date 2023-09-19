package com.example.frases.data

import com.example.frases.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val infinity = MotivationConstants.FILTER.ALL
    private val happy = MotivationConstants.FILTER.HAPPY
    private val sun = MotivationConstants.FILTER.SUN

    val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sun),
        Phrase("Você perde todas as chances que você não aproveita.", sun),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sun),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sun),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sun),
        Phrase("Se você acredita, faz toda a diferença.", sun),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sun

        )
    )

    fun getPhrase(value: Int): String {
        val filtered = mListPhrase.filter {it.categoryId == value || value == infinity}
        val index = Random.nextInt(filtered.size)
        return filtered[index].description
    }
}