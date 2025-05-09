package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1366956614L;

    public static final QMember member = new QMember("member1");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath birth = createString("birth");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.domain.mapping.MemberAlarm, umc.spring.domain.mapping.QMemberAlarm> memberAlarmList = this.<umc.spring.domain.mapping.MemberAlarm, umc.spring.domain.mapping.QMemberAlarm>createList("memberAlarmList", umc.spring.domain.mapping.MemberAlarm.class, umc.spring.domain.mapping.QMemberAlarm.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.MemberMission, umc.spring.domain.mapping.QMemberMission> memberMissionList = this.<umc.spring.domain.mapping.MemberMission, umc.spring.domain.mapping.QMemberMission>createList("memberMissionList", umc.spring.domain.mapping.MemberMission.class, umc.spring.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.PreferFoodCategory, umc.spring.domain.mapping.QPreferFoodCategory> memberPreferList = this.<umc.spring.domain.mapping.PreferFoodCategory, umc.spring.domain.mapping.QPreferFoodCategory>createList("memberPreferList", umc.spring.domain.mapping.PreferFoodCategory.class, umc.spring.domain.mapping.QPreferFoodCategory.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath phoneNum = createString("phoneNum");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final EnumPath<umc.spring.domain.enums.MemberStatus> status = createEnum("status", umc.spring.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

