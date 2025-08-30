package apiclient;

import apiclient.catfactmodel.CatFact;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CatFactRestClient {

    @Test
    public void test() throws IOException {

        // pobieramy jsona z jakiegoś zewnętrznego api  (lista różnych publicznych API: https://github.com/public-apis/public-apis)
        URL url = new URL("https://cat-fact.herokuapp.com/facts/random");
        InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());

        //Generator klas na podstawie jsona
        //korzystamy z https://www.jsonschema2pojo.org
        //narzędzie to generuje klasy na podstawie Jsona
        //Tworzymy klasę CatFact oraz do Status
        //teraz będzie można utworzyć cały obiekt CatFact z zaciągniętego zewnętrznego Jsona
        CatFact catFact = new Gson().fromJson(inputStreamReader, CatFact.class);

        System.out.println(catFact.getText());

        // lub

        URL url1 = new URL("https://aws.random.cat/meow");
        InputStreamReader inputStreamReader1 = new InputStreamReader(url1.openStream());
        JsonObject jsonObject = new JsonParser().parse(inputStreamReader1).getAsJsonObject();
        String randomCatFile = jsonObject.get("file").getAsString();
        System.out.println(randomCatFile);

    }
}




































