const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const n = parseInt(input[0]);
const m = parseInt(input[1]);
const friends = input.slice(2).map(line => line.split(" ").map(Number));

const graph = Array.from({ length: n + 1 }, () => []);
for (const [a, b] of friends) {
  graph[a].push(b);
  graph[b].push(a);
}

const invited = new Set();

for (const friend of graph[1]) {
  invited.add(friend);
  for (const friendOfFriend of graph[friend]) {
    if (friendOfFriend !== 1) {
      invited.add(friendOfFriend);
    }
  }
}

console.log(invited.size);
