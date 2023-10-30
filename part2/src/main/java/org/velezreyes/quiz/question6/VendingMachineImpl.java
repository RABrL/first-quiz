package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {

  float money = 0;

  public static VendingMachine getInstance() {
    return new VendingMachineImpl();
  }

  @Override
  public void insertQuarter() {
    this.money += 0.25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if (name.equals(new ScottCola().getName())) {
      if (money < 0.75)
        throw new NotEnoughMoneyException();
      money -= 0.75;
      return new ScottCola();
    }
    if (name.equals(new KarenTea().getName())) {
      if (money < 1)
        throw new NotEnoughMoneyException();
      money -= 1;
      return new KarenTea();
    }

    throw new UnknownDrinkException();
  }
}
