-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.47-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema atm
--

CREATE DATABASE IF NOT EXISTS atm;
USE atm;

--
-- Definition of table `atm_users`
--

DROP TABLE IF EXISTS `atm_users`;
CREATE TABLE `atm_users` (
  `Card_Number` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Pin` int(10) unsigned NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Contact_Number` bigint(20) unsigned NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Total_Balance` int(10) unsigned NOT NULL,
  `Trans_1` varchar(70) NOT NULL,
  `Trans_2` varchar(70) NOT NULL,
  `Trans_3` varchar(70) NOT NULL,
  `AdhaarCard` bigint(45) unsigned NOT NULL,
  PRIMARY KEY (`Card_Number`,`Pin`,`AdhaarCard`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=963211 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atm_users`
--

/*!40000 ALTER TABLE `atm_users` DISABLE KEYS */;
INSERT INTO `atm_users` (`Card_Number`,`Pin`,`Name`,`Contact_Number`,`Address`,`Total_Balance`,`Trans_1`,`Trans_2`,`Trans_3`,`AdhaarCard`) VALUES 
 (12345,1818,'abc',123,'qwe',10000,'1','1','1',0),
 (100000,1818,'Harmanjit Singh',9417517782,'Kapurthala',1021000,'Money Deposit Rs.1000onWed Jul 20 14:00:10 IST 2016','Money Withdrawn Rs.1000onWed Jul 20 14:10:19 IST 2016','Money Deposit Rs.1000onWed Jul 20 14:10:29 IST 2016',987654321098),
 (100001,1432,'Harpreet Kaur',8054281774,'Faridkot',787900,'Money Withdrawn Rs.100onThu Mar 30 11:11:41 IST 2017','Money Withdrawn Rs.1000onSat Apr 01 23:32:26 IST 2017','Money Withdrawn Rs.1000onTue Apr 11 10:41:29 IST 2017',123456789012),
 (100002,6394,'Ravneet Singh',9646956394,'Pathankot',1000000,'1','1','1',0),
 (100003,6227,'Akshdeep Singh',9814563191,'Moga',500000,'1','1','1',0),
 (100004,6144,'Abhay Thakur',8054374640,'Pathankot',400000,'1','1','1',0),
 (100005,6318,'Kamal',9779406318,'Faridkot',500000,'1','1','1',0),
 (100006,1122,'Rohit Thakur',9815528668,'Mukerian',200000,'1','1','1',0),
 (100007,1234,'Inderpreet Singh',8559011610,'Kapurthala',600000,'1','1','1',0),
 (100008,6232,'Ajaypal Singh',7837010037,'Moga',100000,'1','1','1',0),
 (100009,7899,'Richa Sharma',9463995295,'Jalandhar',200000,'1','1','1',0),
 (100010,7456,'Gourav Arora',7837580326,'Jalandhar',300000,'1','1','1',0),
 (100011,2580,'Mandeep Kaur',8699526492,'Jalandhar',400000,'1','1','1',0),
 (100012,6520,'Neetu Verma',9815352586,'Patiala',500000,'1','1','1',0),
 (100013,6548,'Meenakshi',9463276162,'Jalandhar',800000,'1','1','1',0),
 (100014,4560,'Gurjot Singh',8872393917,'Bhogpur',900000,'1','1','1',0),
 (100015,8520,'Jaspreet Singh',9888886802,'Ludhaina',700000,'1','1','1',0),
 (100016,7410,'Gouravpreet Singh',9888434762,'Ludhaina',300000,'1','1','1',0),
 (100017,3210,'Gurasis Singh',9464547155,'Kapurthala',400000,'1','1','1',0),
 (100018,6459,'Lovepreet Singh',7087086459,'Amritsar',700000,'1','1','1',0),
 (100019,6338,'Chetan Sharma',9876543210,'Jalandhar',900000,'1','1','1',0),
 (100020,2525,'Amrinder Gill',7837464022,'Kapurthala',900000,'1','1','1',0),
 (100065,6207,'Gurdeep Singh',9914200642,'Kapurthala',500000,'1','1','1',0),
 (100094,1563,'Mehakpreet Singh',9815811563,'Kapurthala',600000,'1','1','1',0),
 (100100,6215,'Harsimran Singh',8528642513,'Moga',700000,'1','1','1',0),
 (115210,6208,'Rattandeep  Singh',9872715251,'Jalandhar',400000,'1','1','1',0),
 (123000,7854,'Marshal',9815784420,'Patiala',800000,'1','1','1',0),
 (200062,9999,'Harmail',9530982470,'Gurdaspur',900000,'1','1','1',0),
 (212555,8989,'Kritika Suri',9815606643,'Jalandhar',700000,'1','1','1',0),
 (312654,8855,'Siddhart Kashyap',7696782238,'Jalandhar',400000,'1','1','1',0),
 (562233,6204,'Mishu Walia',9501678911,'Kapurthala',400000,'1','1','1',0),
 (562234,6209,'Deepak Dhiman',8437048232,'Kapurthala',500000,'1','1','1',0),
 (562244,6782,'Paramjit Singh',9417475641,'Kapurthala',1000000,'1','1','1',0),
 (621062,1818,'Virat Kohli',8725816210,'New Delhi',1000000,'1','1','1',0),
 (654456,6312,'Avtar Singh',8054586898,'Amritsar',300000,'1','1','1',0),
 (654562,7894,'Raghav Bhanot',8591014669,'Amritsar',900000,'1','1','1',0),
 (655456,6311,'Nishant',9815774841,'Kapurthala',200000,'1','1','1',0),
 (789654,6311,'Amarjit Singh',9417596474,'Kapurthala',500000,'1','1','1',0),
 (789658,9856,'Abhishek',9988350602,'Amritsar',600000,'1','1','1',0),
 (899554,6140,'Barinderjit Singh',7865496140,'Gurdaspur',800000,'1','1','1',0),
 (899556,5879,'Jatin Saini',9876545879,'Gurdaspur',800000,'1','1','1',0),
 (963210,6363,'Gurpreet Singh',9856231111,'Kapurthala',500000,'1','1','1',0);
/*!40000 ALTER TABLE `atm_users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
