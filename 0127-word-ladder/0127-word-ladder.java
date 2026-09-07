class Pair{
    String first;
    int second;
    Pair(String f , int s){
        this.first = f;
        this.second = s;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord , 1));
        Set<String> st = new HashSet<String>();
        for(int i = 0; i < wordList.size() ; i++){
            st.add((wordList.get(i)));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord) == true) {
                return steps;
            }
            for(int i = 0 ; i < word.length() ; i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char arr[] = word.toCharArray();
                    arr[i] = ch;
                    String replaced = new String(arr);
                    if(st.contains(replaced) == true){
                        st.remove(replaced);
                        q.offer(new Pair(replaced , steps+1));
                    }
                }
            }
        }
        return 0;
    }
}