# Ordered-Array-Search-Algorithms
Introduce an ordered array search algorithm that improve the efficiency by reduicing the times of comparing process.
-Summary of idea:
  1)Get the average difference of value between elements in the ordered integer array;
  2)Caluate the times of average difference the target integer has to locate the most possible index of it;
  3)If the possible index incorrect, compare it to the target to find wither it is larger or less than the target;
  4)According to the result of compare with the target(Larger or Less), iterate from the current index forward or backward unitl the      target has been found or the value of element is no more larger/less(didn't found).
