package pro.sw_expert.Solution;

/*
20,288 kb -> 20,256 kb
메모리
1,564 ms ->308 ms
실행시간
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class sw_1247_0819 {
    static Pair[] lists;
    static int N;
    static boolean[] chk;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = stoi(br.readLine());
        for (int Tcase = 1; Tcase <= T; Tcase++) {
            lists = new Pair[12];   //최대 10
            ans = Integer.MAX_VALUE;
            sb.append("#").append(Tcase).append(" ");
            N =stoi(br.readLine());//버림
             
            chk = new boolean[N+2];
              
            st = new StringTokenizer(br.readLine());
            lists[0] = new Pair(stoi(st.nextToken()), stoi(st.nextToken()));    //회사
            lists[1] = new Pair(stoi(st.nextToken()), stoi(st.nextToken()));    //집
            for (int idx = 2; idx < N+2; idx++) {
                lists[idx] = new Pair(stoi(st.nextToken()), stoi(st.nextToken())); 
            }
            condidate(0,0,0);
             
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
 
    private static void condidate(int start, int pre,int result) {
        // TODO Auto-generated method stub
        if(ans < result) {return;}
        if(N == start) { //시작은 항상 1
            result += distance(pre,1); //집으로 돌아감
            if(ans > result)
                ans = result;
        }
        else {
            for (int i = 2; i < N+2; i++) {
                if(chk[i]) continue;
                chk[i] = true;
                condidate(start+1, i, result+distance(pre,i));
                chk[i] = false;
            }
        }
    }
    private static int distance(int pre, int i) {
        // TODO Auto-generated method stub
        Pair p1 = lists[pre];
        Pair p2 = lists[i];
        return p1.distance(p2);
    }
 
    private static int stoi(String readLine) {
        // TODO Auto-generated method stub
        return Integer.parseInt(readLine);
    }
}
 
class Pair{
    int x;
    int y;
    public Pair(int x, int y) {
        // TODO Auto-generated constructor stub
        this.x = x;
        this.y = y;
    }
    public int distance(Pair pair2) {
        return (Math.abs(this.x-pair2.x) + Math.abs(this.y-pair2.y));
    }
}