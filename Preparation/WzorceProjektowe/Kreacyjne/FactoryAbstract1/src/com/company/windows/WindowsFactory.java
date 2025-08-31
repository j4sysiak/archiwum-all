package com.company.windows;

import com.company.IButton;
import com.company.IPanelFactory;
import com.company.ITextbox;

public class WindowsFactory implements IPanelFactory {

    @Override
    public IButton createButton() {
        return new WindowsButton(); // zwraca konkretny element (Button)  dla Windowsa
    }

    @Override
    public ITextbox createTextbox() {
        return new WindowsTextbox();  // zwraca konkretny element (Textbox)  dla Windowsa
    }
}
