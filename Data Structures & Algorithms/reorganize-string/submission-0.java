class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>((a, b) -> b.cnt - a.cnt);
        int[] f = new int[26];
        for(int i = 0  ; i < s.length() ; i++) {
            f[s.charAt(i)-'a']++;
        }
        for(int i=0; i < 26; i++) {
            if(f[i] == 0) {
                continue;
            }
            pq.add(new Element((char)(i+'a'), f[i]));
        }
        //System.out.println(pq);
        String str = "";
        while(pq.size() >= 2 ) {  
            Element e1 = pq.remove();
            Element e2 = pq.remove();
            str = str+e1.ch+e2.ch;
            e1.cnt--;
            e2.cnt--;
            if(e1.cnt != 0) pq.add(e1);
            if(e2.cnt != 0) pq.add(e2);
        }
        if(pq.size() >= 1 && pq.peek().cnt > 1) {
            return "";
        }
        if(pq.size() == 1) {
            str = str+pq.peek().ch;
        }
        return str;
    }
}

class Element {
    char ch;
    int cnt;
    Element(char chr, int c) {
        ch = chr;
        cnt = c;
    }
    public String toString() {
        return "{"+ch+":"+cnt+"}";
    }
}