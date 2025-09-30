public class Week5 {
    class Counter {
        private int value;
        private boolean check;

        // Four different constructors
        public Counter(int startingValue, boolean check) {
            this.value = startingValue;
            this.check = check;
        }

        public Counter(int startingValue) {
            this(startingValue, false);
        }

        public Counter(boolean check) {
            this(0, check);
        }

        public Counter() {
            this(0, false);
        }

        // Required methods
        public int value() {
            return this.value;
        }

        public void increase() {
            this.value++;
        }

        public void decrease() {
            if (this.check && this.value <= 0) {
                return;
            }
            this.value--;
        }

        // Overloaded methods
        public void increase(int increaseAmount) {
            if (increaseAmount >= 0) {
                this.value += increaseAmount;
            }
        }

        public void decrease(int decreaseAmount) {
            if (decreaseAmount < 0) {
                return;
            }

            if (this.check) {
                this.value = Math.max(0, this.value - decreaseAmount);
            } else {
                this.value -= decreaseAmount;
            }
        }
    }
}
