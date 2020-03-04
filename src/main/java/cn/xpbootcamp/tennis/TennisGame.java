package cn.xpbootcamp.tennis;

import java.util.HashMap;
import java.util.Map;

public interface TennisGame {
    Map<Integer, String> scoreDescription = new HashMap<Integer, String>(){{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};
    void wonPoint(String playerName);
    String getScore();
}