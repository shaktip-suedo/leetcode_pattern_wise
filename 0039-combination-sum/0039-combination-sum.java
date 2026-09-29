class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
          List<List<Integer>> results = new ArrayList<>();
          solve(candidates , target , 0 , new ArrayList<>(),results);
          return results;
    }
    public void solve(int[] candidates ,int remainTar , int stIdx,List<Integer> currentCombination ,List<List<Integer>> results ){
        if(remainTar == 0){
            results.add(new ArrayList<>(currentCombination));
            return;
        }
        if(remainTar<0){
            return ;
        }
        for(int i = stIdx ; i<candidates.length;i++){
            currentCombination.add(candidates[i]);
            solve(candidates,remainTar - candidates[i],i,currentCombination,results);
            currentCombination.remove(currentCombination.size()-1);
        }
         
    }
}