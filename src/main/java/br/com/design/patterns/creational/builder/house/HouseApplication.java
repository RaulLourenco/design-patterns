package br.com.design.patterns.creational.builder.house;

public class HouseApplication {
    public static void main(String[] args) {
        final House house = new House.Builder()
                .setFoundation("Concrete")
                .setStructure("Wood and Brick")
                .setRoof("Shingle")
                .setWindows(10)
                .setDoors(2)
                .build();

        System.out.println(house);
    }
}

class House {
    private final String foundation;
    private final String structure;
    private final String roof;
    private final int windows;
    private final int doors;

    private House(Builder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.windows = builder.windows;
        this.doors = builder.doors;
    }

    @Override
    public String toString() {
        return "House{" +
                "foundation='" + foundation + '\'' +
                ", structure='" + structure + '\'' +
                ", roof='" + roof + '\'' +
                ", windows=" + windows +
                ", doors=" + doors +
                '}';
    }

    public static class Builder {
        private String foundation;
        private String structure;
        private String roof;
        private int windows;
        private int doors;

        public Builder setFoundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public Builder setStructure(String structure) {
            this.structure = structure;
            return this;
        }

        public Builder setRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public Builder setWindows(int windows) {
            this.windows = windows;
            return this;
        }

        public Builder setDoors(int doors) {
            this.doors = doors;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}

