class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            int largest = i;
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if (left < sortLength && tree[left] > tree[largest]) {
                largest = left;
            }

            if (right < sortLength && tree[right] > tree[largest]) {
                largest = right;
            }

            if (largest != i) {
                int swap = tree[i];
                tree[i] = tree[largest];
                tree[largest] = swap;
                buildTree(tree, sortLength);
            }
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        buildTree(sortArray, sortLength);

        for (int i = sortLength - 1; i >= 0; i--) {
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;
            buildTree(sortArray, i);
        }
    }
}
