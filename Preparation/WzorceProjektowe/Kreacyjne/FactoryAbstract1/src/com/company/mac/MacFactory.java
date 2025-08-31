package com.company.mac;

import com.company.IButton;
import com.company.IPanelFactory;
import com.company.ITextbox;

public class MacFactory implements IPanelFactory {

    @Override
    public IButton createButton() {
        return new MacButton();  // zwraca konkretny element (Button)  dla Mac
    }

    @Override
    public ITextbox createTextbox() {
        return new MacTextbox();  // zwraca konkretny element (Textbox) dla Mac
    }
}
