import java.util.Scanner;
public class StepTracker {
    MonthData[] monthToData;
    Converter calc;
    int targetValue = 10000; // целовое значение пройденных шагов в день, устанавливается по умолчанию. Может быть изменено пользователем


    public StepTracker() {
        monthToData = new MonthData[12]; // инициализируем массив объектов
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        calc = new Converter(); //создаём объект класса Converter
    }

    public void addTarget(int value) {
        if (value < 0 || value == 0) { // проверяем, чтобы значение не было меньше или равно 0
            System.out.println("Введите корректное количество проёденных шагов!");
        } else {targetValue = value;}
    }

    public void addDayValue(int month, int day, int steps) { // добавление количества шагов в определенный день и месяц
        if (month < 0 || month > 11) { //проверка на ввод месяца
            System.out.println("Введите корректное значение от 0 до 11!");
        } else {
            if (day < 1 || day > 30) { //проверка на ввод даты дня
                System.out.println("Введите корректное значение от 1 до 30!");
            } else {
                if (steps < 0) { //проверка на ввод количества шагов
                    System.out.println("Введитие значение больше 0!");
                } else {monthToData[month].stepsInDay[day-1] = steps;}
            }
            }
        }

    public void statisticsCalc ( int month){ // вывод статистики
            for (int i = 0; i < monthToData[month].stepsInDay.length; i++) {
                System.out.println(i + 1 + " день: " + monthToData[month].stepsInDay[i]); // вывод статистики по дням
            }
        }

    public int monthSum ( int month){
            int sum = 0;
            for (int i = 0; i < monthToData[month].stepsInDay.length; i++) { //подсчёт общего количества шагов за месяц
                sum = sum + monthToData[month].stepsInDay[i];
            }
            return sum;
        }
    public int maxSteps ( int month){
        int max = 0;
        for (int i = 0; i < monthToData[month].stepsInDay.length; i++) { // определяем максимальное количество шагов за месяц
            if (max < monthToData[month].stepsInDay[i]) { // если предыдущее значение меньше текущего, то
                max = monthToData[month].stepsInDay[i]; //заменяем
                }
            }
            return max;
        }
    public double monthAverage (int month){
        double average = 0;
        int sum = 0; // возможно нужно будет присвоить первое значение
            for (int i = 0; i < monthToData[month].stepsInDay.length; i++) { // подсчёт среднего количества шагов в месяце
                sum = sum + monthToData[month].stepsInDay[i];
            }
            average = sum / 30;
            return average;
        }
    public void distAndCalor(int month) {
        System.out.println("За месяц пройдено километров: " + calc.pathCalc(monthSum(month))); //вызов подсчета километров
        System.out.println("Всего за месяц сожжённых калорий: " + calc.calorCalc(monthSum(month))); //вызов подсчёта калорий
        }
    public int bestSerial(int month, int targetVal) { // метод для вывода лучшей серии
        int t = 0;//счетчик дней
        int maxVal = 0;//счётчик серии
        for (int i =0; i < monthToData[month].stepsInDay.length; i++) {
            if (monthToData[month].stepsInDay[i] > targetVal) { //если больше целевого значения
                t = t + 1; // то, увеличиваем счетчик

            } else { // если нет
                    if (t > maxVal) { //преверяем больше ли текущий счетчик лучшей серии
                        maxVal = t; //если да, то заменяем
            }  }
        }
        return maxVal;
        }

    public void setStatistic(int month) {
        System.out.println("Статистика месяца по дням: ");
        statisticsCalc(month);
        System.out.println("Общее количество шагов в месяце равно: " + monthSum(month));
        System.out.println("Максимальное количество шагов за один день в месяце: " + maxSteps(month));
        System.out.println("Среднее количество шагов за месяц: " + monthAverage(month));
        distAndCalor(month);
        System.out.println("Лучшая серия дней подряд, когда превышено целевое количество шагов за день: " + bestSerial(month, targetValue));

    }

    public void showStat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер нужного месяца. Где, 0 - Январь, 11- Декабрь");
        int month = scanner.nextInt();
        setStatistic(month);

    }

    public void addStepsInDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер нужного месяца. Где, 0 - Январь, 11- Декабрь: ");
        int month = scanner.nextInt();
        System.out.println("Введите день для добавления количества шагов. От 1 до 30: ");
        int day = scanner.nextInt();
        System.out.println("Введите количество пройденных шагов за этот день: ");
        int steps = scanner.nextInt();
        addDayValue(month, day, steps);
    }

    public void changeTargetValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новое целевое значение пройденных шагов в день: ");
        int targetValue = scanner.nextInt();
        addTarget(targetValue);
    }
    }




class MonthData {
    int[] stepsInDay = new int[30];

}