class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length, i = 0, j = n - 1, arr[] = new int[2];
        while(i < j){
            int a = numbers[i], b = numbers[j];
            if(a + b > target) j--;
            else if(a + b < target) i++;
            else {
                arr[0] = i + 1;
                arr[1] = j + 1;
                return arr;
            }
        }
        return arr;
    }
}