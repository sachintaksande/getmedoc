package com.square.getmedoc.db.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QWebaddress is a Querydsl query type for Webaddress
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QWebaddress extends EntityPathBase<Webaddress> {

    private static final long serialVersionUID = -989230603;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWebaddress webaddress = new QWebaddress("webaddress");

    public final QAppuser appuser;

    public final StringPath email = createString("email");

    public final NumberPath<Integer> preferred = createNumber("preferred", Integer.class);

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final NumberPath<Long> webaddressid = createNumber("webaddressid", Long.class);

    public QWebaddress(String variable) {
        this(Webaddress.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QWebaddress(Path<? extends Webaddress> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWebaddress(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWebaddress(PathMetadata<?> metadata, PathInits inits) {
        this(Webaddress.class, metadata, inits);
    }

    public QWebaddress(Class<? extends Webaddress> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.appuser = inits.isInitialized("appuser") ? new QAppuser(forProperty("appuser")) : null;
    }

}

