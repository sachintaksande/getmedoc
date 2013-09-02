package com.square.getmedoc.db.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAddress extends EntityPathBase<Address> {

    private static final long serialVersionUID = 1063474239;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAddress address = new QAddress("address");

    public final NumberPath<Long> addressid = createNumber("addressid", Long.class);

    public final QAppuser appuser;

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final StringPath line1 = createString("line1");

    public final StringPath line2 = createString("line2");

    public final StringPath line3 = createString("line3");

    public final NumberPath<Integer> preferred = createNumber("preferred", Integer.class);

    public final StringPath state = createString("state");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final StringPath zip = createString("zip");

    public QAddress(String variable) {
        this(Address.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QAddress(Path<? extends Address> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAddress(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAddress(PathMetadata<?> metadata, PathInits inits) {
        this(Address.class, metadata, inits);
    }

    public QAddress(Class<? extends Address> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.appuser = inits.isInitialized("appuser") ? new QAppuser(forProperty("appuser")) : null;
    }

}

