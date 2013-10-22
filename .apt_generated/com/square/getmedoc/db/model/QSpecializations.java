package com.square.getmedoc.db.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSpecializations is a Querydsl query type for Specializations
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSpecializations extends EntityPathBase<Specializations> {

    private static final long serialVersionUID = 374046099;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSpecializations specializations = new QSpecializations("specializations");

    public final QAppuser appuser;

    public final QChoice choice;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QSpecializations(String variable) {
        this(Specializations.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QSpecializations(Path<? extends Specializations> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSpecializations(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSpecializations(PathMetadata<?> metadata, PathInits inits) {
        this(Specializations.class, metadata, inits);
    }

    public QSpecializations(Class<? extends Specializations> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.appuser = inits.isInitialized("appuser") ? new QAppuser(forProperty("appuser")) : null;
        this.choice = inits.isInitialized("choice") ? new QChoice(forProperty("choice")) : null;
    }

}

