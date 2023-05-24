# Puzzlers

This repository contains a set of programming puzzles that are solved using Java or Kotlin programming language.
Tests provided for every problem.

## Project structure

The project directory structure is as follows:

    .
    ├── src/main                                  # Source files
    │   ├── java                                  # Java sources
    │   ├── kotlin                                # Kotlin sources
    ├── src/test                                  # Test files
    │   ├── resources/.../*tested-class-name*/    # Tested class resources (input and output files)
    ├── LICENSE
    └── README.md

### Test source

[TestSource](src/test/java/io/github/chizganov/puzzlers/util/TestSource.java) annotation and
[TestSourceProvider](src/test/java/io/github/chizganov/puzzlers/util/TestSourceProvider.java) are junit's
ArgumentProvider implementation
that search for the test resources (input and output files) in the directory structure, the same as test(ed) class
package.
Allows to test different class implementations (solutions to the problem) for every input-output pair file as in the
code snippet below:

```kotlin
@ParameterizedTest
@TestSource(
    value = RucksackReorganization::class, // used as single implementation if no custom implementations provided.
    implementations = [RucksackReorganization::class, IdiomaticRucksackReorganization::class]
)
fun findTotalRearrangementPriority(rucksackReorganization: RucksackReorganization, input: Path, output: Path)
```

With execution of 4 tests for 2 implementations and 2 input-output pairs.
![test-results.png](doc/test-results.png)

## Advent of Code 2022

