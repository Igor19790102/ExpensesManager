import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;
    ArrayList<Double> expenses;

    ExpensesManager() {
        expenses = new ArrayList<>();
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
            expenses = expensesByCategories.get(category);
            expenses.add(expense);
        } else {
            expenses = new ArrayList<>();
            expensesByCategories.put(category, expenses);
            expenses.add(expense);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        for (String category : expensesByCategories.keySet()) {
            expenses = expensesByCategories.get(category);
            System.out.println(category);
            for (Double exp : expensesByCategories.get(category)) {
                System.out.println(exp);
            }
        }
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)) {
            expenses = expensesByCategories.get(category);
            for (Double exp : expenses) {
                if (exp > maxExpense) {
                    maxExpense = exp;
                }
            }
        } else
            System.out.println("Такой категории пока нет.");
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }
}
