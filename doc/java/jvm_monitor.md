1. jps [option] [pid]
- q: only print pid
- m: main class delivered to **java** command
- l: full qualified name of main class
- v: boostrap args

2. jstat [option pid [interval[s|ms] [count]]] 
> jstat -gc 20455 1s 20

- gc: java heap including eden(EC/EU), survivors(S0C/S1C), old and perms
- class: 
- gccapacity:
- gccause:

3. jmap [option] pid
> jmap -dump:live,format=b,file=/var/tmp/test.dump 20445

- dump: generate dump info
- finalizerinfo: show objects in F-Queue waiting for Finalizer
- heap: show details of heap
- histo: show statistics of class, instance count of objects in heap/stack

4. jhat test.dump
> access url **http://ip:7000** to query the dump msg

5. jstack [option] pid
- F: show thread stack
- l: show info of lock
- m: show native stack info
