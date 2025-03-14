class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        def check(mid):
            return sum(c//mid for c in candies)>=k

        left,right=0,max(candies)
        while left<right:
            mid=ceil(left+(right-left)/2)
            if check(mid):
                left=mid
            else:
                right=mid-1
        return left