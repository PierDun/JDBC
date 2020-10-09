package com.company;

public class Main {

    public static void main(String[] args) {
        DataBase database = new DataBase(Chest.class);
        database.insert(new Chest ("mimik", "55", "2", "5"));
    }
}
