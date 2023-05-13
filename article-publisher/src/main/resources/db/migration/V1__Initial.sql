DROP TABLE IF EXISTS "users";
DROP SEQUENCE IF EXISTS users_id_seq;
CREATE SEQUENCE users_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "users" (
                         "id" bigint DEFAULT nextval('users_id_seq') NOT NULL,
                         "user_name" text,
                         "email" text,
                         "age" integer,
                         CONSTRAINT "users_pkey" PRIMARY KEY ("id")
);
INSERT INTO "users" ("id", "email", "user_name", "age") VALUES
                                                (1,	    'user0@email.com', 'Abigail Rose',	80),
                                                (2,	    'user1@email.com', 'Adam Parker',	36),
                                                (3,	    'user2@email.com', 'Adeline Rivers',	49),
                                                (4,	    'user3@email.com', 'Aiden Knight',	87),
                                                (5,	    'user4@email.com', 'Alexa Stone',	34),
                                                (6,	    'user5@email.com', 'Alexander Chase',	22),
                                                (7,	    'user6@email.com', 'Alexandria Blake',	43),
                                                (8,	    'user7@email.com', 'Allison Ford',	56),
                                                (9,	    'user8@email.com', 'Amelia Reed',	63),
                                                (10,	'user9@email.com', 'Andrew Knight',	77),
                                                (11,	'user10@email.com', 'Annabelle Scott',	68),
                                                (12,	'user11@email.com', 'Anthony Green',	70),
                                                (13,	'user12@email.com', 'Ariana Cole',	84),
                                                (14,	'user13@email.com', 'Ashton Stone',	28),
                                                (15,	'user14@email.com', 'Audrey Morgan',	48),
                                                (16,	'user15@email.com', 'Ava Barnes',	81),
                                                (17,	'user16@email.com', 'Benjamin Parker',	25),
                                                (18,	'user17@email.com', 'Bethany Grey',	38),
                                                (19,	'user18@email.com', 'Blake Walker',	67),
                                                (20,	'user19@email.com', 'Bradley Evans',	69),
                                                (21,	'user20@email.com', 'Brianna Flynn',	54),
                                                (22,	'user21@email.com', 'Brooke Stevens',	79),
                                                (23,	'user22@email.com', 'Caleb Davis',	72),
                                                (24,	'user23@email.com', 'Cameron Riley',	66),
                                                (25,	'user24@email.com', 'Caroline King',	46),
                                                (26,	'user25@email.com', 'Carter Scott',	57),
                                                (27,	'user26@email.com', 'Casey Edwards',	75),
                                                (28,	'user27@email.com', 'Cassandra Hill',	74),
                                                (29,	'user28@email.com', 'Charlotte Hayes',	45),
                                                (30,	'user29@email.com', 'Chelsea Jones',	58),
                                                (31,	'user30@email.com', 'Claire Collins',	71),
                                                (32,	'user31@email.com', 'Cody Matthews',	35),
                                                (33,	'user32@email.com', 'Cole Brooks',	52),
                                                (34,	'user33@email.com', 'Cooper Daniels',	89),
                                                (35,	'user34@email.com', 'Daisy Cooper',	53),
                                                (36,	'user35@email.com', 'Daniel Ford',	51),
                                                (37,	'user36@email.com', 'Daniella Rose',	41),
                                                (38,	'user37@email.com', 'David James',	64),
                                                (39,	'user38@email.com', 'Delilah Greene',	26),
                                                (40,	'user39@email.com', 'Dylan Baker',	44),
                                                (41,	'user40@email.com', 'Elizabeth Wells',	85),
                                                (42,	'user41@email.com', 'Emily Campbell',	23),
                                                (43,	'user42@email.com', 'Emma Taylor',	61),
                                                (44,	'user43@email.com', 'Ethan Grey',	86),
                                                (45,	'user44@email.com', 'Eva Parker',	76),
                                                (46,	'user45@email.com', 'Finn Walker',	55),
                                                (47,	'user46@email.com', 'Gabrielle Jones',	30),
                                                (48,	'user47@email.com', 'Gavin Sullivan',	33),
                                                (49,	'user48@email.com', 'Georgia Young',	88),
                                                (50,	'user49@email.com', 'Grace Cooper',	82),
                                                (51,	'user50@email.com', 'Haley Anderson',	27),
                                                (52,	'user51@email.com', 'Harper Thompson',	42),
                                                (53,	'user52@email.com', 'Hayden Foster',	78),
                                                (54,	'user53@email.com', 'Isabella James',	50),
                                                (55,	'user54@email.com', 'Jackson Ford',	60),
                                                (56,	'user55@email.com', 'Jacob Matthews',	37),
                                                (57,	'user56@email.com', 'Jade Taylor',	83),
                                                (58,	'user57@email.com', 'Jameson Reid',	31),
                                                (59,	'user58@email.com', 'Jasmine Cooper',	24),
                                                (60,	'user59@email.com', 'Jason Scott',	62),
                                                (61,	'user60@email.com', 'Jayden Knight',	73),
                                                (62,	'user61@email.com', 'Jenna Evans',	47),
                                                (63,	'user62@email.com', 'Jessica Stone',	65),
                                                (64,	'user63@email.com', 'John Davis',	39),
                                                (65,	'user64@email.com', 'Jordan Greene',	32),
                                                (66,	'user65@email.com', 'Josephine King',	59),
                                                (67,	'user66@email.com', 'Joshua Campbell',	40),
                                                (68,	'user67@email.com', 'Julia Parker',	72),
                                                (69,	'user68@email.com', 'Justin Evans',	58),
                                                (70,	'user69@email.com', 'Kaitlyn Thompson',	31),
                                                (71,	'user70@email.com', 'Kate Johnson',	24),
                                                (72,	'user71@email.com', 'Katherine Anderson',	75),
                                                (73,	'user72@email.com', 'Kathryn Greene',	41),
                                                (74,	'user73@email.com', 'Kelly Collins',	63),
                                                (75,	'user74@email.com', 'Kennedy Foster',	69),
                                                (76,	'user75@email.com', 'Kimberly Jones',	52),
                                                (77,	'user76@email.com', 'Kyle Reed',	28),
                                                (78,	'user77@email.com', 'Lauren Mitchell',	76),
                                                (79,	'user78@email.com', 'Leah Cooper',	85),
                                                (80,	'user79@email.com', 'Leo Sullivan',	87),
                                                (81,	'user80@email.com', 'Lily Matthews',	77),
                                                (82,	'user81@email.com', 'Logan Green',	35),
                                                (83,	'user82@email.com', 'Lucas Taylor',	60),
                                                (84,	'user83@email.com', 'Mackenzie Parker',	46),
                                                (85,	'user84@email.com', 'Madeline Jones',	34),
                                                (86,	'user85@email.com', 'Marcus Evans',	86),
                                                (87,	'user86@email.com', 'Margaret Scott',	80),
                                                (88,	'user87@email.com', 'Maria King',	53),
                                                (89,	'user88@email.com', 'Mason Anderson',	54),
                                                (90,	'user89@email.com', 'Matthew Brown',	42),
                                                (91,	'user90@email.com', 'Megan Foster',	30),
                                                (92,	'user91@email.com', 'Michael Reed',	67),
                                                (93,	'user92@email.com', 'Miranda Hayes',	50),
                                                (94,	'user93@email.com', 'Natalie Campbell',	56),
                                                (95,	'user94@email.com', 'Nathan Grey',	78),
                                                (96,	'user95@email.com', 'Nicholas Baker',	89),
                                                (97,	'user96@email.com', 'Olivia Thompson',	49),
                                                (98,	'user97@email.com', 'Patrick Green',	81),
                                                (99,	'user98@email.com', 'Penelope Davis',	61),
                                                (100,	'user99@email.com', 'Rachel Wilson',	38);

