class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap <String, Integer > freq = new HashMap<>();
        Set <String> bannedMap= new HashSet<>();

    String cleaned = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();
    String[] words = cleaned.split("\\s+");

        for(String word : banned){
            bannedMap.add(word);
        }
        for(String word : words){
            if(!bannedMap.contains(word)){
                freq.put(word, freq.getOrDefault(word,0)+1);
            }
        }
        String res = "";
        int maxFreq = 0;

        for(Map.Entry <String, Integer> a : freq.entrySet()){
            if(a.getValue() > maxFreq){
                res = a.getKey();
                maxFreq = a.getValue();
            }
        }
        return res;
    }
}