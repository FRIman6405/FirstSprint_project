import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker steptrack = new StepTracker(); //инициализируем объект стептракера
        while (true) {
            setMenu(); // Выводится меню, позволяющее выбрать нужную опцию
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt(); // Пользователь вводит значение
            if(choice == 1) { // Выводится информация согласно выбранному пункту
               steptrack.addStepsInDay();
            }
            else if(choice == 2) {
                steptrack.showStat();
            }
            else if(choice == 3) {
                steptrack.changeTargetValue();
            }

            else if(choice == 4) {
                System.out.println("Выйти из приложения.");
                return;  // Выход из программы

            } else {System.out.println("Такого пункта меню нет! Просьба ввести корректное значение"); }


        }

    }

    public static void setMenu() {
        System.out.println("Выберите нужное действие:");
        System.out.println("1: Ввести количество шагов за определённый день;");
        System.out.println("2: Напечатать статистику за определённый месяц;");
        System.out.println("3: Изменить цель по количеству шагов в день;");
        System.out.println("4: Выйти из приложения.");
    }




}

