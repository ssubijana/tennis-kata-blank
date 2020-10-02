package org.kata;

public class Player {

  private String name;

  private int score;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public void scores() {
    score++;
  }

  public boolean inDeuceWithPlayer(final Player otherPlayer) {
    final boolean isForty = this.score >= 3;
    return isForty && this.score == otherPlayer.getScore();
  }
}
