package org.kata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


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

    @Test
    void shouldReturnDeuce() {
        final Game game1 = createGameWithScore(3, 3);
        final Game game2 = createGameWithScore(5, 5);
        final String score1 = game1.getScore();
        final String score2 = game2.getScore();

        assertThat(score1, is("deuce"));
        assertThat(score2, is("deuce"));
    }

    @Test
    void shouldReturnPlayerOneAdvantage() {
        final Game game1 = createGameWithScore(4, 3);
        final Game game2 = createGameWithScore(7, 6);

        final String score1 = game1.getScore();
        final String score2 = game2.getScore();

        assertThat(score1, is("one advantage"));
        assertThat(score2, is("one advantage"));
    }

    @Test
    void shouldReturnPlayerTwoAdvantage() {
        final Game game1 = createGameWithScore(3, 4);
        final Game game2 = createGameWithScore(6, 7);

        final String score1 = game1.getScore();
        final String score2 = game2.getScore();

        assertThat(score1, is("two advantage"));
        assertThat(score2, is("two advantage"));
    }

    @Test
    void shouldReturnPlayerOneWins() {
        final Game game1 = createGameWithScore(5, 3);
        final Game game2 = createGameWithScore(7, 5);

        final String score1 = game1.getScore();
        final String score2 = game2.getScore();

        assertThat(score1, is("one wins"));
        assertThat(score2, is("one wins"));
    }

    @Test
    void shouldReturnPlayerTwoWins() {
        final Game game1 = createGameWithScore(3, 5);
        final Game game2 = createGameWithScore(5, 7);

        final String score1 = game1.getScore();
        final String score2 = game2.getScore();

        assertThat(score1, is("two wins"));
        assertThat(score2, is("two wins"));
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
