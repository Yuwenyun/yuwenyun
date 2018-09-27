1. mongodb的事务处理？
2. restful service是什么？

RESTful(Representational State Transfer)表述性状态转移，服务端将服务封装成URI，客户端
通过访问URI来获取服务。
- 面向资源，所有服务都看做资源
- 使用动词标志需要对资源进行的操作
- 资源具有状态信息

3. mysql事务
4. 排序算法

- 冒泡排序，比较相邻，较大则向后移动，稳定
- 选择排序，从第一个开始选择之后的元素中最小的交换位置，稳定
- 插入排序，从第n个开始向前比较，较小则换位，稳定
- 希尔排序，分组插入排序，不稳定
- 堆排序，整理成大顶堆，交换最大值与末尾值，不稳定
- 归并排序
- 快速排序

Arrays.sort()的实现：数组大于quicksort_threshold且局部有序使用归并，非局部有序使用双轴快排。
数组小于quicksort_threshold且大于insertsort_threshold，使用双轴快排，小于insertsort_threshold使用插入排序。

5. Map
6. MVN生命周期
7. JVM内存分配及调优