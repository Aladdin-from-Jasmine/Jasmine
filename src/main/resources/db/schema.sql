
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
   report               VARCHAR2(20) NULL ,
   content_             VARCHAR2(20) NULL ,
   img                  VARCHAR2(20) NULL ,
   startPrice           INTEGER NULL ,
   uploadDate           DATE NULL ,
   endDate              DATE NULL ,
   count                INTEGER NULL ,
   maxPrice             INTEGER NULL ,
   state                VARCHAR2(20) NULL ,
   menuId               INTEGER NULL ,
   isAmPm               VARCHAR2(20) NULL ,
   hour                 INTEGER NULL ,
   minute               INTEGER NULL ,
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
   auctionTitle         VARCHAR2(20) NULL ,
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
);

CREATE UNIQUE INDEX XPKBook ON Book
(bookId   ASC);

ALTER TABLE Book
   ADD CONSTRAINT  XPKBook PRIMARY KEY (bookId);

CREATE TABLE Order
(
   orderId              INTEGER NOT NULL ,
   orderUser            VARCHAR2(20) NULL ,
   orderDate            VARCHAR2(20) NULL ,
   orderPrice           INTEGER NULL ,
   status               VARCHAR2(20) NULL ,
   bookId               INTEGER NULL ,
   userId               VARCHAR2(20) NULL 
);

CREATE UNIQUE INDEX XPKOrder ON Order
(orderId   ASC);

ALTER TABLE Order
   ADD CONSTRAINT  XPKOrder PRIMARY KEY (orderId);

CREATE TABLE BookCategory
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

ALTER TABLE Order
   ADD (CONSTRAINT R_16 FOREIGN KEY (bookId) REFERENCES Book (bookId) ON DELETE SET NULL);

ALTER TABLE Order
   ADD (CONSTRAINT R_13 FOREIGN KEY (userId) REFERENCES User_ (userId) ON DELETE SET NULL);

ALTER TABLE Cart
   ADD (CONSTRAINT R_15 FOREIGN KEY (userId) REFERENCES User_ (userId) ON DELETE SET NULL);

ALTER TABLE CartItem
   ADD (CONSTRAINT R_10 FOREIGN KEY (cartId) REFERENCES Cart (cartId) ON DELETE SET NULL);

ALTER TABLE CartItem
   ADD (CONSTRAINT R_11 FOREIGN KEY (bookId) REFERENCES Book (bookId) ON DELETE SET NULL);