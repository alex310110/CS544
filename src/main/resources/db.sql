/*Data for the table `advert` */

insert  into `advert`(`id`,`count`,`creationDateTime`,`description`,`expirationDateTime`,`image`,`title`,`url`) values (1,NULL,NULL,'long sleeves',NULL,'/img/adverts/5be8da29-cd51-4b56-8ef2-5e16a927027a.jpg','banner1','banner.com');
insert  into `advert`(`id`,`count`,`creationDateTime`,`description`,`expirationDateTime`,`image`,`title`,`url`) values (2,NULL,NULL,'women clothing',NULL,'/img/adverts/5daab05d-dd51-43f8-9f36-b84fef1a3377.jpg','banner2','banner2.com');

/*Data for the table `buyer` */

insert  into `buyer`(`id`,`points`,`user_id`) values (1,0,1);
insert  into `buyer`(`id`,`points`,`user_id`) values (2,0,4);
insert  into `buyer`(`id`,`points`,`user_id`) values (3,0,5);

/*Data for the table `cartitem` */

insert  into `cartitem`(`id`,`quantity`,`buyer_id`,`product_id`) values (1,1,1,1);
insert  into `cartitem`(`id`,`quantity`,`buyer_id`,`product_id`) values (2,1,1,2);
insert  into `cartitem`(`id`,`quantity`,`buyer_id`,`product_id`) values (3,1,1,3);

/*Data for the table `category` */

insert  into `category`(`id`,`description`,`name`) values (1,'Dresses','Dresses');
insert  into `category`(`id`,`description`,`name`) values (2,'Shirts','Shirts');
insert  into `category`(`id`,`description`,`name`) values (3,'Blazers','Blazers');
insert  into `category`(`id`,`description`,`name`) values (4,'Jeans','Jeans');
insert  into `category`(`id`,`description`,`name`) values (5,'Sweaters','Sweaters');
insert  into `category`(`id`,`description`,`name`) values (6,'Skirts','Skirts');
insert  into `category`(`id`,`description`,`name`) values (7,'Sportswear','Sportswear');
insert  into `category`(`id`,`description`,`name`) values (8,'Swimwear','Swimwear');
insert  into `category`(`id`,`description`,`name`) values (9,'Suits','Suits');
insert  into `category`(`id`,`description`,`name`) values (10,'Pants','Pants');
insert  into `category`(`id`,`description`,`name`) values (11,'Jackets','Jackets');

/*Data for the table `following` */

insert  into `following`(`buyer_id`,`seller_id`) values (1,1);
insert  into `following`(`buyer_id`,`seller_id`) values (2,1);
insert  into `following`(`buyer_id`,`seller_id`) values (3,1);

/*Data for the table `message` */

insert  into `message`(`id`,`content`,`isRead`,`receivedDate`,`user_id`) values (1,'From Phoenix shop: New product added','\0','2019-09-24 20:41:25',1);
insert  into `message`(`id`,`content`,`isRead`,`receivedDate`,`user_id`) values (2,'From Phoenix shop: New product added','\0','2019-09-24 20:41:25',1);

/*Data for the table `orderitem` */

insert  into `orderitem`(`id`,`deliveredDate`,`orderStatus`,`quantity`,`rating`,`review`,`reviewDate`,`reviewStatus`,`shippingDate`,`order_id`,`product_id`) values (1,NULL,'ORDERED',1,4,'Nice jeans','2019-09-24 20:44:51','APPROVED',NULL,1,8);
insert  into `orderitem`(`id`,`deliveredDate`,`orderStatus`,`quantity`,`rating`,`review`,`reviewDate`,`reviewStatus`,`shippingDate`,`order_id`,`product_id`) values (2,NULL,'ORDERED',1,4,'Nice shirt','2019-09-24 20:44:51','PENDING',NULL,1,9);
insert  into `orderitem`(`id`,`deliveredDate`,`orderStatus`,`quantity`,`rating`,`review`,`reviewDate`,`reviewStatus`,`shippingDate`,`order_id`,`product_id`) values (3,NULL,'ORDERED',1,4,'Nice blazer','2019-09-24 20:44:51','PENDING',NULL,1,10);
insert  into `orderitem`(`id`,`deliveredDate`,`orderStatus`,`quantity`,`rating`,`review`,`reviewDate`,`reviewStatus`,`shippingDate`,`order_id`,`product_id`) values (4,NULL,'DELIVERED',1,1,'Too tight!!!','2019-09-24 20:44:51','APPROVED',NULL,2,8);
insert  into `orderitem`(`id`,`deliveredDate`,`orderStatus`,`quantity`,`rating`,`review`,`reviewDate`,`reviewStatus`,`shippingDate`,`order_id`,`product_id`) values (5,NULL,'DELIVERED',1,3,'It does not look like the photo','2019-09-24 20:44:51','APPROVED',NULL,3,8);

