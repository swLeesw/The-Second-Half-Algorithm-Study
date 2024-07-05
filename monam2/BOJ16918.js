const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

let [r, c, t] = input.shift().trim().split(" ").map(i => +i);
let grid = input.map(i => i.trim().split(""));

function copyGrid(src) {
    return src.map(row => row.slice());
}

function fillGrid() {
    return Array.from({ length: r }, () => Array(c).fill('O'));
}

function detonate(bombs) {
    const newGrid = fillGrid();
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    for (let i = 0; i < r; i++) {
        for (let j = 0; j < c; j++) {
            if (bombs[i][j] === 'O') {
                newGrid[i][j] = '.';
                for (const [dx, dy] of directions) {
                    const ni = i + dx;
                    const nj = j + dy;
                    if (ni >= 0 && ni < r && nj >= 0 && nj < c) {
                        newGrid[ni][nj] = '.';
                    }
                }
            }
        }
    }
    return newGrid;
}

function printGrid(grid) {
    grid.forEach(row => console.log(row.join("")));
}

if (t === 1) {
    printGrid(grid);
} else if (t % 2 === 0) {
    printGrid(fillGrid());
} else {
    let firstDetonation = detonate(grid);
    if (t % 4 === 3) {
        printGrid(firstDetonation);
    } else if (t % 4 === 1) {
        printGrid(detonate(firstDetonation));
    }
}
