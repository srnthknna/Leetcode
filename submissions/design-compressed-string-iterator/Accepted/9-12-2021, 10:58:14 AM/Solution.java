// https://leetcode.com/problems/design-compressed-string-iterator

class StringIterator {
    
    String res;
    int ptr = 0, num = 0;
    char ch = ' ';

    public StringIterator(String compressedString) {
        res = compressedString;
    }
    
    public char next() {
        if (!hasNext()) return ' ';
        if (num == 0) {
            ch = res.charAt(ptr++);
            while (ptr < res.length() && Character.isDigit(res.charAt(ptr))) {
                num = num * 10 + (res.charAt(ptr++) - '0');
            }
        }
        num--;
        return ch;
    }
    
    public boolean hasNext() {
        return res.length() != ptr || num != 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */