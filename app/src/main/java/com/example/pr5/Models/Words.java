package com.example.pr5.Models;

public class Words {

        private String theme;  // столица
        private int img;

        public Words(String theme, int img){
            this.theme=theme;
            this.img=img;
        }

        public String getTheme() {
            return this.theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public int getImg() {
            return this.img;
        }

        public void setImg(int img) {
            this.img = img;
        }
    }

