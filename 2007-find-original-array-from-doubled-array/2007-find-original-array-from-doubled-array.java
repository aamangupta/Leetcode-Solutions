class Solution {
    public int[] helper(ArrayList<Integer> list){
        int k = 0, n = list.size();
        int []ans = new int[n];
        for(int i : list){
            ans[k] = i;
            k++;
        }
        return ans;
    }
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length, k = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(changed);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int c = 0; // to store the cnt of non zeros
        for(int i : changed){
            if(i != 0){
                c++;
                map.put(i , map.getOrDefault(i, 0) + 1);
            }
        }
        
        for(int j = 0; j < n; j++){
            int i = changed[j];
            if(i == 0){
                continue;
            }
            else if(map.containsKey(i * 2) && map.containsKey(i)){
                int freq = map.get(i * 2);
                if(freq > 1){
                    map.put(i * 2, freq - 1);
                }else{
                    map.remove(i * 2);
                }
                int freqq = map.get(i);
                if(freqq != 1){
                    map.put(i, freqq - 1);
                }else{
                    map.remove(i);
                }
                ans.add(i);
            }
        }
        
        
        if(c == 0 && (n - c) % 2 == 0){
            if(n - c > 2){
                int add = (n-c)/2;
                for(int i = 0; i < add; i++) ans.add(0);
            }else ans.add(0);
            return helper(ans);
        }
        // no zeros are there
        else if(map.size() == 0 && (n - c) == 0){
            System.out.println("aaaaa");
            return helper(ans);
        }
        // zeros are in pairs
        else if(map.size() == 0 && (n - c) % 2 == 0 ){
            if(n - c > 2){
                int add = (n-c)/2;
                for(int i = 0; i < add; i++) ans.add(0);
            }else ans.add(0);
            return helper(ans);
        }else{
            return new int[0];
        }
    }

}