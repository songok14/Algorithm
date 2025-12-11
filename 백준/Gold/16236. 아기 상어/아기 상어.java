import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[][] map;
    static int N;
    static int size = 2;
    static int eat = 0;
    static int time = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Shark {
        int x;
        int y;
        int dist;

        public Shark(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        // 거리 -> 가장 왼쪽 -> 가장 위
        @Override
        public int compareTo(Fish o) {
            if (this.dist != o.dist) {
                return this.dist - o.dist;
            } else if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return this.y - o.y;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int X = 0;
        int Y = 0;

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j];

                if (input[j] == 9) {
                    X = i;
                    Y = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish nextFish = findNextFish(X, Y);

            if (nextFish == null) {
                break;
            }

            time += nextFish.dist;
            X = nextFish.x;
            Y = nextFish.y;

            map[X][Y] = 0;
            eat++;

            if (size == eat) {
                size++;
                eat = 0;
            }
        }

        System.out.println(time);

        br.close();
    }

    public static Fish findNextFish(int X, int Y) {
        Queue<Shark> myQ = new LinkedList<>();
        int[][] dist = new int[N][N];

        myQ.add(new Shark(X, Y, 0));
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }
        dist[X][Y] = 0;

        List<Fish> eatableFish = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!myQ.isEmpty()) {
            Shark current = myQ.poll();

            if (current.dist > minDist) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && dist[nx][ny] == -1 && size >= map[nx][ny]) {
                    dist[nx][ny] = current.dist + 1;
                    if (dist[nx][ny] > minDist) {
                        continue;
                    }
                    myQ.add(new Shark(nx, ny, current.dist + 1));

                    if (map[nx][ny] > 0 && size > map[nx][ny]) {
                        if (dist[nx][ny] < minDist) {
                            minDist = dist[nx][ny];
                        }
                        eatableFish.add(new Fish(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }
        if (eatableFish.isEmpty()) {
            return null;
        }

        Collections.sort(eatableFish);
        return eatableFish.get(0);
    }
}