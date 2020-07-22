package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  实现一种狗猫队列的结构,要求如下:
 *  用户可以调用add方法将cat类或dog类的实例放入队列中;
 *  用户可以调用pollAll方法,将队列中所有的实例按照进队列的先后顺序依次弹出;
 *  用户可以调用pollDog方法,将队列中dog类的实例按照进队列的先后顺序依次弹出;
 *  用户可以调用pollCat方法,将队列中cat类的实例按照进队列的先后顺序依次弹出;
 *  用户可以调用isEmpty方法,检查队列中是否还有dog或cat的实例;
 *  用户可以调用isDogEmpty方法,检查队列中是否有dog类的实例;
 *  用户可以调用isCatEmpty方法,检查队列中是否有cat类的实例
 */
public class DogCatQueue {
    class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    class Dog extends Pet {
        public Dog(String type) {
            super(type);
        }
    }

    class Cat extends Pet {
        public Cat(String type) {
            super(type);
        }
    }

    /**
     * 记录每个实例进入队列的时间戳
     */
    class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getEnterPetType() {
            return pet.getType();
        }
    }

    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private long count;

    public DogCatQueue() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        PetEnterQueue petEnterQueue = new PetEnterQueue(pet, count++);
        if ("dog".equals(pet.getType())) {
            dogQueue.add(petEnterQueue);
        } else if ("cat".equals(pet.getType())) {
            catQueue.add(petEnterQueue);
        } else {
            System.out.println("Wrong type");
        }
    }

    public void pollAll() {
        while (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
            if (dogQueue.peek().count > catQueue.peek().count) {
                catQueue.poll();
            } else {
                dogQueue.poll();
            }
        }
        while (!dogQueue.isEmpty()) {
            dogQueue.poll();
        }
        while (!catQueue.isEmpty()) {
            catQueue.poll();
        }
    }

    public Dog pollDog() {
        if (!dogQueue.isEmpty()) {
            return (Dog) dogQueue.poll().getPet();
        }
        return null;
    }

    public Cat poolCat() {
        if (!catQueue.isEmpty()) {
            return (Cat) catQueue.poll().getPet();
        }
        return null;
    }

    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }
}
