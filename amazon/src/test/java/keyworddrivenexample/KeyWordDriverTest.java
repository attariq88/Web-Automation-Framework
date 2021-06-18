package keyworddrivenexample;

import org.testng.annotations.Test;

public class KeyWordDriverTest {

    @Test
    public void keywordTest(){
        EventCase eventCase = new EventCase();
        eventCase.functionEventCase("goTOSignInPage");
    }
}
