package ru.geekbrains.bridge;

public class About implements WebPage {
    protected Theme theme;

    @Override
    public void construct(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "About page in " + this.theme.getColor();
    }
}
