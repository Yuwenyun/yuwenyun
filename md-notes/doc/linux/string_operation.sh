#!/bin/bash
str="abc,def,gab,c"

# get length
echo ${#str}

# get substring
echo ${str:2} # extract string from index 2
echo ${str:2:3} # extract 3 charactors from index 2

# get substring
echo ${str#a*c} # "#" means minimum match from left, a*c is pattern
echo ${str##a*c} # maximum match from left
echo ${str%a*c} # minimum match from right
echo ${str%%a*c} # maximum match from right

# replace string
echo ${str/ab/AB} # replace the first "ab"
echo ${str//ab/AB} # replace all the "ab"
echo ${str/#ab/AB} # replace "ab" if str start with "ab"
echo ${str/%ab/AB} # replace "ab" if str end with "ab"

# comparison
[[ "a.txt" == a* ]] # true, pattern match
[[ "a.txt" =~ .*\.txt$ ]] # true, regex match
[[ "a.txt" == "a.txt" ]] # true, string comparison
[[ "11" < "2" ]] # string comparison by ascii