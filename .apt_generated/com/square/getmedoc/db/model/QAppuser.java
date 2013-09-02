package com.square.getmedoc.db.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAppuser is a Querydsl query type for Appuser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAppuser extends EntityPathBase<Appuser> {

    private static final long serialVersionUID = 1418208695;

    public static final QAppuser appuser = new QAppuser("appuser");

    public final SetPath<Address, QAddress> addresses = this.<Address, QAddress>createSet("addresses", Address.class, QAddress.class, PathInits.DIRECT2);

    public final NumberPath<Long> appuserid = createNumber("appuserid", Long.class);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> enabled = createNumber("enabled", Integer.class);

    public final StringPath fullname = createString("fullname");

    public final StringPath password = createString("password");

    public final SetPath<Phone, QPhone> phones = this.<Phone, QPhone>createSet("phones", Phone.class, QPhone.class, PathInits.DIRECT2);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Integer> substatus = createNumber("substatus", Integer.class);

    public final StringPath username = createString("username");

    public final SetPath<Userrole, QUserrole> userroles = this.<Userrole, QUserrole>createSet("userroles", Userrole.class, QUserrole.class, PathInits.DIRECT2);

    public final NumberPath<Integer> usersubtype = createNumber("usersubtype", Integer.class);

    public final NumberPath<Integer> usertype = createNumber("usertype", Integer.class);

    public final SetPath<Webaddress, QWebaddress> webaddresses = this.<Webaddress, QWebaddress>createSet("webaddresses", Webaddress.class, QWebaddress.class, PathInits.DIRECT2);

    public QAppuser(String variable) {
        super(Appuser.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QAppuser(Path<? extends Appuser> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QAppuser(PathMetadata<?> metadata) {
        super(Appuser.class, metadata);
    }

}

