package org.kata;

import java.util.Map;

public class Game {

  private Player playerOne;

  private Player playerTwo;

  public Game(Player playerOne, Player playerTwo) {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
  }

  private final Map<Integer, String> playerScoresTranslation = Map.of(
      0, "love",
      1, "fifteen",
      2, "thirty",
      3, "forty"
  );

  public String getScore() {
    if (playerOne.inDeuceWithPlayer(playerTwo)) {
      return "deuce";
    }
    return String.format("%s - %s", playerScoresTranslation.get(playerOne.getScore()),
        playerScoresTranslation.get(playerTwo.getScore()));
  }
}
