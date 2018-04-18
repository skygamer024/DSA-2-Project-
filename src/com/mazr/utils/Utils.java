package com.mazr.utils;

public class Utils {
    public enum Orientation {
        Horizontal,
        Vertical
    }

    public enum Wall {
        North,
        South,
        East,
        West;

        private Wall opposite;
        private Orientation orientation;

        static {
            North.opposite = South;
            South.opposite = North;
            East.opposite = West;
            West.opposite = East;

            North.orientation = Orientation.Horizontal;
            South.orientation = Orientation.Horizontal;
            East.orientation = Orientation.Vertical;
            West.orientation = Orientation.Vertical;
        }

        public Wall getOpposite() {
            return opposite;
        }

        public Orientation getOrientation() {
            return orientation;
        }
    }
}
