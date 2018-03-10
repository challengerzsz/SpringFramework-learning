package pojo.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.CompactDisc;
import pojo.MediaPlayer;

@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
