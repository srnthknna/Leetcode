// https://leetcode.com/problems/high-five

class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> scores = new HashMap<>();
        
        for (int[] item : items) {
            if (!scores.containsKey(item[0])) {
                scores.put(item[0], new ArrayList<Integer>());
            }
            scores.get(item[0]).add(item[1]);
        }
        
        for (List<Integer> score : scores.values()) {
            Collections.sort(score);
        }

        Object[] arr = scores.keySet().toArray();
        Arrays.sort(arr);

        int[][] result = new int[arr.length][2];
        int index = 0;
        for (Object ido : arr) {
            Integer id = (Integer)ido;
            int sum = 0;
            List<Integer> cur = scores.get(id);
            for (int i = cur.size() - 5; i < cur.size(); i++) {
                sum += cur.get(i);
            }
            result[index][0] = id;
            result[index][1] = sum / 5;
            index++;
        }
        return result;
    }
}