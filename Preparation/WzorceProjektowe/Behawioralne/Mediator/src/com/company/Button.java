package com.company;

public class Button extends Component {

    public void click() {
        System.out.println("Button click ...");

        // informujemy inne komponenty (przy użyciu mediatora) o tym zdareniu
        this.iMediator.notify(this, "click");
    }

    public void render(){
        System.out.println("Render button ...");
        // CLUE:
        //  i  nic dalej nie robimy nie wysyłamy info notyfikacji do mediatora
        //  nie informujemy innych komponentów (przy użyciu mediatora) o tym zdareniu
    }
}
