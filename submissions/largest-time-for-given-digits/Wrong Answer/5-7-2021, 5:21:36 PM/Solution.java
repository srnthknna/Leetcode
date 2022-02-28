// https://leetcode.com/problems/largest-time-for-given-digits

class Solution {
    public String largestTimeFromDigits(int[] arr) {
        List<Integer> avail = new ArrayList<>();
        for (int i : arr) avail.add(i);
        
        // Get Max Hour
        int hFirst = avail.stream().filter(i -> i <= 2).max(Comparator.naturalOrder()).orElse(10);
        if (hFirst == 10) 
            hFirst = avail.stream().filter(i -> i <= 2).min(Comparator.naturalOrder()).orElse(10);
        final int hFirstFinal = hFirst;
        if (hFirst == 10) return "";
        System.out.println(hFirst);
        avail.remove(avail.indexOf(hFirst));
        int hSecond = avail.stream().filter(i -> i <= (hFirstFinal == 2 ? 3 : (hFirstFinal < 2 ? 9 : 0))).max(Comparator.naturalOrder()).orElse(10);
        System.out.println(hSecond);
        if (hSecond == 10) return "";
        avail.remove(avail.indexOf(hSecond));
        int mFirst = avail.stream().filter(i -> i <= 5).max(Comparator.naturalOrder()).orElse(10);
        if (mFirst == 10) return "";
        avail.remove(avail.indexOf(mFirst));
        int mSecond = avail.get(0);
        return "" + hFirstFinal + hSecond + ":" + mFirst + mSecond;
    }
}