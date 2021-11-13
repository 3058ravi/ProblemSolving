package tree.heap;

class MinHeapNode {
    int element;
    int i;
    int j;

    public MinHeapNode(int element, int i, int j) {
        this.element = element;
        this.i = i;
        this.j = j;
    }
}

class MinHeapArr {
    MinHeapNode[] hArr;
    int size;

    public MinHeapArr(MinHeapNode[] a, int size) {
        this.size = size;
        hArr = a;
        int i = (size - 1) / 2;
        while (i >= 0) {
            minHepify(i);
            i--;
        }
    }

    void minHepify(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int smallest = i;
        if (l < size && hArr[l].element < hArr[i].element)
            smallest = l;
        if (r < size && hArr[r].element < hArr[smallest].element)
            smallest = r;

        if (smallest != i) {
            MinHeapNode temp = hArr[i];
            hArr[i] = hArr[smallest];
            hArr[smallest] = temp;
            minHepify(smallest);
        }
    }

    MinHeapNode getMin()
    {
        if(size <= 0)
        {
            System.out.println("Heap underflow");
            return null;
        }
        return hArr[0];
    }
    void replaceMin(MinHeapNode root) {
        hArr[0] = root;
        minHepify(0);
    }
}

public class MergeKSortedArrays {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 3;
        int[] res = mergeKsortedArrays(arr, k);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
    }

    public static int[] mergeKsortedArrays(int[][] arr, int k) {
        MinHeapNode[] hArr= new MinHeapNode[k];
        int resultSize=0;
        for (int i = 0; i < arr.length; i++){
            MinHeapNode minHeapNode= new MinHeapNode(arr[i][0], i,1);
            hArr[i]=minHeapNode;
            resultSize += arr[i].length;
        }

        MinHeapArr minHeapArr = new MinHeapArr(hArr,k);
        int[] res=new int[resultSize];

        for(int i=0; i<resultSize; i++){
            MinHeapNode root = minHeapArr.getMin();
            res[i] = root.element;
            if(root.j < arr[root.i].length)
                root.element = arr[root.i][root.j++];
            else
                root.element = Integer.MAX_VALUE;


            minHeapArr.replaceMin(root);
        }

            return  res;
    }
}
