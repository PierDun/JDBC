package com.company;

import java.awt.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Chest implements Serializable {
    private String name;
    private int sum;
    private final DateFormat create_format = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzzz yyyy", Locale.ENGLISH);
    private Date create_date;
    int[] state = new int[2];
    private Color color;

    /**
     * Конструктор сундука
     *
     * @param a - задаваемое имя
     * @param b - задаваемая хранимая сумма
     */
    Chest(String a, String b, String x, String y) {
        setName(a);
        setSum(b);
        create_date = new Date();
        setState(Integer.valueOf(x), Integer.valueOf(y));
    }

    /**
     * Конструктор сундука
     */
    Chest() { int col = (int)(4*Math.random());
        switch (col) {
            case (0): color = Color.red;
                break;
            case (1): color = Color.green;
                break;
            case (2): color = Color.blue;
                break;
            case (3): color = Color.yellow;
                break;
        }
    }

    /**
     * Задать имя сундука
     *
     * @param name - его имя
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Задать сумму, хранимую в сундуке
     *
     * @param sum - сумма на хранение
     */
    void setSum(String sum) {
        try {
            this.sum = Integer.parseInt(sum);
        } catch (NumberFormatException e) {
            System.out.println("Неверный числовой формат в сумме в " + this.name + "'е.");
        }
    }

    void setCreate_date(String date){
        try {
            this.create_date = create_format.parse(date);
        } catch (ParseException e) {
            System.out.println("Строка не преобразоаывается в дату");
        }
    }

    private void setState(int x, int y) {
        try {
            state[0] = x;
            state[1] = y;
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат в координатах в " + this.name + "'е");
        }
    }

    /**
     * Получить имя сундука
     *
     * @return - полученное имя
     */
    String getName() {
        return this.name;
    }

    /**
     * Узнать хранимую в сундуке сумму
     *
     * @return - хранимая сумма
     */
    int getSum() {
        return sum;
    }

    Date getCreate_date() {
        return create_date;
    }

    Color getColor() {
        return color;
    }

    void printInfo(){
        System.out.printf("%s, %d, {%d, %d}, %tF %tT \n", getName(), getSum(), state[0], state[1], getCreate_date(), getCreate_date());
    }
}
