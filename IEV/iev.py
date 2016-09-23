
def iev(nums):

    return (nums[0] + nums[1] + nums[2])*2 + nums[3]*1.5 + nums[4]

with open("rosalind_iev.txt", "r") as f:

    nums = [int(x) for x in next(f).split(" ")]
    
with open("output.txt", "w+") as o:

    o.write(str(iev(nums)))
        
