class Solution {
    public void swap(int []arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public int[] sortArrayByParity(int[] arr) {
        int n = arr.length, i = 0, j = n - 1;
        while(i <= j){
            if(arr[i] % 2 == 1){
                if(arr[j] % 2 == 0){
                    swap(arr, i, j);
                }else j--;
            }else{
                i++;
            }
            if(i > j) break;
            
            if(arr[j] % 2 == 0){
                if(arr[i] % 2 == 1){
                    swap(arr, i, j);
                }else i++;
            }else{
                j--;
            }
        }
        return arr;
    }
}