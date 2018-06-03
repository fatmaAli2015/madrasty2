package com.example.fatmaali.madrasty2.Model;


public class CardItems {
    private int Images;
    private int mTitle;

    public CardItems(int images, int mTitle) {
        Images = images;
        this.mTitle = mTitle;
    }

    public int getImages() {
        return Images;
    }

    public void setImages(int images) {
        Images = images;
    }


    public int getmTitle() {
        return mTitle;
    }

    public void setmTitle(int mTitle) {
        this.mTitle = mTitle;
    }
}
