package org.kata;

import java.util.Map;

public class Game {

  private int playerOneScore;

  private Map<Integer, String> playerScoresText = Map.of(
      0, "love",
      1, "fifteen",
      2, "thirty"
  );

  public String getScore() {
    return String.format("%s - love", playerScoresText.get(playerOneScore));
  }

  public void playerOneScores() {
    playerOneScore++;
  }
}
