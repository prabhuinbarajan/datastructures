#!/bin/bash
rm -rf *.class
#javac SortClient.java
javac *.java
java SortClient InsertionSorter
java SortClient InsertionSorter1
java SortClient KnuthShellSorter 
java SortClient BubbleSorter
java SortClient QuickSorter
java SortClient SelectionSorter
java SortClient MergeSorter1
java SortClient HeapSorter
