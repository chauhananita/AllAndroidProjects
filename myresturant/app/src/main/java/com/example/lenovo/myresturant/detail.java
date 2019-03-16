package com.example.lenovo.myresturant;

public class detail {
    String name, add;
    int roll;

    detail()

    {

    }

    public detail(String name, String add, int roll) {
        this.name = name;
        this.add = add;
        this.roll = roll;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
}
