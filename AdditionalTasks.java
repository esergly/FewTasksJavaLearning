import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* Задача
пользователь вводит число и звёздочками рисуем фигуру (треугольник или ромб)
*/

public class AdditionalTasks {
    public static void main(String[] args) {

        System.out.println("Введите размер стороны фигуры: ");
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        String line = "*";
        int size2 = 0;

        while (size2++ != size) {
            System.out.println();
            for (int i = 0; i < size2; i++) {
                System.out.print(line);
            }
        }
        while (size-- > -1) {
            System.out.println();
            for (int i = 0; i < size + 1; i++) {
                System.out.print(line);
            }
        }

/* Задача
100 дверей. Все закрыты. Проходим по порядку сначала каждую дверь и меняем её состояние (открываем),
потом проходим каждую вторую, потом каждую третью и так до 100-й меняя состояние.
*/

        System.out.println();
        boolean[] doors = new boolean[101];
        for (int count =1; count < doors.length; count++) {
            for (int i = count - 1; i < doors.length; i = i + count) {
                if (!doors[i]) doors[i] = true;
                else doors[i] = false;
            }
        }
        System.out.println("From all 100 doors had stay opened only doors ");
        for (int i = 0; i < doors.length-1; i++) {
            if (doors[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

/*  массив из кубиков (например 6 штук). Бросаем их и получаем числа, которые сравниваем между собой.
после этого ищем совпадающие элементы и вычисляем их сумму. Выясняем, из каких чисел эта сумма состоит и выводим эти
числа на print  */

        System.out.println();
        int[] cubes = new int[6];
        Random r = new Random();
        for (int i = 0; i < cubes.length; i++) {
        cubes[i] = r.nextInt(7);
        if (cubes[i] == 0) {
        cubes[i] = 1;
            }
        }
        System.out.println(Arrays.toString(cubes));
        int[] counters = new int[7];
        for (int i = 0; i < cubes.length; i++) {
        counters[cubes[i]]++;
        }
        for (int i = 1; i < counters.length; i++) {
        if (counters[i] > 1) {
        System.out.println("Грани с " + i + " выпали " + counters[i] + " раз. Их сумма составляет " + counters[i] * i);
        }
        }



/*  Представьте себе замкнутую по окружности железную дорогу. По ней едет поезд, последний вагон которого скреплён с первым так, что внутри можно свободно перемещаться между вагонами.
Вы оказались в одном случайном вагоне и ваша задача — подсчитать их общее количество. В каждом вагоне можно включать или выключать свет, но начальное положение переключателей случайное и заранее неизвестно.
Все вагоны внутри выглядят строго одинаково, окна закрыты так, что невозможно посмотреть наружу, движение поезда равномерное. Помечать вагоны как-либо, кроме включения или выключения света, нельзя.
*/

        System.out.println();
        Random random = new Random();
        // делаем произвольное количество вагонов в диапазоне 0...10е7 и передаём это число в метод toBinaryString, чтобы оно отображалось в бинарном виде
        int carriage = random.nextInt(50000000) + 1000000;
        String base = String.format("%s", Integer.toBinaryString(carriage)).replace(" ", "0");
        System.out.println(base);

        StringBuilder sb = new StringBuilder(base);
        //Включаем в первом вагоне свет
        sb.deleteCharAt(0);
        sb.insert(0, "1");

        int revnumb = 0; //счётчик алгоритма
        //Перебираем вагоны
        for (int i = 1; i < base.length() + 1; i++) {
            if (sb.charAt(revnumb) == 0) { // свет выключен - ничего не делаем
                revnumb++;                 // увеличиваем счётчик вагонов

            } else {
                sb.deleteCharAt(revnumb); // если в вагоне горит свет - гасим его, и увеличиваем счётчик вагонов - мы знаем сколько вагонов до точки начал счёта
                sb.insert(revnumb, "0");
                if (sb.charAt(revnumb) != 0) {// если после выключения света в первом вагоне стало темно - круг замкнулся и счётчик не увеличивается
                    revnumb++;
                }
            }
        }
        System.out.println(sb.toString());
        System.out.println(base.length());
        System.out.println(revnumb);
    }
}
