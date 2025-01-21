package hexlet.code;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotMain extends TelegramLongPollingBot {

    public static void main(String[] atgs) throws TelegramApiException  {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new BotMain());
        System.out.println("Hello!");
    }

    @Override
    public void onUpdateReceived(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String userInput = update.getMessage().getText();
        System.out.println(userInput);


        if(userInput.equals("/start")) {
            sendMessage(chatId, "Добро пожаловать в игру 21");
            sendMessage(chatId, "Взять карту? (д/н)");
        }
        if (userInput.equals("д")) {
            sendMessage(chatId, "Ваш счет: + 0");
            sendMessage(chatId, "Взять карту? (д/н)");
        }

        if (userInput.equals("н")) {
            sendMessage(chatId, "Ход крупье ...");
            while (deal)
        }

        if (dealer)

        SendMessage sendMessage = new SendMessage(chatId, userInput);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    void sendMessage

    @Override
    public String getBotUsername() {
        return "Hexlet_java_i22r_bot";
    }

    @Override
    public String getBotToken() {
        return "7753905667:AAHheJkt70yhgx_0RKi57JyAppUwBWfu3t8";
    }
}
