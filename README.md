# GoTrainning

Compilation of all of the excercises being solved during the training.

## Packages

There are three folders according to the following:
```
src
 |-- crackingcodinginterview
 |-- hackerrank
 |-- more
 |-- multithreading
 +-- functionalprogramming
```
All of them contains exercises requested from the book Cracking the Coding Interview, exercises requested from HackerRank (on the presentation) and additional exercises requested during the training.

## Time complexity

Here we go, trying to get the time complexities from our solutions... 

### Cracking the Coding Interview

#### Chapter 1 - Arrays and Strings
   1. UniqueCharacters.java - Sol 1: Complexity `O(n)` Sol 2: Complexity `O(n)` Sol 3: Complexity `O(n+(n-1)+(n-2)...) = O(n/2)`
   2. ReverseCStyleString.java - Complexity `O(n)`
   3. RemoveDuplicateCharacters.java - Complexity `O(n * m^2)`
   4. Anagrams.java - Complexity `O(n) + O(2(n * log2(n))) = O(n * log2(n))`
   5. ReplaceSpaces.java - Complexity `O(n)`
   8. RotationWithSubstring.java - Complexity `O(n)`
   6. RotateMatrix.java - Complexity `O((n-1)+(n-2)...) = O(n/2)` 
  
#### Chapter 2 - Linked Lists
   1. HappyLinkedList.java - Remove duplicates - Complexity `O(n^2)`
   2. HappyLinkedList.java - Get sublist- Complexity `O(n)`
   3. HappyLinkedList.java - Remove node - Complexity `O(n)`
   4. SumWithLinkedList.java - Complexity `O(n)`

### HackerRank 

#### OOPs
  1. InheritanceI.java - https://www.hackerrank.com/challenges/java-com - Complexity `O(1)`

#### Collections
  1. OperationsOnList.java - https://www.hackerrank.com/challenges/java-list - Complexity `O(n)`
  2. XYOperationsOnArrayList.java - https://www.hackerrank.com/challenges/java-arraylist - Complexity `O(n*m + q)`
  3. PhoneBookOnMap.java - https://www.hackerrank.com/challenges/phone-book - Complexity `O(n)`
  4. NamesOnHashset.java - https://www.hackerrank.com/challenges/java-hashset - Complexity `O(n)`
  5. NeighboursNumbersOnDeque.java - https://www.hackerrank.com/challenges/java-dequeue - Complexity `O(n)`
  6. PlayerComparator.java - https://www.hackerrank.com/challenges/java-comparator - Complexity `O(n)`
  7. StudentSort.java - https://www.hackerrank.com/challenges/java-sort - Complexity `O(n)`
  8. BalancedBrackets.java / https://www.hackerrank.com/challenges/balanced-brackets - Complexity `O(n)`

### More 
* PrimarySchoolStudents - Complexity `O(n)`
* WeirdMap.java - Complexity `O(1)`
* HappyTree.java - Find Least Common Ancestor - Complexity `O(log2(n))`
* HappyTree.java - Traverse Depth First - Pre Order - Complexity `O(n)`
* HappyTree.java - Traverse Depth First - In Order - Complexity `O(n)`
* HappyTree.java - Traverse Depth First - Post Order - Complexity `O(n)`
* HappyTree.java - Traverse Breadth First - Complexity `O(n)`
* HappyTree.java - Is BST - Complexity `O(n)`
* BucketTestingHashMap.java

### Multithreading
* CountingThreads.java
* PingPong.java
* ThreadSafeSingletonObject.java
* ThreadSafeSingletonObjectEnum.java


### Functional programming
* FunctionalProgramming.java - Day 7 exercises
* LambdasHackerRank.java - Day 7 exercises


