<?php
/**
 * Created by PhpStorm.
 * User: bendz
 * Date: 3. 05. 2016
 * Time: 12:15
 */
    class DBConnection
    {
        private $username = "localhost";
        private $database = "chinnok";
        private $user = "root";
        private $password ="";

        private $connection;

        public function  __construct()
        {
            $this->connection = new PDO("mysql:host=$this->servername;dbname=$this->database;charset=utf8",$this->user,$this->passowrd);
            $this->connection->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
        }


        public function query($queryString) {
            return  $this->connection->query($queryString);
        }
    }
?>