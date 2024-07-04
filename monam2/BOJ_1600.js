const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const k = +input.shift().trim();
const [w, h] = input.shift().trim().split(" ").map(i => +i);
const grid = input.map(i => i.trim().split(" ").map(v => +v));

const moves = [
    [1, 0], [-1, 0], [0, 1], [0, -1]
];

const horseMoves = [
    [2, 1], [2, -1], [-2, 1], [-2, -1],
    [1, 2], [1, -2], [-1, 2], [-1, -2]
];

const visited = Array.from({ length: h }, () =>
    Array.from({ length: w }, () => Array(k + 1).fill(false))
);

const q = [[0, 0, 0, 0]]; //x, y, 이동 수, 말 이동 횟수
visited[0][0][0] = true;

let result = -1;

while (q.length > 0) {
    const [x, y, steps, horseMovesUsed] = q.shift();

    if (x === h - 1 && y === w - 1) {
        result = steps;
        break;
    }

    for (const [dx, dy] of moves) {
        const nx = x + dx;
        const ny = y + dy;
        if (nx >= 0 && nx < h && ny >= 0 && ny < w && grid[nx][ny] === 0 && !visited[nx][ny][horseMovesUsed]) {
            visited[nx][ny][horseMovesUsed] = true;
            q.push([nx, ny, steps + 1, horseMovesUsed]);
        }
    }

    if (horseMovesUsed < k) {
        for (const [dx, dy] of horseMoves) {
            const nx = x + dx;
            const ny = y + dy;
            if (nx >= 0 && nx < h && ny >= 0 && ny < w && grid[nx][ny] === 0 && !visited[nx][ny][horseMovesUsed + 1]) {
                visited[nx][ny][horseMovesUsed + 1] = true;
                q.push([nx, ny, steps + 1, horseMovesUsed + 1]);
            }
        }
    }
}

console.log(result);
