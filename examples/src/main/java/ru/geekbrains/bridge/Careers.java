package ru.geekbrains.bridge;

public class Careers implements WebPage {
    protected Theme theme;

    @Override
    public void construct(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "Careers page in " + this.theme.getColor();
    }
}
