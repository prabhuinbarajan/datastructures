#!/bin/bash
rm -rf sort/*.class
#javac SortClient.java
javac sort/*.java
java -cp . sort.SortClient sort.InsertionSorter
java -cp . sort.SortClient sort.InsertionSorter1
java -cp . sort.SortClient sort.KnuthShellSorter 
java -cp . sort.SortClient sort.BubbleSorter
java -cp . sort.SortClient sort.QuickSorter
java -cp . sort.SortClient sort.QuickSorter1
java -cp . sort.SortClient sort.SelectionSorter
java -cp . sort.SortClient sort.MergeSorter1
java -cp . sort.SortClient sort.HeapSorter
java -cp . sort.SortClient sort.HeapSorter1