package top.dolo.springboot02.entity;

public class Girl {
    private String name;
    private int age;
    private char cupSize;

    public String say(){
        System.out.println(name + "wohaiyaoma");
        return name;
    }

    public Girl() {}

    public Girl(String name, int age, char cupSize) {
        this.name = name;
        this.age = age;
        this.cupSize = cupSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getCupSize() {
        return cupSize;
    }

    public void setCupSize(char cupSize) {
        this.cupSize = cupSize;
    }
}
