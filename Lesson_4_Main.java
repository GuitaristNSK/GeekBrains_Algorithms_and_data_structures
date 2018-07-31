package Lesson_4;

import Lesson_3.Queue;
import Lesson_3.Stack;

import java.util.Iterator;

public class Lesson_4_Main {
    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedListImpl<>();
//        list.insertFirst(1);
//        list.insertFirst(2);
//        list.insertFirst(3);
//        list.insertFirst(4);
//        list.display();
//        System.out.println("----------------------------------");
//        System.out.println("Find 3: " + list.find(3));
//        System.out.println("Find 13: " + list.find(13));
//        System.out.println(list.remove(4));
//        list.display();
//----------------------------------------------------------------
//        LinkedListStack stack = new LinkedListStack();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        System.out.println("Stack top = " + stack.peek());
//        stack.pop();
//        while (!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
// ----------------------------------------------------------------
//        TwoWayLinkedList twoWayLinkedList = new TwoWayLinkedListImpl();
//        twoWayLinkedList.insertFirst(1);
//        twoWayLinkedList.insertFirst(2);
//        twoWayLinkedList.insertLast(3);
//        twoWayLinkedList.insertFirst(4);
//        twoWayLinkedList.display();
// ----------------------------------------------------------------
//        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
//        linkedListQueue.insertLast(3);
//        linkedListQueue.insertLast(1);
//        linkedListQueue.insertLast(4);
//        linkedListQueue.insertLast(2);
//        linkedListQueue.insertLast(0);
//        linkedListQueue.insertLast(0);
//        linkedListQueue.removeFirst();
//
//        while (!linkedListQueue.isEmpty()){
//            System.out.println(linkedListQueue.removeFirst()   );
//        }
// ----------------------------------------------------------------
        LinkedList list = new LinkedListImpl();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        LinkedListIterator iterator = new LinkedListIterator(list);

        while (iterator.hasNext()) {
            iterator.next();
            System.out.println("Value" + iterator.getCurrent());
            System.out.println("Is End: " + iterator.isEnd());
            System.out.println("---------------");
        }
        iterator.insertAfter(5);
        iterator.insertAfter(6);
        iterator.insertBefore(7);
        iterator.deleteCurrent();

        for (Object iter:list) {
            System.out.println(iter);
        }
    }
}
