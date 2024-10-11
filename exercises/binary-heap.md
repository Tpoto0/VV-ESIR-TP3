# Implementing and testing a binary heap

A [*binary heap*](https://en.wikipedia.org/wiki/Binary_heap) is a data structure that contains comparable objects and it is able to efficiently return the lowest element.
This data structure relies on a binary tree to keep the insertion and deletion operations efficient. It is the base of the [*Heapsort* algorithm](https://en.wikipedia.org/wiki/Heapsort).

Implement a `BinaryHeap` class with the following interface:

```java
class BinaryHeap<T> {

    public BinaryHeap(Comparator<T> comparator) { ... }

    public T pop() { ... }

    public T peek() { ... }

    public void push(T element) { ... }

    public int count() { ... }

}
```

A `BinaryHeap` instance is created using a `Comparator` object that represents the ordering criterion between the objects in the heap.
`pop` returns and removes the minimum object in the heap. If the heap is empty it throws a `NotSuchElementException`.
`peek` similar to `pop`, returns the minimum object but it does not remove it from the `BinaryHeap`.
`push` adds an element to the `BinaryHeap`.
`count` returns the number of elements in the `BinaryHeap`.

Design and implement a test suite for this `BinaryHeap` class.
Feel free to add any extra method you may need.

Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-heap](../code/tp3-heap) to complete this exercise.

## Answer

1. 
Method: pop()

Characteristics
Heap size:
- Block 1: Empty heap (invalid input, expect assertion error)
- Block 2: Single-element heap
- Block 3: Multiple-element heap

Heap structure (if not empty):
- Block 1: Balanced heap
- Block 2: Unbalanced heap

Method: peek()

Characteristics
Heap size:
- Block 1: Empty heap (invalid input, expect assertion error)
- Block 2: Non-empty heap

Top element value (for non-empty heap):
- Block 1: Minimum element (already at root)
- Block 2: Other elements (not at root)

Method: push(T element)

Characteristics
Heap size:
- Block 1: Empty heap
- Block 2: Non-empty heap

Element relationship:
- Block 1: Element smaller than the current root
- Block 2: Element larger than the current root
- Block 3: Element already in the heap (duplicate values)

Method: count()
Characteristics
Heap size:
- Block 1: Empty heap
- Block 2: Single-element heap
- Block 3: Multiple-element heap

2. 
After evaluating the test cases coverage and adding some tests to improve the initial coverage, we get a score of 97%.To do this, we launch the test coverage with VSCode, this indicates the score and the areas where the code passes or does not pass. It is thanks to this visualization that we can see that the coverage is almost perfect.

3. 