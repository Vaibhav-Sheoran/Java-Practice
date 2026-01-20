class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        
        Integer[] arr = nums.toArray(new Integer[0]);
        int[] res = new int[nums.size()];
        for(int j = 0 ; j < arr.length ; j++){
            boolean changed = false;
            for(int i = -1000 ; i < 1000 ; i++){
                if((i | (i+1)) == arr[j]){
                    res[j] = i;
                    changed = true;
                    break;
                } 
            }
            if(!changed)res[j] = -1; 
        }
        return res;
   
    }
}