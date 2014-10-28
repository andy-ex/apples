package model.javafx;

import javafx.beans.property.*;
import model.record.DimensionRecord;

/**
 * Created by U430p on 27.10.2014.
 */
public class DimensionSelection {

    private BooleanProperty selected;
    private ObjectProperty<DimensionRecord> dimensionRecord;

    public DimensionSelection(DimensionRecord record) {
        this(record, true);
    }

    public DimensionSelection(DimensionRecord record, boolean selected) {
        dimensionRecord = new SimpleObjectProperty<>(record);
        this.selected = new SimpleBooleanProperty(selected);
    }

    public boolean getSelected() {
        return selected.get();
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    public DimensionRecord getDimensionRecord() {
        return dimensionRecord.get();
    }

    public ObjectProperty<DimensionRecord> dimensionRecordProperty() {
        return dimensionRecord;
    }

    public void setDimensionRecord(DimensionRecord dimensionRecord) {
        this.dimensionRecord.set(dimensionRecord);
    }
}
