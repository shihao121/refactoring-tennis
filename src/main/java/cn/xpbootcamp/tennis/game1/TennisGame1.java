package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private static final String TIE_SCORE_DESCRIPTION = "%s-All";
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        int tempScore = 0;
        if (player1Score == player2Score) {
            score = new StringBuilder("Deuce");
            if (player1Score <= 2) {
                score = new StringBuilder(String.format(TIE_SCORE_DESCRIPTION, scoreDescription.get(player1Score)));

            }
        } else if (player1Score >= 4 || player2Score >= 4) {
            int minusResult = player1Score - player2Score;
            if (minusResult == 1) score = new StringBuilder("Advantage player1");
            else if (minusResult == -1) score = new StringBuilder("Advantage player2");
            else if (minusResult >= 2) score = new StringBuilder("Win for player1");
            else score = new StringBuilder("Win for player2");
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1Score;
                else {
                    score.append("-");
                    tempScore = player2Score;
                }
                score.append(scoreDescription.get(tempScore));
            }
        }
        return score.toString();
    }
}