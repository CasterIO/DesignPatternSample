package io.caster.designpatterns.chain.output;


import io.caster.designpatterns.utils.MemoryUtils;

class OutputChainElement implements ValueCallback{
    private final int managedItem;
    private final OutputCallback callback;
    private final String elementName;
    private OutputChainElement next;

    public OutputChainElement(int managedItem, OutputCallback callback) {
        this.managedItem = managedItem;
        this.callback = callback;
        elementName = MemoryUtils.findMemoryAddressOf(this);
    }

    public void setNext(OutputChainElement next) {
        this.next = next;
    }

    @Override
    public void onNewValueSelected(int value) {
        if (managedItem == value) {
            callback.onNewValueReceived(Value.managed(elementName, value));
        } else {
            callback.onNewValueReceived(Value.unmanaged(elementName, managedItem, value));
            next.onNewValueSelected(value);
        }
    }

}
