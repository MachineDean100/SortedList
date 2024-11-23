import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }


    public void add(String value) {
        int index = binarySearchInsertPosition(value);
        list.add(index, value);
    }

    // Search for a string and return its index or negative insertion point
    public int search(String value) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midVal = list.get(mid);
            int cmp = midVal.compareTo(value);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public String toString() {
        return list.toString();
    }

    public String get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }


    private int binarySearchInsertPosition(String value) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;
            String midVal = list.get(mid);
            int cmp = midVal.compareTo(value);

            if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
