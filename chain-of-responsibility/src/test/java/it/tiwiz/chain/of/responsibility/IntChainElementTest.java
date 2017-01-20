package it.tiwiz.chain.of.responsibility;

import org.junit.Test;


public class IntChainElementTest {

    @Test
    public void createChainOfResponsibility() throws Exception {
        IntChainElement manages1 = new IntChainElement(1);
        IntChainElement manages2 = new IntChainElement(2);
        IntChainElement manages3 = new IntChainElement(3);

        manages1.setNext(manages2);
        manages2.setNext(manages3);

        manages1.onRequest(3);
    }
}