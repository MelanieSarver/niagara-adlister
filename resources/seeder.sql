USE adlister_db;

Insert INTO users(username, password, email) VALUES
  ('ryan', 'changeme', 'ryan@codeup.com');

INSERT into ads(user_id, title, description) VALUES
  (1, 'playstation for sale', 'This is a slightly used playstation'),
  (1, 'Super Nintendo', 'Get your game on with this old-school classic!'),
  (1, 'Junior Java Developer Position', 'Minimum 7 years of experience required. You will
  be working in the scripting language for Java, JavaScript'),
  (1, 'javaScript Developer Needed', 'Must have strong Java skills');
