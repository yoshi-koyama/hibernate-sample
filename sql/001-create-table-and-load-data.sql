CREATE TABLE player_score(
  id int auto_increment,
  player_name varchar(100),
  score int,
  difficulty varchar(30),
  registered_at datetime,
  primary key(id)
);

INSERT player_score values(1, 'koujienami', 70, 'normal', now());
INSERT player_score values(2, 'koujienami', 65, 'hard', now());
