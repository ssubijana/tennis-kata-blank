package org.kata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;


class TennisTest {

    @Test
    void whenGameStartsScoreShouldBeLoveLove() {
        final Game game = createGameWithScore(0, 0);
        String score = game.getScore();
        assertThat(score, is("love - love"));
    }

    @Test
    void whenPlayerOneWinsOnePointShouldBeFifteenLove() {
        final Game game = createGameWithScore(1, 0);
        String score = game.getScore();

        assertThat(score, is("fifteen - love"));
    }

    @Test
    void whenPlayerOneWinsTwoPointShouldBeFifteenLove() {
        final Game game = createGameWithScore(2, 0);
        String score = game.getScore();

        assertThat(score, is("thirty - love"));
    }

    @Test
    void whenPlayerOneWinsThreePointShouldBeFifteenLove() {
        final Game game = createGameWithScore(3, 0);
        String score = game.getScore();

        assertThat(score, is("forty - love"));
    }

    @Test
    void whenPlayerTwoWinsOnePointShouldBeLoveFifteen() {
        final Game game = createGameWithScore(0, 1);
        String score = game.getScore();

        assertThat(score, is("love - fifteen"));
    }

    private Game createGameWithScore(final int playerOneScore, final int playerTwoScore) {
        final Player playerOne = new Player("one");
        final Player playerTwo = new Player("two");
        final Game game = new Game(playerOne, playerTwo);

        for(int i = 0; i < playerOneScore; i++) {
            playerOne.scores();
        }
        for(int i = 0; i < playerTwoScore; i++) {
            playerTwo.scores();
        }

        return game;
    }
}
