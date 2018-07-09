package stacks;

import java.util.LinkedList;


public class AnimalShelter {
    private class PetNode{}

    private LinkedList<Pet> cats;
    private LinkedList<Pet> dogs;

    public AnimalShelter() {

    }

    public void enqueue(Pet pet) {
        queue.add(pet);

    }

    public Pet dequeueAny(){
        Pet result = queue.getLast();
        queue.removeLast();
        return result;
    }

    public Dog dequeueDog() {

    }

    public Cat dequeueCat() {

    }
}

class Pet{}

class Dog extends Pet{}

class Cat extends Pet{}