package com.xmqiu.uigenerate.entity;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class Align {
    public AlignTo leftToRightOf;
    public AlignTo right;
    public AlignTo top;
    public AlignTo bottom;
//    AlignValue baseLineAlign;

//    public AlignTo leftToLeftOf;
//    public AlignTo leftToLeftOf;
//    public AlignTo rightToLeftOf;
//    public AlignTo rightToRightOf;
//    public AlignTo topToTopOf;
//    public AlignTo topToBottomOf;
//    public AlignTo bottomToTopOf;
//    public AlignTo bottomToBottomOf;

    public class AlignTo {
        public BaseAlign align;
        public String to;

        public AlignTo(BaseAlign align, String to) {
            this.to = to;
        }
    }

//    public enum LeftAlign {
//        leftToLeftOf,
//        rightToRightOf
//    }

    public class BaseAlign {
        public String to;

        public BaseAlign(String to) {
            this.to = to;
        }
    }

    public class leftAlign extends BaseAlign {
        public leftAlign(String to) {
            super(to);
        }
    }

    public class toLeftOf extends BaseAlign {
        public toLeftOf(String to) {
            super(to);
        }
    }

    public class toRightOf extends BaseAlign {
        public toRightOf(String to) {
            super(to);
        }
    }
//            leftToLeftOf,
//            rightToLeftOf,
//            rightToRightOf,
//            topToTopOf,
//            topToBottomOf,
//            bottomToTopOf,
//            bottomToBottomOf,
}
