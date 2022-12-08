INSERT INTO entity(id,title,content) VALUES (1,'가가가','1111');
INSERT INTO entity(id,title,content) VALUES (2,'나나나','2222');
INSERT INTO entity(id,title,content) VALUES (3,'다다다','3333');

-- article 더미

INSERT INTO entity(id,title,content) VALUES (4,'당신의 인생 영화는?','댓글 ㄱ');
INSERT INTO entity(id,title,content) VALUES (5,'당신의 소울 푸드는?','댓글 ㄱㄱ');
INSERT INTO entity(id,title,content) VALUES (6,'당신의 취미는?','댓글 ㄱㄱㄱ');

-- comment 더미 데이터
---- 4번 게시글의 댓글
INSERT INTO comment(id, entity_id, nickname,body) VALUES (1,4,'park','굳 헌팅');
INSERT INTO comment(id, entity_id, nickname,body) VALUES (2,4,'kim','아이 엠 샘');
INSERT INTO comment(id, entity_id, nickname,body) VALUES (3,4,'lee','범죄도시');

---- 5번 게시글의 댓글
INSERT INTO comment(id, entity_id, nickname,body) VALUES (4,5,'park','치킨');
INSERT INTO comment(id, entity_id, nickname,body) VALUES (5,5,'kim','샤브샤브');
INSERT INTO comment(id, entity_id, nickname,body) VALUES (6,5,'lee','햄버거');

---- 6번 게시글의 댓글
INSERT INTO comment(id, entity_id, nickname,body) VALUES (7,6,'park','조깅');
INSERT INTO comment(id, entity_id, nickname,body) VALUES (8,6,'kim','유튜브');
INSERT INTO comment(id, entity_id, nickname,body) VALUES (9,6,'lee','축구');

