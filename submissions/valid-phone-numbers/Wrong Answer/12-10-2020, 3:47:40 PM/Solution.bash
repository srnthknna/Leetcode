// https://leetcode.com/problems/valid-phone-numbers

# Read from the file file.txt and output all valid phone numbers to stdout.
filename='file.txt'
n=1
while read line; do
# reading each line
echo "Line No. $n : $line"
n=$((n+1))
done < $filename
