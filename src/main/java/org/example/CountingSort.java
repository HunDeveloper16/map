package org.example;

public class CountingSort {

    public static void main(String[] args) {

        /**
         *           ★ 카운팅 정렬 ( 계수 정렬 )
         *
         * 정렬 알고리즘 중 시간복잡도가 O(n)으로 엄청난 성능을 보여줌.
         * 그러나 특정 타입에 한정되어 있고,
         * 입력되는 수의 갯수가 적지만, 수의 범위가 매우 클 경우 심한 메모리 낭비를 초래한다.
         * JAVA에서는 1차원 배열 객체의 하나의 크기는 최대 Integer.MAX_VALUE 미만으로만 가능하기 때문에 실생활에서 거의 쓰이지않는다.
         * 그렇기 때문에 대부분 언어에서는 TimSort나 QuickSort를 쓴다.
         */

        //STEP 0. 배열 생성
        int[] arr = new int[100];  // 배열의 크기
        int[] counting = new int[31]; // 숫자의 범위 0 ~ 30
        int[] result = new int[100]; // 카운팅된 배열

        //STEP 1. 난수 삽입
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*31);;
        }

        //STEP 2. 위에서 생성된 난수를 인덱스 번호로 두고 해당 인덱스 번호에 있는 값 상승
        for(int i=0; i<arr.length; i++){
            counting[arr[i]]++;
        }

        //STEP 3. 누적 합으로 변환 시킨다.
        for(int i=1; i<counting.length; i++){
            counting[i] += counting[i-1];
        }

        //STEP 4. arr의 i 번째 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤, counting 배열의 값을 인덱스로 하여 result에 value 값을 저장한다.
        for(int i = arr.length-1; i>=0; i--){
            int value = arr[i];
            counting[value]--; // 숫자가 같을 경우 여기서 한칸씩 배열이 아래로 당겨진다.
            result[counting[value]] = value;
        }


    }
}
