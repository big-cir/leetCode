/**
 * @param {string} s
 * @return {boolean}
 */

class Stack {
    constructor() {
      this.arr = [];
    }

    push(item) {
      this.arr.push(item);
    }

    pop() {
      return this.arr.pop();
    }

    peek() {
        if (this.arr.length === 0) {
            return null;
        }
        return this.arr[this.arr.length - 1];
    }

    getSize() {
        return this.arr.length;
      }

    isEmpty() {
        return this.getSize() === 0;
    }
}

var isValid = function(s) {
    let stack = new Stack();
    
    for (let ch of s.split("")) {
        if (ch === '(' || ch === '{' || ch === '[') {
            stack.push(ch);
        } else {
            if (stack.isEmpty()) return false;
            
            if (ch === ')' && stack.pop() !== '(') return false;
            if (ch === '}' && stack.pop() !== '{') return false;
            if (ch === ']' && stack.pop() !== '[') return false;
        }
    }

    return stack.isEmpty();
};