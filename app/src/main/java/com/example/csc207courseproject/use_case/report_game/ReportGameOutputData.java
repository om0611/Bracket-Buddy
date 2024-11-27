package com.example.csc207courseproject.use_case.report_game;

public class ReportGameOutputData {

    private int winnerID;
    private int gameNumber;
    private String p1Character;
    private String p2Character;


    public ReportGameOutputData(int winnerID, int gameNumber, String p1Character, String p2Character) {
        this.winnerID = winnerID;
        this.gameNumber = gameNumber;
        this.p1Character = p1Character;
        this.p2Character = p2Character;
    }
}
