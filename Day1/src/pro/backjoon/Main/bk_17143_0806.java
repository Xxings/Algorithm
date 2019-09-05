package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class bk_17143_0806 {
	static int ROW;
	static int COL;
	static List<SangO> list; 
	static SangO[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		ROW = Integer.parseInt(str[0]);
		COL = Integer.parseInt(str[1]);
		int num = Integer.parseInt(str[2]);
		
		list = new ArrayList<SangO>();
		map = new SangO[ROW+1][];
		for (int row = 0; row < ROW+1; row++) {
			map[row] = new SangO[COL+1];
		}
		///////////////
		
		
		for (int i = 0; i < num; i++) {
			String data = br.readLine();
			String[] input = data.split(" ");
			SangO obj = new SangO(Integer.parseInt(input[0]),
					Integer.parseInt(input[1]),
					Integer.parseInt(input[2]),
					Integer.parseInt(input[3]),
					Integer.parseInt(input[4]));
			
			list.add(obj);
			map[obj.row][obj.col] = obj;
		}
		
//		Tmap(map);
		int col=1;
		int result = 0;
		////while
		while(col!=COL+1) {
			result += capture(col);
			move();
			System.out.println();
			Tmap(map);
			col++;
		}
		System.out.println(result);
		
		
		
		
	}
	private static void move() {
		//임시 저장 맵
		SangO[][] temp_map = new SangO[ROW+1][];
		for (int row = 0; row < ROW+1; row++) {
			temp_map[row] = new SangO[COL+1];
		}
		
		
		// TODO Auto-generated method stub
		for(SangO sangO : list) {
			if(sangO.isDie) continue;

			sangO.move();
			if(temp_map[sangO.row][sangO.col] != null) {	//상어있으면?
				SangO other = temp_map[sangO.row][sangO.col];
				if(sangO.attack(other)) {
					System.out.print("####"+sangO.no+" ->");
					other.die();
					temp_map[sangO.row][sangO.col] = sangO;
				}
				else{
					System.out.print("####"+other.no+" ->");
					sangO.die();
					temp_map[sangO.row][sangO.col] = other;
				}
			}else {//상어없으면 자리차지
				temp_map[sangO.row][sangO.col] = sangO;
			}
		}	//상어들 힘내요
		
		save(temp_map);
	}
	private static void save(SangO[][] temp_map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < temp_map.length; i++) {
			map[i] = temp_map[i].clone();
		}
	}
	private static int capture(int col) {
		// TODO Auto-generated method stub
		for (int row = 1; row <= ROW; row++) {
			if(map[row][col] != null) {
				SangO sangO = map[row][col];
				System.out.print("####사람한테 ->");
				sangO.die();
				return sangO.weigh;
			}
		}
		return 0;
	}
	private static void Tmap(SangO[][] map2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < map2.length; i++) {
			System.out.println(Arrays.toString(map2[i]));
		}
	}
	
	
	
	
	
	static class SangO{
		int row;
		int col;	
		int speed;	//이동거리
		int dir;	//상 하 우 좌
		int rdir;
		int cdir;
		static int[] dir_row = {0, -1,1,0,0};	//idx 0은 안씀
		static int[] dir_col = {0, 0,0,1,-1};	//idx 0은 안씀
		int weigh;	//크기
		boolean isDie;
		static char cnt = 'A';
		char no;
		protected SangO(int row, int col, int speed, int dir, int weigh) {
			super();
			this.no = cnt++;
			this.row = row;
			this.col = col;
			this.speed = speed;
			this.dir = dir;
			this.rdir = dir_row[dir];
			this.cdir = dir_col[dir];
			this.weigh = weigh;
			this.isDie = false;
		}
		public void die() {
			// TODO Auto-generated method stub
			System.out.println("no : "+no+" 죽음");
			this.isDie = true;
		}
		public boolean attack(SangO other) {
			// TODO Auto-generated method stub
			return (this.weigh >= other.weigh);
		}
		public void move() {
			// TODO Auto-generated method stub
			int goRow = row;
			int Rmove = speed;
			
			int goCol = col;
			int Cmove = speed;
			
			while(Rmove != 0) {
				if(rdir == 0) break;
				if(goRow == 1) {
					rdir = 1;
				}
				else if (goRow == ROW){
					rdir = -1;
				}
				goRow += rdir;
				Rmove--;
			}

			while(Cmove != 0) {
				if(cdir == 0) break;
				
				if(goCol == 1) {
					cdir = 1;
				}
				else if (goCol == COL){
					cdir = -1;
				}
				goCol += cdir;
				Cmove--;
			}
		
			this.row = goRow;
			this.col = goCol;
			
		}
		@Override
		public String toString() {
			return "no:"+no;
		}
	}
}

