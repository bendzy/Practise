<?php
/**
 * Created by PhpStorm.
 * User: bendz
 * Date: 3. 05. 2016
 * Time: 12:27
 */
    $server = "localhost";
    $database = "chinook";
    $user = "root";
    $password = "";

    $conn= new PDO("mysql:host=$server;dbname=$database;charset=utf8", $user, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);

    //if ($_GET["load"] == "Customers") {
        try {

            $stmt = $conn->prepare("SELECT customer.CustomerId, customer.FirstName, customer.LastName, customer.City, customer.Country FROM customer limit 10");
            $stmt->execute();

            $customers = $stmt->fetchAll();

           $jTableResult = array();
           $jTableResult["Result"] = "OK";
           $jTableResult["Records"] = $customers;

            //var_dump($jTableResult);

           echo json_encode($jTableResult);

        }catch(PDOException $e) {
            echo $e->getMessage();
        }
    //}


?>