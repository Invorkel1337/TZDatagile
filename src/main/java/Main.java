
abstract class Animal {
    private String name;
    private int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract void makeSound();
    public void eat() {
        System.out.println(name + " ест.");
    }

    public void sleep() {
        System.out.println(name + " спит.");
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    @Override
    public void makeSound() {
        System.out.println(getName() + " лает: Гав-гав!");
    }

    public String getBreed() {
        return breed;
    }
}
class Cat extends Animal {
    private boolean isIndoor; // Дополнительное поле

    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " мяукает: Мяу!");
    }

    public boolean isIndoor() {
        return isIndoor;
    }
}
public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Бобик", 5, "Лабрадор");
        Animal cat = new Cat("Мурка", 3, true);

        dog.makeSound();
        dog.eat();
        dog.sleep();

        cat.makeSound();
        cat.eat();
        cat.sleep();

        if (dog instanceof Dog) {
            Dog specificDog = (Dog) dog;
            System.out.println("Порода собаки: " + specificDog.getBreed());
        }

        if (cat instanceof Cat) {
            Cat specificCat = (Cat) cat;
            System.out.println("Кошка домашняя? " + specificCat.isIndoor());
        }
    }
}