package com.cjnnode.jQuery.bean;

/**
 * @program: AJAX
 * @description: 省份类
 * @author: 陈建南
 * @create: 2022-08-21 16:07
 **/
public class Province {
        private int id;
        private String name;
        private String shenghui;
        private String jiancheng;

        public Province(int id, String name, String shenghui, String jiancheng) {
            this.id = id;
            this.name = name;
            this.shenghui = shenghui;
            this.jiancheng = jiancheng;
        }

        public Province() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShenghui() {
            return shenghui;
        }

        public void setShenghui(String shenghui) {
            this.shenghui = shenghui;
        }

        public String getJiancheng() {
            return jiancheng;
        }

        public void setJiancheng(String jiancheng) {
            this.jiancheng = jiancheng;
        }

        @Override
        public String toString() {
            return "Province{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", shenghui='" + shenghui + '\'' +
                    ", jiancheng='" + jiancheng + '\'' +
                    '}';
        }

}