package app.core;


import app.annotations.Inject;
import app.interfaces.Blob;
import app.repositories.Repository;

import java.util.Collections;
import java.util.List;

public class BaseCommand {
    @Inject
    private List<String> params;
    @Inject
    private Repository<Blob> blobRepository;

    protected BaseCommand() {}

    protected List<String> getParams() {
        return Collections.unmodifiableList(this.params);
    }

    protected Repository<Blob> getBlobRepository() {
        return this.blobRepository;
    }
}
