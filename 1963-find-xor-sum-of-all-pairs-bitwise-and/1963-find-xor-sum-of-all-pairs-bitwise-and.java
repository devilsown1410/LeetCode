class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1=XOR(arr1);
        int xor2=XOR(arr2);
        return (xor1&xor2);
    }
    public static int XOR(int arr[]){
        int xor=0;
        for(int i:arr){
            xor^=i;
        }
        return xor;
    }
}