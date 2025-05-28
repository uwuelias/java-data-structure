# Data Structure Performance Visualizer

## Overview

This Java Swing GUI application compares the performance of various sorting and searching algorithms using different Java data structures. It provides a hands-on way to visualize the efficiency of operations like sorting, adding elements to structures, and searching within them.

---

## Features

- Load integers from two separate files:
  - **Sort File**: The main dataset to be sorted and added to structures
  - **Search File**: Values to search within the datasets
- Perform sorting using:
  - Selection Sort
  - Merge Sort (bottom-up)
- Add values to structures:
  - `TreeSet` (BST)
  - `HashSet`
  - `PriorityQueue`
  - `ArrayList` (unsorted and sorted)
  - Raw `int[]` array
- Search structures using:
  - Linear search (e.g., `HashSet`, `ArrayList`)
  - Binary search (e.g., sorted list, array, MergeSorted)
- Measure and display runtime (in milliseconds) for each operation

---

## Execution
Run the program with two arguments: the sort data file and the search data file.
# java wu_feng_p8 sortData.txt searchData.txt
