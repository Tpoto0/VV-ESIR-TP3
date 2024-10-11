package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;

class BinaryHeap<T> {
    private ArrayList<T> heap;
    private Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    public T pop() {
        assert !heap.isEmpty() : "Heap is empty";
        T result = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        movingDown(0);  
        return result;
    }

    public T peek() {
        assert !heap.isEmpty() : "Heap is empty";
        return heap.get(0);
    }

    public void push(T element) {
        heap.add(element);
        movingUp(heap.size() - 1);
    }

    public int count() {
        return heap.size();
    }

    // Restore the heap property by moving the element up
    private void movingUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (comparator.compare(heap.get(index), heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Restore the heap property by moving the element down
    private void movingDown(int index) {
        int leftChild, rightChild, smallest;
        while (index < heap.size()) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            smallest = index;

            if (leftChild < heap.size() && comparator.compare(heap.get(leftChild), heap.get(smallest)) < 0) {
                smallest = leftChild;
            }
            if (rightChild < heap.size() && comparator.compare(heap.get(rightChild), heap.get(smallest)) < 0) {
                smallest = rightChild;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    // Function to swap elements in the heap
    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

}