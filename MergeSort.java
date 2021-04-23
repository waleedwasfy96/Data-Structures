public class MergeSort {

    public static void mergeSort(int[] x,int start, int end){
        int middle=start +(end-start)/2;
        if(middle==start){
            return;
        }
        mergeSort(x,start,middle);
        mergeSort(x,middle,end);
        merge(x,start,middle,end);
    }
    public static void merge(int[] x, int start,int middle, int end){
        int [] left=new int[middle-start];
        int [] right=new int[end-middle];
        for(int i=0;i<left.length;i++){
            left[i]=x[start+i];
        }
        for(int i=0;i<right.length;i++){
            right[i]=x[middle+i];
        }
        int i=0;
        int j=0;
        int k=start;
        while(i<left.length && j<right.length && k<end){
            if(left[i]<=right[j]){
                x[k]=left[i];
                k++;
                i++;
            }
            else{
                x[k]=right[j];
                k++;
                j++;
            }
        }
        while(i<left.length){
            x[k]=left[i];
            k++;
            i++;
        }
        while(j< right.length){
            x[k]=right[j];
            k++;
            j++;
        }

    }

    public static void main(String[] args) {
        int [] x={5,8,3,2,0,9,12,33,61,16,6,4};
        mergeSort(x,0,x.length);
        for (int i:x
             ) {
            System.out.print(i +" ");
        }

    }
}