[Advent of Code 2022](https://adventofcode.com/2022) challenge.

| Day | Problem                                                         | Solution                                                                                                                   |
|-----|-----------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|
| 1   | [Calorie Counting](https://adventofcode.com/2022/day/1)         | [CalorieCounting.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/CalorieCounting.kt)               |
| 2   | [Rock Paper Scissors](https://adventofcode.com/2022/day/2)      | [RockPaperScissors.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/RockPaperScissors.kt)           |
| 3   | [Rucksack Reorganization](https://adventofcode.com/2022/day/3)  | [RucksackReorganization.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/RucksackReorganization.kt) |
| 4   | [Camp of Cleanup](https://adventofcode.com/2022/day/4)          | [CampCleanup.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/CampCleanup.kt)                       |
| 5   | [Supply Stacks](https://adventofcode.com/2022/day/5)            | [SupplyStacks.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/SupplyStacks.kt)                     |
| 6   | [Tuning Trouble](https://adventofcode.com/2022/day/6)           | [TuningTrouble.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/TuningTrouble.kt)                   |
| 7   | [No Space Left On Device](https://adventofcode.com/2022/day/7)  | [DeviceSpace.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/DeviceSpace.kt)                       |
| 8   | [Treetop Tree House](https://adventofcode.com/2022/day/8)       | [TreetopTreeHouse.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/TreetopTreeHouse.kt)             |
| 9   | [Rope Bridge](https://adventofcode.com/2022/day/9)              | [RopeBridge.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/RopeBridge.kt)                         |
| 10  | [Cathode-Ray Tube](https://adventofcode.com/2022/day/10)        | [CathodeRayTube.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/CathodeRayTube.kt)                 |
| 11  | [Monkey In The Middle](https://adventofcode.com/2022/day/11)    | [MonkeyInTheMiddle.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/MonkeyInTheMiddle.kt)           |
| 12  | [Hill Climbing Algorithm](https://adventofcode.com/2022/day/12) | [HillClimbingAlgorithm.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/HillClimbingAlgorithm.kt)   |
| 13  | [Distress Signal](https://adventofcode.com/2022/day/13)         | [DistressSignal.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/DistressSignal.kt)                 |
| 14  | [Regolith Reservoir](https://adventofcode.com/2022/day/14)      | [RegolithReservoir.kt](src/main/kotlin/io/github/chizganov/puzzlers/adventofcode/twentytwo/RegolithReservoir.kt)           |

## Leetcode

The following challenges from the [Leetcode](https://leetcode.com/).

### Top Interview Questions

This is the list of the [Top Interview Questions](https://leetcode.com/problemset/all/?listId=wpwgkgt&page=1).

| Number | Problem                                                                                                                                 | Solution                                                                                                                         |
|--------|-----------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| 1      | [Two Sum](https://leetcode.com/problems/two-sum/)                                                                                       | [TwoSum.java](src/main/java/io/github/chizganov/puzzlers/leetcode/TwoSum.java)                                                   |
| 2      | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)                                                                       | [AddTwoNumbers.java](src/main/java/io/github/chizganov/puzzlers/leetcode/AddTwoNumbers.java)                                     |
| 5      | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/)                               | [LongestPalindromicSubstring.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/LongestPalindromicSubstring.kt)           |
| 14     | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)                                                           | [LongestCommonPrefix.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/LongestCommonPrefix.kt)                           |
| 20     | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)                                                                   | [ValidParentheses.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/ValidParentheses.kt)                                 |
| 28     | [Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/) | [FirstOccurrenceInString.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/FirstOccurrenceInString.kt)                   |
| 33     | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)                                         | [SearchInRotatedSortedArray.java](src/main/java/io/github/chizganov/puzzlers/leetcode/thirtyday/SearchInRotatedSortedArray.java) |
| 38     | [Count and Say](https://leetcode.com/problems/count-and-say/)                                                                           | [CountAndSay.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/CountAndSay.kt)                                           |
| 54     | [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)                                                                           | [SpiralMatrix.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/SpiralMatrix.kt)                                         |
| 55     | [Jump Game](https://leetcode.com/problems/jump-game/)                                                                                   | [JumpGame.java](src/main/java/io/github/chizganov/puzzlers/leetcode/thirtyday/JumpGame.java)                                     |
| 69     | [Sqrt(x)](https://leetcode.com/problems/sqrtx/)                                                                                         | [Sqrt.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/Sqrt.kt)                                                         |
| 70     | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)                                                                       | [ClimbingStairs.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/ClimbingStairs.kt)                                     |
| 101    | [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)                                                                         | [SymmetricTree.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/SymmetricTree.kt)                                       |
| 104    | [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)                                             | [BstMaxDepth.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/BinaryTreeMaxDepth.kt)                                    |
| 124    | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)                                             | [BinaryTreeMaxPath.java](src/main/java/io/github/chizganov/puzzlers/leetcode/thirtyday/BinaryTreeMaxPath.java)                   |
| 125    | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)                                                                     | [ValidPalindromeSentence.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/ValidPalindromeSentence.kt)                   |
| 136    | [Single Number](https://leetcode.com/problems/single-number/)                                                                           | [SingleNumber.java](src/main/java/io/github/chizganov/puzzlers/leetcode/thirtyday/SingleNumber.java)                             |
| 146    | [LRU Cache](https://leetcode.com/problems/lru-cache/)                                                                                   | [LRUCache.java](src/main/java/io/github/chizganov/puzzlers/leetcode/thirtyday/LRUCache.java)                                     |
| 152    | [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)                                                     | [MaxProductSubarray.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/MaxProductSubarray.kt)                             |
| 169    | [Majority Element](https://leetcode.com/problems/majority-element/)                                                                     | [MajorityElement.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/MajorityElement.java)                             |
| 191    | [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)                                                                     | [BitsNumber.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/BitsNumber.kt)                                             |
| 200    | [Number of Islands](https://leetcode.com/problems/number-of-islands/)                                                                   | [NumberOfIslands.java](src/main/java/io/github/chizganov/puzzlers/leetcode/thirtyday/NumberOfIslands.java)                       |
| 202    | [Happy Number](https://leetcode.com/problems/happy-number/)                                                                             | [HappyNumber.java](src/main/java/io/github/chizganov/puzzlers/leetcode/thirtyday/HappyNumber.java)                               |
| 208    | [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)                                               | [Trie.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/Trie.java)                                                   |
| 230    | [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)                                           | [KthSmallestElementInBst.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/KthSmallestElementInBst.java)             |
| 238    | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)                                             | [ProductExceptSelf.java](src/main/java/io/github/chizganov/puzzlers/leetcode/thirtyday/ProductExceptSelf.java)                   |
| 328    | [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)                                                             | [OddEvenLinkedList.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/OddEvenLinkedList.java)                         |
| 344    | [Reverse String](https://leetcode.com/problems/reverse-string/)                                                                         | [ReverseString.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/ReverseString.kt)                                       |
| 347    | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements)                                                        | [TopKFrequentElements.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/TopKFrequentElements.kt)                         |
| 350    | [Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/)                                           | [TwoArrayIntersectionII.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/TwoArrayIntersectionII.kt)                     |
| 387    | [First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/)                                 | [FirstUniqueChar.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/FirstUniqueChar.java)                             |
| 412    | [Fizz Buzz](https://leetcode.com/problems/fizz-buzz/)                                                                                   | [FizzBazz.kt](src/main/kotlin/io/github/chizganov/puzzlers/leetcode/FizzBuzz.kt)                                                 |

### May LeetCoding Challenge

[May LeetCoding](https://leetcode.com/explore/featured/card/may-leetcoding-challenge/) consists of 31 daily problems
over May. Beginner-friendly.

| Day | Number | Problem                                                                                                                                     | Solution                                                                                                                             |
|-----|--------|---------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| 1   | 278    | [First Bad Version](https://leetcode.com/problems/first-bad-version/)                                                                       | [FirstBadVersion.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/FirstBadVersion.java)                                 |
| 2   | 771    | [Jewels And Stones](https://leetcode.com/problems/jewels-and-stones/)                                                                       | [JewelsAndStones.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/JewelsAndStones.java)                                 |
| 3   | 383    | [Ransom Note](https://leetcode.com/problems/ransom-note/)                                                                                   | [RansomNote.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/RansomNote.java)                                           |
| 4   | 476    | [Number Complement](https://leetcode.com/problems/number-complement/)                                                                       | [NumberComplement.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/NumberComplement.java)                               |
| 5   | 387    | [First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/)                                     | [FirstUniqueChar.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/FirstUniqueChar.java)                                 |
| 6   | 169    | [Majority Element](https://leetcode.com/problems/majority-element/)                                                                         | [MajorityElement.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/MajorityElement.java)                                 |
| 7   | 993    | [Cousins in Binary Tree](https://leetcode.com/problems/cousins-in-binary-tree/)                                                             | [CousinsInBinaryTree.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/CousinsInBinaryTree.java)                         |
| 8   | 1232   | [Check If It Is a Straight Line](https://leetcode.com/problems/check-if-it-is-a-straight-line/)                                             | [CheckStraightLine.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/CheckStraightLine.java)                             |
| 9   | 367    | [Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)                                                                 | [ValidPerfectSquare.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/ValidPerfectSquare.java)                           |
| 10  | 997    | [Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)                                                                   | [FindTownJudge.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/FindTownJudge.java)                                     |
| 11  | 733    | [Flood Fill](https://leetcode.com/problems/flood-fill/)                                                                                     | [FloodFill.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/FloodFill.java)                                             |
| 12  | 540    | [Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/)                                         | [SingleElementInSortedArray.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/SingleElementInSortedArray.java)           |
| 13  | 402    | [Remove K Digits](https://leetcode.com/problems/remove-k-digits/)                                                                           | [RemoveDigits.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/RemoveDigits.java)                                       |
| 14  | 208    | [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)                                                   | [Trie.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/Trie.java)                                                       |
| 15  | 918    | [Maximum Sum Circular Subarray](https://leetcode.com/problems/maximum-sum-circular-subarray/)                                               | [MaxSumCircularSubarray.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/MaxSumCircularSubarray.java)                   |
| 16  | 328    | [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)                                                                 | [OddEvenLinkedList.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/OddEvenLinkedList.java)                             |
| 17  | 438    | [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)                                               | [FindAllAnagrams.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/FindAllAnagrams.java)                                 |
| 18  | 567    | [Permutation in String](https://leetcode.com/problems/permutation-in-string/)                                                               | [PermutationInString.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/PermutationInString.java)                         |
| 19  | 901    | [Online Stock Span](https://leetcode.com/problems/online-stock-span/)                                                                       | [StockSpanner.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/StockSpanner.java)                                       |
| 20  | 230    | [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)                                               | [KthSmallestElementInBst.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/KthSmallestElementInBst.java)                 |
| 21  | 1277   | [Count Square Submatrices with All Ones](https://leetcode.com/problems/count-square-submatrices-with-all-ones/)                             | [CountSquareSubmatrices.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/CountSquareSubmatrices.java)                   |
| 22  | 451    | [Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/)                                                 | [SortCharactersByFrequency.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/SortCharactersByFrequency.java)             |
| 23  | 986    | [Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/)                                                   | [IntervalListIntersection.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/IntervalListIntersection.java)               |
| 24  | 1008   | [Construct Binary Search Tree from Preorder Traversal](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/) | [BinarySearchTreeFromPreorder.java](src/main/java/io/github/chizganov/puzzlers/leetcode/thirtyday/BinarySearchTreeFromPreorder.java) |
| 25  | 1035   | [Uncrossed Lines](https://leetcode.com/problems/uncrossed-lines/)                                                                           | [UncrossedLines.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/UncrossedLines.java)                                   |
| 26  | 525    | [Contiguous Array](https://leetcode.com/problems/contiguous-array/)                                                                         | [ContiguousArray.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/ContiguousArray.java)                                 |
| 27  | 886    | [Possible Bipartition](https://leetcode.com/problems/possible-bipartition/)                                                                 | [PossibleBipartition.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/PossibleBipartition.java)                         |
| 28  | 338    | [Counting Bits](https://leetcode.com/problems/counting-bits/)                                                                               | [CountingBits.java](src/main/java/io/github/chizganov/puzzlers/leetcode/may/CountingBits.java)                                       |