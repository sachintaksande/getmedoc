package com.square.getmedoc.db.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QDegree is a Querydsl query type for Degree
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDegree extends EntityPathBase<Degree> {

    private static final long serialVersionUID = -848625375;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDegree degree = new QDegree("degree");

    public final QAppuser appuser;

    public final QChoice choice;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QDegree(String variable) {
        this(Degree.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QDegree(Path<? extends Degree> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDegree(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDegree(PathMetadata<?> metadata, PathInits inits) {
        this(Degree.class, metadata, inits);
    }

    public QDegree(Class<? extends Degree> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.appuser = inits.isInitialized("appuser") ? new QAppuser(forProperty("appuser")) : null;
        this.choice = inits.isInitialized("choice") ? new QChoice(forProperty("choice")) : null;
    }

}

