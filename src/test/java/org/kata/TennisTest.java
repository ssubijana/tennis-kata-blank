package org.kata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;


class TennisTest {

    @Test
    void whenGameStartsScoreShouldBeLoveLove() {
        final Game game = createGameWithScore(0);
        String score = game.getScore();
        assertThat(score, is("love - love"));
    }

    @Test
    void whenPlayerOneWinsOnePointShouldBeFifteenLove() {
        final Game game = createGameWithScore(1);
        String score = game.getScore();

        assertThat(score, is("fifteen - love"));
    }

    @Test
    void whenPlayerOneWinsTwoPointShouldBeFifteenLove() {
        final Game game = createGameWithScore(2);
        String score = game.getScore();

        assertThat(score, is("thirty - love"));
    }

    @Test
    void whenPlayerOneWinsThreePointShouldBeFifteenLove() {
        final Game game = createGameWithScore(3);
        String score = game.getScore();

        assertThat(score, is("forty - love"));
    }

    private Game createGameWithScore(final int score) {
        final Game game = new Game();

        for(int i = 0; i < score; i++) {
            game.playerOneScores();
        }

        return game;
    }
}
