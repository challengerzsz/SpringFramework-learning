package pojo.impls;

import pojo.CompactDisc;

public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. MixSound";
    private String artist = "zsz";

    public void play() {
        System.out.print("Playing " + title + " by " + artist);
    }
}
