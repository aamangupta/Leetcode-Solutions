class Solution {
    // checking all the elements from arr[0] to arr[n]
    // initially, with first ele, a = arr[i] and b = arr[j]
    // loop till set contains(a + b) and update a = b and b = sum;
    // update the answer
    
    public int lenLongestFibSubseq(int[] arr) {
        // Set<Integer> s = new HashSet<Integer>();
        // for (int x : A) s.add(x);
        // int res = 2;
        // for (int i = 0; i < A.length; ++i)
        //     for (int j = i + 1; j < A.length; ++j) {
        //         int a = A[i], b = A[j], l = 2;
        //         while (s.contains(a + b)) {
        //             b = a + b;
        //             a = b - a;
        //             l++;
        //         }
        //         res = Math.max(res, l);
        //     }
        // return res > 2 ? res : 0;
        HashSet<Integer> set = new HashSet<>();
        int n = arr.length, ans = 2;
        for(int i : arr) set.add(i);
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int a = arr[i], b = arr[j], count = 2;
                while(set.contains(a + b)){
                    int sum = a + b;
                    a = b;
                    b = sum;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans > 2 ? ans : 0;
    }
}