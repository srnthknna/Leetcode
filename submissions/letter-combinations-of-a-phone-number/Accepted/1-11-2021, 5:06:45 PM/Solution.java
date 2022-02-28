// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {

    List<String> result = new ArrayList<>();
    Map<Character, List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        buildMap();
        if(digits.equals(""))
            return result;
        recurse(digits, new StringBuilder(), 0);
        return result;
    }

    private void buildMap(){
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r', 's'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
    }

    private void recurse(String digits, StringBuilder temp, int startAt){
        if(temp.length()==digits.length()){
            result.add(new String(temp.toString()));
            return;
        }

        List<Character> charList = map.get(digits.charAt(startAt));
        for(int j=0 ;j<charList.size(); j++){
            temp.append(charList.get(j));
            recurse(digits,temp, startAt+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}