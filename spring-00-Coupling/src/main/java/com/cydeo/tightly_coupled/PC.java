package com.cydeo.tightly_coupled;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PC {

    private DellCase theCase;
    private AcerMonitor monitor; // if you want to change monitor for example then we need to change it here
    // so that is why PC is tightly coupled. To make change is not EASY
    private AsusMotherboard motherboard;


    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        monitor.drawPixelAt(1200, 50, "yellow");
    }
}
