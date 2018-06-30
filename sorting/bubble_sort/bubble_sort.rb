puts "Number of elements to be sorted"
n = gets.to_i
puts "Enter the elements"
a = []
for i in 0...n
	a[i] = gets.to_i
end

# Bubble sort begins here
for i in 0...n-1
	for j in 1...n-i
		if a[j-1] > a[j]
			temp = a[j]
			a[j] = a[j-1]
			a[j-1] = temp
		end
	end
end
# Bubble sort ends here

puts "Sorted array is: "
for i in 0...n 
	print a[i]
	print " "
end
