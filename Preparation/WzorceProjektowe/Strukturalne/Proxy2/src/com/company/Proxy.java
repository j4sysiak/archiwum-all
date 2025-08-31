package com.company;

public class Proxy implements IService {

    IService iService;  // nie tworzymy obiektu, tylko go deklarujemy
                        // dopiero w trakcie wywołania metody method() - tworzymy ten obiekt

    @Override
    public void method() {
        //druga przyczyna stosowania Proxy  np. AOP, Security, jakieś testy
        //możemy też dodać jakiś fragment kodu, który wykona się przed i po odpaleniem właściwej metody na obiekcie ServiceImpl
        //wzbogacamy kod o dodatkowe metody
   System.out.println("Before"); //tutaj możemy wykonać jakąś kluczową czynność:  np. AOP (Aspect Object Programming)

        //pierwsza przyczyna dodawania Proxy
        if (iService == null) {
            iService = new ServiceImpl();
        }
        System.out.println("Hello World from Proxy!!!!! - odwołuje się do włąściwego obiektu w klasie ServiceImpl");
        iService.method();

   System.out.println("After");
    }
}
