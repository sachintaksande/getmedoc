package com.square.getmedoc.db.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPhone is a Querydsl query type for Phone
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPhone extends EntityPathBase<Phone> {

    private static final long serialVersionUID = -708932487;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPhone phone = new QPhone("phone");

    public final QAppuser appuser;

    public final StringPath ext = createString("ext");

    public final NumberPath<Integer> phoneid = createNumber("phoneid", Integer.class);

    public final StringPath phonenum = createString("phonenum");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public QPhone(String variable) {
        this(Phone.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QPhone(Path<? extends Phone> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPhone(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPhone(PathMetadata<?> metadata, PathInits inits) {
        this(Phone.class, metadata, inits);
    }

    public QPhone(Class<? extends Phone> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.appuser = inits.isInitialized("appuser") ? new QAppuser(forProperty("appuser")) : null;
    }

}

