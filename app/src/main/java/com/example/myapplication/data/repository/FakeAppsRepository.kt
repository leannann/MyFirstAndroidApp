package com.example.myapplication.data.repository

import com.example.myapplication.data.model.AppUiModel

object FakeAppsRepository : AppsRepository {

    private val apps = listOf(
        AppUiModel(
            id = 1,
            title = "VK",
            description = "Сообщения, звонки, клипы и сообщества",
            category = "Социальные сети",
            rating = 4.6f
        ),
        AppUiModel(
            id = 2,
            title = "СберБанк",
            description = "Платежи, переводы и управление картами",
            category = "Финансы",
            rating = 4.5f
        ),
        AppUiModel(
            id = 3,
            title = "Яндекс Музыка",
            description = "Музыка, подкасты и подборки",
            category = "Музыка",
            rating = 4.7f
        ),
        AppUiModel(
            id = 4,
            title = "Ozon",
            description = "Маркетплейс и доставка товаров",
            category = "Покупки",
            rating = 4.4f
        ),
        AppUiModel(
            id = 5,
            title = "Wildberries",
            description = "Каталог товаров и пункты выдачи",
            category = "Покупки",
            rating = 4.2f
        ),
        AppUiModel(
            id = 6,
            title = "Telegram",
            description = "Чаты, каналы и видеозвонки",
            category = "Связь",
            rating = 4.8f
        ),
        AppUiModel(
            id = 7,
            title = "2ГИС",
            description = "Карты, навигация и справочник",
            category = "Карты",
            rating = 4.7f
        ),
        AppUiModel(
            id = 8,
            title = "Авито",
            description = "Объявления: покупка и продажа",
            category = "Сервисы",
            rating = 4.3f
        ),
        AppUiModel(
            id = 9,
            title = "Кинопоиск",
            description = "Фильмы, сериалы и рекомендации",
            category = "Развлечения",
            rating = 4.6f
        ),
        AppUiModel(
            id = 10,
            title = "YouTube",
            description = "Видео, каналы и трансляции",
            category = "Видео",
            rating = 4.5f
        ),
        AppUiModel(
            id = 11,
            title = "Google Maps",
            description = "Маршруты, места и отзывы",
            category = "Карты",
            rating = 4.6f
        ),
        AppUiModel(
            id = 12,
            title = "Duolingo",
            description = "Изучение языков каждый день",
            category = "Образование",
            rating = 4.8f
        )
    )

    override fun getApps(): List<AppUiModel> = apps

    override fun getAppById(id: Int): AppUiModel? =
        apps.firstOrNull { it.id == id }
}