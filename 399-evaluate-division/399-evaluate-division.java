class Solution {
    public class pair{
        String des;
        double val;
        pair(String des, double val){
            this.des = des;
            this.val = val;
        }
    }
    public void dfs(String u, String v, HashMap<String, List<pair>> map, double ans, double temp, HashSet<String> set){
        if(u.equals(v)){
            val = temp;
            return;
        }
        set.add(u);
        if(map.containsKey(u)){
            for(pair p : map.get(u)){
                String des = p.des;
                double val = p.val;
                if(set.contains(des) == false){
                    dfs(des, v, map, ans, temp * val, set);
                }
            }
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<pair>> map = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> l = equations.get(i);
            String src = l.get(0);
            String dest = l.get(1);
            if(map.containsKey(src)){
                List<pair> list = map.get(src);
                list.add(new pair(dest, values[i]));
                map.put(src, list);
            }else{
                List<pair> list = new ArrayList<>();
                list.add(new pair(dest, values[i]));
                map.put(src, list);
            }
            
            if(map.containsKey(dest)){
                List<pair> list = map.get(dest);
                list.add(new pair(src, 1.0 / values[i]));
                map.put(dest, list);
            }else{
                List<pair> list = new ArrayList<>();
                list.add(new pair(src, 1.0 / values[i]));
                map.put(dest, list);
            }
        }
//         for(String s : map.keySet()){
//             List<pair> list = map.get(s);
//             for(pair p : list){
                
//                 System.out.print(s + "->" + p.des + " " + p.val + "***");
//             }
//             System.out.println();
//         }
        int n = queries.size();
        double []ans = new double[n];
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            List<String> list = queries.get(i);
            String u = list.get(0), v = list.get(1);
            set = new HashSet<>();
            val = -1.0;
            if(map.containsKey(u) == false){
                ans[i] = -1.00000;
                continue;
            }
            if(u == v){
                ans[i] = 1.00000;
                continue;
            }
            dfs(u, v, map, val, 1.0, set);
            ans[i] = val;
        }
        return ans;
    }
    double val = -1.0;
}