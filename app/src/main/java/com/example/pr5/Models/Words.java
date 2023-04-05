package com.example.pr5.Models;

public class Words {

        private String theme;  // столица
        private int img; // ресурс флага

        public Words(String theme, int img){
            this.theme=theme;
            this.img=img;
        }

        public String getCapital() {
            return this.theme;
        }

        public void setCapital(String capital) {
            this.theme = capital;
        }

        public int getFlagResource() {
            return this.img;
        }

        public void setFlagResource(int flagResource) {
            this.img = flagResource;
        }
    }

