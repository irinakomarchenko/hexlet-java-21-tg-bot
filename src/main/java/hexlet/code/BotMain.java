package hexlet.code;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotMain extends TelegramLongPollingBot {
    private final Game game = new Game();

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new BotMain());
        System.out.println("Bot started!");
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }

        String chatId = update.getMessage().getChatId().toString();
        String userInput = update.getMessage().getText().trim();

        String response = game.processInput(userInput);
        sendMessage(chatId, response);
    }

    private void sendMessage(String chatId, String text) {
        SendMessage sendMessage = new SendMessage(chatId, text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Hexlet_java_i22r_bot";
    }

    @Override
    public String getBotToken() {
        return //"YOUR_BOT_TOKEN_HERE";
                "7753905667:AAHheJkt70yhgx_0RKi57JyAppUwBWfu3t8";
    }
}
