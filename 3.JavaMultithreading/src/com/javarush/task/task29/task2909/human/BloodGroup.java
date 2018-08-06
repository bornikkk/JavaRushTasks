package com.javarush.task.task29.task2909.human;

public class BloodGroup {
    /*
9.4.2. Добавь в класс BloodGroup приватное константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3. Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
9.4.4. Примени в классе Human новый тип BloodGroup.
     */
    private final int code;

    public static BloodGroup first(){
        return new BloodGroup(1);
    }

    public static BloodGroup second(){
        return new BloodGroup(2);
    }

    public static BloodGroup third(){
        return new BloodGroup(3);
    }

    public static BloodGroup fourth(){
        return new BloodGroup(4);
    }

    private BloodGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
