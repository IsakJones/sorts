# sorts
This project includes ten implementations of sorting algorithms, including:
 - Selection sort;
 - Insertion sort;
 - Bubble sort;
 - Shell sort;
 - Merge sort (plus improvement);
 - Quick sort (plus improvement);
 - Heap sort;
There is also an implementation of Quick Selection, which finds the kth largest or smallest element in an array
(in linear time) and the implementation of a heap representing a min-oriented binary tree.

Overall, the project was a great opportunity to test and improve my knowledge of the most common sorting
algorithms, as well as a great introduction to the object-oriented structure of Java programs, and a neat
opportunity to empirically observe performance beyond the theory (i.e. beyond big O notation).

Each sorting algorithm's performance is measured in milliseconds, with surprising results!
For example, shellsort has in my tests been consistently faster than mergesort, and quicksort has consistently
outperformed other algorithms. Heapsort is also very fast, and surprisingly faster than mergesort, despite the
intensive use of memory.

These implementations draw heavy inspiration from Princeton's "[Algorithms Part 1](https://www.coursera.org/learn/algorithms-part1/home/welcome)" course on Coursera,
though I have tried to make the implementations my own by writing out the algorithms from memory after at least
one day of the corresponding lecture, and only double-checked the slides' code if I got stuck (Quicksort was
particularly tricky to implement).
