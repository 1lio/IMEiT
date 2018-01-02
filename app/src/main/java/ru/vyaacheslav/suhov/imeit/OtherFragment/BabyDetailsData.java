package ru.vyaacheslav.suhov.imeit.OtherFragment;

public class BabyDetailsData {

    String babyname;
    int babypicture;

    public BabyDetailsData(String babyname, int babypicture) {
        super();
        this.babyname = babyname;
        this.babypicture = babypicture;
    }

    public String getBabyname() {
        return babyname;
    }

    public void setBabyname(String babyname) {
        this.babyname = babyname;
    }

    public int getBabypicture() {
        return babypicture;
    }

    public void setBabypicture(int babypicture) {
        this.babypicture = babypicture;
    }
}