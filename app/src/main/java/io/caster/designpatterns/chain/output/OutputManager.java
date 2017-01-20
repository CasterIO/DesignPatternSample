package io.caster.designpatterns.chain.output;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.caster.designpatterns.R;
import io.caster.designpatterns.chain.ChainOfResponsibilityActivity;


public class OutputManager implements OutputCallback, ValueCallback {

    private final ValueAdapter adapter = new ValueAdapter();
    private final OutputChainElement chain;

    public static OutputManager with(@NonNull ChainOfResponsibilityActivity target) {
        RecyclerView list = (RecyclerView) target.findViewById(R.id.outputList);
        return new OutputManager(list);
    }

    private OutputManager(RecyclerView outputList) {
        this.chain = buildWith(this);
        outputList.setLayoutManager(new LinearLayoutManager(outputList.getContext()));
        outputList.setAdapter(adapter);
    }

    private OutputChainElement buildWith(OutputManager outputManager) {
        OutputChainElement chain0 = new OutputChainElement(0, outputManager);
        OutputChainElement chain1 = new OutputChainElement(1, outputManager);
        OutputChainElement chain2 = new OutputChainElement(2, outputManager);
        OutputChainElement chain3 = new OutputChainElement(3, outputManager);
        OutputChainElement chain4 = new OutputChainElement(4, outputManager);
        OutputChainElement chain5 = new OutputChainElement(5, outputManager);
        OutputChainElement chain6 = new OutputChainElement(6, outputManager);
        OutputChainElement chain7 = new OutputChainElement(7, outputManager);
        OutputChainElement chain8 = new OutputChainElement(8, outputManager);
        OutputChainElement chain9 = new OutputChainElement(9, outputManager);
        OutputChainElement chain10 = new OutputChainElement(10, outputManager);

        chain0.setNext(chain1);
        chain1.setNext(chain2);
        chain2.setNext(chain3);
        chain3.setNext(chain4);
        chain4.setNext(chain5);
        chain5.setNext(chain6);
        chain6.setNext(chain9);
        chain7.setNext(chain8);
        chain8.setNext(chain9);
        chain9.setNext(chain10);

        return chain0;
    }

    @Override
    public void onNewValueReceived(@NonNull Value value) {
        adapter.addValue(value);
    }

    @Override
    public void onNewValueSelected(int value) {
        chain.onNewValueSelected(value);
    }
}
