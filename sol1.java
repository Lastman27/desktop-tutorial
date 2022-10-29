class Solution {
    public int leastInterval(char[] tasks, int n) {
        // step 1 : find a maxFreq of a task & no.OfTask wid maxFreq
        int maxf = 0; // maximum freq
        int cntf = 0; // count of maximum freq i.e., no.OfTask with maximum freq
        
        int freq[]=new int[26];
        for(char c : tasks){
            freq[c-'A']++;
            
            if(freq[c-'A'] > maxf){
                maxf = freq[c-'A'];
                cntf = 1;
            }
            else if(freq[c-'A'] == maxf) cntf++;
        }
        // step 1 complete
        
        int parts = maxf - 1; 
        int emptySlots = parts * (n - (cntf-1)); 
        int avlTask = tasks.length - (cntf*maxf); 
        
        int idles = Math.max(0,emptySlots - avlTask);
        
        return tasks.length + idles;
    }
}
