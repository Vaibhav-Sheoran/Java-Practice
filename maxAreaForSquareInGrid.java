class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) 
    {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int side = Math.min(func(hBars) , func(vBars));
        return side*side;
        
    }


    int func(int [] bars){
        int res= 1, streak = 1;
        for(int i = 1 ; i < bars.length ; i++){
            if(bars[i] - bars[i-1] == 1)streak++;
            else streak = 1;
            res = Math.max(res, streak);
        }

        return res+1;
    }
}