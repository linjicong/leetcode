1. two sum/ three sum/ four sum/
1.1 two sum
时间复杂度 O(n), 空间复杂度O(1)
```python
# two pointer for sorted array
class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        # time: O(n)l space: O(1)
        numbers = sorted(numbers)
        l,r = 0, len(numbers)-1
        while l<r:
            if numbers[l]+numbers[r] < target:
                l+=1
            elif numbers[l]+numbers[r] > target:
                r-=1
            else:
                return (l+1,r+1)
```
时间复杂度 O(n), 空间复杂度O(n)
```python
# hash 表的存在是为了更快的找到pair num的下标
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        #build hashmap
        maps = {}
        for i,ele in enumerate(nums):
            remain = target - ele
            if remain in maps.keys():
                return (maps[remain],i)
            else:
                maps[ele] = i
```
1.2 three sum
```python
class Solution(object):
    def threeSum(self, nums):
        ans = set() 
        if len(nums) < 3: return ans 
        if nums.count(0) >= 3: ans.add((0,0,0)) 
        nums_set = set(nums)
        numMax, numMin = max(nums_set), min(nums_set)
        if numMax <= 0 or numMin >= 0: return ans
        # Split into two parts, positive and negative, so don't have to iterate the whole nums. It reduces about 70% time.
        setP = set(num for num in nums_set if (num > 0 and num <= -2 * numMin))
        setN = set(num for num in nums_set if (num < 0 and num >= -2 * numMax)) 
        count = collections.Counter(nums)
        for numP in setP:
            for numN in setN:
                numD=-numP-numN
                if numD in nums_set:
                    val=tuple(sorted([numD,numP,numN]))
                    # this step make sure that count num correctly
                    # 比如 numN = -1 只出现一次的话，上述操作可能会有（-1，-1，2），
                    # 但是2<1会过滤掉这个答案。
                    if val.count(numD)<=count[numD] and val.count(numP)<=count[numP] and val.count(numN)<=count[numN]:
                        ans.add(val)
        return ans
```
```javascript
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        solution_set = []
        nums = sorted(nums)
        print(nums)
        for i in range(len(nums)-2):
            if ( i == 0 or nums[i] != nums[i-1]):
                target = 0 - nums[i]
                low, high = i+1, len(nums)-1
                while(low < high):
                    if(nums[low]+nums[high] == target):
                        solution_set.append([nums[i],nums[low],nums[high]])
                        while(low < len(nums)-1  and nums[low] == nums[low+1]):
                            low += 1
                        while(high>=1 and nums[high] == nums[high-1]):
                            high -= 1
                        low += 1
                        high -= 1
                    elif(nums[low]+nums[high] < target):
                        low += 1
                    else:
                        high -= 1
                        
        return solution_set
```
1.3 four sum
暴力破解法，时间复杂度O(n^4)
双指针法，时间复杂度O(n^3)
```python
class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums = sorted(nums)
        print(nums)
        def kSum(start, k, target):
            tmp_set = []
            # if k is greater than left nums, return directly
            if k > len(nums)-start:
                return tmp_set
            # k smallest elements, k largets elements
            k_min,k_max = 0,0
            for i in range(start,start+k):
                k_min += nums[i]
                k_max += nums[-i+start-1]
            if k_min > target or k_max < target:
                return tmp_set
            elif k > 2:
                for i,ele in enumerate(nums[start:-k+1]):
                    # choose ele and skip duplicate value
                    if i == 0 or nums[start+i-1] != ele:
                        small_tmp_set = kSum(start+i+1,k-1,target-ele)
                        # add ele into tmp_set
                        #print(small_tmp_set)
                        if all(small_tmp_set) != 0:
                            for l in small_tmp_set:
                                tmp_set.append([ele]+l)
            elif k == 2:
                low , high = start, len(nums)-1
                while(low < high):
                    if(nums[low]+nums[high] == target):
                        tmp_set.append([nums[low],nums[high]])
                        while(low < len(nums)-1  and nums[low] == nums[low+1]):
                            low += 1
                        while(high>=1 and nums[high] == nums[high-1]):
                            high -= 1
                        low += 1
                        high -= 1
                    elif(nums[low]+nums[high] < target):
                        low += 1
                    else:
                        high -= 1
            #print('*',k,tmp_set)
            return tmp_set
        solution_set = kSum(0,4,target)
        return solution_set
```