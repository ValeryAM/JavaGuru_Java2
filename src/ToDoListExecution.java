import java.util.Scanner;
import java.util.ArrayList;

public class ToDoListExecution {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Affair> toDoList = new ArrayList();
    
    public void mainLoop() {
        
loop:   while (true) {
            printMainMenu();
            String menuCode = getStringFromUser();
            if (menuCode.length() == 1) {
                char menuCase = menuCode.charAt(0);
                switch (menuCase) {
                    case '1':
                        printToDoList();
                        break;
                    case '2':
                        addAffair();
                        break;
                    case '3':
//                    editAffair();
                        break;
                    case '4':
                        deleteAffair();
                        break;
                    case '5':
                        break loop;
                    default:
                        printWarningMessage();
                }
            } else {
                printWarningMessage();
            }
        }
    }

    private void deleteAffair() {
        if (!toDoList.isEmpty()) {
            System.out.println("Введите название удаляемой задачи:");
            String affairNameToDelete = getStringFromUser();
            boolean flagIfDeleted = false;
            for (int i = 0; i < toDoList.size(); i++) {
                Affair tempAffair = toDoList.get(i);
                String tempAffairName = tempAffair.getAffairName();
                if (tempAffairName.equalsIgnoreCase(affairNameToDelete)) {
                    toDoList.remove(i);
                    System.out.println("Задача " + affairNameToDelete + " удалена!");
                    flagIfDeleted = true;
                    break;
                }
            }
            if (!flagIfDeleted) {
                System.out.println("Задачи с таким именем не существует!");
            }
        } else {
            System.out.println("\nСписок задач пуст!");
        }
    }

    private void printWarningMessage() {
        System.out.println("Вы ввели неверный код! Повторите ввод!");
    }

/*    private void editAffair() {
        while (true) {
            System.out.println("Введите название задачи или 'Exit' для выхода:");
            String affairName = getStringFromUser();
            if (affairName.equalsIgnoreCase("Exit")) {
                break;
            } else {
                int index = toDoList.indexOf(affairName);
                if (index >= 0) {
                    System.out.println("Введите новое название задачи: ");
                } else {
                    System.out.println("Задачи с таким именем не существует, повторите ввод!");
                }
            }
        }
    }
*/

    private void printMainMenu() {
        System.out.println("Введите код операции:");
        System.out.println("1 - Посмотреть на консоли список задач");
        System.out.println("2 - Добавить новую задачу в список");
        System.out.println("3 - Редактировать задачу из списка");
        System.out.println("4 - Удалить задачу из списка");
        System.out.println("5 - Выйти из программы");
    }

    private String getStringFromUser() {
//        return sc.next();
        return sc.nextLine();
    }

    private void printToDoList() {
        if (!toDoList.isEmpty()) {
            System.out.println("Список содержит следующие задачи:");
            for (int i = 0; i < toDoList.size(); i++) {
                Affair outAffair = toDoList.get(i);
                System.out.println(outAffair.toString());
            }
        } else {
            System.out.println("\nСписок задач пуст!");
        }

    }

    private void addAffair() {
        System.out.println("Введите название задачи:");
        String affairName = sc.nextLine();
        System.out.println("Введите описание задачи:");
        String affairDescription = sc.nextLine();
        System.out.println("Введите дату выполнения задачи:");
        String affairDeadline = sc.nextLine();
        Affair newAffair = new Affair(affairName, affairDescription, affairDeadline);
        toDoList.add(0, newAffair);
        System.out.println("Новая задача " + affairName + " добавлена в список");
    }
}
