package ss.week4;

public class ArrayExercises {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
        reverseArray(arr);
    }

    /**
     *
     * @param arr the array you want to count negative numbers in
     * @return the amount of negative numbers in the given array
     */
    public static int countNegativeNumbers(int[] arr) {
        int count = 0;
        for (int a: arr) {
            if (a<0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Reverse array with help of a temporary array
     * @param ints the array to be reversed
     * @return the reversed array
     */
    public static void reverseArrayWithNew(int[] ints) {
        int[] array = new int[ints.length];
        int index = 0;
        for (int i = ints.length-1; i >= 0; i--) {
            array[index] = ints[i];
            index++;
        }
        for (int i = 0; i <= ints.length-1; i++) {
            ints[i] = array[i];
            System.out.println(ints[i]);
        }

    }
    /**
     * Reverse array without the help of a temporary array
     * @param ints the array to be reversed
     * @return the reversed array
     */
    public static void reverseArray(int[] ints) {
        for (int i = 0; i < (ints.length)/2; i++) {
                int temp = ints[i];
                ints[i] = ints[ints.length - i - 1];
                ints[ints.length - i - 1] = temp;

        }
        for (int a: ints) {
            System.out.println(a);
        }
    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
