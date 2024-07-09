const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const city = input.slice(1).map(line => line.split(" ").map(Number));

let homes = [];
let chickens = [];

for (let r = 0; r < N; r++) {
    for (let c = 0; c < N; c++) {
        if (city[r][c] === 1) {
            homes.push([r, c]);
        } else if (city[r][c] === 2) {
            chickens.push([r, c]);
        }
    }
}

function getCombinations(arr, selectNumber) {
    const results = [];
    if (selectNumber === 1) return arr.map(value => [value]);
    arr.forEach((fixed, index, origin) => {
        const rest = origin.slice(index + 1);
        const combinations = getCombinations(rest, selectNumber - 1);
        const attached = combinations.map(combination => [fixed, ...combination]);
        results.push(...attached);
    });
    return results;
}

function getCityChickenDist(selectedChickens) {
    let totalDist = 0;
    for (const [hx, hy] of homes) {
        let minDist = Infinity;
        for (const [cx, cy] of selectedChickens) {
            const dist = Math.abs(hx - cx) + Math.abs(hy - cy);
            minDist = Math.min(minDist, dist);
        }
        totalDist += minDist;
    }
    return totalDist;
}

const chickenCombinations = getCombinations(chickens, M);
let minCityChickenDist = Infinity;

for (const combination of chickenCombinations) {
    const cityChickenDist = getCityChickenDist(combination);
    minCityChickenDist = Math.min(minCityChickenDist, cityChickenDist);
}

console.log(minCityChickenDist);
