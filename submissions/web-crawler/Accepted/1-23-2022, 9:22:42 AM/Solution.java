// https://leetcode.com/problems/web-crawler

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startUrl);
        visited.add(startUrl);
        String hostname = getHostName(startUrl);
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (String neigh : htmlParser.getUrls(curr)) {
                if (neigh.contains(hostname) && !visited.contains(neigh)) {
                    queue.offer(neigh);
                    visited.add(neigh);
                }
            }
        }
        return new ArrayList<String>(visited);
    }
    
    private String getHostName(String url) {
        return url.split("/")[2];
    }
}