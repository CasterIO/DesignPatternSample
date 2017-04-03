package it.ennova.adapter;


public class NewToLegacyAdapter implements LegacyData{
    private final NewData wrapped;

    public NewToLegacyAdapter(NewData wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public long getByteCount() {
        return wrapped.dataRepresentation().getBytes().length;
    }

    @Override
    public String getDataAsString() {
        return wrapped.dataRepresentation();
    }
}
