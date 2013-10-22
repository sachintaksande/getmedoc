package com.square.getmedoc.db.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QDoctor is a Querydsl query type for Doctor
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDoctor extends EntityPathBase<Doctor> {

    private static final long serialVersionUID = -839507084;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDoctor doctor = new QDoctor("doctor");

    public final QAppuser appuser;

    public final NumberPath<Integer> degree = createNumber("degree", Integer.class);

    public final StringPath expertise = createString("expertise");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> specilization = createNumber("specilization", Integer.class);

    public QDoctor(String variable) {
        this(Doctor.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QDoctor(Path<? extends Doctor> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDoctor(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDoctor(PathMetadata<?> metadata, PathInits inits) {
        this(Doctor.class, metadata, inits);
    }

    public QDoctor(Class<? extends Doctor> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.appuser = inits.isInitialized("appuser") ? new QAppuser(forProperty("appuser")) : null;
    }

}

