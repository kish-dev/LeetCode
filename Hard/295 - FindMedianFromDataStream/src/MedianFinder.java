class MedianFinder {
    private HeapMaxOrdered heapMaxOrdered;
    private HeapMinOrdered heapMinOrdered;

    static boolean haveMedian;
    static int median;

    MedianFinder() {
        int maxCountOfValues = 1000000;
        haveMedian = false;
        median = -1;
        heapMaxOrdered = new HeapMaxOrdered(maxCountOfValues / 2);
        heapMinOrdered = new HeapMinOrdered(maxCountOfValues / 2);
    }

    void addNum(int value) {     //не очень ожидаемо, что insert что-то возвращает, но проблему
        //с вводом/выводом данных я решил именно так в связи отсутствии времени
        if (haveMedian) {   //размеры хипов равны
            if (value > median) {
                heapMinOrdered.insert(value);
                heapMaxOrdered.insert(median);
            } else {
                heapMaxOrdered.insert(value);
                heapMinOrdered.insert(median);
            }
            haveMedian = false;
            median = -1;
        } else {
            haveMedian = true;
            if (value > heapMaxOrdered.getRoot() && value < heapMinOrdered.getRoot()) {

                median = value;
            } else {
                if (value > heapMaxOrdered.getRoot()) {
                    heapMinOrdered.insert(value);

                    median = heapMinOrdered.extract();
                } else {
                    heapMaxOrdered.insert(value);

                    median = heapMaxOrdered.extract();
                }
            }
        }
    }

    double findMedian() {
        if (haveMedian) {
            return median;
        } else {
            double temp =heapMaxOrdered.getRoot() + heapMinOrdered.getRoot();
            return temp / 2;
        }
    }
}


class HeapMaxOrdered {

    private int[] array;
    private int lastIndex;

    public HeapMaxOrdered(int n) {
        array = new int[n + 1];
        array[0] = Integer.MIN_VALUE;
        lastIndex = 1;
    }

    public void insert(int value) {
        array[lastIndex] = value;
        swim(lastIndex);
        ++lastIndex;
    }

    public int extract() {
        int root = array[1];
        --lastIndex;
        swap(array, lastIndex, 1);
        array[lastIndex] = Integer.MIN_VALUE;
        sink(1);
        return root;
    }

    public void swim(int k) {   //всплытие аргумента, передаем индекс
        while (array[k] > array[k / 2] && k > 1) {
            swap(array, k, k / 2);
            k /= 2;
        }
    }

    public void sink(int k) {
        while (2 * k <= lastIndex) {

            int indexLeft = 2 * k;

            int index;     //индекс ребенка, с которым меняем утопца

            if (indexLeft + 1 <= lastIndex) {
                index = array[indexLeft] > array[indexLeft + 1] ?
                        indexLeft : indexLeft + 1;
            } else {
                index = indexLeft;
            }
            if (array[k] < array[index]) {
                swap(array, k, index);
                k = index;
            } else {
                break;
            }
        }
    }

    public int getRoot() {
        return array[1];
    }

    public int getSize() {
        return lastIndex;
    }

    public static void swap(int[] a, int child, int parent) {
        int temp = a[child];
        a[child] = a[parent];
        a[parent] = temp;
    }
}

class HeapMinOrdered {

    private int[] array;
    private int lastIndex;

    public HeapMinOrdered(int n) {
        array = new int[n + 1];
        array[0] = -1;
        lastIndex = 1;
    }

    public void insert(int value) {
        array[lastIndex] = value;
        swim(lastIndex);
        ++lastIndex;
    }


    public int extract() {
        int root = array[1];
        --lastIndex;
        swap(array, lastIndex, 1);
        array[lastIndex] = Integer.MAX_VALUE;
        sink(1);
        return root;
    }

    public void swim(int k) {   //всплытие аргумента, передаем индекс
        while (array[k] < array[k / 2] && k > 1) {
            swap(array, k, k / 2);
            k /= 2;
        }
    }

    public void sink(int k) {
        while (2 * k <= lastIndex) {

            int indexLeft = 2 * k;

            int index;     //индекс ребенка, с которым меняем утопца

            if (indexLeft + 1 <= lastIndex) {
                index = array[indexLeft] < array[indexLeft + 1] ?
                        indexLeft : indexLeft + 1;
            } else {
                index = indexLeft;
            }
            if (array[k] > array[index]) {
                swap(array, k, index);
                k = index;
            } else {
                break;
            }
        }
    }

    public int getRoot() {
        return array[1];
    }

    public int getSize() {
        return lastIndex;
    }

    public static void swap(int[] a, int child, int parent) {
        int temp = a[child];
        a[child] = a[parent];
        a[parent] = temp;
    }
}