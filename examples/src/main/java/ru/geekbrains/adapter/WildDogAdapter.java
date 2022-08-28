package ru.geekbrains.adapter;

public class WildDogAdapter implements Lion {
    protected WildDog dog;

    public WildDogAdapter(WildDog dog) {
        this.dog = dog;
    }

    @Override
    public void roar() {
        this.dog.bark();
    }
}
