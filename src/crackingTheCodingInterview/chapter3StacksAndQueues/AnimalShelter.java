package crackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.LinkedList;

/*
Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
that type). They cannot select which specific animal they would like. Create the data structures to
maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
and dequeueCat. You may use the built in Linkedlist data structure
 */
public class AnimalShelter {

    public static void main(String[] args) {

    }

    abstract class Animal {
        private int order;
        protected String name;
        public Animal(String s) {
            name = s;
        }
        public void setOrder(int order) {
            this.order = order;
        }
        public int getOrder() {
            return this.order;
        }
        //Compare orders of animals to return the older item
        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }
    class Dog extends Animal {
        public Dog(String s) {
            super(s);
        }
    }
    class Cat extends Animal {
        public Cat(String s) {
            super(s);
        }
    }

    class AnimalQueue {
        LinkedList<Dog> dogs = new LinkedList<>();
        LinkedList<Cat> cats = new LinkedList<>();
        private int order = 0; //act as timestamps
        public void enqueue(Animal a) {
            a.setOrder(order);
            order++;
            if(a instanceof Dog)
                dogs.addLast((Dog) a);
            else
                cats.addLast((Cat) a);
        }
        public Animal dequeueAny() {
            //Look at tops of dog and cat queues
            //and pop the queue with the oldest
            if(dogs.size() == 0) {
                return dequeueCats();
            } else if(cats.size() == 0)
                return dequeueDogs();
            Dog dog = dogs.peek();
            Cat cat = cats.peek();
            if(dog.isOlderThan(cat)) {
                return dequeueDogs();
            } else {
                return dequeueCats();
            }
        }
        public Dog dequeueDogs() {
            return dogs.poll();
        }
        public Cat dequeueCats() {
            return cats.poll();
        }
    }



}
