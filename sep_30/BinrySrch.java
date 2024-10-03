package sep_30;

// Java implementation of iterative Binary Search
class BinrySrch {
	// Returns index of x if it is present in arr[l....r], else return -1
	int fun1(int arr[], int l, int r, int x) {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] > x) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	int fun2(int arr[], int l, int r, int x) {
		if (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] > x) {
				return fun2(arr, l, mid - 1, x);
			} else {
				return fun2(arr, mid + 1, r, x);
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		BinrySrch ob = new BinrySrch();

		int arr[] = { 2, 3, 4, 8, 20 };
		int n = arr.length;
		int x = 8;
		// int result = ob.fun1(arr, 0, n - 1, x);
		int result2 = ob.fun2(arr, 0, n - 1, x);

		if (result2 == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index "
					+ result2);
	}
}
