package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		for (Integer num : array) {
			if (num == null) {
				return null;
			}
		}
		sort(array, 0, array.length - 1);
		return search(array, 0, array.length - 1, x);
	}

	private Integer search(Integer[] array, int leftIndex, int rightIndex, Integer x) {
		if (leftIndex > rightIndex) {
			return null;
		}

		if (x == null) {
			return null;
		}

		if (array[rightIndex] <= x) {
			return array[rightIndex];
		}

		int mid = (leftIndex + rightIndex) / 2;

		if (mid > 0 && array[mid - 1] <= x && x < array[mid]) {
			return array[mid - 1];
		}

		if (x < array[mid]) {
			return search(array, leftIndex, mid - 1, x);
		}

		return search(array, mid + 1, rightIndex, x);
	}

	private void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > 1) {
			if (leftIndex < rightIndex) {
				int index_pivot = partition(array, leftIndex, rightIndex);
				sort(array, leftIndex, index_pivot - 1);
				sort(array, index_pivot + 1, rightIndex);
			}
		}
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = i + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, leftIndex, i);
		return i;
	}
}