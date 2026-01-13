class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String , List <String>> map = new HashMap <>();

        for(int i = 0 ; i < strs.length ; i++){
            char [] signature = strs[i].toCharArray();
            Arrays.sort(signature);
            String key = new String(signature);


            if(!map.containsKey(key))map.put(key , new ArrayList<>());

            map.get(key).add(strs[i]);

        }
        return new ArrayList<>(map.values());
        
    }
}
