package service;

public class CombiData {
    public static void main(String[] args) {
    	

        int[] arr = {41,42,44,45}; //조합을 만들 배열
        boolean[] visited = new boolean[arr.length];
        
        for(int r = 1; r <= arr.length ; r++) {
        	System.out.println("\n" + arr.length + "개 중에 " + r  + "개 뽑음");
            comb2(arr, visited, 0, r);
        }
    }
 
    //2. 재귀를 이용해 구현
    static void comb2(int[] arr, boolean[] visited, int depth, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        }
        if(depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            comb2(arr, visited, depth + 1, r - 1);
 
            visited[depth] = false;
            comb2(arr, visited, depth + 1, r);
        }
    }
 
    // 배열 출력
    static void print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}


/*
----1~9까지----
7개 중에 2개 뽑음
2 3 
2 5 
2 6 
2 7 
2 8 
2 9 
3 5 
3 6 
3 7 
3 8 
3 9 
5 6 
5 7 
5 8 
5 9 
6 7 
6 8 
6 9 
7 8 
7 9 
8 9 

7개 중에 3개 뽑음
2 3 5 
2 3 6 
2 3 7 
2 3 8 
2 3 9 
2 5 6 
2 5 7 
2 5 8 
2 5 9 
2 6 7 
2 6 8 
2 6 9 
2 7 8 
2 7 9 
2 8 9 
3 5 6 
3 5 7 
3 5 8 
3 5 9 
3 6 7 
3 6 8 
3 6 9 
3 7 8 
3 7 9 
3 8 9 
5 6 7 
5 6 8 
5 6 9 
5 7 8 
5 7 9 
5 8 9 
6 7 8 
6 7 9 
6 8 9 
7 8 9 
*/