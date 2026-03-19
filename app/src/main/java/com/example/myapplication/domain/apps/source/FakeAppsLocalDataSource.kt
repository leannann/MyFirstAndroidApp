package com.example.myapplication.data.apps.source

import com.example.myapplication.data.apps.dto.AppDto

class FakeAppsLocalDataSource : AppsLocalDataSource {

    private val apps = listOf(
        AppDto(1, "VK", "Сообщения, звонки, клипы и сообщества", "Социальные сети", 4.6f, null),
        AppDto(2, "СберБанк", "Платежи, переводы и управление картами", "Финансы", 4.5f, null),
        AppDto(3, "Яндекс Музыка", "Музыка, подкасты и подборки", "Музыка", 4.7f, null),
        AppDto(4, "Ozon", "Маркетплейс и доставка товаров", "Покупки", 4.4f, null),
        AppDto(5, "Wildberries", "Каталог товаров и пункты выдачи", "Покупки", 4.2f, null),
        AppDto(6, "Telegram", "Чаты, каналы и видеозвонки", "Связь", 4.8f, null),
        AppDto(7, "2ГИС", "Карты, навигация и справочник", "Карты", 4.7f, null),
        AppDto(8, "Авито", "Объявления: покупка и продажа", "Сервисы", 4.3f, null),
        AppDto(9, "Кинопоиск", "Фильмы, сериалы и рекомендации", "Развлечения", 4.6f, null),
        AppDto(10, "YouTube", "Видео, каналы и трансляции", "Видео", 4.5f, null),
        AppDto(11, "Google Maps", "Маршруты, места и отзывы", "Карты", 4.6f, null),
        AppDto(12, "Duolingo", "Изучение языков каждый день", "Образование", 4.8f, null),
    )

    override fun getApps(): List<AppDto> = apps
    override fun getAppById(id: Int): AppDto? = apps.firstOrNull { it.id == id }
}