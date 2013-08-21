package com.square.getmedoc.db.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUserrole is a Querydsl query type for Userrole
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserrole extends EntityPathBase<Userrole> {

    private static final long serialVersionUID = -438902826;

    public static final QUserrole userrole = new QUserrole("userrole");

    public final SetPath<Appuser, QAppuser> appusers = this.<Appuser, QAppuser>createSet("appusers", Appuser.class, QAppuser.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final NumberPath<Integer> roleid = createNumber("roleid", Integer.class);

    public final StringPath rolename = createString("rolename");

    public QUserrole(String variable) {
        super(Userrole.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QUserrole(Path<? extends Userrole> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QUserrole(PathMetadata<?> metadata) {
        super(Userrole.class, metadata);
    }

}

