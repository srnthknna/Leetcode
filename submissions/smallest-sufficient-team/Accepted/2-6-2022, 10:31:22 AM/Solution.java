// https://leetcode.com/problems/smallest-sufficient-team

class Solution {
    List<Integer> sol = new ArrayList<>();
    
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int nskills = req_skills.length, npeople = people.size();
        Map<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < nskills; i++)
            skillMap.put(req_skills[i], i);
        
        int[] peopleSkills = new int[npeople];
        for (int i = 0; i < npeople; i++) {
            for (String skill : people.get(i)) {
                if (skillMap.containsKey(skill))
                peopleSkills[i] |= (1 << skillMap.get(skill));
            }
        }
        
        search(peopleSkills, new ArrayList<>(), nskills, 0);
        int answer[] = new int[sol.size()], ind = 0;
        for (int index : sol)
            answer[ind++] = index;
        
        return answer;
    }
    
    private void search(int[] peopleSkills, List<Integer> currSol, int nskills, int skillMask) {
        if (skillMask == (1 << nskills) - 1) {
            if (sol.size() == 0 | currSol.size() < sol.size()) {
                sol = new ArrayList<>(currSol);
            }
            return;
        }
        
        if (sol.size() != 0 && currSol.size() >= sol.size()) return;
        int zeroBit = 0;
        while (((skillMask>>zeroBit)&1) == 1) zeroBit++;  
        for (int i = 0; i < peopleSkills.length; i++) {
            if (((peopleSkills[i]>>zeroBit)&1) == 1) {
                currSol.add(i);
                search(peopleSkills, currSol, nskills, skillMask | peopleSkills[i]);
                currSol.remove(currSol.size() - 1);
            }
        }
    }
}