# Telegram Blackjack Bot

Этот бот для Telegram реализует простую игру в "21" (Blackjack) и позволяет пользователям играть через чат.

## Установка

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/yourusername/telegram-blackjack-bot.git
   cd telegram-blackjack-bot

2. Установите зависимости и запустите сборку (если используете Gradle)::
   ```bash
   ./gradlew build
   
3. Создайте Telegram-бота через BotFather и получите API-токен.
4. В файле BotMain.java укажите свой BOT_TOKEN и BOT_USERNAME.

## Запуск

Запустите бота командой:
 ```bash
java -jar build/libs/telegram-blackjack-bot.jar
 ```

## Как играть

1. Напишите /start, чтобы начать новую игру.
2. Вводите д, чтобы взять карту, или н, чтобы остановиться.
3. Бот определит победителя в соответствии с правилами игры.


 ## Технологии
* Java
* Telegram API
* Gradle
