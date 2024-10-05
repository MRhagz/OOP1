package PvZ_LAB;

public abstract class Mushroom extends Plant {
    private boolean state;
    public Mushroom (String name, int sun_cost, boolean state ) {
        super(name, sun_cost);
        this.state = state;
    }

    public boolean isAwake () {
        return state;
    }

    public void awaken (CoffeeBean bean) {
        bean.die();
        state = true;
    }


    // new Plants

    public static class SunShroom extends Mushroom implements SunProducer {
        public SunShroom(String name, int sun_cost, boolean state) {
            super(name, sun_cost, state);
        }

        @Override
        public int produce_sun() {
            if (!isAwake()) {
                System.out.println(name + " is asleep and cannot produce sun");
                return 0;
            }
            return 10;
        }
    }

    public static class PuffShroom extends Mushroom implements Attacker{
        public PuffShroom(String name, int sun_cost, boolean state) {
            super(name, sun_cost, state);
        }

        @Override
        public int attack () {
            if (!isAwake()) {
                System.out.println(name + " is asleep and cannot attack");
                return 0;
            }
            return 1;
        }

        @Override
        public int rangeType() {
            return RangeType.LIMITED_RANGE.getValue();
        }
    }

    public static class DoomShroom extends Mushroom implements Attacker, InstantKiller {
        public DoomShroom (String name, int sun_cost, boolean state) {
            super(name, sun_cost, state);
        }

        @Override
        public String die () {
            return super.die() + " while exploding and leaves a crater";
        }

        @Override
        public int attack () {
            if (!isAwake()) {
                System.out.println(name + " is asleep and cannot attack");
                return 0;
            }
            die();
            return 10;
        }

        @Override
        public int rangeType() {
            return RangeType.AREA_OF_EFFECT.getValue();
        }
    }
}
