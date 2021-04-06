package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private static final String TIE_SCORE_DESCRIPTION_FORMAT = "%s-All";
    private static final String SCORE_DESCRIPTION_FORMAT = "%s %s";
    private static final String ABC = "%s-%s";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE = "Advantage";
    public static final String WIN_FOR = "Win for";
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return GenerateTieScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return GenerateWinnerScore();
        } else {
            return GenerateOrdinaryScore();
        }
    }

    private String GenerateTieScore() {
        if (player1Score <= 2) {
            return String.format(TIE_SCORE_DESCRIPTION_FORMAT, scoreDescription.get(player1Score));
        }
        return DEUCE;
    }

    private String GenerateWinnerScore() {
        int minusResult = player1Score - player2Score;
        String title = Math.abs(minusResult) == 1 ? ADVANTAGE : WIN_FOR;
        String winnerName = minusResult > 0 ? player1Name : player2Name;
        return String.format(SCORE_DESCRIPTION_FORMAT, title, winnerName);
    }

    private String GenerateOrdinaryScore() {
        return String.format(ORDINARY_DESCRIPTION_FORMAT,
                scoreDescription.get(player1Score), scoreDescription.get(player2Score));
    }
}
