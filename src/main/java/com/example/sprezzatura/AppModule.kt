package com.example.sprezzatura

import com.example.sprezzatura.guider.Guider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGuider(): Guider {
        var currentNode = Guider.TreeNode("Привет! Меня зовут Гайдер и я буду твоим цифровым наставником. У меня ты можешь много важной информации. С чего начнем?",
            arrayListOf(
                Guider.ContentItem("Работа"),
                Guider.ContentItem("Обучение"),
                Guider.ContentItem("Коллектив")
            ))
        var workNode = Guider.TreeNode("Работа",
            arrayListOf(
                Guider.ContentItem("Текущий проект"),
                Guider.ContentItem("Мои компетенции")
            ))
        var learningNode = Guider.TreeNode("Обучение",
            arrayListOf(
                Guider.ContentItem("Правила банка"),
                Guider.ContentItem("Ресурсы для обучения")
            ))
        var staffNode = Guider.TreeNode("Коллектив",
            arrayListOf(
                Guider.ContentItem("Знакомство с командой"),
                Guider.ContentItem("Ближайшие активности>")
            ))
        currentNode.content[0].nextNode = workNode
        currentNode.content[1].nextNode = learningNode
        currentNode.content[2].nextNode = staffNode

        var currentProjectNode = Guider.TreeNode("Текущий проект",
            arrayListOf(
                Guider.ContentItem("Отвечающие за проект"),
                Guider.ContentItem("Документация"),
                Guider.ContentItem("Допуски")
            ))

        currentProjectNode.content[0].nextNode = Guider.TreeNode("Отвечающие за проект: ", arrayListOf())
        currentProjectNode.content[1].nextNode = Guider.TreeNode("Документация: ", arrayListOf())
        currentProjectNode.content[2].nextNode = Guider.TreeNode("Допуски: ", arrayListOf())

        var myCompetenceNode = Guider.TreeNode("Ответственность за: ", arrayListOf())

        workNode.content[0].nextNode = currentProjectNode
        workNode.content[1].nextNode = myCompetenceNode

        var bankRulesNode = Guider.TreeNode("Правила банка: ", arrayListOf())

        var learningResourcesNode = Guider.TreeNode("Ресурсы для обучения: ", arrayListOf())

        learningNode.content[0].nextNode = bankRulesNode
        learningNode.content[1].nextNode = learningResourcesNode

        var meetTeamNode = Guider.TreeNode("Знакомство с командой: ", arrayListOf())

        var eventsNode = Guider.TreeNode("Ближайшие активности: ", arrayListOf())

        staffNode.content[0].nextNode = meetTeamNode
        staffNode.content[1].nextNode = eventsNode

        return Guider(currentNode)
    }
}