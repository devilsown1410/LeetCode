import heapq

class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        hell = []
        for num in nums:
            heapq.heappush(hell, num)
        
        res = 0
        while hell[0] < k:
            ten = heapq.heappop(hell)
            twenty = heapq.heappop(hell)
            res =res+ 1
            ral = min(ten, twenty) * 2 + max(ten, twenty)
            
            heapq.heappush(hell, ral)
        
        return res