/*Data for the table `orders` */

insert  into `orders`(`id`,`billingAddress`,`endDate`,`orderedDate`,`paymentInfo`,`paymentMethod`,`shippingAddress`,`status`,`totalAmount`,`usingPoints`,`buyer_id`) values (1,'1000 N 4th St, Fairfield, IA',NULL,'2019-09-24 20:44:51','Paid by the card number XXXX XXXX XXXX 1234','DEBIT CARD','1000 N 4th St, Fairfield, IA','NEW',64.97,'\0',1);
insert  into `orders`(`id`,`billingAddress`,`endDate`,`orderedDate`,`paymentInfo`,`paymentMethod`,`shippingAddress`,`status`,`totalAmount`,`usingPoints`,`buyer_id`) values (2,'1000 N 4th St, Fairfield, IA',NULL,'2019-09-24 20:44:51','Paid by the card number XXXX XXXX XXXX 2345','CREDIT CARD','1000 N 4th St, Fairfield, IA','COMPLETED',19.99,'\0',2);
insert  into `orders`(`id`,`billingAddress`,`endDate`,`orderedDate`,`paymentInfo`,`paymentMethod`,`shippingAddress`,`status`,`totalAmount`,`usingPoints`,`buyer_id`) values (3,'1000 N 4th St, Fairfield, IA',NULL,'2019-09-24 20:44:51','Paid by the card number XXXX XXXX XXXX 3456','CREDIT CARD','1000 N 4th St, Fairfield, IA','COMPLETED',19.99,'\0',3);

/*Data for the table `product` */

insert  into `product`(`id`,`available`,`description`,`image`,`name`,`price`,`category_id`,`seller_id`) values (1,100,'V-neck, knee-length dress in airy chiffon with details on shoulders. Cap sleeves, buttons at front, and elastication at back of waist. Attached tie belt. Satin lining','/img/product/beltdress.jpg','Dress with Tie Belt',34.99,1,1);
insert  into `product`(`id`,`available`,`description`,`image`,`name`,`price`,`category_id`,`seller_id`) values (2,100,'Short, gently fitted bib overall dress in woven fabric. Buttons at front, wide, adjustable shoulder straps, and a seam at waist','/img/product/overalldress.jpg','Bib Overall Dress',34.99,1,1);
insert  into `product`(`id`,`available`,`description`,`image`,`name`,`price`,`category_id`,`seller_id`) values (3,100,'Calf-length dress in airy, woven fabric with a printed pattern. Jersey liner dress','/img/product/patterneddress.jpg','Patterned Dress',39.99,1,1);
insert  into `product`(`id`,`available`,`description`,`image`,`name`,`price`,`category_id`,`seller_id`) values (4,100,'Sleeveless, calf-length wrap dress in airy, woven plumeti fabric. Narrow, adjustable shoulder straps and seam below bust with ties','/img/product/wrapdress.jpg','Pleated Wrap Dress',79.99,1,1);
insert  into `product`(`id`,`available`,`description`,`image`,`name`,`price`,`category_id`,`seller_id`) values (5,100,'Sleeveless shirt dress in woven viscose fabric with a collar, buttons at front, and removable tie belt at waist. Gently rounded hem.','/img/product/shirtdress.jpg','Sleeveless Shirt Dress',17.99,1,1);
insert  into `product`(`id`,`available`,`description`,`image`,`name`,`price`,`category_id`,`seller_id`) values (6,100,'Short, sleeveless dress in lace with scalloped edges. V-neck, adjustable, extra-narrow shoulder straps, and a concealed zip at back. Gently flared skirt','/img/product/vneckdress.jpg','Lace V-neck Dress',59.99,1,1);
insert  into `product`(`id`,`available`,`description`,`image`,`name`,`price`,`category_id`,`seller_id`) values (7,100,'Ankle-length jeans in washed stretch denim with a regular waist. Mock front pockets, regular back pockets, and skinny legs','/img/product/skinnyjeans.jpg','Skinny Regular Ankle Jeans',9.99,4,1);
insert  into `product`(`id`,`available`,`description`,`image`,`name`,`price`,`category_id`,`seller_id`) values (8,100,'5-pocket jeans in washed denim with a regular waist, zip fly, and slim legs','/img/product/slimjeans.jpg','Slim Jeans',19.99,4,1);
insert  into `product`(`id`,`available`,`description`,`image`,`name`,`price`,`category_id`,`seller_id`) values (9,100,'Shirt in woven cotton-blend fabric. Regular Fit – classic fit with good room for movement and gently shaped waist for a comfortable, tailored silhouette','/img/product/fitshirt.jpg','Regular Fit Henley Shirt',24.99,2,1);
insert  into `product`(`id`,`available`,`description`,`image`,`name`,`price`,`category_id`,`seller_id`) values (10,100,'Single-breasted blazer in woven stretch fabric with narrow, notched lapels. Super skinny fit – slightly shorter style, shaped at chest, tapered sharply at waist, combined with narrow shoulders and sleeves for a completely tailored silhouette','/img/product/fitblazer.jpg','Super Skinny Fit Blazer',19.99,3,1);

