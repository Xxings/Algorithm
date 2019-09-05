package pro.sw_expert.Solution;

import java.util.*;
import java.io.*;
 
public class sw_1258_0902_bfs {
    static int N;
    static int[][] che;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static LinkedList<Arr> result = new LinkedList<>();
     
    static class Arr implements Comparable<Arr>{
        int row, col, size;
         
        Arr(int row, int col, int size){
            this.row = row;
            this.col = col;
            this.size = size;
        }
 
        public int compareTo(Arr o) {
            if(size < o.size) return -1;
            else if(size == o.size)     return row < o.row ? -1 : 1;
            else return 1;
        }
    }
     
    public static void search(int x, int y, int row, int col) {
        visited[y][x] = true;
         
        if((x + 1 == N || che[y][x + 1] == 0) && (y + 1 == N || che[y + 1][x] == 0))
            result.add(new Arr(row, col, row*col));
         
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
             
            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
             
            if(visited[ny][nx] || che[ny][nx] == 0)
                continue;
            // 우 하 좌 상
            if(i == 0)
                search(nx, ny, row, col + 1);
            else if(i == 1)
                search(nx, ny, row + 1, col);
            else if(i == 2)
                search(nx, ny, row, col - 1);
            else
                search(nx, ny, row - 1, col);
        }
    }
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
         
        for(int z = 1; z <= testcase; z++) {
            N = Integer.parseInt(br.readLine());
            che = new int[N][N];
            visited = new boolean[N][N];
            result.clear();
 
            for(int i = 0; i < N; i++) {
                String[] strs = br.readLine().split(" ");
                 
                for(int j = 0; j < N; j++)
                    che[i][j] = Integer.parseInt(strs[j]);
            }
             
            for(int y = 0; y < N; y++) {
                for(int x = 0; x < N; x++) {
                    if(che[y][x] != 0 && !visited[y][x])
                        search(x, y, 1, 1);
                }
            }
             
            Collections.sort(result);
            System.out.print("#" + z + " " + result.size());
            for(Arr x : result)
                System.out.print(" " + x.row + " " + x.col);
            System.out.println();
        }
    }
}