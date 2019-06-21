package AgChSaJo;

/**
 * In case we want to add an additional game to our App
 * we just need the IGame interfaces it holds all methods
 * a game necessarily need
 */
public interface IGame {

    void playAgain();
    void resumeGame();
    void stopGame();
    void closeGame();
}
