package com.example.csc207courseproject.use_case.report_game;

public class ReportGameInputData {

    private int winnerId;
    private int gameNumber;
    private String p1Character;
    private String p2Character;

    public ReportGameInputData(int winnerId, int gameNumber, String p1Character, String p2Character) {
        this.winnerId = winnerId;
        this.gameNumber = gameNumber;
        this.p1Character = p1Character;
        this.p2Character = p2Character;
    }
}
