import * as fs from 'fs';

const filePath = process.platform === 'linux' ? '/dev/stdin' : 'test.txt';
const input: string[] = fs.readFileSync(filePath).toString().trim().split('\n');

const [n, k]: number[] = input.shift()!.trim().split(' ').map(Number);
const arr: number[] = input.shift()!.trim().split(' ').map(Number);

function findLongest(n: number, k: number, arr: number[]): number {
    const countMap: Record<number, number> = {};
    let left = 0;
    let maxLength = 0;

    for (let right = 0; right < n; right++) {
        const current = arr[right];
        if (countMap[current] === undefined) {
            countMap[current] = 0;
        }
        countMap[current] += 1;

        while (countMap[current] > k) {
            countMap[arr[left]] -= 1;
            left += 1;
        }

        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}

const result = findLongest(n, k, arr);
console.log(result);
