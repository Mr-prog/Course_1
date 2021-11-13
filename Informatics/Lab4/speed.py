import os
import time
tm = time.time()
for i in range(10):
    os.system('python task1.py')
time_task1 = time.time() - tm
for i in range(10):
    os.system('python task2.py')
time_task2 = time.time() - tm - time_task1
print(time_task1, time_task2)