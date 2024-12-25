package com.GinElmaC.Pojo;

public class Car {
        private Long id;
        private String car_num;
        private String brand;
        private Double guide_price;
        private String produce_time;
        private String car_type;


        public Car() {
        }

        public Car(Long id, String car_num, String brand, Double guide_price, String produce_time, String car_type) {
            this.id = id;
            this.car_num = car_num;
            this.brand = brand;
            this.guide_price = guide_price;
            this.produce_time = produce_time;
            this.car_type = car_type;
        }

        /**
         * 获取
         * @return id
         */
        public Long getId() {
            return id;
        }

        /**
         * 设置
         * @param id
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * 获取
         * @return car_num
         */
        public String getCar_num() {
            return car_num;
        }

        /**
         * 设置
         * @param car_num
         */
        public void setCar_num(String car_num) {
            this.car_num = car_num;
        }

        /**
         * 获取
         * @return brand
         */
        public String getBrand() {
            return brand;
        }

        /**
         * 设置
         * @param brand
         */
        public void setBrand(String brand) {
            this.brand = brand;
        }

        /**
         * 获取
         * @return guide_price
         */
        public Double getGuide_price() {
            return guide_price;
        }

        /**
         * 设置
         * @param guide_price
         */
        public void setGuide_price(Double guide_price) {
            this.guide_price = guide_price;
        }

        /**
         * 获取
         * @return produce_time
         */
        public String getProduce_time() {
            return produce_time;
        }

        /**
         * 设置
         * @param produce_time
         */
        public void setProduce_time(String produce_time) {
            this.produce_time = produce_time;
        }

        /**
         * 获取
         * @return car_type
         */
        public String getCar_type() {
            return car_type;
        }

        /**
         * 设置
         * @param car_type
         */
        public void setCar_type(String car_type) {
            this.car_type = car_type;
        }

        public String toString() {
            return "Car{id = " + id + ", car_num = " + car_num + ", brand = " + brand + ", guide_price = " + guide_price + ", produce_time = " + produce_time + ", car_type = " + car_type + "}";
        }
    }
