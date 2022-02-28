// https://leetcode.com/problems/largest-time-for-given-digits

class Solution {
    public String largestTimeFromDigits(int[] arr) {
        List<Integer> avail = new ArrayList<>();
        for (int i : arr) avail.add(i);
        StringBuilder sb = new StringBuilder();
        
        // Get Max Hour
        int hFirst = avail.stream().filter(i -> i <= 2).max(Comparator.naturalOrder()).orElse(10);
        if (hFirst == 10) return "";
        avail.remove(avail.indexOf(hFirst));
        int hSecond = avail.stream().filter(i -> i <= 3).max(Comparator.naturalOrder()).orElse(10);
        if (hSecond == 10) return "";
        avail.remove(avail.indexOf(hSecond));
        int mFirst = avail.stream().filter(i -> i <= 5).max(Comparator.naturalOrder()).orElse(10);
        if (mFirst == 10) return "";
        avail.remove(avail.indexOf(mFirst));
        int mSecond = avail.get(0);
        return "" + hFirst + hSecond + ":" + mFirst + mSecond;
    }
}