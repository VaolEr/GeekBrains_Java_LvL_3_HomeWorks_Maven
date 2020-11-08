package Lesson6;

//1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
//   Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
//   идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо
//   выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//   Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
//
//2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
//   то метод вернет false; Если есть числа отличныче от 1 и 4 то вернуть false; Написать набор тестов для этого метода
//   (по 3-4 варианта входных данных).
//[ 1 1 1 4 4 1 4 4 ] -> true
//[ 1 1 1 1 1 1 ] -> false
//[ 4 4 4 4 ] -> false
//[ 1 4 4 1 1 4 3 ] -> false
//
//3. * Добавить на серверную сторону сетевого чата логирование событий (сервер запущен, произошла ошибка, клиент подключился, клиент прислал сообщение/команду).
//     Ссылка на пулл реквест:


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,4,4,2,3,4,1,7};
        Integer[] subArr = returnSubArrayAfterSubElement(array,5);
        System.out.println(Arrays.toString(array) + " -> " + Arrays.toString(subArr));
    }

    public static Integer[] returnSubArrayAfterSubElement(int[] initialArray, int subElement){

        Deque<Integer> subArray = new LinkedList<Integer>();
        Integer[] arr;

        for (int i = initialArray.length-1; i >= 0; i--){
            if(initialArray[i] == subElement){
                break;
            }
            subArray.addFirst(initialArray[i]);
        }
        if(subArray.size() == initialArray.length){
            String message = "There is no [" + subElement + "] in input array!";
            throw new RuntimeException(message);
        }

        arr = new Integer[subArray.size()];
        return subArray.toArray(arr);
    }

    public static boolean checkArrayOnElementsPresent(int[] array, int element1, int element2){
        int element1Count = 0;
        int element2Count = 0;
        for (int arrayElement:array) {
            if(arrayElement != element1 && arrayElement !=element2){
                return false;
            }
            if(arrayElement == element1){
                element1Count++;
            }
            if(arrayElement == element2){
                element2Count++;
            }
        }
        return element1Count != 0 && element2Count != 0;
    }
}