package org.kata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;


class TennisTest {

    @Test
    void whenGameStartsScoreShouldBeLoveLove() {
        final Game game = new Game();
        String score = game.getScore();
        assertThat(score, is("love - love"));
    }

    @Test
    void whenPlayerOneWinsOnePointShouldBeFifteenLove() {
        final Game game = new Game();
        game.playerOneScores();
        String score = game.getScore();

        assertThat(score, is("fifteen - love"));
    }

    @Test
    void whenPlayerOneWinsTwoPointShouldBeFifteenLove() {
        final Game game = new Game();
        game.playerOneScores();
        game.playerOneScores();
        String score = game.getScore();

        assertThat(score, is("thirty - love"));
    }
}
