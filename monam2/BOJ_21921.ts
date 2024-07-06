import * as fs from 'fs';

const filePath = process.platform === 'linux' ? '/dev/stdin' : 'test.txt';
const input: string[] = fs.readFileSync(filePath).toString().trim().split('\n');

const [n, x]: number[] = input.shift()!.trim().split(' ').map(Number);
const arr: number[] = input.shift()!.trim().split(' ').map(Number);

function solution(): void {
    let currentSum: number = 0;
    for (let i = 0; i < x; i++) {
        currentSum += arr[i];
    }

    let maxVisitor: number = currentSum;
    let count: number = 1;

    for (let i = x; i < n; i++) {
        currentSum += arr[i] - arr[i - x];
        if (currentSum > maxVisitor) {
            maxVisitor = currentSum;
            count = 1;
        } else if (currentSum === maxVisitor) {
            count += 1;
        }
    }

    if (maxVisitor === 0) {
        console.log("SAD");
    } else {
        console.log(maxVisitor);
        console.log(count);
    }
}

solution();
