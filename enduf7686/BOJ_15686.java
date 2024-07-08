import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;

    private static int[][] map;
    private static List<Location> houseLocations = new ArrayList<>();
    private static List<Location> chickenStoreLocations = new ArrayList<>();

    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int location = Integer.parseInt(st.nextToken());

                if (location == 1) {
                    houseLocations.add(new Location(y, x));
                    map[y][x] = location;
                } else if (location == 2) {
                    chickenStoreLocations.add(new Location(y, x));
                } else {
                    map[y][x] = location;
                }
            }
        }

        combination(new Location[M], 0, 0);
        System.out.println(answer);
    }

    private static void combination(Location[] locations, int start, int count) {
        if (count == M) {
            answer = Math.min(answer, calculateDistance(locations));
            return;
        }

        for (int i = start; i < chickenStoreLocations.size(); i++) {
            locations[count] = chickenStoreLocations.get(i);
            combination(locations, i + 1, count + 1);
        }
    }

    private static int calculateDistance(Location[] locations) {
        int[][] tempMap = new int[N][N];
        for (int y = 0; y < N; y++) {
            tempMap[y] = map[y].clone();
        }

        setChickenStore(tempMap, locations);

        return houseLocations.stream()
                .mapToInt(location -> bfs(tempMap, location))
                .sum();
    }

    private static int bfs(int[][] tempMap, Location location) {
        Queue<Location> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.offer(location);
        visited[location.getY()][location.getX()] = true;

        while (!queue.isEmpty()) {
            Location currentLocation = queue.poll();

            for (int i = 0; i < 4; i++) {
                int Y = currentLocation.getY() + dy[i];
                int X = currentLocation.getX() + dx[i];

                if (Y < 0 || Y >= N || X < 0 || X >= N || visited[Y][X]) {
                    continue;
                }

                if (tempMap[Y][X] == 2) {
                    return Math.abs(location.getY() - Y) + Math.abs(location.getX() - X);
                }

                queue.offer(new Location(Y, X));
                visited[Y][X] = true;
            }
        }

        throw new RuntimeException();
    }

    private static void setChickenStore(int[][] tempMap, Location[] locations) {
        Arrays.stream(locations).forEach(location -> tempMap[location.getY()][location.getX()] = 2);
    }

    private static class Location {

        private int y;
        private int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}

