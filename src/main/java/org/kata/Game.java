package org.kata;

import java.util.Map;
import java.util.Optional;

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
    if (isDeuce()) {
      return "deuce";
    }
    final Optional<Player> playerWithAdvantageOpt = hasPlayerAdvantage();
    if (playerWithAdvantageOpt.isPresent()) {
      return String.format("%s advantage", playerWithAdvantageOpt.get().getName());
    }
    return String.format("%s - %s", playerScoresTranslation.get(playerOne.getScore()),
        playerScoresTranslation.get(playerTwo.getScore()));
  }

  public boolean isDeuce() {
    final boolean isForty = playerOne.getScore() >= 3;
    return isForty && playerOne.getScore() == playerTwo.getScore();
  }

  public Optional<Player> hasPlayerAdvantage() {
    if (playerOne.getScore() >= 4 && playerOne.getScore() -1 == playerTwo.getScore()) {
      return Optional.of(playerOne);
    }
    if (playerTwo.getScore() >= 4 && playerTwo.getScore() -1 == playerOne.getScore()) {
      return Optional.of(playerTwo);
    }
    return Optional.empty();
  }
}