DROP TABLE IF EXISTS "articles";
DROP SEQUENCE IF EXISTS article_id_seq;
CREATE SEQUENCE article_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "articles" (
                            "id" text NOT NULL,
                            "title" text,
                            "body" text,
                            "author_id" bigint,
                            CONSTRAINT "articles_pkey" PRIMARY KEY ("id")
);
INSERT INTO "articles" ("id", "title", "body", "author_id") VALUES
                                                             (1, '978-1-2345-6789-0',	'The Shadow in the Attic',	1),
                                                             (2, '978-1-2345-6789-1',	'Beyond the Horizon',	2),
                                                             (3, '978-1-2345-6789-2',	'The Last Ember',	3),
                                                             (4, '978-1-2345-6789-3',	'The Forgotten Key',	4),
                                                             (5, '978-1-2345-6789-4',	'The Silence in the Woods',	5),
                                                             (6, '978-1-2345-6789-5',	'In the Eye of the Storm',	6),
                                                             (7, '978-1-2345-6789-6',	'The Seventh Sense',	7),
                                                             (8, '978-1-2345-6789-7',	'The Secret of the Stars',	8),
                                                             (9, '978-1-2345-6789-8',	'The Forgotten Ones',	9),
                                                             (10, '978-1-2345-6789-9',	'The Lost Heirloom',	10),
                                                             (11, '978-1-2345-6780-0',	'The Whispering Tree',	11),
                                                             (12, '978-1-2345-6780-1',	'The Last Harvest',	12),
                                                             (13, '978-1-2345-6780-2',	'The Darkened Path',	13),
                                                             (14, '978-1-2345-6780-3',	'The Forgotten City',	14),
                                                             (15, '978-1-2345-6780-4',	'The Crystal Key',	15),
                                                             (16, '978-1-2345-6780-5',	'The Seventh Scroll',	16),
                                                             (17, '978-1-2345-6780-6',	'The Witching Hour',	17),
                                                             (18, '978-1-2345-6780-7',	'The Darkening Skies',	18),
                                                             (19, '978-1-2345-6780-8',	'The Cursed Mirror',	19),
                                                             (20, '978-1-2345-6780-9',	'The Ghost in the Mirror',	20),
                                                             (21, '978-1-2345-6781-0',	'The Chosen One',	21),
                                                             (22, '978-1-2345-6781-1',	'The Enchanted Forest',	22),
                                                             (23, '978-1-2345-6781-2',	'The Hidden Truth',	23),
                                                             (24, '978-1-2345-6781-3',	'The Silver Lining',	24),
                                                             (25, '978-1-2345-6781-4',	'The Burning Sands',	25),
                                                             (26, '978-1-2345-6781-5',	'The Final Countdown',	26),
                                                             (27, '978-1-2345-6781-6',	'The Lost Civilization',	27),
                                                             (28, '978-1-2345-6781-7',	'The Dead of Night',	28),
                                                             (29, '978-1-2345-6781-8',	'The Forgotten Castle',	29),
                                                             (30, '978-1-2345-6781-9',	'The Crimson Rose',	30),
                                                             (31, '978-1-2345-6782-0',	'The Phantom of the Opera House',	31),
                                                             (32, '978-1-2345-6782-1',	'The Burning Tide',	32),
                                                             (33, '978-1-2345-6782-2',	'The Nightingale''s Lament',	33),
                                                             (34, '978-1-2345-6782-3',	'The Shimmering Sands',	34),
                                                             (35, '978-1-2345-6782-4',	'The Timeless River',	35),
                                                             (36, '978-1-2345-6782-5',	'The Lost Kingdom',	36),
                                                             (37, '978-1-2345-6782-6',	'The Starless Sky',	37),
                                                             (38, '978-1-2345-6782-7',	'The Cursed Mansion',	38),
                                                             (39, '978-1-2345-6782-8',	'The Haunting of Briarwood Manor',	39),
                                                             (40, '978-1-2345-6782-9',	'The Twisted Vine',	40),
                                                             (41, '978-1-2345-6783-0',	'The Dragon''s Lair',	41),
                                                             (42, '978-1-2345-6783-1',	'The Secret Society',	42),
                                                             (43, '978-1-2345-6783-2',	'The Vanishing Village',	43),
                                                             (44, '978-1-2345-6783-3',	'The Fire Within',	44),
                                                             (45, '978-1-2345-6783-4',	'The Shadowed Path',	45),
                                                             (46, '978-1-2345-6783-5',	'The Forbidden Tome',	46),
                                                             (47, '978-1-2345-6783-6',	'The Final Reckoning',	47),
                                                             (48, '978-1-2345-6783-7',	'The Dreamer''s Labyrinth',	48),
                                                             (49, '978-1-2345-6783-8',	'The Hollow Mountain',	49),
                                                             (50, '978-1-2345-6783-9',	'The Endless Abyss',	50),
                                                             (51, '978-1-2345-6784-0',	'The Cryptic Key',	51),
                                                             (52, '978-1-2345-6784-1',	'The Forbidden City',	52),
                                                             (53, '978-1-2345-6784-2',	'The Chasm of Despair',	53),
                                                             (54, '978-1-2345-6784-3',	'The Seer''s Prophecy',	54),
                                                             (55, '978-1-2345-6784-4',	'The Last Hope',	55),
                                                             (56, '978-1-2345-6784-5',	'The Enigma of the Sphinx',	56),
                                                             (57, '978-1-2345-6784-6',	'The Mists of Avalon',	57),
                                                             (58, '978-1-2345-6784-7',	'The Lost Treasure',	58),
                                                             (59, '978-1-2345-6784-8',	'The Darkened Forest',	59),
                                                             (60, '978-1-2345-6784-9',	'The Secret of the Ocean',	60),
                                                             (61, '978-1-2345-6785-0',	'The Seventh Tower',	61),
                                                             (62, '978-1-2345-6785-1',	'The Missing Link',	62),
                                                             (63, '978-1-2345-6785-2',	'The Cursed Woods',	63),
                                                             (64, '978-1-2345-6785-3',	'The Mystic''s Legacy',	64),
                                                             (65, '978-1-2345-6785-4',	'The Dragon''s Breath',	65),
                                                             (66, '978-1-2345-6785-5',	'The Secret of the Sphinx',	66),
                                                             (67, '978-1-2345-6785-6',	'The Crimson Sun',	67),
                                                             (68, '978-1-2345-6785-7',	'The Fallen Star',	68),
                                                             (69, '978-1-2345-6785-8',	'The Phantom''s Curse',	69),
                                                             (70, '978-1-2345-6785-9',	'The Shattered Mirror',	70),
                                                             (71, '978-1-2345-6786-0',	'The Lost Causeway',	71),
                                                             (72, '978-1-2345-6786-1',	'The Enchanted Mirror',	72),
                                                             (73, '978-1-2345-6786-2',	'The Secret of the Island',	73),
                                                             (74, '978-1-2345-6786-3',	'The Chosen One''s Destiny',	74),
                                                             (75, '978-1-2345-6786-4',	'The Burning Beacon',	75),
                                                             (76, '978-1-2345-6786-5',	'The Eternal Flame',	76),
                                                             (77, '978-1-2345-6786-6',	'The Timekeeper''s Secret',	77),
                                                             (78, '978-1-2345-6786-7',	'The Lost Language',	78),
                                                             (79, '978-1-2345-6786-8',	'The Secret of the Scroll',	79),
                                                             (80, '978-1-2345-6786-9',	'The Last Battle',	80),
                                                             (81, '978-1-2345-6787-0',	'The Forbidden Forest',	81),
                                                             (82, '978-1-2345-6787-1',	'The Hidden Path',	82),
                                                             (83, '978-1-2345-6787-2',	'The Shrouded Mansion',	83),
                                                             (84, '978-1-2345-6787-3',	'The Final Sacrifice',	84),
                                                             (85, '978-1-2345-6787-4',	'The Lost Temple',	85),
                                                             (86, '978-1-2345-6787-5',	'The Starless Night',	86),
                                                             (87, '978-1-2345-6787-6',	'The Cursed Crown',	87),
                                                             (88, '978-1-2345-6787-7',	'The Haunting of Ravenwood Hall',	88),
                                                             (89, '978-1-2345-6787-8',	'The Twisted Woods',	89),
                                                             (90, '978-1-2345-6787-9',	'The Dragon''s Roar',	90),
                                                             (91, '978-1-2345-6788-0',	'The Secret Order',	91),
                                                             (92, '978-1-2345-6788-1',	'The Vanishing Town',	92),
                                                             (93, '978-1-2345-6788-2',	'The Fire Within Us',	93),
                                                             (94, '978-1-2345-6788-3',	'The Shadowed Forest',	94),
                                                             (95, '978-1-2345-6788-4',	'The Forbidden Library',	95),
                                                             (96, '978-1-2345-6788-5',	'The Final Hour',	96),
                                                             (97, '978-1-2345-6788-6',	'The Dreamer''s Nightmare',	97),
                                                             (98, '978-1-2345-6788-7',	'The Hollow Cave',	98),
                                                             (99, '978-1-2345-6788-8',	'The Endless Night',	99),
                                                             (100, '978-2-2345-6789-1',	'The Cryptic Castle',	100);