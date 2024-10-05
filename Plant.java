package PvZ_LAB;

public abstract class Plant {
    String name;
    int hp;
    int sun_cost;

    public Plant (String name, int sun_cost) {
        this.name = name;
        hp = Health.DEFAULT.getValue();
        this.sun_cost = sun_cost;
    }

    public Plant(String name, int hp, int sun_cost) {
        this.name = name;
        this.hp = hp;
        this.sun_cost = sun_cost;
    }

    public Boolean isAlive() {
        return hp > 0;
    }

    public String die () {
        return name + " dies";
    }

    @Override
    public String toString() {
        return name + " (" + (hp == Health.DEFAULT.getValue() ? hp : '∞') + ") - cost: " + sun_cost;
    }

    // plants
    public static class CoffeeBean extends Plant{
        public CoffeeBean(String name, int sun_cost) {
            super(name, Health.INFINITE.getValue(), sun_cost);
        }
    }

    public static class Peashooter extends Plant implements Attacker{
        public Peashooter (String name, int sun_cost) {
            super(name, sun_cost);
        }

        @Override
        public int attack () {
            return 1;
        }

        @Override
        public int rangeType () {
            return RangeType.SINGLE_LINE.getValue();
        }
    }

    public static class Sunflower extends Plant implements SunProducer, Upgradable {
        public Sunflower (String name, int sun_cost) {
            super(name, sun_cost);
        }

        @Override
        public int produce_sun () {
            return 50;
        }

        @Override
        public PlantUpgrade upgrade () {
            return new TwinSunflower(name, sun_cost);
        }
    }

    public static class TwinSunflower extends Plant implements SunProducer, PlantUpgrade {
        public TwinSunflower (String name, int sun_cost) {
            super(name, sun_cost);
        }

        @Override
        public int produce_sun () {
            return 50;
        }

        @Override
        public int concurrentSunCost () {
            return 50;
        }
    }

    public static class WallNut extends Plant {
        public WallNut (String name, int sun_cost) {
            super(name, Health.INFINITE.getValue(), sun_cost);
        }
    }

    public static class Squash extends Plant implements Attacker, InstantKiller {
        public Squash (String name, int sun_cost) {
            super(name, Health.INFINITE.getValue(), sun_cost);
        }

        @Override
        public String die () {
            return super.die() + " while squashing zombies";
        }

        @Override
        public int attack () {
            die();
            return 3;
        }

        @Override
        public int rangeType () {
            return RangeType.LIMITED_RANGE.getValue();
        }

        @Override
        public int killType () {
            return KillType.CLOSE_CONTACT.getValue();
        }
    }

    public static class Jalapeno extends Plant implements Attacker, InstantKiller {
        public Jalapeno (String name, int sun_cost) {
            super(name, Health.INFINITE.getValue(), sun_cost);
        }

        @Override
        public String die () {
            return super.die() + " while exploding";
        }

        @Override
        public int attack () {
            die();
            return 5;
        }

        @Override
        public int rangeType () {
            return RangeType.SINGLE_LINE.getValue();
        }

        @Override
        public int killType () {
            return KillType.INSTANTLY.getValue();
        }
    }

    public static class LilyPad extends Plant implements Upgradable {
        public LilyPad (String name, int sun_cost) {
            super(name, sun_cost);
        }

        @Override
        public PlantUpgrade upgrade () {
            return new Cattail ();
        }
    }

    public static class Cattail extends Plant implements PlantUpgrade, Attacker {
        public Cattail (String name, int sun_cost) {
            super(name, sun_cost);
        }

        @Override
        public int concurrentSunCost () {
            return 25;
        }

        @Override
        public int rangeType () {
            return RangeType.FREE_RANGE.getValue();
        }

        @Override
        public int attack () {
            return 1;
        }
    }
}
