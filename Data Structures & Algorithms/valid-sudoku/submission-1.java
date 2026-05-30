class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> visited = new HashSet();
        for(int i=0;i<9;i++) {
            visited = new HashSet();
            for(int j=0;j<9;j++){
                    char ch = board[i][j]; 
                if(ch == '.'){
                    continue;
                }
                if(visited.contains(ch)) {
                    return false;
                }
                visited.add(ch);
            }
        }
        

        for(int i=0;i<9;i++) {
            visited = new HashSet();
            for(int j=0;j<9;j++){
                char ch = board[j][i]; 
                if(ch == '.'){
                    continue;
                }
                if(visited.contains(ch)) {
                    return false;
                }
                visited.add(ch);
            }
        }

        for(int k=0;k<9;k=k+3){
            for(int l=0;l<9;l=l+3) {
                visited = new HashSet();
                for(int i=0;i<3;i++) {
                    for(int j=0;j<3;j++) {
                        char ch = board[k+i][l+j]; 
                        if(ch == '.'){
                            continue;
                        }
                        if(visited.contains(ch)) {
                            return false;
                        }
                        visited.add(ch);
                    }
                }
            }
        }
        return true;
    }
}
