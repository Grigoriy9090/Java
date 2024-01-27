// -Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
// методы. Реализовать в java.
// - Создать множество ноутбуков.
// - Написать метод, который будет запрашивать у пользователя критерий (или критерии)
// фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
// хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// - Далее нужно запросить минимальные значения для указанных критериев - сохранить
// параметры фильтрации можно также в Map.
// - Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
// условиям.

// _____________________________
// Магазин ноутбуков.
// Поля:
//     Модель(model)
//     ОЗУ (ram);
//     Объем ЖД (hardDriveCapacity);
//     Операционная система (os);
//     Цвет корпуса (color);
// Методы:
//     Получить ОЗУ (getRam);
//     Получить ЖД (getHardDriveCapacity);
//     Получить ОС (getOs);
//     Получить цвет корпуса (getColour);

import java.util.Objects;

public class Laptop {

  private int ram;
  private int hardDriveCapacity;
  private String model;
  private String os;
  private String colour;

  public Laptop(
    int ram,
    int hardDriveCapacity,
    String model,
    String os,
    String colour
  ) {
    this.ram = ram;
    this.os = os;
    this.model = model;
    this.hardDriveCapacity = hardDriveCapacity;
    this.colour = colour;
  }

  public int getRam() {
    return ram;
  }

  public int getHardDriveCapacity() {
    return hardDriveCapacity;
  }

  public String getModel() {
    return model;
  }

  public String getOs() {
    return os;
  }

  public String getColour() {
    return colour;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public void setHardDriveCapacity(int hardDriveCapacity) {
    this.hardDriveCapacity = hardDriveCapacity;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  @Override
  public String toString() {
    String result =
      "Модель ноутбука: " +
      model +
      ", ОЗУ: " +
      ram +
      ", Объем жесткого диска: " +
      hardDriveCapacity +
      ", Операционная система: " +
      os +
      ", Цвет: " +
      colour;
    return result;
  }
}
