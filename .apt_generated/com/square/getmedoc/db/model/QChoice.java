package com.square.getmedoc.db.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QChoice is a Querydsl query type for Choice
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QChoice extends EntityPathBase<Choice> {

    private static final long serialVersionUID = -874254346;

    public static final QChoice choice = new QChoice("choice");

    public final NumberPath<Integer> choiceid = createNumber("choiceid", Integer.class);

    public final NumberPath<Integer> choiceindex = createNumber("choiceindex", Integer.class);

    public final SetPath<Degree, QDegree> degrees = this.<Degree, QDegree>createSet("degrees", Degree.class, QDegree.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final SetPath<Specializations, QSpecializations> specializationses = this.<Specializations, QSpecializations>createSet("specializationses", Specializations.class, QSpecializations.class, PathInits.DIRECT2);

    public QChoice(String variable) {
        super(Choice.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QChoice(Path<? extends Choice> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QChoice(PathMetadata<?> metadata) {
        super(Choice.class, metadata);
    }

}

