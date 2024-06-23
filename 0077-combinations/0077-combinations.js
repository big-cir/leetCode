/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    let answer = [];
    com(0, n, k, 1, answer, []);
    return answer;
};

const com = (level, n, k, start, answer, tmp) => {
    if (level === k) {
        answer.push(tmp.slice());  // tmp 배열의 복사본을 추가
        return;
    }

    for (let i = start; i <= n; i++) {
        tmp.push(i);
        com(level + 1, n, k, i + 1, answer, tmp);
        tmp.pop();
    }
}
