package com.deng.mall;



public  class  Solution{
    int[][] step=new int[50][50];
    public boolean dfs(char[][] board,char[] word, int index,int upAndDown,int rightAndLeft){
           if (index==word.length-1){
               return  true;
           }
           if (rightAndLeft>=board.length-1||rightAndLeft<0||upAndDown>board[0].length-1
                   ||upAndDown<0||board[upAndDown][rightAndLeft]!=word[index]){
                 return false;
           }
           if (step[upAndDown][rightAndLeft]==0){
               step[upAndDown][rightAndLeft]=0;
               dfs(board,word,index+1,upAndDown+1,rightAndLeft);
               dfs(board,word,index+1,upAndDown-1,rightAndLeft);
               dfs(board,word,index+1,upAndDown,rightAndLeft+1);
               dfs(board,word,index+1,upAndDown,rightAndLeft-1);
               step[upAndDown][rightAndLeft]=1;
           }
           return false;
    }

    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        int col=board[0].length,row=board.length;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (dfs(board,words,0,i,j)){
                    return  true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board={ {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word="ABCCED";
        Solution solution=new Solution();
        solution.exist(board,word);
    }
}