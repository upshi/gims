package com.yiheidaodi.gims.dto;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.dto
 * 描述：
 * 作者：王豫宁
 * 时间：2016-9-21 09:40.
 */

public class ListAndMsg<T> {

    private List<T> models;
    private List<Pair> msgs;

    public ListAndMsg() {}

    public ListAndMsg(List<T> models, List<Pair> msgs) {
        this.models = models;
        this.msgs = msgs;
    }

    public List<T> getModels() {
        return models;
    }

    public void setModels(List<T> models) {
        this.models = models;
    }

    public List<Pair> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Pair> msgs) {
        this.msgs = msgs;
    }

    @Override
    public String toString() {
        return "ListAndMsg{" +
                "models=" + models +
                ", msgs=" + msgs +
                '}';
    }




    public static class Pair {
        String key;
        String value;

        public Pair() {}

        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

}
