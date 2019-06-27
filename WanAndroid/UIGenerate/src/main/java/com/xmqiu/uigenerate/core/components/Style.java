package com.xmqiu.uigenerate.core.components;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:09
 */
public class Style {
    public int width, height;

    private Style(Builder builder) {
        this.width = builder.width;
        this.height = builder.height;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private int width;
        private int height;

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Style build() {
            return new Style(this);
        }
    }
}
