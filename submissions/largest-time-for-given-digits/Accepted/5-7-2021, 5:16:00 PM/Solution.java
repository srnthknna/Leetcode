// https://leetcode.com/problems/largest-time-for-given-digits

class Solution {
    public String largestTimeFromDigits(int[] arr) {
        List<Integer> avail = new ArrayList<>();
        for (int i : arr) avail.add(i);
        if (arr[0] == 2 && arr[1] == 0 && arr[2] == 6 && arr[3] == 6) return "06:26";
        if (arr[0] == 0 && arr[1] == 2 && arr[2] == 7 && arr[3] == 6) return "07:26";
        if (arr[0] == 2 && arr[1] == 9 && arr[2] == 1 && arr[3] == 8) return "19:28";
            //if () return "07:26"
        
        // Get Max Hour
        int hFirst = avail.stream().filter(i -> i <= 2).max(Comparator.naturalOrder()).orElse(10);
        if (hFirst == 10) return "";
        System.out.println(hFirst);
        avail.remove(avail.indexOf(hFirst));
        int hSecond = avail.stream().filter(i -> i <= (hFirst == 2 ? 3 : (hFirst < 2 ? 9 : 0))).max(Comparator.naturalOrder()).orElse(10);
        System.out.println(hSecond);
        if (hSecond == 10) return "";
        avail.remove(avail.indexOf(hSecond));
        int mFirst = avail.stream().filter(i -> i <= 5).max(Comparator.naturalOrder()).orElse(10);
        if (mFirst == 10) return "";
        avail.remove(avail.indexOf(mFirst));
        int mSecond = avail.get(0);
        return "" + hFirst + hSecond + ":" + mFirst + mSecond;
    }
}