/*Data for the table `seller` */

insert  into `seller`(`id`,`description`,`name`,`picture`,`status`,`user_id`) values (1,'Phoenix offers fashion and quality at the best price','Phoenix','/img/shop/4a8ed458-a506-4e36-87f0-67b1614a2eeb.jpg','APPROVED',2);
insert  into `seller`(`id`,`description`,`name`,`picture`,`status`,`user_id`) values (2,'Blue Sand offers fashion and quality at the best price','Blue Sand','/img/shop/bluesand-fashion-shop.jpg','PENDING',6);
insert  into `seller`(`id`,`description`,`name`,`picture`,`status`,`user_id`) values (3,'Fashion Shop offers fashion and quality at the best price','Fashion Shop','/img/shop/3D-Fashion-Shop-11-Model-Free-Download-3.jpg','PENDING',7);

/*Data for the table `user` */

insert  into `user`(`id`,`address`,`avatar`,`email`,`firstName`,`lastName`,`password`,`phone`,`registerDate`,`role`) values (1,'1000 N 4th St, Fairfield, IA','/img/avatar/buyer.jpg','buyer@shopping.com','First','Buyer','$2a$10$b.9CsDYMBdFIMB5ja.lg0.3/OHFiv5kMn7yR.FKCZY3JScMRPvE.G','123-456-7890','2019-09-24','BUYER');
insert  into `user`(`id`,`address`,`avatar`,`email`,`firstName`,`lastName`,`password`,`phone`,`registerDate`,`role`) values (2,'1000 N 4th St, Fairfield, IA','/img/avatar/seller.png','seller@shopping.com','First','Seller','$2a$10$13wR9hYkIwBP0WIT525/XO23UfTvtjUKjbHCLlwAzYNzF3IkBlZRy','123-456-7890','2019-09-24','SELLER');
insert  into `user`(`id`,`address`,`avatar`,`email`,`firstName`,`lastName`,`password`,`phone`,`registerDate`,`role`) values (3,'1000 N 4th St, Fairfield, IA','/img/avatar/admin.png','admin@shopping.com','Shopping','Admin','$2a$10$HM.MYd2XpX7VEsNoZMTUmer6X7MZ7/semLLQ/bDqdsrbhn5EeRO3y','000-000-0000','2019-09-24','ADMIN');
insert  into `user`(`id`,`address`,`avatar`,`email`,`firstName`,`lastName`,`password`,`phone`,`registerDate`,`role`) values (4,'1000 N 4th St, Fairfield, IA',NULL,'buyer2@shopping.com','Second','Buyer','$2a$10$b.9CsDYMBdFIMB5ja.lg0.3/OHFiv5kMn7yR.FKCZY3JScMRPvE.G','123-456-7890','2019-09-24','BUYER');
insert  into `user`(`id`,`address`,`avatar`,`email`,`firstName`,`lastName`,`password`,`phone`,`registerDate`,`role`) values (5,'1000 N 4th St, Fairfield, IA',NULL,'buyer3@shopping.com','Third','Buyer','$2a$10$b.9CsDYMBdFIMB5ja.lg0.3/OHFiv5kMn7yR.FKCZY3JScMRPvE.G','123-456-7890','2019-09-24','BUYER');
insert  into `user`(`id`,`address`,`avatar`,`email`,`firstName`,`lastName`,`password`,`phone`,`registerDate`,`role`) values (6,'1000 N 4th St, Fairfield, IA',NULL,'seller2@shopping.com','Second','Seller','$2a$10$13wR9hYkIwBP0WIT525/XO23UfTvtjUKjbHCLlwAzYNzF3IkBlZRy','123-456-7890','2019-09-24','SELLER');
insert  into `user`(`id`,`address`,`avatar`,`email`,`firstName`,`lastName`,`password`,`phone`,`registerDate`,`role`) values (7,'1000 N 4th St, Fairfield, IA',NULL,'seller3@shopping.com','Second','Seller','$2a$10$13wR9hYkIwBP0WIT525/XO23UfTvtjUKjbHCLlwAzYNzF3IkBlZRy','123-456-7890','2019-09-24','SELLER');
