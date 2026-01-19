class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int prefixSum [][] = new int[mat.length +1 ][mat[0].length +1 ];
        int res = 0;
        int n = prefixSum.length;
        int m = prefixSum[0].length;

        for(int i = 1 ; i < n ; i++){
     
            for(int j = 1 ; j < m ; j++){
                prefixSum[i][j] = 
                mat[i-1][j-1]+
                prefixSum[i][j-1]+
                prefixSum[i-1][j]-
                prefixSum[i-1][j-1];
            
            }
        }

        int low = 0, high = Math.min(n-1,m-1);
        
        while(low <= high){
            int mid = (low+high)/2;

            if(doesSquareExist(prefixSum , mid , threshold)){
                res = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }

        }
        return res;
    }
        boolean doesSquareExist(int [][] prefixSum , int k , int threshold){
            if(k == 0)return true;

            for(int i = k ; i < prefixSum.length ; i++){
                for(int j = k ; j < prefixSum[0].length ; j++){
                    int sum = prefixSum[i][j]-
                    prefixSum[i-k][j]-
                    prefixSum[i][j-k]+
                    prefixSum[i-k][j-k];

                    if(sum<=threshold)return true;
                }
            }
            return false;
        
    }

}