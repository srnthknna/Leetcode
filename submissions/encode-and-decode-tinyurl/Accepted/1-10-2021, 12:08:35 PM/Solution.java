// https://leetcode.com/problems/encode-and-decode-tinyurl


public class Codec {
    Map<Integer, String> map = new HashMap<>();

    public String encode(String longUrl) {
        int key = longUrl.hashCode();
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
