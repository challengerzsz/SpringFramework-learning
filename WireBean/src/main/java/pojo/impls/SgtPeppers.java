package pojo.impls;

import org.springframework.stereotype.Component;
import pojo.CompactDisc;

@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. MixSound";
    private String artist = "zsz";

    public void play() {
        System.out.print("Playing " + title + " by " + artist);
    }
}
