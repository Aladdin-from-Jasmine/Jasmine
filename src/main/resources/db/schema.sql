DROP TABLE User_ CASCADE CONSTRAINTS PURGE;

DROP TABLE Community CASCADE CONSTRAINTS PURGE;

DROP TABLE Auction CASCADE CONSTRAINTS PURGE;

DROP TABLE Bid CASCADE CONSTRAINTS PURGE;

DROP TABLE Book CASCADE CONSTRAINTS PURGE;

DROP TABLE Order CASCADE CONSTRAINTS PURGE;

DROP TABLE BookCategory CASCADE CONSTRAINTS PURGE;

DROP TABLE Cart CASCADE CONSTRAINTS PURGE;

DROP TABLE CartItem CASCADE CONSTRAINTS PURGE;

CREATE TABLE User_
(
   userId               VARCHAR2(20) NOT NULL ,
   password             VARCHAR2(40) NOT NULL ,
   username             VARCHAR2(40) NOT NULL ,
   address              VARCHAR2(40) NOT NULL ,
   phone                VARCHAR2(40) NOT NULL ,
   email                VARCHAR2(40) NOT NULL 
);

CREATE UNIQUE INDEX XPKUser ON User_
(userId   ASC);

ALTER TABLE User_
   ADD CONSTRAINT  XPKUser PRIMARY KEY (userId);

CREATE TABLE Community
(
   postId               INTEGER NOT NULL ,
   title                VARCHAR2(20) NULL ,
   communityDate        VARCHAR2(20) NULL ,
   content_             VARCHAR2(20) NULL ,
   userId               VARCHAR2(20) NULL 
);

CREATE UNIQUE INDEX XPKCommunity ON Community
(postId   ASC);

ALTER TABLE Community
   ADD CONSTRAINT  XPKCommunity PRIMARY KEY (postId);
   
CREATE TABLE Auction
(
	auctionId            INTEGER NOT NULL ,
	title                VARCHAR2(20) NULL ,
	content_             VARCHAR2(20) NULL ,
	img                  VARCHAR2(20) NULL ,
	startPrice           INTEGER NULL ,
	uploadDate           DATE NULL ,
	endDate              DATE NULL ,
	count                INTEGER NULL ,
	maxPrice             INTEGER NULL ,
	state                VARCHAR2(20) NULL ,
	bookTitle            VARCHAR2(20) NULL ,
	bookAuthor           VARCHAR2(20) NULL ,
	bookPublisher        VARCHAR2(20) NULL ,
	userId               VARCHAR2(20) NULL 
);

CREATE UNIQUE INDEX XPKAuction ON Auction
(auctionId   ASC);

ALTER TABLE Auction
   ADD CONSTRAINT  XPKAuction PRIMARY KEY (auctionId);

CREATE TABLE Bid
(
	bidId                INTEGER NOT NULL ,
	bidPrice             INTEGER NULL ,
	isBidded             VARCHAR2(20) NULL ,
	bidDate              DATE NULL ,
	auctionId            INTEGER NULL ,
	userId               VARCHAR2(20) NULL 
);

CREATE UNIQUE INDEX XPKBid ON Bid
(bidId   ASC);

ALTER TABLE Bid
   ADD CONSTRAINT  XPKBid PRIMARY KEY (bidId);

CREATE TABLE Book
(
   bookId               INTEGER NOT NULL ,
   isbn                 INTEGER NULL ,
   price                INTEGER NULL ,
   title                VARCHAR2(20) NULL ,
   author               VARCHAR2(20) NULL ,
   publisher            VARCHAR2(20) NULL ,
   categoryId           INTEGER NULL 
   userId				VARCHAR2(20)
);

CREATE UNIQUE INDEX XPKBook ON Book
(bookId   ASC);

ALTER TABLE Book
   ADD CONSTRAINT  XPKBook PRIMARY KEY (bookId);

