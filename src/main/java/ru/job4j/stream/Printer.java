package ru.job4j.stream;

public class Printer {
    private String type;
    private String model;
    private String color;
    private int speedOfPrinting;
    private int yearOfProduction;
    private boolean wifi;
    private boolean delivery;

    @Override
    public String toString() {
        return "Printer{"
                + "type='" + type + '\''
                + ", model='" + model + '\''
                + ", color='" + color + '\''
                + ", speedOfPrinting=" + speedOfPrinting
                + ", yearOfProduction=" + yearOfProduction
                + ", wifi=" + wifi
                + ", delivery=" + delivery + '}';
    }

    static class Builder {
        private String type;
        private String model;
        private String color;
        private int speedOfPrinting;
        private int yearOfProduction;
        private boolean wifi;
        private boolean delivery;

        Builder buildType(String type) {
            this.type = type;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildSpeedOfPrinting(int speedOfPrinting) {
            this.speedOfPrinting = speedOfPrinting;
            return this;
        }

        Builder buildYearOfProduction(int yearOfProduction) {
            this.yearOfProduction = yearOfProduction;
            return this;
        }

        Builder buildWifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        Builder buildDelivery(boolean delivery) {
            this.delivery = delivery;
            return this;
        }

        Printer build() {
            Printer printer = new Printer();
            printer.type = type;
            printer.model = model;
            printer.color = color;
            printer.speedOfPrinting = speedOfPrinting;
            printer.yearOfProduction = yearOfProduction;
            printer.wifi = wifi;
            printer.delivery = delivery;
            return printer;
        }
    }

    public static void main(String[] args) {
        Printer printer = new Builder()
                .buildType("Laser")
                .buildModel("HP LaserJet Pro M28w")
                .buildColor("White")
                .buildSpeedOfPrinting(18)
                .buildYearOfProduction(2018)
                .buildWifi(true)
                .buildDelivery(false)
                .build();
        System.out.println(printer);
    }
}
