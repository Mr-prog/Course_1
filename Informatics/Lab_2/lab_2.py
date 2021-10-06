def check(a):
    for i in range(len(nums)):
        if int(a[i]) != 1 and int(a[i])!= 0:
            return False
        a.pop(0)
    return True

def rightResult(nums):
    nums = list(nums)
    r1 = int(nums[0])
    r2 = int(nums[1])
    r3 = int(nums[3])
    count = 0
    if r1 != (int(nums[2]) + int(nums[4]) + int(nums[6])) % 2:
        count += 1
    if r2 != (int(nums[2]) + int(nums[5]) + int(nums[6])) % 2:
        count += 2
    if r3 != (int(nums[4]) + int(nums[5]) + int(nums[6])) % 2:
        count += 4
    if count == 0:
        return ("Все верно")
    else:
        count = count - 1
        if nums[count] == "1":
            nums[count] = "0"
        else:
            nums[count] = "1"
        return ("Правильный ответ: " + ("".join(list(map(str,nums)))))

while True:
    print("Введите сообщение")
    nums = str(input())
    if len(nums) != 7 and check(nums):
        print("Некорректный ввод")
        continue
    print(rightResult(nums))
    break
    
