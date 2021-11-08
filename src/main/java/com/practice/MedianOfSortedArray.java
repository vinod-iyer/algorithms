package com.practice;

public class MedianOfSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int indexNums1 = 0, indexNums2 = 0, resultIndex = 0;
        double median = 0d;
        int mergedArrayLength = nums1.length + nums2.length;
        int[] resultArray = new int[(mergedArrayLength/2)+1];

        while (indexNums1 < nums1.length && indexNums2 < nums2.length && resultIndex <= (mergedArrayLength / 2)) {

            if (nums1[indexNums1] < nums2[indexNums2]) {
                resultArray[resultIndex++] = nums1[indexNums1];
                indexNums1++;

            } else {
                if (nums2[indexNums2] < nums1[indexNums1]) {
                    resultArray[resultIndex++] = nums2[indexNums2];
                    indexNums2++;
                } else if (nums2[indexNums2] == nums1[indexNums1]) {
                    resultArray[resultIndex++] = nums1[indexNums1];
                    resultArray[resultIndex++] = nums2[indexNums2];
                    indexNums1++;
                    indexNums2++;
                }
            }

        }
        while (resultIndex <= (mergedArrayLength / 2)) {
            if (indexNums1 < nums1.length) {
                resultArray[resultIndex] = nums1[indexNums1++];
            }
            if (indexNums2 < nums2.length) {
                resultArray[resultIndex] = nums2[indexNums2++];
            }
            resultIndex++;
        }


        if (mergedArrayLength % 2 == 0) {
            median = (double) (resultArray[(mergedArrayLength / 2) - 1] + resultArray[mergedArrayLength / 2]) / 2;
        } else {
            median = (double) (resultArray[mergedArrayLength / 2]);
        }
        return median;

    }

    public static void main(String[] args) {
        new MedianOfSortedArray().findMedianSortedArrays(new int[]{}, new int[]{1});
    }
}
