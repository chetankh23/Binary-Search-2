/**
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
class FirstAndLastOccurrenceInSortedArray {

  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[] { -1, -1 };
    }

    if (target < nums[0] || target > nums[nums.length - 1]) {
      return new int[] { -1, -1 };
    }

    int first = findFirstOccurrence(nums, target);
    if (first == -1) {
      return new int[] { -1, -1 };
    }
    int last = findLastOccurrence(nums, target);
    return new int[] { first, last };
  }

  public int findFirstOccurrence(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        if ((mid == 0) || (nums[mid - 1] != target)) {
          return mid;
        }
        high = mid - 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

  public int findLastOccurrence(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        if ((mid == nums.length - 1) || (nums[mid + 1] != target)) {
          return mid;
        }
        low = mid - 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}