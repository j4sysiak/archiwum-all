package com.company.mac;

import com.company.IButton;

public class MacButton implements IButton {

    @Override
    public void renderButton() {
        System.out.println("Render Mac button");
    }

    @Override
    public void handleClickButton() {
        System.out.println("Handle Mac click event");
    }
}
