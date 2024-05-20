----- ADMIN -----
INSERT INTO ADMIN (
    NO
    , ID
    , PWD
    , NAME
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_ADMIN.NEXTVAL
    , 'admin01'
    , '1234abcd'
    , 'ÀÌÁö¼ö'
    , SYSDATE
    , 'N'
);

INSERT INTO ADMIN (
    NO
    , ID
    , PWD
    , NAME
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_ADMIN.NEXTVAL
    , 'admin02'
    , '1234abcd'
    , '³ªÁö¿ø'
    , SYSDATE
    , 'N'
);

INSERT INTO ADMIN (
    NO
    , ID
    , PWD
    , NAME
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_ADMIN.NEXTVAL
    , 'admin03'
    , '1234abcd'
    , 'ÁÖ¼±±â'
    , SYSDATE
    , 'N'
);



----- HOST -----
INSERT INTO HOST (
    NO
    , ID
    , PWD
    , NAME
    , PHONE
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_HOST.NEXTVAL
    , 'host01'
    , '1234abcd'
    , 'ÀÌÁö¼öÀ¡'
    , '01012345678'
    , SYSDATE
    , 'N'
);

INSERT INTO HOST (
    NO
    , ID
    , PWD
    , NAME
    , PHONE
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_HOST.NEXTVAL
    , 'host02'
    , '1234abcd'
    , '³ªÁö¿ø¼ö'
    , '01087654321'
    , SYSDATE
    , 'N'
);

INSERT INTO HOST (
    NO
    , ID
    , PWD
    , NAME
    , PHONE
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_HOST.NEXTVAL
    , 'host03'
    , '1234abcd'
    , '±è½ºÆ®'
    , '01043219876'
    , SYSDATE
    , 'N'
);



----- MEMBER -----
INSERT INTO MEMBER (
    NO
    , ID
    , PWD
    , NAME
    , EMAIL
    , MILEAGE
    , PHONE
    , IMG_URL
    , BIRTH_DATE
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_MEMBER.NEXTVAL
    , 'user01'
    , '1234abcd'
    , '±è¸â¹ö'
    , 'member01@naver.com'
    , 0
    , '01055442288'
    , ''
    , '19971105'
    , SYSDATE
    , 'N'
);

INSERT INTO MEMBER (
    NO
    , ID
    , PWD
    , NAME
    , EMAIL
    , MILEAGE
    , PHONE
    , IMG_URL
    , BIRTH_DATE
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_MEMBER.NEXTVAL
    , 'user02'
    , '1234abcd'
    , '±è¹³¹«'
    , 'member02@naver.com'
    , 0
    , '01044558822'
    , ''
    , '19920322'
    , SYSDATE
    , 'N'
);

INSERT INTO MEMBER (
    NO
    , ID
    , PWD
    , NAME
    , EMAIL
    , MILEAGE
    , PHONE
    , IMG_URL
    , BIRTH_DATE
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_MEMBER.NEXTVAL
    , 'user03'
    , '1234abcd'
    , '±è¸¾¹Ù'
    , 'member03@naver.com'
    , 0
    , '01028824212'
    , ''
    , '19861212'
    , SYSDATE
    , 'N'
);



----- FAQ -----
INSERT INTO FAQ (
    NO
    , TITLE
    , CONTENT
    , DEL_YN
    , ENROLL_DATE
    , MODIFY_DATE
    , VISIT
)
VALUES (
    SEQ_FAQ.NEXTVAL
    , 'title01'
    , 'content01'
    , 'N'
    , SYSDATE
    , NULL
    , 0
);

INSERT INTO FAQ (
    NO
    , TITLE
    , CONTENT
    , DEL_YN
    , ENROLL_DATE
    , MODIFY_DATE
    , VISIT
)
VALUES (
    SEQ_FAQ.NEXTVAL
    , 'title02'
    , 'content02'
    , 'N'
    , SYSDATE
    , NULL
    , 0
);

INSERT INTO FAQ (
    NO
    , TITLE
    , CONTENT
    , DEL_YN
    , ENROLL_DATE
    , MODIFY_DATE
    , VISIT
)
VALUES (
    SEQ_FAQ.NEXTVAL
    , 'title03'
    , 'content03'
    , 'N'
    , SYSDATE
    , NULL
    , 0
);



----- PAY_METHOD -----
INSERT INTO PAY_METHOD (
    PAY_METHOD_CODE
    , PAY_METHOD_NAME
)
VALUES (
    'P1'
    , 'card'
);

INSERT INTO PAY_METHOD (
    PAY_METHOD_CODE
    , PAY_METHOD_NAME
)
VALUES (
    'P2'
    , 'deposit'
);



----- THEME -----
INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T1'
    , 'country'
);

INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T2'
    , 'view'
);

INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T3'
    , 'swim'
);

INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T4'
    , 'beach'
);

INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T5'
    , 'farm'
);

INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T6'
    , 'korean'
);

INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T7'
    , 'camping'
);

INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T8'
    , 'kids'
);

INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T9'
    , 'castle'
);

INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T10'
    , 'new'
);

INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T11'
    , 'lake'
);

INSERT INTO THEME (
    THEME_CODE
    , THEME_NAME
)
VALUES (
    'T12'
    , 'golf'
);



----- QNA -----
INSERT INTO QNA (
    NO
    , ROOM_NO
    , WRITER_NO
    , TITLE
    , CONTENT
    , ANSWER
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_QNA.NEXTVAL
    , 1
    , 1
    , 'title01'
    , 'content01'
    , ''
    , SYSDATE
    , 'N'
);

INSERT INTO QNA (
    NO
    , ROOM_NO
    , WRITER_NO
    , TITLE
    , CONTENT
    , ANSWER
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_QNA.NEXTVAL
    , 2
    , 1
    , 'title02'
    , 'content02'
    , ''
    , SYSDATE
    , 'N'
);

INSERT INTO QNA (
    NO
    , ROOM_NO
    , WRITER_NO
    , TITLE
    , CONTENT
    , ANSWER
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_QNA.NEXTVAL
    , 1
    , 2
    , 'title03'
    , 'content03'
    , ''
    , SYSDATE
    , 'N'
);

INSERT INTO QNA (
    NO
    , ROOM_NO
    , WRITER_NO
    , TITLE
    , CONTENT
    , ANSWER
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_QNA.NEXTVAL
    , 2
    , 2
    , 'title04'
    , 'content04'
    , ''
    , SYSDATE
    , 'N'
);

INSERT INTO QNA (
    NO
    , ROOM_NO
    , WRITER_NO
    , TITLE
    , CONTENT
    , ANSWER
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_QNA.NEXTVAL
    , 1
    , 3
    , 'title05'
    , 'content05'
    , ''
    , SYSDATE
    , 'N'
);

INSERT INTO QNA (
    NO
    , ROOM_NO
    , WRITER_NO
    , TITLE
    , CONTENT
    , ANSWER
    , ENROLL_DATE
    , DEL_YN
)
VALUES (
    SEQ_QNA.NEXTVAL
    , 2
    , 3
    , 'title06'
    , 'content06'
    , ''
    , SYSDATE
    , 'N'
);

COMMIT;
