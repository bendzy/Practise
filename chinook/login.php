<?php
/**
 * Created by PhpStorm.
 * User: bendz
 * Date: 24. 04. 2016
 * Time: 13:33
 */


    /****** LOGIN CHECK ******/

    $server = "localhost";
    $database = "chinook";
    $user = "root";
    $password = "";

        $conn= new PDO("mysql:host=$server;dbname=$database;charset=utf8", $user, $password);
        $conn->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);

        //checking for post method
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        //check if username and password is set
        if (isset($_POST["username"]) && isset($_POST["password"])) {

                //get values from post method
                $username = $_POST["username"];
                $password = $_POST["password"];

                //check if user is in database
                try {
                    $stmt = $conn->prepare("SELECT * FROM employee where FirstName=:username and LastName=:password");
                    $stmt->execute(array(
                        ":username" => $username,
                        ":password" => $password
                    ));

                    $row = $stmt->fetch();

                        //check if username and password is valid
                        if ($row["FirstName"] == $username && $row["LastName"] == $password) {
                            echo "OK";
                        }else {
                            echo "Sory, the member name and password
                                  you entered do not match. Please try again";
                        }


                }catch (PDOException $e) {
                    echo $e->getMessage();
            }


        }else {
            echo "Plese enter both fields";
        }

        /**** GET CUSTOMERS AND TRACKS FROM DATABASE ***/

    }
   else if ($_SERVER["REQUEST_METHOD"] == "GET") {

        // Customers
            $together = array();
            try {
                //getting top Customer's
                $customerStmt = $conn->prepare("Select customer.FirstName, customer.LastName, customer.City, sum(invoice.Total) from invoice INNER JOIN customer on invoice.CustomerId = customer.CustomerId group by invoice.CustomerId order by sum(invoice.total) DESC LIMIT 10");
                $customerStmt->execute();

                $customers = $customerStmt->fetchAll();
                //sending back


                //getting Artist's
                $artistStmt = $conn->prepare("SELECT Artist.Name , COUNT(Album.ArtistId) FROM Album INNER JOIN Artist ON Album.ArtistId=Artist.ArtistId GROUP BY Album.ArtistId ORDER BY COUNT(*) DESC LIMIT 10");
                $artistStmt->execute();

                $artists = $artistStmt->fetchAll();

                $together["customers"] = array($customers);
                $together["artists"] = array($artists);

                echo json_encode($together);


            }catch (PDOException $e) {
               echo $e->getMessage();
            }


    }else {
        echo "Browser error!";
    }



?>