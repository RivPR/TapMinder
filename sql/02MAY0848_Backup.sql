-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: May 02, 2016 at 04:41 PM
-- Server version: 5.5.42
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `tapminder`
--
CREATE DATABASE IF NOT EXISTS `tapminder` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `tapminder`;

-- --------------------------------------------------------

--
-- Table structure for table `beers`
--

DROP TABLE IF EXISTS `beers`;
CREATE TABLE `beers` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `abv` double DEFAULT NULL,
  `hop_count` double DEFAULT NULL,
  `style` varchar(45) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `image_link` varchar(200) DEFAULT NULL,
  `breweries_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `beers`
--

INSERT INTO `beers` (`id`, `name`, `abv`, `hop_count`, `style`, `description`, `image_link`, `breweries_id`) VALUES
(1, 'Avalanche Ale', 4.4, 2.5, 'Ale', 'Nice beer', '', 1),
(2, 'Lucky U IPA', 6.2, 50, 'IPA', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 1),
(3, 'Vanilla porter', 5.4, 50, 'Porter', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 1),
(4, 'Agave Wheat', 4.2, 50, 'Wheat Ale*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 1),
(5, 'Oatmeal Stout', 5, 50, 'Stout', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 1),
(6, 'Hercules', 10, 50, 'Double IPA', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 2),
(7, 'Yeti Imperial Stout', 9.5, 75, 'Stout', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 2),
(8, 'Titan IPA', 7.1, 50, 'India Pale Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 2),
(9, 'Hoss Rye Lager', 6.2, 50, 'Lager*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 2),
(10, 'Claymore Scotch Ale', 7.7, 50, 'Scotch Ale*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 2),
(11, 'Denver Pale Ale', 5, 50, 'Pale Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 2),
(12, 'Nomad Pilsner', 5.4, 50, 'Pilsner', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 2),
(13, 'Hades', 7.8, 50, 'Belgian Style Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 2),
(14, 'Hippity Hops Chrysanthemum', 7.5, 50, 'IPA', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 3),
(15, 'Honey Matrimony Brown Ale', 5.9, 50, 'Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 3),
(16, 'Lao Wang Lager', 5.2, 50, 'Lager', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 3),
(17, 'Wild Blonde Ale', 4.6, 50, 'Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 3),
(18, 'Bat Black Smoked Robust Porter', 8.5, 50, 'Robust Porter', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 3),
(19, 'Yellow Card', 5.5, 50, 'Porter*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 4),
(20, 'DEFCON Red', 5.5, 18, 'India Pale Ale*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 4),
(21, 'Koffee Kream Stout', 4.8, 30, 'Stout', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 4),
(22, 'Superpower IPA', 7.5, 28, 'India Pale Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 4),
(23, 'Colorado Cream Ale', 5.2, 15, 'Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 5),
(24, 'American White', 5, 15, 'Porter*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 5),
(25, 'Session IPA', 4.2, 50, 'India Pale Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 5),
(26, 'Red X', 4.7, 50, 'Porter*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 5),
(27, 'Chocolate Rye.', 5, 50, 'India Pale Ale*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 5),
(28, 'Amalgam', 5.4, 50, 'Ale/Lager Hybrid', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 6),
(29, 'Fluence', 5.1, 50, 'Hefeweizen', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 6),
(30, 'Canticle', 7.4, 20, 'Belgian Dubbel', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 6),
(31, 'Meristem', 10, 50, 'Russian Imperial Stout', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 6),
(32, 'Prisma', 4.9, 50, 'Pale Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 6),
(33, 'Imprint', 5.9, 50, 'Black Saison', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 6),
(34, 'Redolent', 7.1, 50, 'Belgian Blonde', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 6),
(35, 'Terrarum', 5, 50, 'English Amber', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 6),
(36, 'Aphion', 7.9, 50, 'Imperial IPA', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 6),
(37, 'Old Bums and Beat Cowboys Pale Ale', 4.9, 50, 'Pale Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 7),
(38, 'Vitality of Illusion Wit', 7.5, 50, 'Belgian Wit', 'Our Wit is a grand illusion of a sessionable beer. At 7.5% ABV this Belgian Wit falls outside the typical alcohol guidelines for this style. We designed our take on this classic using a blend of traditional and new world ingredients including un-malted wheat pilsner malt white wheat oats and honey. Cascade hops are used sparingly for balance and to enhance the natural citrus aroma and flavor of this beer. Pink peppercorns lemongrass bitter orange peel and coriander are added in the boil to further develop citrus aroma and flavor. Light in color effervescent and smooth our Wit won’t disappoint.', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 7),
(39, 'The Dreamer IPA', 8, 50, 'IPA', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 7),
(40, 'Feely Effects Stout', 8, 50, 'Stout', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 7),
(41, 'Golden Ghost', 5.2, 50, 'Ale', 'Our lightest ale — a shade of the hair of the dog for which it is named. This lightly hopped beer will have you ordering another.', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 8),
(42, 'Longest Wickedest Wit', 5, 50, 'Wheat Beer', 'Playboy once dubbed Colfax “The Longest Wickedest Street in America.” Our Belgian wheat beer is made with Belgian barley wheat unmalted wheat and oats. Spiced with Coriander orange peel and tangerine peel. Silver Medal Winner at the 2015 Denver International Beer Competition.', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 8),
(43, 'Grave Robber Fraud Quad', 9, 50, 'Belgian Style Quadruple', 'Traditional Belgian style Quadruple. When the cemetery that was located on what is now Cheesman Park was moved the City discovered they had been duped into paying for more graves than were actually moved. Years after the graves were moved bones were still found in the park. This beer is brewed with Belgian malts a Trappist yeast strain Belgian brown sugar (beet sugar) with plum and raisin flavors.', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 8),
(44, 'District 6 Pils', 5, 50, 'Pilsner', 'So named for the location of Lost Highway Brewing in relation to the Denver Police District 6 station. The beer is a classic German style Pilsner. Brewed with German hops and Barley and Monastery yeast. Pale straw color this is a refreshing session beer. Silver Medal Winner at the 2015 Denver International Beer Competition.', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 8),
(45, '520 Copper Lager', 6, 50, 'Lager', '“520” was the street address of our brewer’s grandmother’s house growing up and coincidentally years later it is the address of the brewery. Silky smooth Germanic malts meld with a balanced combo of American and Noble hops to form an assertive crisp finish on this copper colored Apparition.', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 8),
(46, 'Varicose Alley Belgian Amber', 7, 50, 'Belgian Amber', 'Beatnik slang for the runway in a strip club. A complex blend of malts teamed with American hops go into making our Belgian Amber ale. A flavor profile of light chocolate clove and a mild roast that finishes with a toasted bitterness.', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 8),
(47, 'Pearl Diver Pale Ale', 5, 50, 'Pale Ale', 'Sessionable pale ale with a balance of toasted malt and aggressive hop characteristics. Simple and groovy all at once.', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 8),
(48, 'O.G. Colfax Porter', 6, 50, 'Porter', 'Brewed with chocolate rye caramel and other specialty dark malts to create a roasted nutty flavor. This perfect dark session beer finishes with just a touch of sweetness. Aptly named after one of our Colfax cruising denizen. Oh Yeah! Named Best of Show & Gold Medal Winner at the 2015 Denver International Beer Competition', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 8),
(49, 'the Poet Session IPA', 6, 50, 'IPA', 'American-style IPA brewed with Galaxy Azacca and Centennial hops to provide a rounded ale with citrus and tropical fruit aromas and an assertive bitter finish.', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 8),
(50, 'Miss American Rye', 5.5, 50, 'Belgian Amber*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(51, 'Hogback', 5.25, 50, 'Wheat Beer*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(52, 'Timberline', 6, 50, 'IPA*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(53, 'Blind Sherpa', 6.5, 50, 'IPA*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(54, 'Gravity', 5.8, 50, 'IPA*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(55, 'Alpine Dog', 8.5, 50, 'IPA*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(56, 'Armada', 7.25, 50, 'IPA*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(57, 'Howl at the Moon', 7.6, 50, 'Hefeweizen*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(58, 'Vendetta', 6, 50, 'IPA*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(59, 'Alpine Monk', 6, 50, 'IPA*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(60, 'Notorious Monk', 7.5, 50, 'IPA*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(61, 'Casanova Monk', 9.5, 50, 'IPA*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 9),
(62, 'East Coast Pale Ale', 6, 50, 'Pale Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 10),
(63, 'Hefeweisen', 4.8, 50, 'Hefeweizen', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 10),
(64, 'Irish Stout', 4.8, 50, 'Stout', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 10),
(65, 'Cap''n Jack''s Best Bitter', 5.9, 50, 'IPA*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 10),
(66, 'Czech Pilsner', 4.7, 50, 'Pilsner', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 10),
(67, 'Colorado Kind Ale', 9.7, 50, 'Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(68, 'Isadore Java Porter', 6.3, 50, 'Porter', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(69, 'Annapurna Amber', 4.9, 50, 'Amber', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(70, 'Illusion Dweller IPA', 6.3, 50, 'IPA', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(71, 'Quinn''s Golden Ale', 6.3, 50, 'Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(72, 'Big Krane Kolsch', 6.3, 50, 'Amber*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(73, 'Hogback Dopplebock', 5.5, 50, 'Amber*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(74, 'Claymore Scotch Ale', 8.1, 50, 'Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(75, 'Raspberry Wheat', 6.3, 50, 'Hefeweizen*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(76, 'XXX Pale Ale', 5.25, 50, 'Pale Ale', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(77, 'Chazz Cat Rye', 6.3, 50, 'Pale Ale*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(78, 'Belgian Dip Chocolate Stout', 6.3, 50, 'Chocolate Stout', 'This is fast becoming our standard stout at Mountain Sun. With the addition of 10 kg. of the finest Belgian chocolate and using lactose this beer is like a stout milk-shake. We will also be doing other Stouts occasionally throughout the year like the Yonder Mountain Stout so keep your eyes (and taste buds) peeled.Hops: bittering: Crystal hops aroma: Liberty & Cascade hops', 'http://beerandtofu.com/wp-content/uploads/2012/02/Rogue_Chocolate_Stout.jpg', 11),
(79, 'Cleveland Brown Ale', 6.5, 50, 'English Ale*', 'Nice beer', 'http://healthygyan.com/wp-content/uploads/2014/10/13-08-08_015226_cbeer.jpg', 11),
(80, 'Muscle Memory', 4.5, 45, 'English Ale', 'A generous helping of oats makes this Third Wave Pale Ale dangerously drinkable. Bursting with grapefruit orange marmalade passion fruit and peach.', 'http://cerebralbrewing.com/wp-content/uploads/2014/06/beer01-220x374.png', 12),
(81, 'Rare Trait', 6.4, 65, 'India Pale Ale', 'A showcase of the finest flavor & aroma hops we could get our hands on featuring powerful notes of tangerine mango and peach candy.', 'http://cerebralbrewing.com/wp-content/uploads/2014/06/SRM20.png', 12),
(82, 'Known Entities', 5.1, 20, 'English Ale', 'Sometimes the simplest answer is the right one. Dry toasty flavors from traditional brown malt supported by a sweet fullness from oats and Scottish mal', 'http://cerebralbrewing.com/wp-content/uploads/2014/06/SRM20-220x374.png', 12),
(83, 'Dark Galaxie', 4.9, 35, 'Oatmeal Milk Stout', 'Dark grains contribute rich notes of chocolate coffee and molasses to this stout that gets its creamy mouthfeel from a generous hand of oats and lactose', 'http://cerebralbrewing.com/wp-content/uploads/2014/06/SRM30-220x374.png', 12);

-- --------------------------------------------------------

--
-- Table structure for table `beer_ratings`
--

DROP TABLE IF EXISTS `beer_ratings`;
CREATE TABLE `beer_ratings` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `beer_id` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `comments` varchar(5000) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `beer_ratings`
--

INSERT INTO `beer_ratings` (`id`, `user_id`, `beer_id`, `rating`, `comments`) VALUES
(7, 1, 33, 1, 'Had a light taste '),
(8, 2, 22, 4, 'Heavy on the stomach but delicious'),
(9, 3, 11, 3, 'Makes me want to drink Belgian brews'),
(10, 4, 45, 5, 'I can''t live without this one'),
(11, 5, 6, 3, 'If this were to ferment for one more week it would have been amazing'),
(12, 6, 8, 2, 'Take me back to this brewery any day seasonals are my jam'),
(13, 7, 14, 3, 'I just can''t get enough'),
(14, 8, 26, 3, 'Life country beer'),
(15, 9, 5, 4, 'Living the dream with this one'),
(16, 10, 7, 1, 'If I had a choice between Coors and this I''d choose Coors');

-- --------------------------------------------------------

--
-- Table structure for table `breweries`
--

DROP TABLE IF EXISTS `breweries`;
CREATE TABLE `breweries` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `street_address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `image_link` varchar(200) DEFAULT NULL,
  `brewery_link` varchar(200) DEFAULT NULL,
  `neighborhood_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `breweries`
--

INSERT INTO `breweries` (`id`, `name`, `street_address`, `city`, `state`, `zip`, `image_link`, `brewery_link`, `neighborhood_id`) VALUES
(1, 'Breckenridge Brewery', '471 Kalamath St.', 'Denver', 'CO', 80204, 'http://www.breckbrew.com/_stay_out/images/logo.png', 'http://www.breckbrew.com/', 16),
(2, 'Great Divide Brewing Company', '2201 Arapahoe St', 'Denver', 'CO', 80205, 'http://www.greenleafdenver.org/wp-content/uploads/2015/10/brew_292.jpg', 'http://greatdivide.com/', 8),
(3, 'Caution Brewing Company', '1057 S. Wadsworth Blvd', 'Lakewood', 'CO', 80226, 'http://www.cautionbrewingco.com/content/images/cautionlogobig.png', 'http://www.cautionbrewingco.com/', 15),
(4, 'Comrade Brewing Company', '7667 East Iliff Ave. #F', 'Denver', 'CO', 80231, 'http://extras.mnginteractive.com/live/media/site36/2014/1217/20141217__comrade-brewing-denver-colorado~p1.jpg', 'http://comradebrewing.com/', 1),
(5, 'Station 26 Brewing Company', '7045 E 38th Ave', 'Denver', 'CO', 80207, 'https://i.vimeocdn.com/portrait/6948793_300x300.jpg', 'http://www.station26brewing.co/', 1),
(6, 'FERMAENTRA', '1715 E. Evans Ave.', 'Denver', 'CO', 80210, 'http://www.fermaentra.com/home/', 'http://www.fermaentra.com/home/', 1),
(7, 'Fiction Beer Company', '7101 E Colfax Ave.', 'Denver', 'CO', 80220, 'http://www.fictionbeer.com/welcome', 'http://www.fictionbeer.com/', 2),
(8, 'Lost Highway Brewing Company', '520 E. Colfax Ave.', 'Denver', 'CO', 80203, 'http://www.losthighwaybrewing.com/images/lost-highway.png', 'http://www.losthighwaybrewing.com/', 2),
(9, 'Alpine Dog Brewing Company', '1505 Odgen St.', 'Denver', 'CO', 80218, 'http://www.alpinedogbrewery.com/images/Header1.jpg', 'http://www.alpinedogbrewery.com/', 2),
(10, 'Deep Draft Brewing Company', '1604 E. 17th Ave.', 'Denver', 'CO', 80218, 'http://denverbreweryguide.com/img/Business/Deep-Draft-Brewing-Company.jpg', 'http://www.deepdraftbrewery.com/', 2),
(11, 'Vine Street Pub & Brewery', '1700 Vine St.', 'Denver', 'CO', 80206, 'http://www.mountainsunpub.com/images/logo2.gif', 'http://www.mountainsunpub.com/locations.php', 2),
(12, 'Cerebral Brewing', '1477 Monroe St.', 'Denver', 'CO', 80206, 'http://cerebralbrewing.com/wp-content/uploads/2014/06/brainDark.png', 'http://cerebralbrewing.com/', 2);

-- --------------------------------------------------------

--
-- Table structure for table `neighborhoods`
--

DROP TABLE IF EXISTS `neighborhoods`;
CREATE TABLE `neighborhoods` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `neighborhoods`
--

INSERT INTO `neighborhoods` (`id`, `name`) VALUES
(1, 'Denver - East'),
(2, 'Denver - East Colfax'),
(3, 'Denver - Highlands'),
(4, 'Denver - Lower Downtown'),
(5, 'Denver - South Broadway Area'),
(6, 'Denver - Southwest'),
(7, 'Denver - West Highlands'),
(8, 'Denver - River North'),
(9, 'Denver - Five Points'),
(10, 'Arvada'),
(11, 'Aurora'),
(12, 'Broomfield'),
(13, 'Edgewater'),
(14, 'Golden'),
(15, 'Lakewood'),
(16, 'Littleton'),
(17, 'Northglenn'),
(18, 'Wheat Ridge');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `usertype_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `firstname`, `lastname`, `email`, `password`, `usertype_id`) VALUES
(1, 'James', 'Jones', 'jjones@fakemail.com', 'password', 1),
(2, 'Tim', 'Trunk', 'ttrunk@fakemail.com', 'password', 2),
(3, 'Tri', 'Tran', 'ttran@fakemail.com', 'password', 1),
(4, 'Angel4', 'Argo', 'aargo@fakemail.com', 'password', 2),
(5, 'Alex', 'Arnot', 'aarnot@fakemail.com', 'password', 3),
(6, 'David', 'Dannies', 'ddannies@fakemail.com', 'password', 3),
(7, 'Elizabeth', 'Elijah', 'eelijah@fakemail.com', 'password', 1),
(8, 'Geoffrey', 'Genes', 'mrPoopyHead@fakemail.com', 'password', 1),
(9, 'Roger', 'Ralphs', 'rralphs@fakemail.com', 'password', 1),
(10, 'Yum', 'Noch', 'ynoch@fakemail.com', 'password', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type` (
  `id` int(11) NOT NULL,
  `type_name` varchar(45) NOT NULL,
  `access_level` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_type`
--

INSERT INTO `user_type` (`id`, `type_name`, `access_level`) VALUES
(1, 'Standard', 1),
(2, 'Moderator', 2),
(3, 'Admin', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `beers`
--
ALTER TABLE `beers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Beers_breweries1_idx` (`breweries_id`);

--
-- Indexes for table `beer_ratings`
--
ALTER TABLE `beer_ratings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_users_has_Beers_Beers1_idx` (`beer_id`),
  ADD KEY `fk_users_has_Beers_users1_idx` (`user_id`);

--
-- Indexes for table `breweries`
--
ALTER TABLE `breweries`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Breweries_neighborhood_idx` (`neighborhood_id`);

--
-- Indexes for table `neighborhoods`
--
ALTER TABLE `neighborhoods`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_type_table11_idx` (`usertype_id`);

--
-- Indexes for table `user_type`
--
ALTER TABLE `user_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `beers`
--
ALTER TABLE `beers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=84;
--
-- AUTO_INCREMENT for table `beer_ratings`
--
ALTER TABLE `beer_ratings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `breweries`
--
ALTER TABLE `breweries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `neighborhoods`
--
ALTER TABLE `neighborhoods`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `user_type`
--
ALTER TABLE `user_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `beers`
--
ALTER TABLE `beers`
  ADD CONSTRAINT `fk_Beers_breweries1` FOREIGN KEY (`breweries_id`) REFERENCES `breweries` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `beer_ratings`
--
ALTER TABLE `beer_ratings`
  ADD CONSTRAINT `fk_users_has_Beers_Beers1` FOREIGN KEY (`beer_id`) REFERENCES `beers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_users_has_Beers_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `breweries`
--
ALTER TABLE `breweries`
  ADD CONSTRAINT `fk_Breweries_neighborhood` FOREIGN KEY (`neighborhood_id`) REFERENCES `neighborhoods` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_user_type_table11` FOREIGN KEY (`usertype_id`) REFERENCES `user_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
