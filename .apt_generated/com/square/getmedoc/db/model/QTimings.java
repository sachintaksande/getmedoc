package com.square.getmedoc.db.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTimings is a Querydsl query type for Timings
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTimings extends EntityPathBase<Timings> {

    private static final long serialVersionUID = 897372596;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTimings timings = new QTimings("timings");

    public final QAddress address;

    public final QAppuser appuser;

    public final TimePath<java.util.Date> from = createTime("from", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final TimePath<java.util.Date> to = createTime("to", java.util.Date.class);

    public QTimings(String variable) {
        this(Timings.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QTimings(Path<? extends Timings> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTimings(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTimings(PathMetadata<?> metadata, PathInits inits) {
        this(Timings.class, metadata, inits);
    }

    public QTimings(Class<? extends Timings> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address"), inits.get("address")) : null;
        this.appuser = inits.isInitialized("appuser") ? new QAppuser(forProperty("appuser")) : null;
    }

}

