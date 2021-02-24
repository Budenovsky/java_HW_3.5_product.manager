package ru.netology.domain;

public class Smartphone extends Product {
    private String teamMark;

    public Smartphone(int id, String name, int price, String teamMark) {
        super(id, name, price);
        this.teamMark = teamMark;
    }

    public String getTeamMark() {
        return teamMark;
    }

    public void setTeamMark(String teamMark) {
        this.teamMark = teamMark;
    }
}
