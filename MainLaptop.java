import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainLaptop {

  public static void main(String[] args) {
    Set<Laptop> shopDB = getLaptops();

    System.out.println("Список параметров:");
    for (Laptop laptop : shopDB) {
      System.out.println(laptop);
    }
    System.out.println("/////////");
    System.out.println();

    Scanner scanner = new Scanner(System.in);

    while (true) {
      Map<String, Object> filters = new HashMap<>();
      System.out.println(
        "Введите параметры ноутбука. Значения указаны в круглых скобках!"
      );
      System.out.println("Введите пустое место вместо пропуска");
      System.out.println(
        "Модель, OS, и цвет корпуса должны точно соответствовать!):"
      );

      System.out.print("Модель (Asus, Acer, HP, Samsung) : ");
      String modelInput = scanner.nextLine();
      if (!modelInput.isEmpty()) {
        filters.put("model", modelInput);
      }

      System.out.print("Минимальный объем ОЗУ (4, 8, 16, 32): ");
      String ramInput = scanner.nextLine();
      if (!ramInput.isEmpty()) {
        filters.put("ram", Integer.parseInt(ramInput));
      }

      System.out.print(
        "Минимальный объем жесткого диска (120, 240, 500, 1000, 2000): "
      );
      String hardDriveCapacityInput = scanner.nextLine();
      if (!hardDriveCapacityInput.isEmpty()) {
        filters.put(
          "hardDriveCapacity",
          Integer.parseInt(hardDriveCapacityInput)
        );
      }

      System.out.print("Операционная система (Linux, Windows): ");
      String computerOsInput = scanner.nextLine();
      if (!computerOsInput.isEmpty()) {
        filters.put("computerOs", computerOsInput);
      }

      System.out.print("Цвет (White, Grey, Black, Red): ");
      String colourInput = scanner.nextLine();
      if (!colourInput.isEmpty()) {
        filters.put("colour", colourInput);
      }

      System.out.println("/////////");
      System.out.println(
        "Параметры выбора (весь список если их нет!)>> " + filters
      );
      System.out.println("////////////////////");

      filterLaptops(filters, shopDB);

      System.out.print("Желаете продолжить выбор (no - нет, yes - да)?: ");
      String yesNo = scanner.nextLine();
      if (yesNo.equals("no")) {
        System.out.println("GoodBye!");
        break;
      }
      System.out.println();
    }
  }

  public static Set<Laptop> getLaptops() {
    Laptop laptop1 = new Laptop(4, 120, "Asus", "Windows", "Red");
    Laptop laptop2 = new Laptop(32, 2000, "Samsung", "Windows", "Black");
    Laptop laptop3 = new Laptop(16, 500, "HP", "Linux", "Grey");
    Laptop laptop4 = new Laptop(8, 1000, "Acer", "Linux", "White");
    Laptop laptop5 = new Laptop(16, 1000, "Asus", "Windows", "Black");
    Laptop laptop6 = new Laptop(4, 240, "Samsung", "Linux", "Grey");
    Laptop laptop7 = new Laptop(16, 1000, "Asus", "Windows", "Black");
    Laptop laptop8 = new Laptop(16, 1000, "Asus", "Windows", "Red");
    Laptop laptop9 = new Laptop(8, 1000, "Acer", "Linux", "White");
    Laptop laptop10 = new Laptop(32, 2000, "Samsung", "Windows", "Black");

    

    Set<Laptop> shopDB = Set.of(
      laptop1,
      laptop2,
      laptop3,
      laptop4,
      laptop5,
      laptop6,
      laptop7,
      laptop8,
      laptop9,
      laptop10
    );
    return shopDB;
  }

  private static void filterLaptops(
    Map<String, Object> filters,
    Set<Laptop> laptopSet
  ) {
    for (Laptop laptop : laptopSet) {
      boolean passFilter = true;

      for (Map.Entry<String, Object> entry : filters.entrySet()) {
        switch (entry.getKey()) {
          case "model":
            if (!laptop.getModel().equals(entry.getValue())) {
              passFilter = false;
            }
            break;
          case "ram":
            if (laptop.getRam() < (int) entry.getValue()) {
              passFilter = false;
            }
            break;
          case "hdSize":
            if (laptop.getHardDriveCapacity() < (int) entry.getValue()) {
              passFilter = false;
            }
            break;
          case "computerOs":
            if (!laptop.getOs().equalsIgnoreCase((String) entry.getValue())) {
              passFilter = false;
            }
            break;
          case "colour":
            if (
              !laptop.getColour().equalsIgnoreCase((String) entry.getValue())
            ) {
              passFilter = false;
            }
            break;
        }
      }

      if (passFilter) {
        System.out.println(laptop);
      }
    }
    System.out.println("////////////////");
    System.out.println();
  }
}
