/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// nums = [2, 7, 11, 15], target = 9
var twoSum = function(nums, target) {
    let map = new Map();
    for (let i = 0; i < nums.length; i++) {
        let gap = target - nums[i];
        
        if (map.has(gap)) {
            return [map.get(gap), i];
        }
        
        map.set(nums[i], i);
    }
    
    return [-1, -1];
};