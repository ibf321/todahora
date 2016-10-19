-- DROP SCHEMA todahora;
CREATE SCHEMA todahora AUTHORIZATION cico;
  
-- User
CREATE TABLE todahora.USER (
	ID serial,
	NAME VARCHAR(80) NOT NULL,
	PHOTO_URL varchar(90),
	email VARCHAR(50) NOT NULL,
	PASSWORD VARCHAR(90) NOT NULL,
	ENABLED BOOLEAN NOT NULL,
	PRIMARY KEY (id)
); 
COMMENT ON TABLE todahora.USER IS 'Responsible for maintaining the record of user';
COMMENT ON COLUMN todahora.USER.ID IS 'Identifier user';
COMMENT ON COLUMN todahora.USER.NAME IS 'Name user'; 
COMMENT ON COLUMN todahora.USER.PHOTO_URL IS 'Photo user';
COMMENT ON COLUMN todahora.USER.EMAIL IS 'EMAIL';
COMMENT ON COLUMN todahora.USER.PASSWORD IS 'User password';
COMMENT ON COLUMN todahora.USER.ENABLED IS 'Enable or disable user';
CREATE UNIQUE INDEX u_idx_email ON todahora.USER (EMAIL);

-- User profile
CREATE TABLE todahora.USER_PROFILE(
   ID serial,
   TYPE VARCHAR(30) NOT NULL,
   PRIMARY KEY (ID)
);
COMMENT ON TABLE todahora.USER_PROFILE IS 'Responsible for maintaining the records of access profiles';
COMMENT ON COLUMN todahora.USER_PROFILE.ID IS 'Identifier profile';
COMMENT ON COLUMN todahora.USER_PROFILE.TYPE IS 'Type of profile';

-- Authority
CREATE TABLE todahora.authority (
    USER_ID bigint NOT NULL,
    USER_PROFILE_ID bigint NOT NULL,
    PRIMARY KEY (USER_ID, USER_PROFILE_ID),
    CONSTRAINT fk_user_id FOREIGN KEY (USER_ID) REFERENCES todahora.USER (ID),
    CONSTRAINT fk_user_profile_id FOREIGN KEY (USER_PROFILE_ID) REFERENCES todahora.USER_PROFILE (ID)
);
COMMENT ON TABLE todahora.AUTHORITY IS 'Responsible for maintaining the register of permission access';
COMMENT ON COLUMN todahora.AUTHORITY.USER_ID IS 'Identifier user';
COMMENT ON COLUMN todahora.AUTHORITY.USER_PROFILE_ID IS 'Identifier profile';

-- Event
CREATE TABLE todahora.EVENT (
	ID serial, 
	NAME VARCHAR(100) NOT NULL, 
	DESCRIPTION VARCHAR(255) NOT NULL, 
	PHOTO_URL VARCHAR(90) NOT NULL, 
	START_TIME TIMESTAMP NOT NULL, 
	FINISH_TIME TIMESTAMP NOT NULL, 
	PRIMARY KEY (ID)
);
COMMENT ON TABLE todahora.EVENT IS 'Responsible for maintaining the record of events';
COMMENT ON COLUMN todahora.EVENT.ID IS 'Event identifier';
COMMENT ON COLUMN todahora.EVENT.DESCRIPTION IS 'Description of the event';
COMMENT ON COLUMN todahora.EVENT.PHOTO_URL IS 'Event photo';
COMMENT ON COLUMN todahora.EVENT.START_TIME IS 'Start date and time of the event';
COMMENT ON COLUMN todahora.EVENT.FINISH_TIME IS 'Date and end time of the event';

-- DROP TABLE todahora.track;
CREATE TABLE todahora.TRACK
(
  ID serial,
  ALBUM character varying(160),
  BAND character varying(120) NOT NULL,
  DURATION character varying(255),
  GENRE character varying(60),
  TITLE character varying(255) NOT NULL,
  YEAR integer,
  TRACK_PATH character varying(255) NOT NULL,
  USER_ID bigint,
  CONSTRAINT track_pkey PRIMARY KEY (ID),
  CONSTRAINT fk_track_user_id FOREIGN KEY (USER_ID)
      REFERENCES todahora."user" (ID)
);
COMMENT ON TABLE todahora.TRACK IS 'Responsible for maintaining the record of events';
COMMENT ON COLUMN todahora.TRACK.ID IS 'Track identifier';
COMMENT ON COLUMN todahora.TRACK.ALBUM IS 'Track Album';
COMMENT ON COLUMN todahora.TRACK.BAND IS 'Track Band';
COMMENT ON COLUMN todahora.TRACK.DURATION IS 'Track Duration';
COMMENT ON COLUMN todahora.TRACK.GENRE IS 'Track Genre';
COMMENT ON COLUMN todahora.TRACK.TITLE IS 'Track Title';
COMMENT ON COLUMN todahora.TRACK.YEAR IS 'Track Year';
COMMENT ON COLUMN todahora.TRACK.TRACK_PATH IS 'Track Path where track is stored';
COMMENT ON COLUMN todahora.TRACK.USER_ID IS 'Track Owner';