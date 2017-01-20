package io.caster.designpatterns.chain.output;


class Value {
    private final boolean isManaged;
    private final String element;
    private final int manageableItem;
    private final int requestedItem;

    Value(boolean isManaged, String element, int manageableItem, int requestedItem) {
        this.isManaged = isManaged;
        this.element = element;
        this.manageableItem = manageableItem;
        this.requestedItem = requestedItem;
    }

    boolean isManaged() {
        return isManaged;
    }

    String getElement() {
        return element;
    }

    int getManageableItem() {
        return manageableItem;
    }

    int getRequestedItem() {
        return requestedItem;
    }

    public static Value unmanaged(String element, int manageableItem, int requestedItem) {
        return new Value(false, element, manageableItem, requestedItem);
    }

    public static Value managed(String element, int requestedItem) {
        return new Value(true, element, requestedItem, requestedItem);
    }
}
