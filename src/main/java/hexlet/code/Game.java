package hexlet.code;

public class Game {
    private static final int WIN_SCORE = 21;
    private static final int MAX_SAFE_SCORE = 17;
    private Deck deck;
    private int playerTotal;
    private int dealerTotal;
    private boolean isPlaying;

    public Game() {
        initGame();
    }

    public void initGame() {
        deck = new Deck();
        playerTotal = deck.drawCard() + deck.drawCard();
        dealerTotal = deck.drawCard() + deck.drawCard();
        isPlaying = true;
        checkInstantWin();
    }

    private void checkInstantWin() {
        if (playerTotal == WIN_SCORE) {
            isPlaying = false;
            System.out.println("Вы набрали 21! Вы победили! Введите /start для новой игры.");
        } else if (dealerTotal == WIN_SCORE) {
            isPlaying = false;
            System.out.println("Крупье набрал 21! Вы проиграли. Введите /start для новой игры.");
        }
    }

    public String processInput(String input) {
        if (input.equals("/start")) {
            initGame();
            return "Добро пожаловать в игру 21! Взять карту? (д/н)";
        }
        if (!isPlaying) {
            return "Введите /start для начала игры.";
        }
        if (input.equals("д")) {
            playerTotal += deck.drawCard();
            if (playerTotal >= WIN_SCORE) {
                isPlaying = false;
                return determineWinner();
            }
            return "Ваш счёт: " + playerTotal + " Взять карту? (д/н)";
        }
        if (input.equals("н")) {
            return dealerTurn();
        }
        return "Некорректный ввод. Введите 'д' для взятия карты или 'н' для завершения.";
    }

    private String dealerTurn() {
        while (dealerTotal < MAX_SAFE_SCORE) {
            dealerTotal += deck.drawCard();
        }
        isPlaying = false;
        return determineWinner();
    }

    private String determineWinner() {
        String result = "Ваш счёт: " + playerTotal + ". Счёт крупье: " + dealerTotal + ". ";
        if (playerTotal > WIN_SCORE) {
            return result + "Перебор! Вы проиграли.";
        } else if (dealerTotal > WIN_SCORE || playerTotal > dealerTotal) {
            return result + "Вы победили!";
        } else if (dealerTotal == playerTotal) {
            return result + "Ничья!";
        } else {
            return result + "Крупье победил!";
        }
    }
}
