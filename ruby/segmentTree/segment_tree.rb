$arr = [1,2,3,4,5,6,7,8,9]
$tree = Array.new(30, 0)

#Function to build the tree
def build_tree(ceiling, bottom, tree_node)
	if(ceiling == bottom)
		$tree[tree_node] = $arr[ceiling]
		return
	end
	mid = (ceiling+bottom)/2
	build_tree(ceiling, mid, tree_node*2)
	build_tree(mid+1, bottom, tree_node*2+1)
	$tree[tree_node] = $tree[tree_node*2] + $tree[(tree_node*2)+1]
	return
end

#Function to update the tree
def update_tree(ceiling, bottom, tree_node, index, value)
	if (ceiling == bottom)
		$tree[tree_node] = value
		$arr[index] = value
		return
	end
	mid = (ceiling+bottom)/2
	if (index <= mid)
		update_tree(ceiling, mid, tree_node*2, index, value)
	else
		update_tree(mid+1, bottom, tree_node*2+1, index, value)
	end
	$tree[tree_node] = $tree[tree_node*2] + $tree[tree_node*2+1]
	return 
end

#Function to find sum of ranges
def sum_of_interval(ceiling, bottom, tree_node, left, right)
	# There are three cases here
	# 1. Completely lies outside the given range
	# 2. Completely lies inside the given range
	# 3. Partially lies in the given range

	# 1. Completely lies outside the given range
	if (right < ceiling || left > bottom)
		return 0
	end

	# 2. Completely lies inside the given range
	if (ceiling>=left && bottom<= right)
		return $tree[tree_node]
	end

	# 3. Partially lies in the given range
	mid = (ceiling+bottom)/2
	sum1 = sum_of_interval(ceiling, mid, tree_node*2, left, right)
	sum2 = sum_of_interval(mid+1, bottom, tree_node*2+1, left, right)
	sum = sum1 + sum2
	return sum
end

build_tree(0, 8, 1)
update_tree(0, 8, 1, 5, 20)
sum = sum_of_interval(0,8,1,3,7)
puts "Sum of range is #{sum}"
