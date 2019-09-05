package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)
 * 
 * 
 */
/*
U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
 */

public class sw_1873_0827 {
	static char[][] map;
	static int H;
	static int W;
	static int[] dirRow = new int[] { -1, 1, 0, 0 }; // 상하좌우
	static int[] dirCol = new int[] { 0, 0, -1, 1 };
	static String tankmod = "^v<>";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.printf("a %d %d %d %d",(int)'^',(int)'v',(int)'<',(int)'>');
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Tank tank = null;

		for (int Tcase = 1; Tcase <= T; Tcase++) {
			String ans = "";
			st = new StringTokenizer(br.readLine(), " ");
			H = stoi(st.nextToken());
			W = stoi(st.nextToken());
			map = new char[H][W];

			for (int row = 0; row < H; row++) {
				map[row] = br.readLine().toCharArray();
				for (int col = 0; col < W; col++) {
					char temp = map[row][col];
					if (tankmod.indexOf(temp) != -1) {
						tank = new Tank(row, col, tankmod.indexOf(temp));
						map[row][col] = '.';
					}
				}
			} // end of map

			int Ncomm = stoi(br.readLine());
			String comm = br.readLine();
			for (int i = 0; i < Ncomm; i++) {
				switch (comm.charAt(i)) {
				case 'U':
					tank.move(0);
					break;
				case 'D':
					tank.move(1);
					break;
				case 'L':
					tank.move(2);
					break;
				case 'R':
					tank.move(3);
					break;
				case 'S':
					tank.shot();
					break;
				}
//				System.out.println("명령어:" + comm.charAt(i));
//				System.out.println(printmap(map, tank));
			} // command
			
			ans = printmap(map, tank);
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans);
		} // end of TC
		System.out.print(sb);
	}

	private static String printmap(char[][] map, Tank tank) {
		// TODO Auto-generated method stub
		int trow = tank.row;
		int tcol = tank.col;
		int tdir = tank.dir;
		map[trow][tcol] = tankmod.charAt(tdir);
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				sb.append(map[row][col]);
			}
			sb.append("\n");
		}
		map[trow][tcol] = '.';
		return sb.toString();
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	private static class Tank {
		int row;
		int col;
		int dir;

		protected Tank(int row, int col, int dir) {
			super();
			this.row = row;
			this.col = col;
			this.dir = dir;
		}

		public void move(int comm) {
			int goRow = row + dirRow[comm];
			int goCol = col + dirCol[comm];
			this.dir = comm;

			if (goRow < 0 || goCol < 0 || goRow > H-1 || goCol > W-1)
				return;
			if (map[goRow][goCol] == '.') {
				row = goRow;
				col = goCol;
			}

		}

		public void shot() {
			int goRow = row + dirRow[dir];
			int goCol = col + dirCol[dir];

			end: while (true) {
				if (goRow < 0 || goCol < 0 || goRow > H-1 || goCol > W-1)
					return;
				switch (map[goRow][goCol]) {
				case '*':
					map[goRow][goCol] = '.';
					break end;
				case '#':
					break end;
				default:
//					System.out.println(map[goRow][goCol]);
				}

				goRow += dirRow[dir];
				goCol += dirCol[dir];

				if (goRow < 0 || goCol < 0 || goRow > H || goCol > W)
					return;
			}
		}

	}
}