CREATE TABLE ORDER_
(
   orderId      INTEGER NOT NULL ,
  userId		VARCHAR2(20) NULL ,
   bookId               INTEGER NULL ,
   auctionId	 INTEGER NULL ,
   cardBank	VARCHAR2(20) NULL ,
   cardNo		VARCHAR2(20) NULL ,
   validDate	 VARCHAR2(20) NULL ,
   cvc		VARCHAR2(20) NULL ,
  address		VARCHAR2(20) NULL ,
  phone		VARCHAR2(20) NULL ,
  refundBank	VARCHAR2(20) NULL ,
  refundAccount    VARCHAR2(20) NULL ,
  totalPrice	INTEGER NULL,
  orderDate	DATE NULL,
   status               VARCHAR2(20) NULL ,
   totalQuantity	INTEGER NULL
);

CREATE UNIQUE INDEX XPKOrder ON Order_
(orderId   ASC);

ALTER TABLE Order_
   ADD CONSTRAINT  XPKOrder PRIMARY KEY (orderId);

CREATE TABLE Category
(
   categoryId           INTEGER NOT NULL ,
   genre                VARCHAR2(20) NULL 
);

CREATE UNIQUE INDEX XPKBookCategory ON BookCategory
(categoryId   ASC);

ALTER TABLE BookCategory
   ADD CONSTRAINT  XPKBookCategory PRIMARY KEY (categoryId);

CREATE TABLE Cart
(
   cartId               INTEGER NOT NULL ,
   totalPrice           INTEGER NULL ,
   userId               VARCHAR2(20) NULL 
);

CREATE UNIQUE INDEX XPKCart ON Cart
(cartId   ASC);

ALTER TABLE Cart
   ADD CONSTRAINT  XPKCart PRIMARY KEY (cartId);

CREATE TABLE CartItem
(
   cartItemId           VARCHAR2(20) NOT NULL ,
   quantity             VARCHAR2(20) NULL ,
   cartId               INTEGER NULL ,
   bookId               INTEGER NULL 
);

CREATE UNIQUE INDEX XPKCartItem ON CartItem
(cartItemId   ASC);

ALTER TABLE CartItem
   ADD CONSTRAINT  XPKCartItem PRIMARY KEY (cartItemId);

ALTER TABLE Community
   ADD (CONSTRAINT R_12 FOREIGN KEY (userId) REFERENCES User_ (userId) ON DELETE SET NULL);

ALTER TABLE Auction
   ADD (CONSTRAINT R_29 FOREIGN KEY (userId) REFERENCES User_ (userId) ON DELETE SET NULL);

ALTER TABLE Bid
   ADD (CONSTRAINT R_27 FOREIGN KEY (auctionId) REFERENCES Auction (auctionId) ON DELETE SET NULL);

ALTER TABLE Bid
   ADD (CONSTRAINT R_28 FOREIGN KEY (userId) REFERENCES User_ (userId) ON DELETE SET NULL);

ALTER TABLE Book
   ADD (CONSTRAINT R_21 FOREIGN KEY (categoryId) REFERENCES BookCategory (categoryId) ON DELETE SET NULL);

ALTER TABLE Order_
   ADD (CONSTRAINT R_16 FOREIGN KEY (bookId) REFERENCES Book (bookId) ON DELETE SET NULL);

ALTER TABLE Order_
   ADD (CONSTRAINT R_13 FOREIGN KEY (userId) REFERENCES User_ (userId) ON DELETE SET NULL);

ALTER TABLE Order_
   ADD (CONSTRAINT R_14 FOREIGN KEY (auctionId) REFERENCES Auction (auctionId) ON DELETE SET NULL);

ALTER TABLE Cart
   ADD (CONSTRAINT R_15 FOREIGN KEY (userId) REFERENCES User_ (userId) ON DELETE SET NULL);

ALTER TABLE CartItem
   ADD (CONSTRAINT R_10 FOREIGN KEY (cartId) REFERENCES Cart (cartId) ON DELETE SET NULL);

ALTER TABLE CartItem
   ADD (CONSTRAINT R_11 FOREIGN KEY (bookId) REFERENCES Book (bookId) ON DELETE SET NULL);
   
ALTER TABLE book
	ADD (CONSTRAINT R_30 FOREIGN KEY (userId) REFERENCES Book (userId) ON DELETE SET NULL);

CREATE SEQUENCE SEQ_AUCTIONID
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SEQ_BIDID
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SEQ_BOOKID
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SEQ_POSTID
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SEQ_ORDERID
START WITH 1
INCREMENT BY 1;